package visa;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Masking is the act of applying a mask to a value. This is accomplished by doing:
 *
 * Bitwise ANDing in order to extract a subset of the bits in the value
 * Bitwise ORing in order to set a subset of the bits in the value
 */

// Variation IDs are 63 bit positive longs composed of:
// Id = <1 sign bit |--48 bits of TS --|6 bits of Node-id | 9 bits of counter -->
//  48 bits time stamp
//  6 bits node id = Values 0 to 63
// 9 bits  = Values 0 to 511
//public static long getNextNumberVisaSeqGen4(long timeStamp, long nodeID, long sequence) {
//        return (timeStamp << 15L | nodeID << 9L | sequence);
//        }

public class IDGenerator2 {

    private final long appEpoch = 0L;


    private long nodeID;
    private volatile long lastTimestamp = -1L;
    private final long maxNodeID = 63L;

    private final long timestampShift = 15L;
    private final long nodeIDShift = 9L;
    private static final long sequenceMask = 511L; // Binary "111111111"


    private volatile long sequence = 0L;
    // generated by MHS, every app node has a unique identity. (10 < NODE_ID < 100)
    private static final String NODE_ID = "vault.identity";

    private static final SimpleDateFormat fmt = new SimpleDateFormat("MM-dd-yyyy:HH:mm:ss");

    public static IDGenerator2 getInstance() {

        return IDGenHelper.INSTANCE;
    }

    private IDGenerator2(long nodeID) {

        if (nodeID == 0) {
            try {

                System.out.println("IDGenerator: nodeID is not set, using random nodeID");
                Random rnd = new Random();
                this.nodeID = rnd.nextInt((int) maxNodeID) + 1;
            } catch (Exception e) {
                throw new RuntimeException("Can not initialized IDGenerator with random nodeID");
            }
        } else if (nodeID < 0 || nodeID > 63) {
            throw new RuntimeException("Node id should be 0<=nodeId<=63. Can not initialized IDGenerator nodeID= " + nodeID);
        } else {
            this.nodeID = nodeID;
        }

        System.out.println("IDGenerator: initialised with nodeID:" + this.nodeID);
    }


    /**
     * Return the next unique id
     *
     * @return
     */

    public synchronized long nextKey() {
        long timestamp = System.currentTimeMillis();

        if (timestamp < lastTimestamp) {
            System.out.println("IDGenerator: Clock moved backwards. Refusing to generate id for milliseconds." + (lastTimestamp - timestamp));
            try {
                Thread.sleep((lastTimestamp - timestamp));
            } catch (InterruptedException e) {
                System.out.println("IDGenerator: Interrupted Exception in IDGenerator");
            }
        }
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }
        System.out.println("Using seq =" + sequence);

        lastTimestamp = timestamp;


        long id = ((timestamp - appEpoch) << timestampShift) | (nodeID << nodeIDShift) | sequence;

        if (id < 0) {
            System.out.println("ID is smaller than 0:" + id);
        }
        return id;
    }


    public synchronized long nextKey(long tsArg) {
        long timestamp = tsArg;

        if (timestamp < lastTimestamp) {
            System.out.println("IDGenerator: Clock moved backwards. Refusing to generate id for milliseconds." + (lastTimestamp - timestamp));
            try {
                Thread.sleep((lastTimestamp - timestamp));
            } catch (InterruptedException e) {
                System.out.println("IDGenerator: Interrupted Exception in IDGenerator");
            }
        }
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }
        System.out.println("Using seq =" + sequence);

        lastTimestamp = timestamp;


        long id = ((timestamp - appEpoch) << timestampShift) | (nodeID << nodeIDShift) | sequence;

        if (id < 0) {
            System.out.println("ID is smaller than 0:" + id);
        }
        return id;
    }


