class Solution {
    public long maxArrayValue(int[] nums) {
        
        
        int len=nums.length;
        long maxt=0;
        
        long last=nums[len-1];
        for(int i=len-2;i>=0;i--){
            
            long val=(long)nums[i];
            if(val<=last){
                last=last+val;
                if(last>maxt)
                    maxt=last;
            }else{
                if(last>maxt)
                    maxt=last;
                last=val;
                
            }
        }
        
        return last;
    }
}