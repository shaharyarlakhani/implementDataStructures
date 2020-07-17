public class MyArrayList {

    private Object[] arr;
    private int size;

    public MyArrayList() {
        this.arr = new Object[10];
        this.size = 0;
    }

    public void add(Object o) {
        insert(size, o);
    }

    // pre 0 <= idx < size
    public Object remove(int idx) {
        Object toRet = arr[idx];
        size--;
        for (int i = idx; i < size - 1; i++)
            arr[i] = arr[i + 1];
        arr[size - 1] = null;
        return toRet;
    }

    // pre 0 <= idx <= size
    public void insert(int idx, Object o) {
        if (size == arr.length)
            resize();
        for (int i = size; i > idx; i++) {
            arr[i] = arr[i - 1];
        }
        arr[idx] = o;
        size++;
    }

    private void resize() {
        Object[] temp = new Object[arr.length * 2 + 1];
        System.arraycopy(arr, 0, temp, 0, size);
        arr = temp;
    }

}