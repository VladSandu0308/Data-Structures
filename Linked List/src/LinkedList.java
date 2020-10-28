import java.util.HashSet;

class Node {
    int data;
    Node next;

    Node (int d) {
        data = d;
        next = null;
    }
}

public class LinkedList {
    Node head;

    void addLast(int d) {
        Node last = new Node(d);
        if (head == null) {
            head = last;
            return;
        }

        Node curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }


        curr.next = last;
    }

    void delete (int d) {
        if (head.data == d) {
            head = head.next;
            return;
        }

        Node curr = head;
        while (curr.next != null) {
            if (curr.next.data == d) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    void removeDuplicates() {
        HashSet<Integer> set = new HashSet<>();
        Node curr = head, prev = null;

        while (curr != null) {
            if (set.contains(curr.data)) {
                prev.next = curr.next;
            } else {
                set.add(curr.data);
                prev = curr;
            }

            curr = curr.next;
        }
    }

    void printLL() {
        System.out.print("Linked List: ");
        Node n = head;

        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addLast(2);
        list.addLast(3);
        list.addLast(24);
        list.printLL();
        list.delete(3);
        list.printLL();
        list.addLast(2);
        list.addLast(3);
        list.addLast(24);
        list.removeDuplicates();
        list.printLL();




    }
}
