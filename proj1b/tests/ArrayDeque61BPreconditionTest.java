import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDeque61BPreconditionTest {

    @Test
    @DisplayName("ArrayDeque61B has no fields besides backing array and primitives")
    void noNonTrivialFields() {
        List<Field> badFields = Reflection.getFields(ArrayDeque61B.class)
                .filter(f -> !(f.getType().isPrimitive() || f.getType().equals(Object[].class) || f.isSynthetic()))
                .toList();

        assertWithMessage("Found fields that are not array or primitives").that(badFields).isEmpty();
    }
    @Test
    void addFirstTest() {
        Deque61B<Integer> all1 = new ArrayDeque61B<>();
        all1.addFirst(1);
        all1.addFirst(2);
        all1.addFirst(3);
        all1.addFirst(4);
        all1.addFirst(5);
        all1.addFirst(6);
        all1.addFirst(7);
        assertThat(all1.toList()).containsExactly(7,6,5,4,3,2,1);
    }
    @Test
    void addLastTest() {
        Deque61B<Integer> all1 = new ArrayDeque61B<>();
        all1.addFirst(1);
        all1.addFirst(2);
        all1.addFirst(3);
        all1.addFirst(4);
        all1.addFirst(5);
        all1.addFirst(6);
        all1.addFirst(7);
        assertThat(all1.toList()).containsExactly(1,2,3,4,5,6,7);
    }
    @Test
    void isEmptyTest() {
        Deque61B<Integer> all2 = new ArrayDeque61B<>();
        assertThat(all2.isEmpty()).isTrue();
        all2.addFirst(1);
        all2.addFirst(2);
        all2.addFirst(3);
        assertThat(all2.isEmpty()).isFalse();
    }
    @Test
    void sizeTest() {
        Deque61B<Integer> all2 = new ArrayDeque61B<>();
        assertThat(all2.size()).isEqualTo(0);
        all2.addFirst(1);
        all2.addFirst(2);
        all2.addFirst(3);
        assertThat(all2.size()).isEqualTo(3);
    }
    @Test
    public void removeFirstTest() {
        Deque61B<Integer> lld1 = new ArrayDeque61B<>();
        lld1.addLast(0);   // [0]
        lld1.addLast(1);   // [0, 1]
        lld1.addFirst(-1); // [-1, 0, 1]
        lld1.addLast(2);   // [-1, 0, 1, 2]
        lld1.addFirst(-2); // [-2, -1, 0, 1, 2]
        lld1.removeFirst();
        assertThat(lld1.toList()).containsExactly(-1,0,1,2);
    }
    @Test
    public void removeLastTest() {
        Deque61B<Integer> lld1 = new ArrayDeque61B<>();
        lld1.addLast(0);   // [0]
        lld1.addLast(1);   // [0, 1]
        lld1.addFirst(-1); // [-1, 0, 1]
        lld1.addLast(2);   // [-1, 0, 1, 2]
        lld1.addFirst(-2); // [-2, -1, 0, 1, 2]
        lld1.removeLast();
        assertThat(lld1.toList()).containsExactly(-2,-1,0,1);
    }
    @Test
    public void getTest() {
        Deque61B<Integer> lld1 = new ArrayDeque61B<>();
        lld1.addLast(0);   // [0]
        lld1.addLast(1);   // [0, 1]
        lld1.addFirst(-1); // [-1, 0, 1]
        lld1.addLast(2);   // [-1, 0, 1, 2]
        lld1.addFirst(-2); // [-2, -1, 0, 1, 2]
        assertThat(lld1.get(3)).isEqualTo(0);
    }
}
