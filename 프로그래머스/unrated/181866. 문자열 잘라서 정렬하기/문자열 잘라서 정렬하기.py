def solution(myString):
    return [word for word in sorted(myString.split("x")) if word]