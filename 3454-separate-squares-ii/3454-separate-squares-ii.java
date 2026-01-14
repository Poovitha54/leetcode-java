import java.util.*;
class Solution{
static class E{long y,x1,x2;int t;E(long y,int t,long x1,long x2){this.y=y;this.t=t;this.x1=x1;this.x2=x2;}}
static class ST{
int n;int[] c;long[] len,x;
ST(long[] x){this.x=x;n=x.length-1;c=new int[4*n];len=new long[4*n];}
void u(int i,int l,int r,int ql,int qr,int v){
if(qr<=l||r<=ql)return;
if(ql<=l&&r<=qr)c[i]+=v;
else{
int m=(l+r)/2;
u(i*2,l,m,ql,qr,v);
u(i*2+1,m,r,ql,qr,v);
}
if(c[i]>0)len[i]=x[r]-x[l];
else if(l+1==r)len[i]=0;
else len[i]=len[i*2]+len[i*2+1];
}
long q(){return len[1];}
}
public double separateSquares(int[][] s){
List<E> e=new ArrayList<>();
Set<Long> xs=new HashSet<>();
for(int[] a:s){
long x=a[0],y=a[1],l=a[2];
e.add(new E(y,1,x,x+l));
e.add(new E(y+l,-1,x,x+l));
xs.add(x);xs.add(x+l);
}
long[] xv=xs.stream().sorted().mapToLong(Long::longValue).toArray();
Map<Long,Integer> m=new HashMap<>();
for(int i=0;i<xv.length;i++)m.put(xv[i],i);
e.sort(Comparator.comparingLong(a->a.y));
ST st=new ST(xv);
long py=e.get(0).y;
double tot=0;
for(E a:e){
long cy=a.y;
tot+=st.q()*(cy-py);
st.u(1,0,st.n,m.get(a.x1),m.get(a.x2),a.t);
py=cy;
}
double half=tot/2.0;
st=new ST(xv);
py=e.get(0).y;
double cur=0;
for(E a:e){
long cy=a.y;
long xl=st.q();
double d=xl*(cy-py);
if(cur+d>=half)return py+(half-cur)/xl;
cur+=d;
st.u(1,0,st.n,m.get(a.x1),m.get(a.x2),a.t);
py=cy;
}
return py;
}
}
