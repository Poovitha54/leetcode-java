class Solution {
    public int lengthOfLastWord(String s) {
      String []arr=s.split(" ");
      int a=arr.length;
      int b=arr[a-1].length();
      return b;
    }
}