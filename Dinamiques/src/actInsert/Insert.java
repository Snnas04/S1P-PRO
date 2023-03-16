package actInsert;

import java.util.Random;

public class Insert {
    Node first;
    Node last;

    public Insert() {
        this.first = null;
        this.last = null;
    }

    public void showQueue() {
        if (first == null) {
            System.out.println("Empty queue");
            return; 
        }

        Node work = first;

        while (work != null) {
            System.out.println(work.info);
            work = work.next;
        }
        System.out.println();
    }

    public void numRandom(int quantitat) {
        int randomNumber = 0;

        for (int i = 0; i < quantitat; i++) {
            Random rand = new Random();
            randomNumber = rand.nextInt(100);
            // System.out.println(randomNumber);
            insertInNode(randomNumber);
        }
    }

    public void insertInNode(int info) {
        Node work = new Node(info);

        if (first == null || info < first.info) {
            work.next = first;
            first = work;
        } 
        else {
            Node currentNode = first;

            while (currentNode.next != null && info > currentNode.next.info) {
                currentNode = currentNode.next;
            }

            work.next = currentNode.next;
            currentNode.next = work;
        }
    }

    public static void main(String[] args) {
        Insert i = new Insert();
        i.numRandom(5);
        i.showQueue();
    }
}
