import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList; // import the ArrayList class
public class LinkedListDeque61B<T> implements Deque61B<T> {
    Node sentinel;
    int size = 0;
    private class Node {
        public T x;
        public Node nextnode;
        public Node lastnode;
    }
    public LinkedListDeque61B() {
        this.sentinel = new Node();
        sentinel.nextnode = sentinel;
        sentinel.lastnode = sentinel;
    }
    @Override
    public void addFirst(T x) {
        Node a = new Node();
        a.x = x;
        this.sentinel.nextnode.lastnode = a;
        a.nextnode = this.sentinel.nextnode;
        a.lastnode = this.sentinel;
        this.sentinel.nextnode = a;
        if (sentinel.nextnode.nextnode == sentinel){
            this.sentinel.lastnode = a;
        }
        this.size++;
    }

    @Override
    public void addLast(T x) {
        Node b = new Node();
        b.x = x;
        this.sentinel.lastnode.nextnode = b;
        b.lastnode = this.sentinel.lastnode;
        b.nextnode = this.sentinel;
        this.sentinel.lastnode = b;
        if (sentinel.nextnode.nextnode ==sentinel){
            this.sentinel.lastnode = b;
        }
        this.size++;
    }

    @Override
    public List<T> toList() {
        List<T> li = new ArrayList<T>();
        Node k = this.sentinel.nextnode;
        while (k != sentinel)
        {
            li.add(k.x);
            k = k.nextnode;
        }
        return li;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }
}
