import java.util.Scanner;
import java.util.Arrays;


public class BinPacking {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter parameters");
        int binCapacity = sc.nextInt();
        int numItems = sc.nextInt();

        int[] nums = new int[numItems];

        for (int i = 0; i < numItems; i++) {
            nums[i] = sc.nextInt(); 
        }
        sc.close();

        insertionSort(nums);

        // for (int i = 0; i < numItems; i++) {
        //     System.out.println(nums[i]);
        // }

       int [][] bins = frontLoader(3, binCapacity, nums);

     System.out.println(Arrays.toString(bins[0]));
     System.out.println(Arrays.toString(bins[1]));
     System.out.println(Arrays.toString(bins[2]));

    System.out.println("-----Unsued Items----- \n");
     for (int i = 0; i < bins[3].length; i++) {
            System.out.println(bins[3][i]);
        }





    }

    //  20 8 12 4 8 15 9 3 1 10
    //  20 6 20 20 20 20 20 20


    //idea one :
    // sort array/filter
    // if smaller than bin size put biggest num in first bin,
    // if under capacity put second biggest numb
    // continue down list till list ends or bin is full
    //repeat bins
    public static int[][]  frontLoader(int numBoxes, int bSize, int[] nums){

        int[][] bins = new int[numBoxes + 1][bSize];
        insertionSort(nums);

        int hi = nums.length-1;// Index or Pointer to highest applicable value
        int lo = 0;// Index or Pointer to lowest applicable value
        int workingBox = 0;
        int unusedItemsIndex = 0;

        for (int i = lo; i < hi+1; i++) {
            if (nums[i] == bSize){
                if (workingBox != 3) {
                // System.out.println(workingBox);
                bins[workingBox][0] = nums[i];
                workingBox++;
                } else {
                    bins[workingBox][unusedItemsIndex] = nums[i];
                    unusedItemsIndex++;
                }
            }

            if (nums[i] + nums[lo] == bSize) {
                bins[workingBox][0] = nums[i];
            }
        }



        // for (int i = lo; i < hi; i++) {
        //     if(nums[i] + nums[hi] <= bSize) {

        //     }
        // }




        return bins;


    }



    //idea two:
    // sort
    // put biggest and smallest inm bin
    // go through all









    public static void insertionSort(int[] A) {
        int n = A.length;
        for (int j = 1; j < n; j++) {
            int key = A[j];
            int i = j-1;
            while ( (i > -1) && (A[i] > key) ) {
                A [i+1] = A [i];
                i--;
            }
            A[i+1] = key;
        }
    }



}