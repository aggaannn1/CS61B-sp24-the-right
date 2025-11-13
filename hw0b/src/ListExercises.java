import java.util.ArrayList;
import java.util.List;

public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        // TODO: Fill in this function.
        int a=0;
        for(int i:L)
        {
            a=a+i;
        }
        return a;
    }

    /** Returns a New list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        // TODO: Fill in this function.
        List<Integer> a= new ArrayList();
        for(int i:L)
        {
            if(i%2==0)
            {
                a.add(i);
            }
        }

        return a;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        // TODO: Fill in this function.
        List<Integer> c=new ArrayList<>();
        for(int i:L1)
        {
            for(int j:L2)
            {
                if(i==j)
                {
                    c.add(i);
                }
            }
        }
        return c;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        // TODO: Fill in this function.
        int k=0;
        for(String i:words)
        {
            for(int j=0;j<i.length();j++)
            {
                if(c==i.charAt(j))
                {
                    k++;
                    break;
                }
            }
        }
        return k;
    }
}
