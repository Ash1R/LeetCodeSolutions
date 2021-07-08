import java.util.*;

class Solution {
    public int findJudge(int n, int[][] trust) {
        HashMap<Integer, Integer> map= new HashMap<>();
        HashMap<Integer, Integer> num= new HashMap<>();
        for (int i = 1; i < n + 1; i++){
            map.put(i, 0);
            num.put(i, 0);
        }
        for (int[] i : trust){
            map.put(i[1], map.get(i[1]) + 1);
            num.put(i[0], map.get(i[0]) + 1);
        }
        for (int i = 1; i < n+1; i++){
            if (map.get(i) == n-1 && num.get(i) == 0){
                return i;
            }
        }
        return -1;
    }
}
