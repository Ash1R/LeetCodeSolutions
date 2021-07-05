import java.util.*;
//https://leetcode.com/problems/maximum-product-of-word-lengths/ 

class Solution {
    public int maxProduct(String[] words) {
    int ans = 0;
    HashSet<Character>[] lst = new HashSet[words.length];
    for (int i = 0; i < words.length; i++){
      HashSet<Character> temp = new HashSet<>();
      for (char c : words[i].toCharArray()){
        temp.add(c);
      }
      lst[i] = temp;
    }
    for (int i = 0; i < words.length; i++){
      for (int j = i; j < words.length; j++){
        HashSet<Character> hs = new HashSet<>(lst[i]);
        
        hs.retainAll(lst[j]);
        if (hs.size() == 0){
            
          if (words[i].length() * words[j].length() > ans){
              
            ans = words[i].length() * words[j].length();
          }
        }
      }
    }
    return ans;
  }
}
