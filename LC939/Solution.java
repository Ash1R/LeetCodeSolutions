class Solution {
    public int minAreaRect(int[][] points) {
        int ans = Integer.MAX_VALUE;
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for (int i = 0; i < points.length; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(points[i][0]);
            temp.add(points[i][1]);
            set.add(temp);
        }
        Iterator itone = set.iterator();
        for (ArrayList<Integer> temone : set){
            
            for (ArrayList<Integer> temtwo : set){
                //ArrayList<Integer> temone = (ArrayList<Integer>)itone.next();
                //ArrayList<Integer> temtwo = (ArrayList<Integer>)ittwo.next();
                if (temone.equals(temtwo)){
                    //System.out.println(temone);
                    //System.out.println(temtwo);
                    continue;
                }
                ArrayList<Integer> checkone = new ArrayList<Integer>();
                if (temone.get(0) == temtwo.get(0)){
                    //System.out.println(temone);
                        //System.out.println(temtwo);
                   // System.out.println("--");
                   continue;
                } 
                if(temone.get(1) == temtwo.get(1)){
                    //System.out.println(temone);
                    //    System.out.println(temtwo);
                    //System.out.println("--");
                    continue;
                }
                checkone.add(temone.get(0));
                checkone.add(temtwo.get(1));
                ArrayList<Integer> checktwo = new ArrayList<Integer>();
                checktwo.add(temtwo.get(0));
                checktwo.add(temone.get(1));
                //System.out.println(set);
                //System.out.println(checkone);
               // System.out.println(checktwo);
               // System.out.println(temone);
                //System.out.println(temtwo);
                //System.out.println("---");
                if (set.contains(checkone) && set.contains(checktwo)){
                    int area = Math.abs(temone.get(0) - temtwo.get(0)) * Math.abs(temone.get(1) - temtwo.get(1));
                    //System.out.println(area);
                    if (area != 0 && area < ans){
                        //System.out.println(temone);
                        //System.out.println(temtwo);
                        //System.out.println(checkone);
                        //System.out.println(checktwo);
                        //System.out.println(area);
                        ans = area;
                    }
                }
            }
        }
        if (ans == Integer.MAX_VALUE){
            return 0;
        }
        return ans;
    }
}
