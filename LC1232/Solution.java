class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        
        double slope;
        slope = (double)(coordinates[0][0] - coordinates[1][0])/(coordinates[0][1] - coordinates[1][1]);
        for (int i = 1; i < coordinates.length; i++){
            
            if (((double)(coordinates[i-1][0] - coordinates[i][0])/(coordinates[i-1][1] - coordinates[i][1])) != slope){
                if (slope == Double.POSITIVE_INFINITY && ((double)(coordinates[i-1][0] - coordinates[i][0])/(coordinates[i-1][1] - coordinates[i][1])) == Double.NEGATIVE_INFINITY){
                    continue;
                }
                if (slope == Double.NEGATIVE_INFINITY && ((double)(coordinates[i-1][0] - coordinates[i][0])/(coordinates[i-1][1] - coordinates[i][1])) == Double.POSITIVE_INFINITY){
                    continue;
                }
                //System.out.println(slope);
                //System.out.println(((double)(coordinates[i-1][0] - coordinates[i][0])/(coordinates[i-1][1] - coordinates[i][1])));
                //System.out.println(coordinates[i-1][0]);
                //System.out.println(coordinates[i-1][1]);
                //System.out.println(coordinates[i][0]);
                //System.out.println(coordinates[i][1]);
                return false;
            }
        }
        return true;
    }
}
