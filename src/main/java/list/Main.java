package list;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String args[]) {
        List l1 = new List();

        for(int i = 0; i < 6; i++) {
            l1.add(i);
        }

        List l2 = new List(l1);
        l1.add(l2);

        System.out.print(l1.toString()+"\n"+l1.length()+"\n");
    }
}