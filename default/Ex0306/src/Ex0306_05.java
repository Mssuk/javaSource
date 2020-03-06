import java.util.*;

public class Ex0306_05 {
    public static void main(String[] args) {
        //set -> 4,6,57,3,2,10 저장하여 출력
        //map -> 1,개 2,소 3,말 4,범 5,돼지
        //로그인 형태를 만들어라

        Scanner scan = new Scanner(System.in);

        HashSet<Integer> set = new HashSet<>();
        set.add(4);
        set.add(6);
        set.add(57);
        set.add(3);
        set.add(2);
        set.add(10);

        Iterator<Integer> it = set.iterator();

        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "개");
        map.put(2, "소");
        map.put(3, "말");
        map.put(4, "범");
        map.put(5, "돼지");


        while (true) {
            System.out.println("[로그인]");
            System.out.println("번호를 입력");
            int id = scan.nextInt();
            if (!map.containsKey(id)) {
                System.out.println("해당 번호 없음");
                continue;
            }
            System.out.println("동물을 입력");
            String animal = scan.next();
            if (!map.get(id).equals(animal)) {
                System.out.println("틀렸음");
                continue;
            }
            System.out.println("정답입니다.");
            break;
        }


        Iterator<Map.Entry<Integer, String>> it2 = map.entrySet().iterator();


        while (it2.hasNext()) {
            Map.Entry<Integer, String> ent = it2.next();
            System.out.print(ent + " ");
        }
        System.out.println();


    }
}
