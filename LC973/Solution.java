class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        TreeMap<Double, HashSet<Integer>> map = new TreeMap<>();
        for (int i = 0; i <points.length; i++){
            if (map.containsKey(Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2)))){
                HashSet<Integer> temp = map.get(Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2)));
                temp.add(i);
                map.put((Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2))), temp);
            } else{
            HashSet<Integer> temp = new HashSet<>();
            temp.add(i);
            map.put(Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2)), temp);}
        }
        Set<Double> set = map.keySet();
        //System.out.println(map);
        Iterator it = set.iterator();
        int j = 0;
        while (k != 0){
            
            double nex = (double)it.next();
            //System.out.println(nex);
            HashSet<Integer> indset = map.get(nex);
            Iterator indit = indset.iterator();
            while(indit.hasNext() && k != 0){
            int ind = (int)indit.next();
            ans[j][0] = points[ind][0];
            ans[j][1] = points[ind][1];
            j++;
            k--;}
        }
        return ans;
    }
}
