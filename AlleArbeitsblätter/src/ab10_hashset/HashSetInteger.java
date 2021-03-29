package ab10_hashset;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetInteger {
    // Main Method
    public static void main(String[] args)
    {
        HashSet<Integer> h = new HashSet<Integer>();

        // Adding elements into HashSet usind add()
        h.add(13);
        h.add(05);
        h.add(02);
        h.add(4); // adding duplicate elements

        // Displaying the HashSet
        System.out.println(h);
        System.out.println("List contains 13 or not:"
                + h.contains(13));

        // Removing items from HashSet using remove()
        h.remove(4);
        System.out.println("List after removing 4:"
                + h);

        // Iterating over hash set items
        System.out.println("Iterating over list:");
        Iterator<Integer> i = h.iterator();
        while (i.hasNext())
            System.out.println(i.next());
    }
}
