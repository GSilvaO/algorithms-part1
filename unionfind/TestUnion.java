import java.util.Scanner;

public class TestUnion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numberOfSides = scanner.nextLine();
        int N = Integer.parseInt(numberOfSides);

        //QuickFind qf = new QuickFind(N); // Initialize N components.
        UFCanonicalElement ufCanonicalElement = new UFCanonicalElement(N);

        while(true) {
            String pString = scanner.nextLine();
            if(pString.isEmpty()) break;
            String qString = scanner.nextLine();
            if(qString.isEmpty()) break;
            int p = Integer.parseInt(pString);
            int q = Integer.parseInt(qString);

            if(ufCanonicalElement.connected(p, q)) continue;

            ufCanonicalElement.union(p, q);
            System.out.println("Greater elements number = " + ufCanonicalElement.find(p));
        }

        //System.out.println(ufCanonicalElement.count() + " components");
        scanner.close();
    }
}
