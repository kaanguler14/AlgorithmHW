package Algo2HW1_2;




import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
	 private Node first; // first node in list
	 private class Node
	 {
	 Item item;
	 Node next;
	 }
	 public void add(Item item)
	 { // same as push() in Stack
	 Node oldfirst = first;
	 first = new Node();
	 first.item = item;
	 first.next = oldfirst;
	 }
	 public void remove(Item item) {
		    //Special occasion: empty bag
		    if (first == null) {
		        return;
		    }

		    // Create an empty node whose first node element is item
		    Node newFirst = new Node();
		    newFirst.next = first;

		    // Now we iterate up to before the item we are looking for in the list.
		    // Update the next of the node behind the newFirst node
		    Node prev = newFirst;
		    while (prev.next != null) {
		        if (prev.next.item.equals(item)) {
		            prev.next = prev.next.next;
		            break;
		        }
		        prev = prev.next;
		    }

		    // Restore the first updated node
		    first = newFirst.next;
		}
		



	 
	 public Iterator<Item> iterator()
	 { return new ListIterator(); }
	 private class ListIterator implements Iterator<Item>
	 {
	 private Node current = first;
	 public boolean hasNext()
	 { return current != null; }

	 public Item next()
	 {
	 Item item = current.item;
	 current = current.next;
	 return item;
	 }
}
	 public static boolean contains(TourGraph G,Integer index,Integer item) {
		 for( int w : G.adj(index)) {
			 if(w==item)
				 return true;
		 }
		 return false;
	 }
	
}
