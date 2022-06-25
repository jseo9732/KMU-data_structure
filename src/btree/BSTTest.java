package btree;

public class BSTTest {

    public static void main(String[] args) {
        Dictionary<Integer, String> bst = new BST<>();

        bst.insert(11, "a");
        bst.insert(3, "b");
        bst.insert(5, "c");
        bst.insert(20, "d");
        bst.insert(30, "e");
        bst.insert(1, "f");
        bst.insert(40, "g");
        bst.insert(33, "h");
        bst.insert(23, "i");
        bst.insert(44, "j");
        bst.insert(12, "k");
        bst.insert(345, "l");

        BST<Integer, String> bst1 = (BST<Integer, String>) bst;
        bst1.inorder(bst1.getRoot());
    }
}
