package Problem2;

// all functions assume using dummy node
public class SingleLinkedList {
    // do not add member variables
    private ListNode head;
    private int size;

    public SingleLinkedList() {
        head = new ListNode();  // dummy node
    }

    // copy constructor
    public SingleLinkedList(SingleLinkedList list) {
        head = new ListNode(); // dummy node
        //iterate through other list
        ListNode currentOther = list.head.next;
        while(currentOther!=null){
            //add the new values to our current list
            add(currentOther.val);
            currentOther=currentOther.next;
        }
    }

    public int removeAll(int valueToRemove) {
        int counter = 0;
        //iterate through list
        ListNode current = head;
        while(current!=null){
            //if we have a next node, check its value, remove it if needed by:
                //setting our current next to the next of the node we want to remove.
            if(current.next!=null){
                if(current.next.val==valueToRemove){
                    current.next=current.next.next;
                    //increment our counter
                    counter++;
                }
                //if we didnt remove, carry on
                else{
                    current=current.next;
                }
            }
            //if we dont have any more nodes, make the current one null so we stop the loop
            else{
                current=current.next;
            }
        }
        //remember to modify the size
        size = size-counter;
        return counter;

    }

    // reverse the linked list nodes iteratively (no recursion)
    // referenced: https://www.geeksforgeeks.org/reverse-a-linked-list/
    public void reverse() {
        //if we have no data or only one node, then we dont need to do anything
        if(size == 0 || size==1){
            return;
        }

        //save the dummy node so we can set the next pointer to the new front of the list
        ListNode dummy = head;

        //the prev and next variables will eventually be the new back and front of the list
        ListNode prev = null;
        ListNode next = null;

        //start at head.next because we dont want to reverse the dummy node into the list
        ListNode current = head.next;

        //swaps pointers similar to swapping integers in an array
        while(current!=null){
            //save the next node that we will need to move a pointer for
            next = current.next;
            //change our pointer to the other direction
            current.next = prev;
            //move up the previous node to the spot we just finished reversing
            prev = current;
            //move the current position forward down the list
            current = next;
        }
        //set our dummy pointer equal to the final element in the, now reversed, linked list
        dummy.next = prev;
    }

    // do not change any function below

    public SingleLinkedList(int[] data) {
        this();
        if (data == null) {
            return;
        }
        ListNode ptr = head;
        for (int datum : data) {
            ptr.next = new ListNode(datum);
            ptr = ptr.next;
            size++;
        }
    }

    // Appends the specified element to the end of this list
    public void add(int val) {
        size++;
        ListNode ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = new ListNode(val);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode ptr = head.next;
        while (ptr != null) {
            builder.append(ptr.val).append(ptr.next == null ? " -> end " : " -> ");
            ptr = ptr.next;
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof SingleLinkedList)) {
            return false;
        }

        SingleLinkedList otherList = (SingleLinkedList) obj;

        if (this.size != otherList.size) {
            return false;
        }
        ListNode n1 = head.next;
        ListNode n2 = otherList.head.next;
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return (n1 == null && n2 == null);
    }

    public int getSize() {
        return size;
    }
}
