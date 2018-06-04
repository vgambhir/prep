package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int noOfLine = scan.nextInt();
        scan.nextLine();
        
        List<List<String>> l = new ArrayList<List<String>> ();
        for(int i = 0 ; i<noOfLine; i++)
        {
            String line = scan.nextLine();
            String[] sArr = line.trim().split(" ");
            List<String> l1 = new ArrayList<String>();
            for(int y = 1 ; y < Integer.parseInt(sArr[0])+1; y++)
            { l1.add(sArr[y].trim());  }
            l.add(l1);
            
        }
        
        System.out.println(l);
        
        int noOfQ = scan.nextInt();
        scan.nextLine();
         for(int i = 0 ; i<noOfQ; i++)
        {
             int lineNo = scan.nextInt();
             int elemNo = scan.nextInt();
             scan.nextLine();
             List<String> res = l.get(lineNo -1);
            
             String pResult = null;
             try
             {
                 pResult = res.get(elemNo - 1);
             }
             catch(Exception e)
             {
            	 
             }
             
             
             if (pResult == null)
                 System.out.println ("ERROR!");
             else
                 System.out.println (pResult);
             
             
         }
        
    }
}