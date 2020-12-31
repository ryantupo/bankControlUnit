
/**
 *
 * @author ryansPC
 */
public class InsertionSortLinkedList {

    public static void main(String[] args) {
        //use for debugging

    }

    //counter
    public int counter2 = 0;

    //nodes
    node head;
    node sorted;

    //node class
    class node {

        double val;
        node next;

        public node(double val) {
            this.val = val;
        }
    }

    //function to add a new node to end of the list
    void push(double val) {
        /* allocate node */
        node newnode = new node(val);
        /* link the old list off the new node */
        newnode.next = head;
        /* move the head to point to the new node */
        head = newnode;

        //increment size counter
        counter2++;
    }

    // function to sort a singly linked list using insertion sort 
    void insertionSort(node headref) {
        // Initialize sorted linked list 
        sorted = null;
        node current = headref;
        // Traverse the given linked list and insert every 
        // node to sorted 
        while (current != null) {
            // Store next for next iteration 
            node next = current.next;
            // insert current in sorted linked list 
            sortedInsert(current);
            // Update current 
            current = next;
        }
        // Update head_ref to point to sorted linked list 
        head = sorted;

    }

    /* 
     * function to insert a new_node in a list. Note that  
     * this function expects a pointer to head_ref as this 
     * can modify the head of the input linked list  
     * (similar to push()) 
     */
    void sortedInsert(node newnode) {
        /* Special case for the head end */
        if (sorted == null || sorted.val >= newnode.val) {
            newnode.next = sorted;
            sorted = newnode;
        } else {
            node current = sorted;
            /* Locate the node before the point of insertion */
            while (current.next != null && current.next.val < newnode.val) {
                current = current.next;
            }
            newnode.next = current.next;
            current.next = newnode;
        }
        counter2++;
    }

    /* Function to return formatted custom linked list */
    String printlist(node head) {
        String text = "";
        while (head != null) {
            text += ("£" + head.val + "\n");
            head = head.next;
        }
        return text;
    }

    //for Collections version (if wanted to use instead of .sort())
//    public static InsertionSortLinkedList createSortedList(double[] unSortedList){
//        InsertionSortLinkedList newList = new InsertionSortLinkedList();
//        for (int i=0;i<unSortedList.length;i++){
//            newList.push(unSortedList[i]);
//        }
//        newList.insertionSort(newList.head);
//        
//        return newList;
//    }
//    
}
