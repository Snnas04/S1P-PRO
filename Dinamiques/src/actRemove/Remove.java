package actRemove;

public class Remove {
    Node first;
    Node last;

    public Remove() {
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

    public void addStraight(int info) {
        Node place = null;
        Node find = first;

        while (find != null && find.info < info) {
            place = find;
            find = find.next;
        }

        if (place == null) {
            addFirstNode(info);
            return;
        }

        Node work = new Node(info);

        work.next = find;
        place.next = work;

        if (find == null) last = work;
    }

    public void removeOnPlace(int info) {
        Node place = null;
        Node find  = first;

        while (find != null && find.info != info) {
            place = find;
            find = find.next;
        }

        if (find == null) {
            System.out.format("Node with value %d not found\n", info);
            return;
        }

        if (place == null) {
            first = first.next;
            return;
        }

        if (place.next == last) {
            last = place;
        }

        place.next = find.next;
    }

    public int removeFirstNode() {
        if (first != null) {
            int result = first.info;

            // System.out.format("Node with info: %d has been removed\n", result);
            first = first.next;
            return result;
        }
        System.out.println("Nothing to remove");
        return -1;
    }

    public int removeLastNode() {
        if (last != null) {
            int result = last.info;
            // System.out.format("Node with info: %d has been removed\n", result);

            if (first == last) {
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

    public void showQueue() {
        System.out.println("----");
        if (first == null) {
            System.out.println("Empty queue");
            return;
        }

        Node work = first;

        while (work != null) {
            System.out.println(work.info);
            work = work.next;
        }
    }

    public static void main(String[] args) {
        Remove q = new Remove();
        q.addFirstNode(1);
        q.addFirstNode(2);
        q.addFirstNode(3);
        q.addFirstNode(4);
        q.addFirstNode(5);
        q.showQueue();
        q.removeOnPlace(5);
        q.showQueue();
    }
}