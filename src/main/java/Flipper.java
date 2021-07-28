import java.util.ArrayList;
import java.util.Arrays;

public class Flipper {
    static int[] sorted;
    static int globalFlipsCounter = 1; //just for the nice print :)
    public static void main(String[] args) {
//        int[] arr = {3, 2, Integer.MAX_VALUE, 4, 1, Integer.MIN_VALUE, };
        int[] arr = {3, 2, 4, 1,};
        System.out.println("Initial State: " + Arrays.toString(arr));
        System.out.println("======");
        ArrayList res = flipSort(arr); //Arraylist was used for dynamic array length
        System.out.println("Actions sequence: " + res);
    }
    static ArrayList<Integer> flipSort(int[] arrToFlip) {
        ArrayList<Integer> actions = new ArrayList<>();
        //First make the validation
        if (validateInput(arrToFlip) == false) {
            return actions;
        }
        for (int i = arrToFlip.length - 1; i > 0; i--) {
            //go over array and flip numbers twice every cycle: first time - put the new largest number first, second - send it to the end.
            if (sorted(arrToFlip, sorted)) { //avoid double action if array is sorted before the first flip
                return actions;
            }
            int maxIndex = findLargestIndex(arrToFlip, i); //find the largest index, starting from the end
            if (!(maxIndex == 0)) { //if it is the first, skip as it will do nothing anyway
                reverse(arrToFlip, maxIndex);
                actions.add(maxIndex + 1); //add to actions
            }
            if (sorted(arrToFlip, sorted)) { //avoid double action if array is sorted before the second flip
                return actions;
            }
            reverse(arrToFlip, i); //flip
            actions.add(i + 1); //add to actions
        }
        return actions;
    }
    static boolean validateInput(int[] arrToFlip) {
        sorted = arrToFlip.clone(); // just copy the original
        Arrays.sort(sorted); //and sort it - to compare with original and check if original is already sorted
        if (arrToFlip.length < 2 || arrToFlip.length > 100) { //check if there are at least 2 numbers, if not return empty array
            System.out.println("Warning, input array should contain more than 2 integers and less than 100");
            return false;
        } else if (sorted(arrToFlip, sorted)) { //initial check to not enter the loop in case it is already sorted
            System.out.println("Warning, input array is sorted");
            return false;
        }
        return true;
    }
    //check if array sorted (equals to expedted sorted array)
    public static boolean sorted(int[] sorted, int[] arrToFlip) {
        return Arrays.equals(sorted, arrToFlip);
    }
    static int findLargestIndex(int[] arr, int end) {
        int maxIndex = 0;
        int maxNumber = Integer.MIN_VALUE;
        for (int i = 0; i <= end; i++) {
            if (arr[i] > maxNumber) {
                maxNumber = arr[i];
                maxIndex = i;
            }
        }
        //System.out.println(String.format("The new max num : %d, the max index : %d", maxNumber, maxIndex));
        return maxIndex;
    }
    static int[] reverse(int[] subArray, int index) {
        System.out.println("flip " + globalFlipsCounter);
        System.out.println("replace first " + (index + 1) + " integers");
        System.out.println("from " + Arrays.toString(subArray));
        //reverse array according to the given index
        for (int i = 0; i < (index + 1) / 2; i++) {
            int temp = subArray[i];
            subArray[i] = subArray[index - i];
            subArray[index - i] = temp;
        }
        System.out.println("to " + Arrays.toString(subArray));
        globalFlipsCounter++;
        System.out.println("======");
        System.out.println("");
        return subArray;
    }
}

