package java8;

public class MyFunction {

    public static void main(String[] args) {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("New thread created");
            }
        }).start();

        Runnable r = ()->System.out.println("New thread created Function");

        new Thread(r).start();



    }
}



