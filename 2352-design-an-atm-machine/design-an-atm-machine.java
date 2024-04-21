class ATM {

    int[] denomination;
    int[] so = {20,50,100,200,500};
    public ATM() {
        denomination = new int[5];
    }
    
    public void deposit(int[] banknotesCount) {
        
        for(int i=0;i<5;i++){
            denomination[i]+=banknotesCount[i];
        }
    }
    
    public int[] withdraw(int amount) {
        int[] ans = new int[5];
        int idx =4;
        while(amount>0 && idx>=0){
            if(amount >= so[idx] && denomination[idx]>0){
                int min = Math.min(denomination[idx],amount/so[idx]);
                ans[idx] = min;
                amount -= min*so[idx];
            }
            idx--;
        }
        if(amount==0){
            for(int i=0;i<5;i++){
                denomination[i]-=ans[i];
            }
             return ans;
        }
        int[] t = {-1};
        return t;
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */