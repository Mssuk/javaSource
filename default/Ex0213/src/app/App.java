package app;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
       int[][] v= {{1,4}, {3,4}, {3,10}};
       int[] answer = new int[2];
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();

        for(int i=0; i<v.length; ++i){
                if(map1.containsKey(v[i][0])){
                    map1.put(v[i][0], map1.get(v[i][0])+1);
                } else {
                    map1.put(v[i][0], 1);
                }
                if(map2.containsKey(v[i][1])){
                    map2.put(v[i][1], map2.get(v[i][1])+1);
                } else {
                    map2.put(v[i][1], 1);
                }    
        }
        Set<Map.Entry<Integer,Integer>> entries = map1.entrySet();
        map1.forEach((key,value)->{
            if(value == 1){
                answer[0] = key;
            }
        });
        entries = map2.entrySet();
        map2.forEach((key,value)->{
            if(value == 1){
                answer[1] = key;
            }
        });

    }
}