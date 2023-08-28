def solution(myString, pat):
    print(myString.rfind(pat))
    return myString[:myString.rfind(pat)+len(pat)]