package proves;
import java.util.Random;

public class OneLink {
    Node first;
    Node last;

    public OneLink() {
        this.first = null;
        this.last = null;
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

    public void numRandom() {
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            int randomNum = random.nextInt(100);
            System.out.println(randomNum);
            addOnNode(randomNum);
        }
    }

    public void addOnNode(int num) {
        Node work = first;
        if (first == null) {
            first = new Node(num);
        }

        for (work = first; work.next != last; work = work.next) {
            if (num < work.next.info) {
                first = work;
            }

            if (num > work.next.info) {
                last = work;
            }
        }
    }

    public int removeFirstNode() {
        if (first != null) {
            int result = first.info;

            System.out.format("Node whith info: %d has been removed\n", first.info);
            first = first.next;

            return result;
        }

        System.out.println("Nothing to remove");
        return -1;
    }

    public void showQueue() {
        System.out.println("----"); 
        if (first == null) {
            System.out.println("Empty queue");
            return; // acabam la rutina i no retornam res, no es 100% necessari perque la rutina es molt curta, 
                    // pero es molt recomenable
        }

        Node work = first;

        while (work != null) {
            System.out.println(work.info);
            work = work.next;
        }
        System.out.println();
    }

    public int removeLastNode() {
        if (last != null) {
            int result = last.info;
            System.out.format("Node whith info: %d has been removed\n", last.info);

            if (first == last) {
                first = null;
                last = null;
                return result;
            }

            Node work = first;

            while (work.next != last)
                work = work.next;

            last = work;
            work.next = null;

            return result;
        }

        System.out.println("Nothing to remove");
        return -1;
    }

    public static void main(String[] args) {
        OneLink q = new OneLink();
        // q.addFirstNode(666);
        // q.addFirstNode(777);
        // q.addFirstNode(888);
        q.numRandom();
        q.showQueue();
    }
}