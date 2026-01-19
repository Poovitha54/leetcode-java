class Solution{
    public String reformat(String s){
        StringBuilder letters=new StringBuilder();
        StringBuilder digits = new StringBuilder();    
        for(char c:s.toCharArray()){
            if(Character.isLetter(c))letters.append(c);
            else digits.append(c);
        }    
        if(Math.abs(letters.length()-digits.length())>1)return""; 
        StringBuilder res=new StringBuilder();
        StringBuilder longer=letters.length()>=digits.length()?letters:digits;
        StringBuilder shorter=letters.length()<digits.length()?letters:digits; 
        int i=0;
        while(i<shorter.length()){
            res.append(longer.charAt(i));
            res.append(shorter.charAt(i));
            i++;
        }
        if(i<longer.length())res.append(longer.charAt(i)); 
        return res.toString();
    }
}
