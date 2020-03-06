import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Ex0306_03 {
    public static void main(String[] args) {
        //HashMap
        Scanner scan = new Scanner(System.in);

        HashMap map = new HashMap<>();
        map.put("myId", 1234);
        map.put("myId", 1234);
        map.put("myId", 1214);
        map.put("aaa", 1234);
        map.put("koitt", 1234);

        Iterator it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            System.out.print("key: " + entry.getKey());
            System.out.println("  value: " + entry.getValue());
        }


        while (true) {
            System.out.println("아이디와 비밀번호를 입력하세요.");
            System.out.println("id:");
            String id = scan.nextLine().trim();
            if (!(map.containsKey(id))) {
                System.out.println("입력한 아이디가 없습니다. 다시 입력하세요.");
                continue;
            }
            System.out.print("pw: ");
            String pw = scan.nextLine().trim();
            if(!(map.get(id).equals(Integer.parseInt(pw)))){
                System.out.println("패스워드 불일치");
                System.out.println(map.get(id));
                continue;
            }

            System.out.println("로그인 되었습니다");
            break;
        }

    }
}
