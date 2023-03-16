import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        AVLTree tree = new AVLTree();
        
        // tree.insert(1);
        // tree.insert(2);
        // tree.insert(3);
        // tree.insert(7);
        // tree.insert(4);
        // tree.insert(8);
        // tree.insert(10);
        // tree.insert(18);
        // tree.insert(21);

        Random random = new Random(666);

        for (int i = 1; i <= 10; i++) {
            tree.insert(random.nextInt(1000));
        }

        tree.print();
    }
}
