import com.sun.tools.javac.Main;

public class LinkedList<E> implements List<E>{
    Link<E> head, tail;
    int size;

    public LinkedList() {
        head = tail = new Link<E>(null, null);
        size = 0;
    }

    public void clear(){
        head.next = null;
        tail = head;
        size = 0;
    }
    public void insert(int pos, E item){
        Link<E> curr = head;
        for(int i = 0; i<pos; i++){
            curr = curr.next;
        }
        Link<E> n = new Link<>(item, curr.next);
        curr.next = n;

        if(curr == tail) {
            tail = curr.next;
        }

        size++;
    }
    public void append(E item){
        Link<E> n = new Link<>(item, null);
        tail.next = n;
        tail = n;
        size++;
    }
    public void update(int pos, E item){
        Link<E> curr = head;
        for(int i = 0; i<pos; i++){
            curr = curr.next;
        }
        curr.next.item = item;
    }
    public E getValue(int pos){
        Link<E> curr = head;
        for(int i = 0; i<pos; i++){
            curr = curr.next;
        }
        return curr.next.item;
    }
    public E remove(int pos){
        Link<E> curr = head;
        for(int i = 0; i<pos; i++){
            curr = curr.next;
        }

        E ret = curr.next.item;

        if(curr.next == tail){
            tail = curr;
        }

        curr.next = curr.next.next;
        size--;

        return ret;
    }
    public int length(){
        return size;
    }

    public String toString(){
        String a = "";
        Link<E> curr = head;
        for(int i=0; i<size; i++){
            a += curr.next.item + ", ";
            curr = curr.next;
        }
        return a;
    }

    public static void main(String[] args){
        List<Integer> myList = new LinkedList<>();

        myList.append(7);
        myList.insert(0,3);
        myList.insert(0,5);
        myList.append(10);
        myList.insert(1,1);
        System.out.println(myList);

        myList.update(2,4);
        System.out.println(myList);

        myList.clear();
        System.out.println("After" + myList);
    }

    public ListIterator<E> listIterator() {
        return new ListIterator<E>() {
            Link<E> curr = head;

            public boolean hasNext() {
                return curr != tail;
            }

            public E next() {
                curr = curr.next;
                return  curr.item;
            }

            public boolean hasPrevious() {
                return curr != head;
            }

            public E previous() {
                Link<E> prev = head;
                while(prev.next != curr) {
                    prev = prev.next;
                }
                curr = prev;
                return curr.next.item;
            }
        };
    }
}