//    public synchronized long nextKeyArg(long myTimeStamp) {
//        long timestamp = myTimeStamp;
//
//
//
//        lastTimestamp = timestamp;
//        long id = ((timestamp - appEpoch) << timestampShift) | (nodeID << nodeIDShift) | sequence;
//
//        if (id < 0) {
//            System.out.println("ID is smaller than 0:" + id);
//        }
//        return id;
//    }


    private long tilNextMillis(long lastTimestamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }

    // Helper class
    private static class IDGenHelper {
        private static final IDGenerator2 INSTANCE = new IDGenerator2(new Long(System.getProperty(NODE_ID, "0")));
        // private static final IDGenerator2 INSTANCE = new IDGenerator2(5L);
    }

    /**
     * Get nodeId for the generated sequence
     *
     * @param id
     * @return
     */
    public static long getNodeID(long id) {

        return (id & sequenceMask) >> 9;
    }


    /**
     * Utility Method to get start Time in ms
     *
     * @param MM_dd_yyyy
     * @return
     * @throws ParseException
     */
    public static long getMillis(String MM_dd_yyyy) throws ParseException {
        return ((Date) fmt.parse(MM_dd_yyyy)).toInstant().toEpochMilli();

    }

    /**
     * Utility Method to get date from milliseconds
     *
     * @param ms
     * @return
     * @throws ParseException
     */
    public static String getDate(long ms) throws ParseException {
        return fmt.format(new Date(ms));
    }

    public String binaryString(Long number) {
        return Long.toBinaryString(number);

    }

    public Long binaryRep() {

        return (long) Math.pow(2, 43);

    }


    /**
     * Get nodeId for the generated sequence
     *
     * @param id
     * @return
     */
    public static long getSeq(long id) {

        return (id & sequenceMask);
    }


    public static long getTimeStamp(long id) {

        return (id & 9223372036853727232L) >> 20;
    }


    public static String getTimeStampDate(long id) throws Exception {

        long tsSinceRealEpoch = getTimeStamp(id) + 1546322400000L;
        return getDate(tsSinceRealEpoch);
    }

    public static void main(String[] arr) throws Exception {


        System.setProperty("vault.identity", "5");
        //123 id

//        for(int i = 0; i < 600; i++)
        printNumberAndLength(IDGenerator2.getInstance().nextKey(), "id generated=");

        printNumberAndLength(IDGenerator2.getInstance().nextKey(System.currentTimeMillis()), "id generated new arg=");

        printNumberAndLength(IDGenerator2.getInstance().nextKey(getMillis("05-30-2019:20:00:00")), "id generated 05-30-2019:20:00:00=");
        printNumberAndLength(IDGenerator2.getInstance().nextKey(getMillis("05-30-2025:20:00:00")), "id generated 05-30-2025:20:00:00=");
        printNumberAndLength(IDGenerator2.getInstance().nextKey(getMillis("05-30-2040:20:00:00")), "id generated 05-30-2040:20:00:00=");
        printNumberAndLength(IDGenerator2.getInstance().nextKey(getMillis("05-30-2050:20:00:00")), "id generated 05-30-2050:20:00:00=");
        printNumberAndLength(IDGenerator2.getInstance().nextKey(getMillis("05-30-2060:20:00:00")), "id generated 05-30-2060:20:00:00=");
        printNumberAndLength(IDGenerator2.getInstance().nextKey(getMillis("05-30-2070:20:00:00")), "id generated 05-30-2070:20:00:00=");
    }


    public static void printNumberAndLength(long l, String text) {
        System.out.println(text + ": " + l + ", length=" + Long.toString(l).length());

    }

}

//12679528313 = ts
//13,295,449,080,414,208 = gen (13 quadrillion)


// max long 9,223,372,036,854,775,807 (inclusive).  quintillion 18 zeros (19 digit)
//
//https://www.callicoder.com/distributed-unique-id-sequence-number-generator/


// System.out.println(IDGenerator.getNodeID(51090910322461184L));
//
//         long millis1 = IDGenerator.getMillis("05-29-2019:00:00:00");
//         System.out.println("New 05-29-2019:00:00:00 number:"+ IDGenerator.getInstance().nextKeyArg(millis1 ));
//
//         long millis2 = IDGenerator.getMillis("05-29-2020:00:00:00");
//         System.out.println("New 05-29-2020:00:00:00 number:"+ IDGenerator.getInstance().nextKeyArg(millis2 ));
//
//
//         String seventeenDigit = "99999999999999999";
//         System.out.println("Binary 17 digit="+ Long.toBinaryString(99999999999999999L));
//         String binString = Long.toBinaryString(99999999999999999L);
//         System.out.println("len====" + binString.length()+ ", binStr="+binString);
//         String tsLargest = binString.substring(0,binString.length()-(20));
//         System.out.println("tsLargest ==" + tsLargest.length());
//
//         Long maxTs = Long.parseLong(tsLargest,2);
//         System.out.println("max ts " + maxTs);
//         //long millInYear =
//         long year =  maxTs/(365L*24L*60L*60L*1000L);
//
//         System.out.println("year ==" + year);
//
//
//
//
//
//
//         System.out.println("value 2^64="+ Math.pow(2,64));
//         System.out.println(Math.pow(2,43));
//         //Node id
//         System.out.println(Long.parseLong("11111100000000000000",2));
//
//         // sequence number
//         System.out.println(Long.parseLong("11111111111111",2));
//
//         // timestamp
//         System.out.println("ts="+ Long.parseLong("111111111111111111111111111111111111111111100000000000000000000",2));
//
//         System.out.println("number generated="+ IDGenerator.getInstance().nextKey());
//         System.out.println("nodeId ="+ IDGenerator.getNodeID(13294607578251264L));
//         System.out.println("seq ="+ IDGenerator.getSeq(13294607578251264L));
//         System.out.println("ts ="+ IDGenerator.getTimeStamp(13295449080414208L));
//         System.out.println("ts ="+ IDGenerator.getTimeStampDate(13295449080414208L));
//
//         for(int i =0; i<10;i++)
//        {
//        System.out.println(IDGenerator.getInstance().nextKey());
//
//        }


// why 64 years
//long millis = (64*365*24*60*60*1000)