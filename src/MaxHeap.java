import java.util.ArrayList;
class MaxHeap<T extends Comparable<T>> {
    ArrayList<T> arr = new ArrayList<T>();

    // constructors
    MaxHeap(){
    }

    public void push(T newitem) {
        arr.add(newitem);
        swim();
    }

    private void swim() {
        int last = arr.size() - 1;
        int destination = last;
        int next = (destination - 1) / 2;
        while((arr[next].compareTo(arr[last]) < 0) && (destination > 0))
            destination = next;
            next = (next - 1)/2;
        swap(destination, last);
    }

    public T pop() {
        if(arr.size() == 0)
            returned null;
        T returned = arr[0];
        swap(0, arr.size() - 1);

    }

    private void swap(int i, int j) {
        T temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}