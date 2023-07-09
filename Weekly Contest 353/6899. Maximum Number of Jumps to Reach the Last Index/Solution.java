class Solution {
    public int maximumJumps(int[] nums, int target) {
        int lent=nums.length;
        int less=target*-1;
        int dp[]=new int[lent];
        for(int i=lent-2;i>=0;i--){
            int max=0;
            int lastt=0;
            for(int j=i+1;j<lent;j++){
                int fir=nums[j]-nums[i];             
                if(fir>=less && fir<=target){
                    if(j<lent-1){
                        int m=dp[j];
                        if(m>max)
                            max=m;
                    }else{
                        if(1>max){
                            max=1;
                            lastt=1;
                        }
                    }
                }
            }
             if(lastt==1)
                dp[i]=1;
            else if(max>0){
                dp[i]=max+1;
            }
        }
        if(dp[0]>0)
        return dp[0];
        else
            return -1;
    }
}