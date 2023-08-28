def solution(a, b):
    odd = 0
    if a % 2 == 1:
        odd += 1
    if b % 2 == 1:
        odd += 1
        
    if odd == 2:
        return a**2 + b**2
    elif odd == 1:
        return 2 * (a + b)
    else :
        return abs(a - b)