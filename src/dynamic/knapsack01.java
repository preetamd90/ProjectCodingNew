package dynamic;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

public class knapsack01 {

    public void getOptimumValue(final int[] weights, final int[] values, final int totalW){

        int no_of_items = weights.length;

        int[][] ans = new int[no_of_items + 1][no_of_items + 1];
        int i,j;

        for(i=0; i<no_of_items; i++){
            ans[i][0] = 0;
        }
        for(i=0; i<no_of_items; i++){
            ans[0][i] = 0;
        }

        for(i = 1; i<= no_of_items; i++) {
            for(j=1; j<= totalW; j++) {
                if(j  > weights[i]){
                    //Check whether we can take the item or not
                    ans[i][j] = Math.max(ans[i-1][j], values[i-1]+ans[i][j-weights[j-1]]);
                } else {
                    ans[i][j] = ans[i][j-1];
                }

            }
        }

        System.out.println(ans[no_of_items][totalW]);

    }
}
