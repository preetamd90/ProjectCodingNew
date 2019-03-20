package example;
import java.util.ArrayList;
import java.util.HashMap;

public class main {

    public static void main(String[] args) {
        //String input = "sqrt(7+5)";
        //boolean ans=areParenthesisPaired(input);
        //System.out.println(ans);

        String sontai = "howdy.com.";
        System.out.println("watch: " + removeTrailingDot(sontai));


        String testInput = "GeeksForGeeks";
        int rotatePoint = 3;
        rotate("left", rotatePoint, testInput); //sForGeeksGeek
        rotate("right", rotatePoint, testInput); //eeksGeeksForG

        String input = "43434tt98121r985h69912608";
        //findZipCodes(input);
        testMap();

        Integer test = Integer.parseInt("50");
        System.out.println("test::" + test);

    }

    /**
     * Returns true if all parenthesis are paired. Else return false
     *
     * @param input
     * @return
     */
    static boolean areParenthesisPaired(String input) {
        char bracketInputString[] = input.toCharArray();

        stack myStack = new stack();

        for (int i = 0; i < bracketInputString.length; ++i) {

            if (bracketInputString[i] == '{' || bracketInputString[i] == '(' || bracketInputString[i] == '[')
                myStack.stackPush(bracketInputString[i]);

            if (bracketInputString[i] == '}' || bracketInputString[i] == ')' || bracketInputString[i] == ']') {
                if (myStack.isStackEmpty() || !areCharectersSame(myStack.stackPop(), bracketInputString[i])) {
                    return false;
                }
            }

        }

        // For matching expression case, stack should be empty
        if (myStack.isStackEmpty())
            return true;
        else {
            return false;
        }
    }

    /**
     * Basic implementation of Stack class with max size 256.
     */
    static class stack {
        int topElement = -1;
        char items[] = new char[256];
        int MAX_STACK_SIZE = 255;

        boolean isStackEmpty() {
            if (topElement == -1) {
                return true;
            } else {
                return false;
            }
        }

        char stackPop() {
            if (topElement == -1) {
                System.out.println("Error: Tried to pop from empty Stack. Cannot process");
                return '\0';
            } else {
                char element = items[topElement];
                topElement--;
                return element;
            }
        }

        void stackPush(char input) {
            if (topElement == MAX_STACK_SIZE) {
                System.out.println("Error: Tried to push in full Stack. Cannot process");
            } else {
                items[++topElement] = input;
            }
        }

    }

    /**
     * Utility method.
     *
     * @param c1
     * @param c2
     * @return
     */
    static boolean areCharectersSame(char c1, char c2) {
        if ((c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']')) {
            return true;
        } else {
            return false;
        }
    }

    static void randomizeArray() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 0;
        int change = 0;
        int temp = list.get(i);   // int temp = arr[i];
        list.set(i, list.get(change));  //arr[i] = arr[change];
        list.set(change, temp); //arr[change] = temp;
    }

    /*
    rotateType left or right
     */
    static void rotate(String rotateType, int rotatePoint, String input) {
        int length = input.length();
        System.out.println();
        System.out.println("original: " + input + " AND rotate Point: " + rotatePoint + " with rotateType:" + rotateType);
        if (rotateType.equalsIgnoreCase("right")) {
            rotatePoint = length - rotatePoint;
        }

        String s1 = input.substring(0, rotatePoint);
        String s2 = input.substring(rotatePoint);
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);

        String ans = s2.concat(s1);
        System.out.println("ans: " + ans);
    }

    static void findZipCodes(String input) {
        int len = input.length();
        String sub;

        for(int i = 0; i<len; i++){
            if(input.charAt(i) == '9'){
                sub = input.substring(i, i+5);
                if(isNumber(sub)){
                    System.out.println(sub);
                }
            }
        }
    }

    static boolean isNumber(String s){
        int len = s.length();
        for (int i=0;i<len;i++) {
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }

    static void testMap(){
        HashMap<Integer, Integer> testMap = new HashMap<Integer, Integer>();
        testMap.put(5, 0);
        System.out.println("see Before:" + testMap);
        Integer count = testMap.get(5);
        count++;
        testMap.put(5, count);
        System.out.println("see After:" + testMap);
    }


    /**
     * Remove a trailing dot if it exists from a given string.
     *
     * @param inputString String
     * @return stringWithTrailingDotRemoved String
     */
    private static String removeTrailingDot(final String inputString) {
        if (inputString.endsWith(".")) {
            return inputString.substring(0, inputString.length() - 1);
        }
        return inputString;
    }

}



