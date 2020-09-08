public class ArrayDeque<T> {
    private T[] arr;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        arr = (T[]) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 3;
    }
    private void sizeUp(int newSize) {
        T[] temp = (T[]) new Object[newSize];
        System.arraycopy(arr,0,temp,0,nextLast);
        System.arraycopy(arr,nextLast,temp,nextLast+newSize-size,size-nextLast);
        nextFirst += nextLast+size-1;
        arr = temp;
    }

    public void addFirst(T item) {
        if (size == arr.length) {
            sizeUp(size*2);
        }
        arr[nextFirst] = item;
        nextFirst -= 1;
        if (nextFirst < 0) {
            nextFirst += arr.length;
        }
        size += 1;
    }

    public void addLast(T item) {
        if (size == arr.length) {
            sizeUp(size*2);
        }
        arr[nextLast] = item;
        nextLast += 1;
        if (nextLast >= arr.length) {
            nextLast -= arr.length;
        }
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int pointer = nextFirst + 1;
        for (int i = 0; i < size; i += 1) {
            if (pointer >= arr.length) {
                pointer -= arr.length;
            }
            System.out.print(arr[pointer]);
            System.out.print(" ");
            pointer += 1;
        }
        System.out.println();
    }

    private void sizeDown(int newSize) {
        T[] temp = (T[]) new Object[newSize];
        if (nextFirst == arr.length-1) {
            nextFirst = -1;
        }
        System.arraycopy(arr,0,temp,0,nextLast);
        System.arraycopy(arr,nextFirst+1,temp,nextLast+newSize-size,size-nextLast);
        nextFirst += nextLast+newSize-size-1;
        arr = temp;
    }

    public T removeFirst() {
        int pointer = nextFirst + 1;
        if (pointer >= arr.length) {
            pointer -= arr.length;
        }
        T pop = arr[pointer];
        arr[pointer] = null;
        nextFirst = pointer;
        size -= 1;
        if (size*4 <= arr.length) {
            sizeDown(size * 2);
        }
        return pop;
    }

    public T removeLast() {
        int pointer = nextLast - 1;
        if (pointer >= arr.length) {
            pointer -= arr.length;
        }
        T pop = arr[pointer];
        arr[pointer] = null;
        nextLast = pointer;
        size -= 1;
        if (size*4 <= arr.length) {
            sizeDown(size * 2);
        }
        return pop;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int pointer = nextFirst + 1 + index;
            if (pointer >= arr.length) {
                pointer -= arr.length;
            }
        return arr[pointer];
    }
}
