class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        clean = ""
        for char in s:
            if char.isalpha() or char.isdigit():
                clean += char
        
        clean_list = list(clean)
        clean_list.reverse()
        clean_reverse = ''.join(clean_list)
        
        if clean == clean_reverse:
            return True
        else : 
            return False