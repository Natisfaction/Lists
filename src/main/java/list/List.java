package list;

public class List {
    private List sublist;
    private int index;
    private Object element;

    public List() {
        index = 0;
    }

    public List(List list) {
        index = 0;
        for(int i = 0; i < list.length(); i++) {
            add(list.getElement(i));
        }
    }

    private List(int index) {
        this.index = index + 1;
    }

    public int length() {
        if(element == null && sublist == null) {
            return index;
        }

        return sublist.length();
    }

    public void reverse() {
        for(int i = 0; i < length() / 2; i++)
            exchange(i, length() - 1 - i);
    }

    public boolean exchange(int source, int destination) {
        if(source < 0 || destination < 0 || source > length() || destination > length())
            return false;

        // Required for objects
        Object sour = getElement(source);
        Object dest = getElement(destination);

        replace(sour, destination);
        replace(dest, source);

        return true;
    }

    // Get the element at the index (INDEX STARTS WITH 0)
    // - If the function fails, null is returned
    // - If the function succeeds, the requested element is returned
    public Object getElement(int index) {
        if(index > length())
            return null;

        if(index != this.index)
            return sublist.getElement(index);

        return element;
    }

    // Remove the latest element
    public boolean remove() {
        return remove(length() - 1);
    }

    // Removes a specific element
    public boolean remove(int index) {
        // Check if the index is greater than the length of the list
        if(index > length() || index < 0)
            return false;

        // Check if the desired element is the current
        if(this.index != index)
            return sublist.remove(index);

        // Removes the element
        // 1) Copy the next element
        if(sublist == null) {
            element = null;
            return true;
        }

        element = sublist.element;

        // 2) Check if this is the last element, if yes remove the reference
        if(sublist.element == null && sublist.sublist == null) {
            element = null;
            sublist = null;

            return true;
        }

        // 3) Else, just repeat till you find the last element
        return remove(index + 1);
    }

    /* Replaces the element, at the position */
    public boolean replace(Object element, int position) {
        if(position < 0 || position > length())
            return false;

        if(position != this.index) {
            return sublist.replace(element, position);
        }

        this.element = element;
        return true;
    }

    // Add function
    public void add(Object... elements) {
        for(Object singleElement: elements) {
            if (sublist != null) {
                sublist.add(singleElement);
            }
            else {
                this.element = singleElement;
                sublist = new List(index);
            }
        }
    }

    public String toString() {
        String ret = new String();

        // Se questo è il primo elemento della lista
        if(index == 0) {
            ret += "{";
        }

        // Se l'elemento della lista è 0, e la sottolista esiste (ultimo elemento)
        if(element == null && sublist == null) {
            return ret += "}";
        }

        if(index != 0)
            ret += ", ";

        if(element instanceof String)
            ret += '"';
        else if (element instanceof Character)
            ret += "'";

        ret += element;

        if(element instanceof String)
            ret += '"';
        else if (element instanceof Character)
            ret += "'";

        ret += sublist.toString();

        return ret;
    }
}