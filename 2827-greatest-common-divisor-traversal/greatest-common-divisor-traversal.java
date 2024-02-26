class Solution {

    public boolean canTraverseAllPairs(int[] nums) {

        //Time Complexity O(N) or O(MAX_VALUE(log(MAX_VALUE)))
        // Here N limit na d MAX_VALUE limit are same so TC -O(Nlog(N))
        int n = nums.length;
        if(n==1) return true;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]==1) return false;
            max=Math.max(max,nums[i]);
        }
        // Returns the list of prime factors for all integers less than max+1;
        // At max any integer max hav 10 distinct prime factors
        Map<Integer,List<Integer>> preimeFactorMap = primeFactorCalculator(max+1);
        Map<Integer,Node> presentPrimes = new HashMap<>();
        Set<Integer> isVisited = new HashSet<>();

        //1. To connect each node  to its smallest prime factor
        //2. To connect all prime factors to its smallest prime factor in each step
        //Time complexity is of O(10N)
        for(int i=0;i<n;i++){
            int cur = nums[i];
            Node smallPrime = null;
            for(Integer p : preimeFactorMap.get(cur)){
                if(p>cur) break;
                if(cur%p==0){
                    Node curPrime = new Node(p);
                    if(presentPrimes.containsKey(p))curPrime=presentPrimes.get(p);
                    else presentPrimes.put(p,curPrime);
                    if(smallPrime==null){
                        smallPrime=curPrime;
                    }else{
                        smallPrime.map.put(p,curPrime);
                        curPrime.map.put(smallPrime.val,smallPrime);
                    }
                }
            }
        }

        int count=0;
        //1. Do DFS on each prime and also check ideally we should enter dfs function only once if entered twice return false
        //Time Complexity is O(N)
        for(Integer i : presentPrimes.keySet()){
            if(isVisited.contains(i))continue;
            if(count>=1) return false;
            DFS(presentPrimes,i,isVisited);
            count++;
        }
        return true;
    }
    
    //it is of complexity O(nlog(n))
    public Map<Integer,List<Integer>> primeFactorCalculator(int n) {
        Map<Integer,List<Integer>> ans = new HashMap<>();
        ans.put(0,new ArrayList<>());
        ans.put(1,new ArrayList<>());
        if(n==0 || n==1) return ans;
        boolean[] primes = new boolean[n+1];
        primes[0]=true;
        primes[1]=true;
        for(int i=2;i<n+1;i++){
            if(primes[i]) continue;
            ans.computeIfAbsent(i,l -> new ArrayList<>()).add(i);
            int j=2*i;
            while(j<n){
                primes[j] =true;
                ans.computeIfAbsent(j,l -> new ArrayList<>()).add(i);
                j+=i;
            }
        }
        return ans;
    }

    /*public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        if(n==1) return true;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]==1) return false;
            max=Math.max(max,nums[i]);
        }
        //prime calculator
        List<Integer> primes = primeCalculator(max+1);
        Map<Integer,Node> presentPrimes = new HashMap<>();
        Set<Integer> isVisited = new HashSet<>();
        //1. To connect each node  to its smallest prime factor
        //2. To connect all prime factors to its smallest prime factor in each step
        for(int i=0;i<n;i++){
            int cur = nums[i];
            Node smallPrime = null;
            for(Integer p : primes){
                if(p>cur) break;
                if(cur%p==0){
                    Node curPrime = new Node(p);
                    if(presentPrimes.containsKey(p))curPrime=presentPrimes.get(p);
                    else presentPrimes.put(p,curPrime);
                    if(smallPrime==null){
                        smallPrime=curPrime;
                    }else{
                        smallPrime.map.put(p,curPrime);
                        curPrime.map.put(smallPrime.val,smallPrime);
                    }
                }
            }
        }

        //1. Start at any node and do dfs
        //2. if we encounter to do dfs again then return false or else true

        int count=0;
        //System.out.println(presentPrimes.keySet().size());
        //for(Integer i : presentPrimes.keySet()){
            //System.out.println(i+"---"+presentPrimes.get(i).map.keySet().size());
        //}
        for(Integer i : presentPrimes.keySet()){
            if(isVisited.contains(i))continue;
            if(count>=1) return false;
            //DFS logic
            DFS(presentPrimes,i,isVisited);
            count++;
        }
        //System.out.println(count);
        return true;

    }

    public List<Integer> primeCalculator(int n) {
        List<Integer> ans = new ArrayList<>();
        if(n==0 || n==1) return ans;
        boolean[] primes = new boolean[n+1];
        primes[0]=true;
        primes[1]=true;
        for(int i=2;i<n+1;i++){
            if(primes[i]) continue;
            int j=2*i;
            while(j<n){
                primes[j] =true;
                j+=i;
            }
        }
        for(int i=2;i<n;i++){
            if(!primes[i]){
                ans.add(i);
                //System.out.println(i);
            }
        }
        return ans;
    }*/

    public void DFS(Map<Integer,Node>presentPrimes,int currentPrime,Set<Integer> isVisited){
        isVisited.add(currentPrime);
        Node cur = presentPrimes.get(currentPrime);
        for(Integer i : cur.map.keySet()){
            if(!isVisited.contains(i)) DFS(presentPrimes,i,isVisited);
        }
    }

    class Node{
        int val;
        Map<Integer,Node> map = new HashMap<>();

        public Node(int val){
            this.val=val;
        }
    }
}