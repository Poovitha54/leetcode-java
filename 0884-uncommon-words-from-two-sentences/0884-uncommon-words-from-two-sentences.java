class Solution {
    public String[] uncommonFromSentences(String s1,String s2){  
        List<String>sentence=new ArrayList<>();
        Collections.addAll(sentence,s1.split(" "));
        Collections.addAll(sentence,s2.split(" "));
        List<String>unCommonWords=new ArrayList<>();
        for (String w:sentence){
            int count=0;
            for (String compareWord:sentence){
                if(w.equals(compareWord)){
                    count++;
                }
            }
            if (count==1){
                unCommonWords.add(w);
            }
        }
        String[]result=new String[unCommonWords.size()];
        for(int i=0;i<unCommonWords.size();i++){
            result[i]=unCommonWords.get(i);
        }
        return result;   
    }
}