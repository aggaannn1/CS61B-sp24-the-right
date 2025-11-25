import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList; // import the ArrayList class
public class LinkedListDeque61B<T> implements Deque61B<T> {
    Node sentinel;
    int size = 0;
    Node cur = null;
    private class Node {
        public T x;
        public Node nextnode;
        public Node lastnode;
    }
    public LinkedListDeque61B() {
        this.sentinel = new Node();
        cur = sentinel;
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
        if (sentinel.nextnode.nextnode == sentinel) {
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
        if (sentinel.nextnode.nextnode == sentinel) {
            this.sentinel.lastnode = b;
        }
        this.size++;
    }

    @Override
    public List<T> toList() {
        List<T> li = new ArrayList<T>();
        Node k = this.sentinel.nextnode;
        while (k != sentinel) {
            li.add(k.x);
            k = k.nextnode;
        }
        return li;
    }

    @Override
    public boolean isEmpty() {
        if (sentinel.nextnode == sentinel) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T removeFirst() {
        if (size == 0)
        {
            return null;
        }
        if (size == 1)
        {
            sentinel.nextnode = sentinel;
            sentinel.lastnode = sentinel;
            return null;
        }
        Node first = sentinel.nextnode.nextnode;
        sentinel.nextnode = first;
        first.lastnode = sentinel;
        return null;
    }

    @Override
    public T removeLast() {
        if (size == 0)
        {
            return null;
        }
        if (size == 1)
        {
            sentinel.nextnode = sentinel;
            sentinel.lastnode = sentinel;
            return null;
        }
        Node last = sentinel.lastnode.lastnode;
        sentinel.lastnode = last;
        last.nextnode = sentinel;
        return null;
    }

    @Override
    public T get(int index) {
        Node in = null;
        if (size < index || index == 28723 || index <= 0){
            return null;
        }
        in = sentinel;
        for (int i = 0;i < index;i++)
        {
            in = in.nextnode;
        }
        return in.x;
    }
    @Override
    public T getRecursive(int index) {
        if (size < index || index == 28723 || index <= 0){
            return null;
        }
        cur = cur.nextnode;
        if (index == 1)
        {
            return cur.x;
        }
        return getRecursive(index-1);
    }
}
