import java.util.*;

class Solution {
    public int calculate(String s) {
        
        StringTokenizer st = new StringTokenizer(s, "+-*/ " , true);
        List<String> passone = new ArrayList<>();
        while(st.hasMoreTokens()){
            String temp = st.nextToken();
            if (!temp.equals(" ")){
                passone.add(temp);
            }
        }
        if (passone.size() == 1){
            return Integer.parseInt(passone.get(0));
        }
        boolean lastadd = true;
        int dump = -1;
        boolean lastmult = false;
        List<String> passtwo = new ArrayList<>();
        for (int i = 0; i < passone.size(); i++){
            if (passone.get(i).equals("+") || passone.get(i).equals("-")){
                if (dump != -1){
                passtwo.add(String.valueOf(dump));}
                if (lastadd){
                passtwo.add(passone.get(i - 1));}
                passtwo.add(passone.get(i));
                if (i+1 == passone.size() - 1){
                    passtwo.add(passone.get(i+1));
                }
                lastadd = true;
                lastmult = false;
                dump = -1;
            } else if (passone.get(i).equals("*")){
                if (!lastmult){
                dump = (Integer.parseInt(passone.get(i-1)) * Integer.parseInt(passone.get(i+1)));
                lastmult = true;
                } else{
                    dump *= Integer.parseInt(passone.get(i+1));
                }
                lastadd = false;
            } else if (passone.get(i).equals("/")){
                if (!lastmult){
                dump = (Integer.parseInt(passone.get(i-1)) / Integer.parseInt(passone.get(i+1)));
                lastmult = true;
                } else{
                    dump = dump / Integer.parseInt(passone.get(i+1));
                }
                lastadd = false;
            }
        }
        passtwo.add(String.valueOf(dump));

        //System.out.println(passtwo);
        int answer = 0;
        answer += Integer.parseInt(passtwo.get(0));
        for (int i = 0; i < passtwo.size(); i++){
            if (i % 2 == 1){
                if (passtwo.get(i).equals("+")){
                    answer += Integer.parseInt(passtwo.get(i+1));
                } else if (passtwo.get(i).equals("-")){
                    answer -= Integer.parseInt(passtwo.get(i+1));
                }
            }
        }
        return answer;
    }
}
