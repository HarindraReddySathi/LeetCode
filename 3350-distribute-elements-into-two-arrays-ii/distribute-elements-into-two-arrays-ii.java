class Solution {
    public int[] resultArray(int[] nums) {
        
        int n = nums.length;
        List<Integer> arr1List = new ArrayList<>();
        List<Integer> arr2List = new ArrayList<>();
        Node arr1 = new Node(-1);
        Node arr2 = new Node(-1);
        arr1.add(nums[0],31);
        arr1List.add(nums[0]);
        arr2.add(nums[1],31);
        arr2List.add(nums[1]);
        int j =2;
        while(j<n){
            int p1 = arr1.greaterCount(nums[j],31);
            int p2 = arr2.greaterCount(nums[j],31);
            if(p1>p2){
                arr1.add(nums[j],31);
                arr1List.add(nums[j]);
            }else if(p1<p2){
                arr2.add(nums[j],31);
                arr2List.add(nums[j]);
            }else{
                if(arr2List.size()<arr1List.size()){
                    arr2.add(nums[j],31);
                    arr2List.add(nums[j]);
                }else{
                    arr1.add(nums[j],31);
                    arr1List.add(nums[j]);
                }
            }
            j++;
        }
        return combine(arr1List,arr2List,n);
    }
    class Node{
        int val;
        Node[] child = new Node[2];
        int[] childCount = new int[2];

        public Node(int val){
            this.val=val;
        }

        public void add(int i,int level){
            if(level==0) return;
            int p = i;
            p >>= (level-1);
            int curBit = p%2;
            if(child[curBit]==null)child[curBit] = new Node(curBit);
            childCount[curBit]++;
            //System.out.println(i+"-----"+level+"---"+curBit);
            child[curBit].add(i,level-1);
        }

        public int greaterCount(int i,int level){
            if(level==0) return 0;
            int p = i;
            p >>= (level-1);
            int curBit = p%2;
            int ans =0;
            if(curBit==0) ans+=childCount[1];
            if(child[curBit]!=null)ans+=child[curBit].greaterCount(i,level-1);
            return ans;
        }
    }

    public int[] combine(List<Integer> arr1,List<Integer> arr2,int n){
        int[] ans = new int[n];
        int i=0;
        for(Integer j : arr1){
            ans[i]=j;
            i++;
        }
        for(Integer j : arr2){
            ans[i]=j;
            i++;
        }
        return ans;
    }
}