def solution(myString, pat):
    myString = myString.replace("A","tmp").replace("B","A").replace("tmp","B")
    return int(pat in myString)