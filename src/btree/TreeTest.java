package btree;

public class TreeTest {
    public static void main(String[] args) {
//        BinNode<String> dog = new INode<>("Dog", null, null);
//        BinNode<String> luck = new INode<>("Luck", null, null);
//        BinNode<String> car = new INode<>("Car", null, null);
//        BinNode<String> home = new INode<>("Home", null, null);
//        BinNode<String> all = new INode<>("All", null, null);
//        BinNode<String> spring = new INode<>("Spring", dog, null);
//        BinNode<String> cake = new INode<>("Cake", luck, car);
//        BinNode<String> act = new INode<>("Act", spring, home);
//        BinNode<String> air = new INode<>("Air", cake, all);
//        BinNode<String> love = new INode<>("Love", act, air);
//
//        preorder(love);
//        System.out.println();
//        inorder(love);
//        System.out.println();
//        postorder(love);

//        BinNode<String> d = new LNode<>("D");
//        BinNode<String> g = new LNode<>("G");
//        BinNode<String> h = new LNode<>("H");
//        BinNode<String> i = new LNode<>("I");
//        BinNode<String> b = new INode<>("B", null, d);
//        BinNode<String> e = new INode<>("E", g, null);
//        BinNode<String> f = new INode<>("F", h, i);
//        BinNode<String> c = new INode<>("C", e, f);
//        BinNode<String> a = new INode<>("A", b, c);
//
//        preorder(a);
//        System.out.println();
//        inorder(a);
//        System.out.println();
//        postorder(a);

        BinNode<String> dog = new LNode<>("Dog");
        BinNode<String> luck = new LNode<>("Luck");
        BinNode<String> car = new LNode<>("Car");
        BinNode<String> home = new LNode<>("Home");
        BinNode<String> all = new LNode<>("All");
        BinNode<String> spring = new INode<>("Spring", dog, null);
        BinNode<String> cake = new INode<>("Cake", luck, car);
        BinNode<String> act = new INode<>("Act", spring, home);
        BinNode<String> air = new INode<>("Air", cake, all);
        BinNode<String> love = new INode<>("Love", act, air);

        preorder(love);
        System.out.println();
        inorder(love);
        System.out.println();
        postorder(love);
    }

    static public <E> void preorder(BinNode<E> rt){
        if(rt == null) return;
        System.out.print(rt.element() + " "); //visit
        preorder(rt.left());
        preorder(rt.right());
    }

    static public <E> void inorder(BinNode<E> rt){
        if(rt == null) return;
        inorder(rt.left());
        System.out.print(rt.element() + " "); //visit
        System.out.println(rt.toString());
        inorder(rt.right());
    }

    static public <E> void postorder(BinNode<E> rt){
        if(rt == null) return;
        postorder(rt.left());
        postorder(rt.right());
        System.out.print(rt.element() + " "); //visit
    }
}











