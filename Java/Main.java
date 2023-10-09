package list;

public class Main {
    public static void main(String[] args) {
        List l1 = new List();

        for(int i = 1; i < 9; i++) {
            l1.add(i);
        }

        List l2 = new List(l1);
        l1.add(l2);

        l1.reverse();

        System.out.print(l1.toString()+"\n"+l1.length()+"\n");
    }
}