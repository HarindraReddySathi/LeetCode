class Solution {

    Comparator<int[]> comp = new Comparator<>(){
        public int compare(int[] i1,int[] i2){

            if(i1[1]!=i2[1]){
                return i1[1]-i2[1];
            }else{
                return i1[0]-i2[0];
            }
        }
    };

    public String minimizeStringValue(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();
        int[]  alpha = new int[26];
        int distinct =0;
        int ques =0;
        for(char c : ch){
            if(c=='?'){
                ques++;
                continue;
            }
            if(alpha[c-'a']==0) distinct++;
            alpha[c-'a']++;
        }
        int[]  sol = new int[26];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(comp);
        for(int i=0;i<26;i++){
            if(alpha[i]!=0){
                int[] adding = new int[2];
                adding[0]=i;
                adding[1]=alpha[i];
                minHeap.add(adding);
            }else{
                if(ques>0){
                    int[] adding = new int[2];
                    adding[0]=i;
                    adding[1]=1;
                    minHeap.add(adding);
                    ques--;
                    sol[i]++;
                    //quesPos[ques] = (char)(i+'a');
                }
            }
        }

        while(ques>0){
            int[] cur = minHeap.poll();
            ques--;
            sol[cur[0]]++;
            //quesPos[ques] = (char)(cur[0]+'a');
            cur[1]++;
            minHeap.add(cur);
        }

        //Arrays.sort(quesPos);
        for(int i =0;i<n;i++){
            if(ch[i]=='?'){
                for(int j=0;j<26;j++){
                    if(sol[j]>0){
                        sol[j]--;
                        ch[i]= (char)(j+'a');
                        break;
                    }
                }
            }
        }
        return String.valueOf(ch);
    }
}