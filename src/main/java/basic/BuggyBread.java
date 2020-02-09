package basic;

public class BuggyBread{
    public static void main (String args[]) {
        int x = 50;
        for(int i=1;i <= 100;i++){
            if(i<=50){
                System.out.println(i*2);
            } else {
                System.out.println(i-x);
                x = x - 1;
            }
        }
    }
}