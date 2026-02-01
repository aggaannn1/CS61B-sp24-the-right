package deque;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.lang.Math;
public class ArrayDeque61B<T> implements Deque61B{

    Object[] items = null;
    int nextfirst = 4;
    int nextlast = 5;
    int size = 0;
    int capacity = 8;
    public ArrayDeque61B() {
        this.items = (T[]) new Object[capacity];
    }
    public ArrayDeque61B(int a) {
        this.capacity = a;
        this.items = (T[]) new Object[capacity];
    }
    @Override
    public void addFirst(Object x) {
        if (size == capacity) {
            Object[] items1 = (T[]) new Object[2*size];
            for(int i = 1;i <= size;i++)
            {
                items1[i] = get(i);
            }
            nextfirst = 0;
            nextlast = size+1;
            items = items1;
        }
        items[nextfirst] = x;
        nextfirst = Math.floorMod(nextfirst-1,capacity);
        size++;
    }

    @Override
    public void addLast(Object x) {
        if (size == capacity) {
            Object[] items1 = (T[]) new Object[2*size];
            for(int i = 1;i <= size;i++)
            {
                items1[i] = get(i);
            }
            nextfirst = 0;
            nextlast = size+1;
            items = items1;
        }
        items[nextlast] = x;
        nextlast = Math.floorMod(nextlast+1,capacity);
        size++;
    }

    @Override
    public List toList() {
        List<Object> li = new ArrayList<>();
        int i = Math.floorMod(nextfirst+1,capacity);
        if (size == 0)
        {
            return li;
        }
        while (i != nextlast)
        {
            li.add(items[i]);
            i++;
            i = Math.floorMod(i,capacity);
        }
        return li;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public Object removeFirst() {
        if(size<0.25*capacity&&capacity>15) {
            Object[] items1 = (T[]) new Object[capacity/3];
            for(int i = 1;i <= size;i++)
            {
                items1[i] = get(i);
            }
            nextfirst = 0;
            nextlast = size+1;
            items = items1;
            capacity = capacity/3;
        }
        nextfirst = Math.floorMod(++nextfirst,capacity);
        items[nextfirst] = 0;
        size--;
        return null;
    }

    @Override
    public Object removeLast() {
        if(size<0.25*capacity&&capacity>15) {
            Object[] items1 = (T[]) new Object[capacity/3];
            for(int i = 1;i <= size;i++)
            {
                items1[i] = get(i);
            }
            nextfirst = 0;
            nextlast = size+1;
            items = items1;
            capacity = capacity/3;
        }
        nextlast = Math.floorMod(--nextlast,capacity);
        items[nextlast] = 0;
        size--;
        return null;
    }

    @Override
    public Object get(int index) {
        int i = Math.floorMod(nextfirst+index,capacity);
        return items[i];
    }

    @Override
    public T getRecursive(int index) {
        throw new UnsupportedOperationException("No need to implement getRecursive for proj 1b");
    }

    @Override
    public Iterator iterator() {

        return new arrayiterator();
    }
    public class arrayiterator implements Iterator<T>{

        int w = Math.floorMod(nextfirst+1,capacity);
        @Override
        public boolean hasNext() {
            if (w != nextlast) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            T re = (T) items[w];
            w = Math.floorMod(w+1,capacity);
            return re;
        }
    }
    @Override
    public boolean equals(Object a) {
        if (a instanceof ArrayDeque61B up) {
            if (size != up.size()) {
                return false;
            }
            int m = Math.floorMod(nextfirst+1,capacity);
            for (Object i:up) {
                if(items[m] != i) {
                    return false;
                }
                m = Math.floorMod(m + 1,capacity);
            }
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        List<T> k = new ArrayList<>();
        for (Object i:this) {
            k.add((T) i);
        }
        return k.toString();
    }
}