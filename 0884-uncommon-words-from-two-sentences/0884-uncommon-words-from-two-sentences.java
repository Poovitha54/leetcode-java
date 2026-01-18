import java.util.*;
class Solution{
    public String[]uncommonFromSentences(String s1,String s2){
        Map<String,Integer>countMap=new HashMap<>();  
        for (String word:s1.split(" ")){
            countMap.put(word,countMap.getOrDefault(word,0)+1);
        }
        for (String word:s2.split(" ")){
            countMap.put(word,countMap.getOrDefault(word,0)+1);
        }
        List<String>result=new ArrayList<>();
        for (String word:countMap.keySet()){
            if(countMap.get(word)==1){
                result.add(word);
            }
        }   
        return result.toArray(new String[0]);
    }
}
