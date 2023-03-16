package Ramon;

import java.util.Random;

public class OneLink
{
    Node first;
    Node last;

    public OneLink()
    {
        this.first = null;
        this.last = null;
    }

    public void addLastNode(int info)
    {
        Node work = new Node(info);

        if (first == null)
            first = work;
        else
            last.next = work;
        last = work;
    }

    public void addFirstNode(int info)
    {
        Node work = new Node(info);

        if (first == null)
            last = work;
        else
            work.next = first;
        first = work;
    }

    public void addOnPlace(int info)
    {
        Node work = new Node(info);

        if (first == null)
        {
            last = work;
            first = work;
            return;
        }

        Node find = first;

        while (find != null && find.info < work.info) find = find.next;

        if (find == null)
        {
            last.next = work;
            last = work;
            return;
        }

        if (find == first)
        {
            work.next = first;
            first = work;
            return;
        }

        Node place = first;

        while (place.next != find) place = place.next;

        work.next = find;
        place.next = work;
    }

    public void addStraight(int info)
    {
        Node place = null;
        Node find = first;

        while (find != null && find.info < info)
        {
            place = find;
            find = find.next;
        }

        if (place == null)
        {
            addFirstNode(info);
            return;
        }

        Node work = new Node(info);

        work.next = find;
        place.next = work;

        if (find == null) last = work;
    }

    public void removeNode(int info) {
        Node place = null;
        Node find  = first;

        while (find != null && find.info != info) {
            place = find;
            find = find.next;
        }

        if (place == null) {
            first = first.next;
            find = null;
            return;
        }

        if (place.next == last) {
            last = place;
            place.next = null;
            return;
        }

        if (find == null) {
            System.out.format("Node with value %d not found\n", info);
            return;
        }

        place.next = find.next;
    }

    public void showQueue()
    {
        System.out.println("----");
        if (first == null)
        {
            System.out.println("Empty queue");
            return;
        }

        Node work = first;

        while (work != null)
        {
            System.out.println(work.info);
            work = work.next;
        }
    }

    public int removeFirstNode()
    {
        if (first != null)
        {
            int result = first.info;

            System.out.format("Node with info: %d has been removed\n", result);
            first = first.next;
            return result;
        }
        System.out.println("Nothing to remove");
        return -1;
    }

    public int removeLastNode()
    {
        if (last != null)
        {
            int result = last.info;
            System.out.format("Node with info: %d has been removed\n", result);

            if (first == last)
            {
                first = null;
                last = null;
                return result;
            }

            Node work = first;

            while (work.next != last) work = work.next;
            last = work;
            work.next = null;

            return result;
        }
        System.out.println("Nothing to remove");
        return -1;
    }

    public static void main(String[] args)
    {
        Random rnd = new Random(13);

        OneLink q = new OneLink();
        for (int i = 0; i < 12; i++) q.addStraight(1 + rnd.nextInt(1000));
        q.showQueue();
    }
}