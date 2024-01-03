package Modul;

public class LinkedList {

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void add(Record data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Node find(String nama) {
        Node current = head;
        while (current != null) {
            if (current.data.getNama().equals(nama)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void delete(String nama) {
        Node current = head;
        Node prev = null;

        while (current != null && !current.data.getNama().equals(nama)) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            if (prev == null) {
                head = current.next;
            } else {
                prev.next = current.next;
            }
        }
    }

    public Node getHead() {
        return head;
    }

    public boolean update(Record updatedRecord) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(updatedRecord)) {
                current.data = updatedRecord;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void display() {
        System.out.println("Linked List: ");
        Node current = head;
        while (current != null) {
            System.out.println(current.data.getNoTelp() + ", " + current.data.getNama());
            current = current.next;
        }
    }
}
