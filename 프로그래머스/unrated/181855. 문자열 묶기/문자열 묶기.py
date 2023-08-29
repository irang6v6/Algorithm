from collections import Counter

def solution(strArr):
    lenArr = []
    for s in strArr:
        lenArr.append(len(s))
    return Counter(lenArr).most_common(1)[0][1]