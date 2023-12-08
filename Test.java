import edu.princeton.cs.algs4.StdRandom;

public class Test {
    public static void main(String[] args) {
        try {
            System.out.println(args[1]);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("error");
        }

        System.out.println("ok");
    }
}
