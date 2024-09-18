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
    //  20 6 10 10 10 10 10 10


    //idea one :
    // sort array/filter
    // if smaller than bin size put biggest num in first bin,
    // if under capacity put second biggest numb
    // continue down list till list ends or bin is full
    // repeat bins
    public static int[][] frontLoader(int numBoxes, int bSize, int[] nums) {
        int[][] bins = new int[numBoxes + 1][nums.length];
        int[] remainingCapacity = new int[numBoxes];
        Arrays.fill(remainingCapacity, bSize);

        int unusedItemsIndex = 0;

        for (int i = nums.length-1; i >= 0; i--) {
            boolean placed = false;

            for (int j = 0; j < numBoxes; j++) {
                if (nums[i] <= remainingCapacity[j]) {
                    bins[j][i] = nums[i];
                    remainingCapacity[j] -= nums[i];
                    placed = true;
                    break;
                }
            }

            if (!placed) {
                bins[numBoxes][unusedItemsIndex] = nums[i];
                unusedItemsIndex++;
            }
        }

        for (int i = 0; i < bins.length-1; i++) {
            bins[i] = Arrays.stream(bins[i]).filter(x -> x != 0).toArray();
        }

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