package Node2;

import java.util.Random;

public class TwoLink {
    Node2 first;
    Node2 last;

    public TwoLink() {
        this.first = null;
        this.last = null;
    }

    public void addFirstNode(int value) {
        Node2 work = new Node2(value);

        if (first == null) {
            last = work;
        }
        else {
            work.next = first;
            first.previous = work;
        }

        first = work;
    }


    public void addLastNode(int value) {
        Node2 work = new Node2(value);

        if (first == null) {
            first = work;
        }
        else {
            last.next = work;
            work.previous = last;
        }

        last = work;
    }

    public void addStraight(int value) {
        Node2 place = first;

        while (place != null && place.value  < value)
            place = place.next;

        if (place  == null) {
            addLastNode(value);
            return;
        }

        if (place == first) {
            addFirstNode(value);
            return;
        }

        Node2 work = new Node2(value);

        work.next = place;
        work.previous = place.previous;
        place.previous = work;
        work.previous.next = work;
    }

    public void addStraightTow(int value) {
        Node2 place = null;
        Node2 find = first;

        while (find != null && find.value  < value) {
            place = find;
            find = find.next;
        }

        if (place  == null) {
            addLastNode(value);
            return;
        }

        if (find == null) {
            addLastNode(value);
            return;
        }

        Node2 work = new Node2(value);

        work.next = find;
        work.previous = place;
        find.previous = work;
        place.next = work;
    }


    public void removeFirstNode() {
        if (first != null) {
            first = first.next;
            if (first != null)
                first.previous = null;
            else
             last = null;
        }
    }

    public void removeLastNode() {
        if (last != null) {
            last = last.previous;
            if (last != null)
                last.next = null;
            else
                first = null;
        }
    }

    public void removeNode(int value) {
        if (first == null) {
            System.out.println("Nothing ot remove");
            return;
        }

        Node2 find = first;

        while (find != null && find.value != value)
            find = find.next;
        
        if (find == null) {
            System.out.format("Element %d not found", value);
            return;
        }

        if (find == first) {
            removeFirstNode();
            return;
        }

        if (find == last) {
            removeLastNode();
            return;
        }

        find.next.previous = find.previous;
        find.previous.next = find.next;
    }



    public void showNodeFront() {
        if (first == null) {
            System.out.println("Nothing to show");
            return;
        }

        Node2 work = first;

        while (work != null) {
            System.out.println(work.value);
            work = work.next;
        }
    }

    public void showNodeBack() {
        if (last == null) {
            System.out.println("Nothing to show");
            return;
        }

        Node2 work = last;

        while (work != null) {
            System.out.println(work.value);
            work = work.previous;
        }
    }



    public void sortTest() {
        TwoLink nova = new TwoLink();
        Node2 work = first;
        
        while (work != null) {
            nova.addStraight(work.value);
            work = work.next;
        }

        this.first = nova.first;
        this.last = nova.last;
    }

    public static void main(String[] args) {
        Random rndNum = new Random(666);

        TwoLink tl = new TwoLink();
        
        for (int i = 0; i < 5; i++) {
            tl.addLastNode(1 + rndNum.nextInt(100));
        }

        tl.showNodeFront();
        System.out.println("-----");
        tl.sortTest();
        tl.addStraight(15);
        tl.showNodeFront();
    }
}
