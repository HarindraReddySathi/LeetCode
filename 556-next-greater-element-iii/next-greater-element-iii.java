class Solution {
    public int nextGreaterElement(int n) {
        int[] ch = getNumToArr(n);
        long ge = getNextElement(ch);
        if(ge<=n || ge>Integer.MAX_VALUE) return -1;
        return (int)ge;
    }

    public long getNextElement(int[] ch){
        int n = ch.length;
        int b=-1;
        for(int i=n-2;i>=0;i--){
            if(ch[i]<ch[i+1]){
                for(int j=n-1;j>i;j--){
                    if(ch[j]<=ch[i])continue;
                    swap(ch,j,i);
                    break;
                }
                b=i;
                break;
            }
        }
        if(b!=-1)reverse(ch,b+1,n-1);
        return arrToLong(ch);
    }

    public void reverse(int[] ch , int start,int end){
        while(start<=end){
            swap(ch,start,end);
            start++;end--;
        }
    }

    public void swap(int[] ch,int i ,int j){
        int temp = ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
    }

    public long arrToLong(int[] ch){
        char[] c = new char[ch.length];
        for(int i=0;i<c.length;i++){
            c[i]=(char)(ch[i]+'0');
        }
        return Long.parseLong(String.valueOf(c));
    }

    public int[] getNumToArr(int n){
        char[] ch = String.valueOf(n).toCharArray();
        int[] nums = new int[ch.length];
        for(int i=0;i<ch.length;i++){
            nums[i]=ch[i]-'0';
            System.out.println(nums[i]);
        }
        return nums;
    }
    /*public int[] getNumToArr(int n){
        Stack<Integer> s = new Stack<>();
        while(n>0){
            int k = n%10;
            n=n/10;
            s.push(k);
        }
        int p = s.size();
        int[] ans = new int[p];
        int i=0;
        while(!s.isEmpty()){
            ans[i]=s.pop();
            i++;
        }
        return ans;
    }*/

    /*public long arrToLong(int[] ch){
        int n = ch.length;
        long ans =0l;
        int mul =1;
        for(int i=n-1;i>=0;i--){
            ans+=(ch[i]*mul);
            mul=mul*10;
        }
        //System.out.println(ans);
        return ans;
    }*/
}