package btree;

public class BST<K extends Comparable<K>, E> implements Dictionary<K, E>{

    public class Entry{
        public K key;
        public E element;
        public  Entry(K key, E element) {
            this.key = key;
            this.element = element;
        }
    }

    public void inorder(BinNode<Entry> rt){
        if(rt == null) return;
        inorder(rt.left());
        System.out.println(rt.toString() + rt.element().key + " " + rt.element().element);
        inorder(rt.right());
    }

    private BinNode<Entry> parentNode = null;

    private BinNode<Entry> root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public BinNode<Entry> getRoot(){
        return this.root;
    }


    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public void insert(K k, E e) {
        root = insert_helper(k, e, root,null);
        size++;
    }


    public BinNode<Entry> insert_helper(K k, E e, BinNode<Entry> rt, BinNode<Entry> parentNode) {

        if (rt == null) {
            if(parentNode == null){
                root = new LNode<>(new Entry(k,e));
                return root;
            }
        }
        else if (rt.element().key.compareTo(k) == 0) {
            rt.element().element = e;
        } else if (rt.element().key.compareTo(k) < 0) {

            BinNode<Entry> newNode = insert_helper(k, e, rt.right(), parentNode);

            if (rt.left() == null) {
                rt = new INode<>(new Entry(rt.element().key, rt.element().element), null, newNode);
            }else{
                rt.setRight(newNode);
            }


        } else {
            BinNode<Entry> newNode = insert_helper(k, e, rt.left(), parentNode);

            if(rt.right() == null) {
                rt = new INode<>(new Entry(rt.element().key, rt.element().element), newNode, null);
            }else{
                rt.setLeft(newNode);
            }

        }
        return rt;
    }

    @Override
    public E remove(K k) {
        E ret = find_helper(k, root);
        if(ret != null) {
            root = remove_helper(k, root);
            size--;
        }
        return ret;
    }

    private BinNode<Entry> remove_helper(K k, BinNode<Entry> rt) {
        if(rt.element().key.compareTo(k) > 0) {
            rt.setLeft(remove_helper(k, rt.left()));
        } else if(rt.element().key.compareTo(k) < 0) {
            rt.setRight(remove_helper(k,rt.right()));
        } else { // 찾았다!
            if(rt.left() == null) {
                return rt.right();
            } else if(rt.right() == null) {
                return rt.left();
            } else {
                Entry leftmost = getLeftMost(rt.right());
                rt.setElement(leftmost);
                rt.setRight(removeLeftMost(rt.right()));
                return rt;
            }
        }
        return rt;
    }

    private Entry getLeftMost(BinNode<Entry> rt) {
        BinNode<Entry> cur = rt;
        while (cur.left() != null) {
            cur = cur.left();
        }
        return cur.element();
    }

    private BinNode<Entry> removeLeftMost(BinNode<Entry> rt) {
        if(rt.left() == null) {
            return rt.right();
        } else {
            rt.setLeft(removeLeftMost(rt.left()));
            return rt;
        }
    }

    @Override
    public E removeAny() {
        if(root == null){
            return null;
        }
        BinNode<Entry> node = root;

        while(node.left() != null || node.right() != null){

            //left가 null일 경우
            if(node.left() == null) {
                node = node.right();
            }else{ //left가 null이 아닐 경우
                node = node.left();
            }
        }
        return remove(node.element().key);
    }

    @Override
    public E find(K k) {
        return find_helper(k, root);
    }

    public E find_helper(K k, BinNode<Entry> rt) {
        if (rt == null) {
            return null;
        } else if (rt.element().key.compareTo(k) == 0) {
            return rt.element().element;
        } else if (rt.element().key.compareTo(k) < 0) { // root.element().key.compareTo(k) < 0랑 같음
            return find_helper(k, rt.right());
        } else {
            return find_helper(k, rt.left());
        }
    }

    @Override
    public int size() {
        return size;
    }

}
