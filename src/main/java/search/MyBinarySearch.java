package search;

public class MyBinarySearch {


    public static void main(String[] args) {

        //sorted arr
        int[] arr = {2,3,4,5};

        int lower = 0;
        int upper =0;

//        public int runBinarySearchIteratively(
//        int[] sortedArray, int key, int low, int high) {
            int index = Integer.MAX_VALUE;
            int key = 5;
            int low = 0;
            int high = arr.length - 1;//2

            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] < key) {
                    low = mid + 1;
                } else if (arr[mid] > key) {
                    high = mid - 1;
                } else if (arr[mid] == key) {
                    index = mid;
                    break;
                }
            }
            System.out.println("index = "+ index);
        }






    }



