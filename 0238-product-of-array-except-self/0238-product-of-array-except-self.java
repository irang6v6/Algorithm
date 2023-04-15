class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        int zero = 0; // 0의 개수 저장
        for(int i : nums){
            if(i == 0){
                zero++;
            }
        }
        
        if(zero > 1){ // 0이 2개 이상이면 모든 원소가 0
            return answer;
        } else if(zero == 1){ // 0이 1개면 그 원소 자리값만 계산하면 됨
            int tmp = 1;
            int idx = 0;
            for(int i = 0; i < n; i++){
                if(nums[i] != 0){
                    tmp *= nums[i];
                }else {
                    idx = i;
                }
            }
            answer[idx] = tmp;
            return answer;
        } else { // 0이 없음
            int multiple = 1;
            for(int i = 0; i < n; i++){
                multiple *= nums[i];
            }
            for(int j = 0; j < n; j++){
                answer[j] = multiple / nums[j];
            }
            
            return answer;
        }
    }
}