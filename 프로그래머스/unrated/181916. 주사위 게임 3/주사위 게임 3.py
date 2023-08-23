from collections import Counter

def solution(a, b, c, d):
    answer = 0
    i = [a,b,c,d]
    j = len(set(i))
    if j == 1:
        return 1111 * a
    elif j == 4 :
        return min(a,b,c,d)
    else:
        counter = Counter(i).most_common()
        if j == 3:
            return counter[1][0] * counter[2][0]
        else :
            if counter[0][1] == 3:
                return (10 * counter[0][0] + counter[1][0]) ** 2
            else :
                p = counter[0][0]
                q = counter[1][0]
                return (p + q) * abs(p - q)
    return 0