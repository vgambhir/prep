package gm;

/**
 * Sum of characters
 */
public class SumOfCharacters {
    public static void main(String[] args) {
        String input = "ABbccc";

        //to lower case
        String lc = input.toLowerCase();

        char[] arr = lc.toCharArray();
        int score = 1;
        for (int i = 0; i < arr.length;i++)
        {
            int x = (arr[i] - 'a' + 1);
            System.out.println(x);
            score = score + x;
        }

        System.out.println(score);


    }

}
