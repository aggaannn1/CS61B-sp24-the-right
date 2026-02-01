package deque;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

public class asd {

    public static void main (String[] args) {
        Deque61B<String> lld1 = new ArrayDeque61B<>();

        lld1.addLast("front");
        lld1.addLast("middle");
        lld1.addLast("back");

        System.out.println(lld1);
    }
}
