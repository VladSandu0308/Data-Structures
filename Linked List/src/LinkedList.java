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

    LinkedList() {
        head = null;
    }

    LinkedList(Node n) {
        head = n;
    }

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

    int kthToLast(Node n, int d) {
        if (n == null) {
            return 0;
        }
        int k = kthToLast(n.next, d) + 1;

        if (k == d) {
            System.out.println("Element at position " + d + " is " + n.data);
        }
        return k;
    }

    void deleteNode (Node n) {
        if (n == null) {
            return;
        }
        n.data = n.next.data;
        n.next = n.next.next;

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

    LinkedList partionList(Node n, int part) {
        Node min = n, max = n;

        while (n != null) {
            Node next = n.next;
            if (n.data < part) {
                n.next = min;
                min = n;
            } else {
                max.next = n;
                max = n;

            }
            n = next;
        }

        max.next = null;
        return new LinkedList(min);

    }

    Node sumList (Node n1, Node n2, int carry) {
        if (n1 == null && n2 == null && carry == 0) return null;

        int val = carry;
        if (n1 != null) {
            val += n1.data;
        }
        if (n2 != null) {
            val += n2.data;
        }

        Node n3 = new Node(val % 10);

        carry = (val > 9) ? 1 : 0;
        n3.next = sumList(n1 == null ? null : n1.next,
                            n2 == null ? null : n2.next, carry);

        return n3;
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.printLL();
        list.delete(3);
        list.printLL();
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.removeDuplicates();
        list.printLL();

        list.addLast(2);
        list.addLast(3);
        list.addLast(5);
        list.kthToLast(list.head,4);
        list.deleteNode(list.head.next.next.next);
        list.printLL();

        LinkedList partition = list.partionList(list.head, 10);
        partition.printLL();

        LinkedList sum = new LinkedList(list.sumList(partition.head, partition.head, 0));
        sum.printLL();

    }
}
