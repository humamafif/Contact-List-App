package Modul;

public class Stack {

    private Node top;

    public Stack() {
        this.top = null;
    }

    public void push(Record data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public Record pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong");
        }
        Record data = top.data;
        top = top.next;
        return data;
    }

    public Record peek() {
        if (isEmpty()) {
            System.out.println("stack kosong");
        }
        return top.data;
    }

    public boolean update(Record updatedRecord) {
        Node current = top;
        while (current != null) {
            if (current.data.equals(updatedRecord)) {
                current.data = updatedRecord;
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
