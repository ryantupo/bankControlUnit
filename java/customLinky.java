
public class customLinky {

    public static CustomListLinky crunchifyList;

    public static void main(String[] args) {

        // Default constructor - let's put "0" into head element.
        crunchifyList = new CustomListLinky();

        // add more elements to LinkedList
        crunchifyList.addLast("1");
        crunchifyList.addLast("2");
        crunchifyList.addLast("3");
        crunchifyList.addLast("4");
        crunchifyList.addLast("5");
        System.out.println(crunchifyList);
        crunchifyList.removeFirst();
        System.out.println(crunchifyList);

        /*
		 * Please note that primitive values can not be added into LinkedList directly. They must be converted to their
		 * corresponding wrapper class.
         */
        System.out.println("Print: crunchifyList: \t\t" + crunchifyList);
        System.out.println(".size(): \t\t\t\t" + crunchifyList.size());
        System.out.println(".get(3): \t\t\t\t" + crunchifyList.get(3) + " (get element at index:3 - list starts from 0)");
        System.out.println(".remove(2): \t\t\t\t" + crunchifyList.remove(2) + " (element removed)");
        System.out.println(".get(3): \t\t\t\t" + crunchifyList.get(3) + " (get element at index:3 - list starts from 0)");
        System.out.println(".size(): \t\t\t\t" + crunchifyList.size());
        System.out.println("Print again: crunchifyList: \t" + crunchifyList);
    }

}

class CustomListLinky {

    private int counter;
    public Node head;

    // Default constructor
    public CustomListLinky() {

    }

    // appends the specified element to the end of this list.
    public void addLast(Object data) {

        // Initialize Node only incase of 1st element
        if (head == null) {
            head = new Node(data);
        }

        Node customTempNode = new Node(data);
        Node customCurrentNode = head;

        // Let's check for NPE before iterate over crunchifyCurrent
        if (customCurrentNode != null) {

            // starting at the head node, crawl to the end of the list and then add element after last node
            while (customCurrentNode.getNext() != null) {
                customCurrentNode = customCurrentNode.getNext();
            }

            // the last node's "next" reference set to our new node
            customCurrentNode.setNext(customTempNode);
        }

        // increment the number of elements variable
        incrementCounter();
    }

    public int getCounter() {
        return counter;
    }

    private void incrementCounter() {
        counter++;
    }

    private void decrementCounter() {
        counter--;
    }

    // inserts the specified element at the specified position in this list
    //basically pushes the node at index wanted forward and reassigns the node before's next to our new node
    public void add(Object data, int index) {
        Node customTempNode = new Node(data);
        Node customCurrentNode = head;

        // Let's check for NPE before iterate over crunchifyCurrent
        if (customCurrentNode != null) {
            // crawl to the requested index or the last element in the list, whichever comes first
            for (int i = 0; i < index && customCurrentNode.getNext() != null; i++) {
                customCurrentNode = customCurrentNode.getNext();

                // set the new node's next-node reference to this node's next-node reference
                customTempNode.setNext(customCurrentNode.getNext());

                // now set this node's next-node reference to the new node
                customCurrentNode.setNext(customTempNode);

                // increment the number of elements variable
                incrementCounter();
            }
        }

    }

    //loops through nodes until it hits the index specified and returns the nodes data
    public Object get(int index) // returns the element at the specified position in this list.
    {
        // index must be 1 or higher
        if (index < 0) {
            return null;
        }
        Node customCurrentNode = null;
        if (head != null) {
            customCurrentNode = head.getNext();

            for (int i = 0; i < index; i++) {
                if (customCurrentNode.getNext() == null) {
                    return null;
                }

                customCurrentNode = customCurrentNode.getNext();
            }
            return customCurrentNode.getData();
        }
        return customCurrentNode;

    }

    // removes the element at the specified position in this list.
    //loops through until we get to the node before the one to be deleted
    //then set the node to be deleted as the .next one
    public boolean remove(int index) {

        // if the index is out of range, exit
        if (index < 1 || index > size()) {
            return false;
        }

        Node customCurrentNode = head;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                if (customCurrentNode.getNext() == null) {
                    return false;
                }

                customCurrentNode = customCurrentNode.getNext();
            }
            customCurrentNode.setNext(customCurrentNode.getNext().getNext());

            // decrement the number of elements variable
            decrementCounter();
            return true;

        }
        return false;
    }

    // removes the element at first index of the list.
    public boolean removeFirst() {

        Node customCurrentNode = head;
        if (head != null) {
            head = customCurrentNode.getNext();

            // decrement the number of elements variable
            decrementCounter();
            return true;

        } else {

        }
        return false;
    }

    // returns the number of elements in this list.
    public int size() {
        return getCounter();
    }

    public String toString() {
        String output = "";

        if (head != null) {
            Node customCurrentNode = head.getNext();
            while (customCurrentNode != null) {
                output += "[" + customCurrentNode.getData().toString() + "]";
                customCurrentNode = customCurrentNode.getNext();
            }

        }
        return output;
    }

    private class Node {
        // reference to the next node in the chain, or null if there isn't one.

        Node next;

        // data carried by this node. could be of any type you need.
        Object data;

        // Node constructor
        public Node(Object dataValue) {
            next = null;
            data = dataValue;
        }

        // another Node constructor if we want to specify the node to point to.
        @SuppressWarnings("unused")
        public Node(Object dataValue, Node nextValue) {
            next = nextValue;
            data = dataValue;
        }

        // these methods should be self-explanatory
        public Object getData() {
            return data;
        }

        @SuppressWarnings("unused")
        public void setData(Object dataValue) {
            data = dataValue;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node nextValue) {
            next = nextValue;
        }

    }

    public InsertionSortLinkedList createSortedList() {
        InsertionSortLinkedList newList = new InsertionSortLinkedList();

        Node current = this.head;
//        while (current != null) {
//            newList.push((Double) current.getData());
//            current = current.getNext();
//            System.out.println("blah");
//        
//
//        }
        System.out.println("asdasasd");
        for (int i = 0; i<this.counter;i++){
            newList.push((Double) current.getData());
            current = current.getNext();
            System.out.println("blah");
        }
        
        return newList;
    }

}
