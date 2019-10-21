package driver;

import dynamic.LongestIncreasingSubsequence;
import dynamic.*;

import java.util.regex.Pattern;

public class main {

    public static void main(String[] args) {
        System.out.println("hello");

        int[] weights = {2, 3, 4, 6, 7};
        int[] values = {10, 20, 30, 40, 30};
        int totalW = 10;

        //System.out.println(String.format("see: %s value: %d", weights.length, totalW));
        //knapsack01 knapsack01 = new knapsack01();
        //knapsack01.getOptimumValue(weights, values, totalW);

        Pattern pattern = Pattern.compile("^arn:" + "aws" + ":" + "mobiletargeting" + ":" + "us-east-1"
                + ":([0-9]{12}):templates/(.*)(/(email|sms|apns|gcm|voice|adm|baidu))?$");

        //pattern = Pattern.compile();

        String test = "arn:aws:mobiletargeting:us-east-1:817098224167:templates/templateName/sms";

        System.out.println("result: " + pattern.matcher(test).matches());

        String text = "+434343232323232323";
        System.out.println("see:" + text.matches("[0-9]+"));

    }

}
