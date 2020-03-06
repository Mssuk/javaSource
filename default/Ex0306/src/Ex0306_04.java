import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Ex0306_04 {
    public static void main(String[] args) {
        HashMap map = new HashMap();

        //Set set = map.entrySet();
        Iterator it = map.entrySet().iterator();

        map.put("myId", "1234");
        map.put("dream","d1111");
        map.put("aaa", "aooo");
        map.put("bbb","b1111");
        map.put("aaa","axxxx");

    }
}
