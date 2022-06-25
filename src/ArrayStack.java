import java.util.Arrays;

public class ArrayStack<E> implements Stack<E> {
    static int maxSize = 10;
    int top;
    E[] listArray;

    public ArrayStack() {
        this(maxSize);
    }

    public ArrayStack(int size) {
        top = -1;
        listArray = (E[]) new Object[size];
    }

    public void clear(){
        top = -1;
    }

    public void push(E it){
        listArray[++top] = it;
    }

    public E pop(){
        E ret = listArray[top];
        top--;
        return ret;
    }

    public E topValue(){
        return listArray[top];
    }

    public int length(){
        return top + 1;
    }

    public static void main(String[] args){
        ArrayStack<Integer> Slist = new ArrayStack<>();
        Slist.push(1);
        System.out.println(Arrays.toString(Slist.listArray));
        Slist.push(2);
        System.out.println(Arrays.toString(Slist.listArray));
        Slist.push(3);
        Slist.push(4);
        Slist.push(5);
        System.out.println(Arrays.toString(Slist.listArray));
        System.out.println("length: " + Slist.length());

        System.out.println("pop: " + Slist.pop());
        System.out.println("pop length: " + Slist.length());

        System.out.println("topValue: " + Slist.topValue());

        Slist.clear();
        System.out.println("clear length: " + Slist.length());
    }
}

