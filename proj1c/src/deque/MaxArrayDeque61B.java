package deque;

import java.util.Comparator;

public class MaxArrayDeque61B<T> extends ArrayDeque61B<T>{
    Comparator<T> cmp;
    public MaxArrayDeque61B(Comparator<T> c) {
        this.cmp = c;
    }
    public T max() {
        if (size == 0) {
            return null;
        }
        int w = Math.floorMod(nextfirst+1,capacity);
        T a = (T) items[w];
        for (Object i:this) {
            if (cmp.compare(a,(T)i)<0) {
                a = (T) i;
            }
        }
        return a;
    }
    public T max(Comparator<T> c) {
        Comparator<T> cmq = c;
        if (size == 0) {
            return null;
        }
        int w = Math.floorMod(nextfirst+1,capacity);
        T a = (T) items[w];
        for (Object i:this) {
            if (cmp.compare(a,(T)i)<0) {
                a = (T) i;
            }
        }
        return a;
    }
}
