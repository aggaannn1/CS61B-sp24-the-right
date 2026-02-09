import java.util.Iterator;
import java.util.Set;

public class BSTMap<k extends Comparable<k>,v> implements Map61B<k,v>{

    private Node root = null;
    int size = 0;
    public class Node {
        k key;
        v value;
        static int size = 0;
        Node rkid = null;
        Node lkid = null;
        Node(k ke,v va) {
            key = ke;
            value = va;
            size++;
        }
        Node get(k ky) {
            if (ky.compareTo(key) == 0) {
                return this;
            }

            if (ky.compareTo(key) > 0) {
                if (rkid == null) {
                    return null;
                }
                return rkid.get(ky);
            }
                if (lkid == null) {
                    return null;
                }
                return lkid.get(ky);
        }
        void change(k ky,v va) {
           if (ky.compareTo(key) == 0) {
               value = va;
           }
           if (ky.compareTo(key) > 0) {
               if (rkid == null) {
                   rkid = new Node(ky,va);
               } else {
                   rkid.change(ky,va);
               }
           }
           if (ky.compareTo(key) < 0) {
               if (lkid == null) {
                   lkid = new Node(ky,va);
               } else {
                   lkid.change(ky,va);
               }
           }

        }
    }
    @Override
    public void put(k key, v value) {
        if (root == null) {
            root = new Node(key,value);
        } else {
            root.change(key,value);
        }
        size = Node.size;
    }

    @Override
    public v get(k key) {
        if (root == null) {
            return null;
        }
        return root.get(key).value;
    }

    @Override
    public boolean containsKey(k key) {
        if (root == null) {
            return false;
        }
        if (root.get(key) == null) {
            return false;
        }
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public Set<k> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public v remove(k key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<k> iterator() {
        throw new UnsupportedOperationException();
    }
}
