package LeetCode;

public class LC11 {
	class Solution {
	    public int maxArea(int[] height) {
	        int n=height.length;
	        int water=0;
	        for(int i=0;i<n;i++){
	            for(int j=n-1;j>i;j--){
	                int h=(height[i]<height[j])? height[i]:height[j];
	                if(h*(j-i)>water){
	                    water=h*(j-i);
	                }
	            }
	        }
	        return water;
	    }
	}
	//반복문으로 모든걸 해결한다,, 2 
}
