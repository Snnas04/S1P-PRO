public class AVLTree {
    private class Node {
        private int value;
        private int height = 0;
        private Node left = null;
        private Node right = null;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "( " + value + " )";
        }
    }

    private Node realRoot;

    public void insert(int value) {
        if (realRoot == null)
            realRoot = new Node(value);
        else
            realRoot = insert(value, realRoot);
    }

    private Node insert(int value, Node root) {
        if (root == null)
            return new Node(value);

        // mes petit
        if (value < root.value)
            root.left = insert(value, root.left);
        
        // mes gran
        else if (value > root.value)
            root.right = insert(value, root.right);
        // es igual
        else
            throw new IllegalArgumentException("value " + value + " is repeated");
        

        setHeight(root);

        return balance(root);
    }

    private Node balance(Node root) {
        // pesa mes de l'esquerra
        if (isLeftHeavy(root)) {
            if (balanceFactor(root.left) < 0)
                root.left = leftRotate(root.left);
           // rotacions
           return rightRotate(root);
        }

        // pesa mes de la dreta
        if (isRightHeavy(root)){
            if (balanceFactor(root.right) > 0)
                root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        // esta balancejat
        return root;
    }

    private Node rightRotate(Node root) {
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;

        setHeight(root);
        setHeight(newRoot);
        
        return newRoot;
    }

    private Node leftRotate(Node root) {
        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;

        setHeight(root);
        setHeight(newRoot);
        
        return newRoot;
    }

    private boolean isLeftHeavy(Node root) {
        return balanceFactor(root) > 1;
    }

    private boolean isRightHeavy(Node root) {
        return balanceFactor(root) < -1;
    }

    private int balanceFactor(Node root) {
        return getHeight(root.left) - getHeight(root.right);
    }

    private void setHeight(Node root) {
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    private int getHeight(Node root) {
        return (root == null) ? -1 : root.height;
    }

    public void print() {
        print(realRoot);
    }

    private void print(Node root) {
        if (root == null)
            return;

        print(root.left);
        System.out.println(root.value + " : height -> " + root.height); 
        print(root.right);
    }
}
