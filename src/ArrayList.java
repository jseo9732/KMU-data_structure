public class ArrayList<E> implements List<E>{
    static int defaultSize = 10;
    int listSize;
    E[] data;

    public ArrayList() {
        this(defaultSize);
    }

    public ArrayList(int size) {
        listSize = 0;
        data = (E[]) new Object[size];
    }

    public void clear(){
        listSize = 0;
    }
    public void insert(int pos, E item){
        for(int i = listSize; i>pos; i--) {
            data[i] = data[i-1];
        }
        data[pos] = item;
        listSize++;
    }
    public void append(E item){
        data[listSize] = item;
        listSize++;
    }
    public void update(int pos, E item){
        data[pos] = item;
    }
    public E getValue(int pos){
        return data[pos];
    }
    public E remove(int pos){
        E ret = data[pos];
        for(int i = pos; i < listSize-1; i++){
            data[i] = data[1+i];
        }
        listSize--;
        return ret;
    }
    public int length(){
        return listSize;
    }

    public ListIterator<E> listIterator() {
        return new ListIterator<E>() {
        int pos = 0;
        public boolean hasNext() { return pos < listSize; }
        public E next() { return data[pos++]; }
        public boolean hasPrevious() { return pos > 0; }
        public E previous() { return data[--pos]; } };
    }

    ];

}