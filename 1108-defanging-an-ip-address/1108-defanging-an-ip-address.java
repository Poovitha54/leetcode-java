class Solution {
    public String defangIPaddr(String address){
        char[]arr=new char[address.length()+6]; 
        int j=0;
        for (char c:address.toCharArray()){
            if(c=='.'){
                arr[j++]='[';
                arr[j++]='.';
                arr[j++]=']';
            } else {
                arr[j++]=c;
            }
        }
        return new String(arr,0,j);
    }
}
