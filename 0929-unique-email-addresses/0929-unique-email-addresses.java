class Solution{
    public int numUniqueEmails(String[]emails){
        Set<String>set=new HashSet<>();
        for(String email:emails){
            int at=email.indexOf('@');
            int plus=email.indexOf('+');
            if(plus!=-1&&plus<at)at=plus; 
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<at;i++) {
                if(email.charAt(i)!='.')sb.append(email.charAt(i));
            }
            sb.append(email.substring(email.indexOf('@')));
            set.add(sb.toString());
        }
        return set.size();
    }
}
