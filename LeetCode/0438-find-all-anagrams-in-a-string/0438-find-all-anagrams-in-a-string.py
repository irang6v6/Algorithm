from collections import Counter

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        count = Counter(p)
        cur = Counter(s[:len(p)-1])
        ans = []
        
        for i,c in enumerate(s[len(p)-1:]):
            cur[c] += 1
            if cur == count:
                ans.append(i)
            cur[s[i]] -= 1
        return ans
                             
            
        