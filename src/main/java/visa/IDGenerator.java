package visa;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Unique id generation for a given node
 * Variation IDs are 63 bit positive longs composed of:
 * Id = <1 sign bit |-- 48 bits of TS --|--6 bits of Node-id --| -- 9 bits of counter -->
 * 48 bits time stamp
 * 6 bits node id = Values 0 to 63
 * 9 bits  = Values 0 to 511
 */


public class IDGenerator {


    private final static long appEpoch = 0L;

    private long nodeID;
    private volatile long lastTimestamp = -1L;
    private volatile long sequence = 0L;


    private final static long timeSegmentSize = 48L;
    private final static long nodeSegmentSize = 6L;
    private final static long sequenceSegmentSize = 9L;

    private final static long sequenceMask = (long) Math.pow(2, sequenceSegmentSize) - 1;
    private final static long maxNodeID = (long) Math.pow(2, nodeSegmentSize) - 1;


    // Notes from MHS: every app node has a unique identity. (10 < NODE_ID < 100)
    // for id generation -> number should be between 0 and 63 inclusive
    private static final String NODE_ID = "vault.identity";

    private static final SimpleDateFormat fmt = new SimpleDateFormat("MM-dd-yyyy:HH:mm:ss");

    public static IDGenerator getInstance() {

        return IDGenHelper.INSTANCE;
    }

    /**
     * Constructor
     *
     * @param nodeID
     */
    private IDGenerator(long nodeID) {

        if (nodeID == 0) {
            try {

                System.out.println("IDGenerator: nodeID is not set, using random nodeID");
                Random rnd = new Random();
                this.nodeID = rnd.nextInt((int) maxNodeID) + 1;
            } catch (Exception e) {
                throw new RuntimeException("Can not initialized IDGenerator with random nodeID");
            }
        } else if (nodeID < 0 || nodeID > maxNodeID) {
            throw new RuntimeException("Node id should be 0<=nodeId<=" + maxNodeID + ". Can not initialized IDGenerator nodeID= " + nodeID);
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
        lastTimestamp = timestamp;
        long id = ((timestamp - appEpoch) << (nodeSegmentSize + sequenceSegmentSize)) | (nodeID << sequenceSegmentSize) | sequence;

        if (id < 0) {
            System.out.println("ID is smaller than 0:" + id);
        }
        return id;
    }


    /**
     * Restrict jump to next milli
     *
     * @param lastTimestamp
     * @return
     */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }

    // Helper class
    private static class IDGenHelper {
        private static final IDGenerator INSTANCE = new IDGenerator(new Long(System.getProperty(NODE_ID, "0")));
    }

    /**
     * Get nodeId from the generated id
     *
     * @param id
     * @return
     */
    public static long getNodeID(long id) {

        long nodeMask = (((long) Math.pow(2, nodeSegmentSize)) - 1) << sequenceSegmentSize;
        return (id & nodeMask) >> sequenceSegmentSize;
    }

    /**
     * Get sequence number from generated id
     *
     * @param id
     * @return
     */
    public static long getSequence(long id) {
        long seqMask = ((long) Math.pow(2, sequenceSegmentSize)) - 1;
        return (id & seqMask);
    }

    /**
     * Get timestamp(date-time) from id
     *
     * @param id
     * @return
     * @throws Exception
     */
    public static long getTimestamp(long id) throws Exception {
        long tsMask = (((long) Math.pow(2, timeSegmentSize)) - 1) << (nodeSegmentSize + sequenceSegmentSize);
        return ((id & tsMask) >> (nodeSegmentSize + sequenceSegmentSize)) + appEpoch;


    }

    public static String getDate(long id) throws Exception {
        return convertTsToDateString(getTimestamp(id));
    }

    /**
     * Utility Method to get ms for the date
     *
     * @param MM_dd_yyyy e.g MM-dd-yy:HH:mm:ss
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
    public static String convertTsToDateString(long ms) throws ParseException {
        return fmt.format(new Date(ms));
    }


}