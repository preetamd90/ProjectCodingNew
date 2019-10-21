package dynamic;

import java.util.ArrayList;

public class LongestIncreasingSubsequence {


    // calArray[i] means longestIncreasingSubsequence ending with inputArray[i].
    // For every i in input array, we consider all elements from 0 to i-1 and
    // consider if ith element is greater than jth element, then the list should contain ith element.
    // else calArray[i] should be updated with calArray[j] provided callArray[j] is higher.
    // updates should be replace_max operation basically.
    public void getLongestIncreasingSubsequence(final int[] inputArray) {

        // calArray[i] means longestIncreasingSubsequence ending with inputArray[i].
        ArrayList<Integer> calArray = new ArrayList<Integer>();

        final int length = inputArray.length;
        for(int i = 0; i< length; i++) {
            calArray.add(i, 1);
        }

        int j, temp;
        for(int i = 0; i< length; i++) {
            for(j=0; j<i; j++) {
                if(inputArray[i] > inputArray[j]){
                    calArray.set(i, Math.max(calArray.get(i), calArray.get(j)+1));
                } else {
                    calArray.set(i, Math.max(calArray.get(i), calArray.get(j)));
                }
            }
        }

        System.out.println(calArray.get(length -1));
        return;

    }

    // driver Code. Run from driver package only.
    public static void main(String[] args) {
        System.out.println("hello");
        LongestIncreasingSubsequence test = new LongestIncreasingSubsequence();
        int arr[] = {2, 1, 3, 5, 7};
        test.getLongestIncreasingSubsequence(arr);
    }

}
