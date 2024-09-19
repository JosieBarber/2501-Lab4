// Josie Barber and El Anderson
import java.util.Scanner;
import java.util.Arrays;


public class BinPacking {
    public static void main(String[] args) {
        //creates new Scanner "sc"
        Scanner sc = new Scanner(System.in);
        // instruction line
        // will not take items of size 0
        System.out.println("enter parameters");
        // first int will be the bin capacity
        int binCapacity = sc.nextInt();
        // second int will be number of items to follow
        int numItems = sc.nextInt();

        int[] nums = new int[numItems];
        // puts rest of ints into array
        for (int i = 0; i < numItems; i++) {
            nums[i] = sc.nextInt(); 
        }
        sc.close();

        // preps the array of numbers to be put into our bin algorithm 
        //(uses insertion sort because has small input quantities)
        insertionSort(nums);

        // calls bin sorting alg on array
        // called frontLoader bc puts biggest numbers into bins first
        int [][] bins = frontLoader(3, binCapacity, nums);

        // Return/Print Statements
        System.out.println("Bin #1 , unused space: " + bins[4][0]);
        System.out.println(Arrays.toString(bins[0]));
        System.out.println("Bin #2 , unused space: " + bins[4][1]);
        System.out.println(Arrays.toString(bins[1]));
        System.out.println("Bin #3 , unused space: " + bins[4][2]);
        System.out.println(Arrays.toString(bins[2]));

        System.out.println("-----Unsued Items-----");
        for (int i = 0; i < bins[3].length; i++) {
                System.out.println(bins[3][i]);
            }

        // Inputs for copy/paste
        //  20 8 12 4 8 15 9 3 1 10
        //  20 6 20 20 20 20 20 20
        //  20 6 10 10 10 10 10 10
    }

    /*
        FrontLoader :
        sort array/filter
        if smaller than bin size put biggest num in first bin,
        if under capacity put second biggest numb
        continue down list till list ends or bin is full
        repeat bins
    */ 
    public static int[][] frontLoader(int numBoxes, int bSize, int[] nums) {
        int[][] bins = new int[numBoxes + 2][nums.length];  //one extra box is for unused imports, second is for capacity
        int[] remainingCapacity = new int[numBoxes];
        Arrays.fill(remainingCapacity, bSize);

        int unusedItemsIndex = 0;
        // creates count for unused space in bins
        // also manages return type issues with remainingCapacity[]
        bins[4][0] = bSize;
        bins[4][1] = bSize;
        bins[4][2] = bSize;

        // traverses each number imported
        for (int i = nums.length-1; i >= 0; i--) {
            boolean placed = false;

            // traverses each of the boxes to find space
            for (int j = 0; j < numBoxes; j++) {
                if (nums[i] <= remainingCapacity[j]) {
                    bins[j][i] = nums[i];
                    bins[4][j] -= nums[i]; //updates unused space
                    remainingCapacity[j] -= nums[i];
                    placed = true;
                    break;
                }
            }

            // adds unused items to unused item bin
            if (!placed) {
                bins[numBoxes][unusedItemsIndex] = nums[i];
                unusedItemsIndex++;
            }
        }

        // removes zeros
        for (int i = 0; i < bins.length-1; i++) {
            bins[i] = Arrays.stream(bins[i]).filter(x -> x != 0).toArray();
        }

        // removes zeros from unused item bin
        bins[3] = Arrays.copyOfRange(bins[3], 0, unusedItemsIndex);

        return bins;
    }

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