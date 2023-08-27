def solution(myString, pat):
    myString = myString.replace("A","tmp")
    myString = myString.replace("B","A")
    myString = myString.replace("tmp","B")
    return int(pat in myString)