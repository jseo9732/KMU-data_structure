public class DList<E> implements List<E> {
    DLink<E> head, tail;
    int size;

    public DList() {
        head = new DLink<E>(null, null, null);
        tail = new DLink<E>(null, head, null);
        head.next = tail;
        size = 0;
    }

    public void clear(){
        head.next = tail;
        size = 0;
    }

    public void insert(int pos, E item){
        DLink<E> curr = head;
        for(int i=0; i<pos; i++) {
            curr = curr.next;
        }
        DLink<E> n = new DLink<>(item, curr, curr.next);
        curr.next = n;
        curr.next.next.prev = curr.next;
        size++;
    }

    public void append(E item){
        DLink<E> n = new DLink<>(item, tail.prev, tail);
        tail.prev.next = n;
        tail.prev = n;
        size++;
    }

    public void update(int pos, E item){
        DLink<E> curr = head;
        for(int i = 0; i<pos; i++){
            curr = curr.next;
        }
        curr.next.item = item;
    }

    public E getValue(int pos){
        DLink<E> curr = head;
        for(int i = 0; i<pos; i++){
            curr = curr.next;
        }
        return curr.next.item;
    }

    public E remove(int pos){
        DLink<E> curr = head;
        for(int i=0; i<pos; i++){
            curr = curr.next;
        }

        E ret = curr.next.item;
        curr.next.next.prev = curr;
        curr.next = curr.next.next;
        size--;
        return ret;
    }

    public int length(){
        return size;
    }

    public ListIterator<E> listIterator() {
        return new ListIterator<E>() {
            DLink<E> curr = head;

            public boolean hasNext() {
                return curr.next != tail;
            }

            public E next() {
                curr = curr.next;
                return  curr.item;
            }

            public boolean hasPrevious() {
                return curr != head;
            }

            public E previous() {
                DLink<E> prev = head;
                while(prev.next != curr) {
                    prev = prev.next;
                }
                curr = prev;
                return curr.next.item;
            }
        };
    }

    public String toString(){
        String a = "";
        DLink<E> curr = head;
        for(int i=0; i<size; i++){
            a += curr.next.item + ", ";
            curr = curr.next;
        }
        return a;
    }

    public static void main(String[] args){
        List<Integer> myList = new DList<>();

        myList.append(1);
        myList.append(2);
        myList.append(4);
        myList.insert(2,3);
        myList.append(10);
        System.out.println(myList);

        myList.remove(2);
        System.out.println("Remove " +myList);

        myList.update(3,4);
        System.out.println("Update " + myList);

        System.out.println("getValue: " + myList.getValue(3));
        System.out.println("length: " + myList.length());

        ListIterator<Integer> itr = myList.listIterator();
        while(itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.print(System.lineSeparator());
        while(itr.hasPrevious()) {
            System.out.print(itr.previous() + " ");
        }

        System.out.print(System.lineSeparator());

        myList.clear();
        System.out.println("clear " + myList);
    }
}