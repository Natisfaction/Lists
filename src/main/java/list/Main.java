package list;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String args[]){
        List l = new List();
        int x[] = new int[2];

        for(int i = 0; i < 10; i++)
            l.add(i);

        System.out.print(l.toString()+"\n"+l.getElements()+"\n");

        x = l.getNumber(4);

        if(x[0] == 0)
            System.out.print(x[1]+"\n");

        System.out.print(l.toString()+"\n"+l.getElements()+"\n");

        x = l.getNumber(4);

        if(x[0] == 0)
            System.out.print(x[1]);
    }
}