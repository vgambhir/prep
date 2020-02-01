package stack;

import java.util.*;

public class BalancedBracket {


    static String isBalanced1(String s) {
        String[] sArr = s.split("");
        if (sArr.length % 2 != 0)
            return "NO";

        Map<String, String> bracketMap = new HashMap<String, String>();
        bracketMap.put("(", ")");
        bracketMap.put("[", "]");
        bracketMap.put("{", "}");
        for (int x = 0, y = sArr.length - 1; x < sArr.length / 2; x++, y--) {
            if (!bracketMap.getOrDefault(sArr[x].trim(), "*").equalsIgnoreCase(sArr[y].trim())) {
                return "NO";

            }

        }

        return "YES";

    }

    static String isBalanced(String s) {
        String[] sArr = s.split("");
        if (sArr.length % 2 != 0)
            return "NO";

        List<String> startBrackets = Arrays.asList("(", "{", "[");
        Map<String, String> bracketMap = new HashMap<String, String>();
        bracketMap.put("(", ")");
        bracketMap.put("[", "]");
        bracketMap.put("{", "}");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < sArr.length; i++) {
            if (startBrackets.contains(sArr[i])) {
                stack.push(sArr[i]);
            } else {
                // not starting bracket
                    if (stack.empty() || !bracketMap.getOrDefault(stack.peek(), "*").equalsIgnoreCase(sArr[i]))
                        return "NO";
                    else
                        stack.pop();

            }

        }

        if (stack.empty())
            return "YES";
        else
            return "NO";

    }


    public static void main(String[] args) {
        //System.out.println(isBalanced("{(([])[])[]]}"));
        System.out.println(isBalanced("}][}}(}][))]"));


    }


}


/**

 6
 }][}}(}][))]
 [](){()}
 ()
 ({}([][]))[]()
 {)[](}]}]}))}(())(
 ([[)



 NO
 YES
 YES
 YES
 NO
 NO
*/
