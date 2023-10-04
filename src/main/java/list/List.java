package list;
public class List {
    private List sublist;
    private int number, index;

    public List() {
        index = 0;
    }

    private List(int index) {
        this.index = index + 1;
    }

    public int getElements() {
        if(number == 0 && sublist == null) {
            return index;
        }

        return sublist.getElements();
    }

    public void sort() {
        //
    }

    public void reverse() {
        //
    }

    // Remove the latest element
    public int remove() {
        return remove(getElements());
    }

    // Get the number at the index (INDEX STARTS WITH 0)

    // - If the function fails,  an array with -1 and 0 is returned
    // - If the function succeds, an array with 0, and the number requested is returned
    public int[] getNumber(int index) {
        if(index > getElements()) {
            int ret[] = {-1, 0};
            return ret;
        }

        if(index != this.index)
            return sublist.getNumber(index);

        int ret[] = {0, number};
        return ret;
    }

    // Removes a specific element
    public int remove(int index) {
        if(index > getElements())
            return -1;

        if(index != this.index)
            return sublist.remove(index);


        int rec, x[] = new int[2];
        // Removes the element

        x = getNumber(index + 1);
        rec = x[1];

        number = sublist.number;

        if(sublist.number == 0 && sublist.sublist == null) {
            number = 0;
            sublist = null;

            return 0;
        }

        return remove(index + 1);
    }

    public String toString() {
        String ret = new String();

        // Se questo è il primo elemento della lista
        if(index == 0) {
            ret += "{";
        }

        // Se questo è il primo elemento E la sottolista NON è vuota
        if(index == 0 && sublist != null) {
            ret += number;
            ret += sublist.toString();

            return ret;
        }

        // Se l'elemento della lista è 0, e la sottolista esiste (ultimo elemento)
        if(number == 0 && sublist == null) {
            return ret += "}";
        }

        ret += "; ";
        ret += number;

        ret += sublist.toString();

        return ret;
    }

    public void add(int number) {
        if(sublist != null) {
            sublist.add(number);
            return;
        }

        this.number = number;
        sublist = new List(index);
    }
}