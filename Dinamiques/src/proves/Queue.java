package proves;
// first in first out

public class Queue {
    Node first;
    Node last;

    public Queue() {
        this.first = null;
        this.last = null;
    }

    public void addNode(int info) {
        Node work = new Node(info);

        if (first == null)
            first = work;
        else
            last.next = work;

        last = work;
    }

    public void removeNode() {
        if (first != null) {
            System.out.format("Node whith info: %d has been removed\n", first.info);
            first = first.next;
        }
        else {
            System.out.println("Nothing to remuve");
        }
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

    public static void main(String[] args) {
        Queue q = new Queue();
        q.addNode(666);
        q.addNode(717);
        q.addNode(28);
        q.showQueue();
        q.removeNode();
        q.showQueue();
        q.addNode(666);
        q.showQueue();
    }
}