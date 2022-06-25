package btree;

public class LNode<E> implements BinNode<E> {

    public E data;

    public LNode(E data) {
        this.data = data;
    }

    @Override
    public E element() {
        return data;
    }

    @Override
    public E setElement(E item) {
        return data = item;
    }

    @Override
    public BinNode<E> left() {
        return null;
    }

    @Override
    public BinNode<E> right() {
        return null;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }

    public  void  setLeft(BinNode<E> n) {

    }

    public  void  setRight(BinNode<E> n) {

    }

    public String toString() {
        return "LNode: ";
    }
}
