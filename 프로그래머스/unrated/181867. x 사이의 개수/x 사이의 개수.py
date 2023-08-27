def solution(myString):
    answer = []
    arr = myString.split("x")
    for o in arr:
        answer.append(len(o))
    return answer