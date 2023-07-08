class Solution:
    def largestNumber(self, nums: [int]) -> str:
        for i, num in enumerate(nums):
            nums[i] = str(num)

        def compare(n1, n2):
            return -1 if n1 + n2 > n2 + n1 else 1

        nums = sorted(nums, key=cmp_to_key(compare))

        result = "".join(nums)
        return str(int(result))