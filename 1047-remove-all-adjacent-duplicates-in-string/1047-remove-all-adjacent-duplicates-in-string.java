class Solution {
    public String removeDuplicates(String s){
        char[]arr=s.toCharArray();
        int i=0;
        for(int j=0;j<arr.length;j++){
            if(i>0&&arr[i-1]==arr[j])i--;
            else arr[i++]=arr[j];
        }
        return new String(arr,0,i);
    }
}
