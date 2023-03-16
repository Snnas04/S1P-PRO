package proves;
// last in first out

public class Stack {
    Node first;
    Node last;

    public Stack() {
        this.first = null;
        this.last = null;
    }

    public void showQueue() {
        System.out.println("----"); if (first == null) {
            System.out.println("Empty queue");
            return; // acabam la rutina i no retornam res, no es necessari perque la rutina es molt curta
        }

        Node work = first;

        while (work != null) {
            System.out.println(work.info);
            work = work.next;
        }
        System.out.println();
    }

    public void addLastNode(int info) {
        Node work = new Node(info);

        if (first == null)
            first = work;
        else
            last.next = work;

        last = work;
    }

    public void addFirstNode(int info) {
        Node work = new Node(info);

        if (first == null)
            last = work;
        else 
            work.next = first;

        first = work;
    }

    public void removeFirstNode() {
        if (first != null) {
            System.out.format("Node whith info: %d has been removed\n", first.info);
            first = first.next;
        }
        else {
            System.out.println("Nothing to remuve");
        }
    }

    public static void main(String[] args) {
        Stack q = new Stack();
        q.addFirstNode(666);
        q.addFirstNode(777);
        q.addFirstNode(888);
        q.showQueue();

        System.out.println(q.last.info);
    }
}