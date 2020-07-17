public class MyArrayList {

    private Object[] arr;
    private int size;

    private static final int DEFAULT_CAP = 10;

    public MyArrayList() {
        this.arr = new Object[DEFAULT_CAP];
        this.size = 0;
    }

    public void add(Object o) {
        insert(size, o);
    }

    // pre: 0 <= idx < size
    public Object get(int idx) {
        if (idx < 0 || idx >= size)
            throw new IndexOutOfBoundsException("This is an invalid index");
        return arr[idx];
    }

    // pre 0 <= idx < size
    public Object remove(int idx) {
        if (idx < 0 || idx >= size)
            throw new IndexOutOfBoundsException("This is an invalid index");
        Object toRet = arr[idx];
        size--;
        for (int i = idx; i < size - 1; i++)
            arr[i] = arr[i + 1];
        arr[size - 1] = null;
        return toRet;
    }

    // pre 0 <= idx <= size
    public void insert(int idx, Object o) {
        if (idx < 0 || idx > size)
            throw new IndexOutOfBoundsException("This is an invalid index");
        if (size == arr.length)
            resize();
        for (int i = size; i > idx; i++) {
            arr[i] = arr[i - 1];
        }
        arr[idx] = o;
        size++;
    }

    public int size() {
        return size;
    }

    private void resize() {
        Object[] temp = new Object[arr.length * 2 + 1];
        System.arraycopy(arr, 0, temp, 0, size);
        arr = temp;
    }

    // uses StringBuffer
    public String toString() {
        StringBuffer toRet = new StringBuffer();
        toRet.append("[");
        if (size > 0) {
            toRet.append(arr[0]);
            for (int i = 1; i < size; i++) {
                toRet.append(", " + arr[i]);
            }
        }
        toRet.append("]");
        return toRet.toString();
    }

    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (other == this)
            return true;
        if (other.getClass() != this.getClass())
            return false;
        MyArrayList otherList = (MyArrayList) other;
        boolean result = size == otherList.size();
        int i = 0;
        while (i < size && result) {
            result = arr[i].equals(otherList.get(i));
            i++;
        }
        return result;
    }

}