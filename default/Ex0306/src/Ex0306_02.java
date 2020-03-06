import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Ex0306_02 {

    //HashSet
    public static void main(String[] args) {
        LinkedHashSet set1 = new LinkedHashSet<>();

        set1.add("1");
        set1.add("5");
        set1.add("3");
        set1.add("4");
        set1.add("8");
        set1.add("8");
        set1.add("8");
        set1.add("8");

        Iterator it = set1.iterator();

        while (it.hasNext()) {
            System.out.print(it.next()+" ");
        }

    }
}
