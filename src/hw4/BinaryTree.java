package hw4;
public class BinaryTree {
    Node root;
    public boolean insert(int value) {
        if(root != null){
            boolean result = insert(root, value);
            root = rebalance(root);
            root.color = Colors.BLACK;
            return result;
        } else {
            root = new Node();
            root.color = Colors.BLACK;
            root.value = value;
            return true;
        }
    }

    private boolean insert(Node node, int value) {
        if (node.value == 0)
            return false;
        if (node.value > value) {
            if (node.left != null) {
                boolean result = insert(node.left, value);
                node.left = rebalance(node.left);
                return result;
            } else {
                node.left = new Node();
                node.left.color = Colors.RED;
                node.left.value = value;
                return true;
            }
        } else {
            if (node.right != null) {
                boolean result = insert(node.right, value);
                node.right = rebalance(node.right);
                return result;
            } else {
                node.right = new Node();
                node.right.color = Colors.RED;
                node.right.value = value;
                return true;
            }
        }
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.right != null && result.right.color == Colors.RED
                    && (result.left == null || result.left.color == Colors.BLACK)) {
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.left != null && result.left.color == Colors.RED
                    && result.left.left != null && result.left.left.color == Colors.RED) {
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.left != null && result.left.color == Colors.RED
                    && result.right != null && result.right.color == Colors.RED) {
                needRebalance = true;
                colorSwap(result);
            }
        } while (needRebalance);
        return result;
    }

    private void colorSwap(Node node) {
        node.right.color = Colors.BLACK;
        node.left.color = Colors.BLACK;
        node.color = Colors.RED;
    }

    private Node leftSwap(Node node) {
        Node leftChild = node.left;
        Node between = leftChild.right;
        leftChild.right = node;
        node.left = between;
        leftChild.color = node.color;
        node.color = Colors.RED;
        return leftChild;
    }

    private Node rightSwap(Node node) {
        Node rightChild = node.right;
        Node between = rightChild.left;
        rightChild.left = node;
        node.right = between;
        rightChild.color = node.color;
        node.color = Colors.RED;
        return rightChild;
    }

    public boolean find(int value) {
        return find(root, value);
    }

    private boolean find(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (node.value == value) {
            return true;
        }

        if (node.value < value) {
            return find(node.right, value);
        } else {
            return find(node.left, value);
        }
    }

}
