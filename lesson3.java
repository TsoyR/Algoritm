class BinaryTree {
    Node root;

    class Node {
        int value;
        Node left;
        Node right;
        boolean isRed;

        public Node(int value) {
            this.value = value;
            this.isRed = true;
        }
    }

    private void print(Node node) {
        if (node == null)
            return;
        System.out.println(node.value);

        if (node.left != null)
            System.out.println("L:" + node.left.value);

        if (node.right != null)
            System.out.println("R:" + node.right.value);

        print(node.left);
        print(node.right);
    }

    public void print() {
        print(root);
    }

    private Node findNode(int value) { // O(log N)
        Node cur = root;
        while (cur != null) {
            if (cur.value == value) {
                return cur;
            }
            if (cur.value < value) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return null;
    }

    public boolean find(int value) {
        return findNode(value) != null;
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        root = insertNode(root, newNode);
        root.isRed = false;
    }



    private Node insertNode(Node root, Node newNode) {
        if (root == null) {
            return newNode;
        }

        if (newNode.value < root.value) {
            root.left = insertNode(root.left, newNode);
        } else if (newNode.value > root.value) {
            root.right = insertNode(root.right, newNode);
        }

        if (isRed(root.right) && !isRed(root.left)) {
            root = rotateLeft(root);
        }
        if (isRed(root.left) && isRed(root.left.left)) {
            root = rotateRight(root);
        }
        if (isRed(root.left) && isRed(root.right)) {
            flipColors(root);
        }

        return root;
    }

    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.isRed;
    }

    private Node rotateLeft(Node root) {
        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        newRoot.isRed = root.isRed;
        root.isRed = true;
        return newRoot;
    }

    private Node rotateRight(Node root) {
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        newRoot.isRed = root.isRed;
        root.isRed = true;
        return newRoot;
    }

    private void flipColors(Node node) {
        node.isRed = !node.isRed;
        node.left.isRed = !node.left.isRed;
        node.right.isRed = !node.right.isRed;
    }
  
}

public class lesson3 {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        tree.print();
    }
}
