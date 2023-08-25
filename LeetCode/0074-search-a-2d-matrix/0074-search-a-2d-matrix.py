class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        nums = sum(matrix,[])
        index = bisect.bisect_left(nums, target)
        
        if index < len(nums) and nums[index] == target:
            return True
        else:
            return False