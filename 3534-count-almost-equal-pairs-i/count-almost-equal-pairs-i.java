class Solution {
    public int countPairs(int[] nums) {
        
        int n = nums.length;

        Map<Integer,Set<Integer>> map = new HashMap<>();
        int max = -1;
        for(int i : nums){
            if(max<i) max =i;
        }
        int numOfDigits = String.valueOf(max).length();
        for(int i : nums){
            if(map.containsKey(i)) continue;
            map.put(i,getSet(i,numOfDigits));

        }

        int count =0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(map.get(nums[j]).contains(nums[i])) count++;
            }
        }

        return count;
    }

    private Set<Integer> getSet(int num,int numOfDigits){
        
        Set<Integer> set = new HashSet<>();
        String s = String.valueOf(num);
        char[] ch = new char[numOfDigits];
        int end = numOfDigits-1, p = s.length()-1;
        while(end>=0){
            if(p>=0)ch[end] = s.charAt(p);
            else ch[end] = '0';
            p--;
            end--;
        }

        int n = ch.length;
        //System.out.println(n);
        //System.out.println(ch[0]+"--"+ch[1]);
        set.add(Integer.parseInt(String.valueOf(ch)));
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                set.add(Integer.parseInt(String.valueOf(ch)));
                temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
            }
        }

        //System.out.println(num + "--"+ set);

        return set;
    }
}