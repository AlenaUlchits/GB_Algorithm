package hw4;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        for (int i = 1; i <= 8; i++) {
            if (i != 2)
                tree.insert(i);
        }
       System.out.println(tree.find(10));


    }
}
