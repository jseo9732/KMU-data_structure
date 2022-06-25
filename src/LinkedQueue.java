public class LinkedQueue<E> implements Queue<E> {
    Link<E> head, tail;
    int size;

    public LinkedQueue() {
        head = tail = new Link<E>(null, null);
        size = 0;
    }

    public void clear(){
        head.next = null;
        tail = head;
        size = 0;
    }

    public void enqueue(E it){
        Link<E> n = new Link<>(it, null);
        tail.next = n;
        tail = n;
        size++;
    }

    public E dequeue(){
        E ret = head.next.item;

        head = head.next;

        if(head.next == tail){
            tail = head;
        }
        head.item = null;
        size--;

        return ret;
    }

    public E frontValue(){
        return head.next.item;
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
        Queue<Integer> myQueue = new LinkedQueue<>();

        myQueue.enqueue(7);
        myQueue.enqueue(3);
        myQueue.enqueue(5);
        myQueue.enqueue(10);
        myQueue.enqueue(1);
        System.out.println(myQueue);

        System.out.println("dequeue value: " + myQueue.dequeue());
        System.out.println("frontValue: " + myQueue.frontValue());

        System.out.println("dequeue value: " + myQueue.dequeue());
        System.out.println(myQueue);

        System.out.println("frontValue: " + myQueue.frontValue());
        System.out.println("length: " + myQueue.length());

        myQueue.clear();
        System.out.println("After" + myQueue);
    }
}

