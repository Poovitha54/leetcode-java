class Solution {
    public int daysBetweenDates(String date1,String date2){
        return Math.abs(days(date1)-days(date2));
    }

    private int days(String date){
        int y=Integer.parseInt(date.substring(0,4));
        int m=Integer.parseInt(date.substring(5,7));
        int d=Integer.parseInt(date.substring(8,10));
        int[]md={31,28,31,30,31,30,31,31,30,31,30,31};
        int res=0;
        for(int i=1971;i<y;i++)
            res+=(i%400==0||(i%4==0&&i%100!=0))?366:365;
        for(int i=0;i<m-1;i++)
            res+=md[i];
        if(m>2&&(y%400==0||(y%4==0&&y%100!=0)))
            res++;
        return res+d;
    }
}
