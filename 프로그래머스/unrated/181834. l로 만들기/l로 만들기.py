import re

def solution(myString):
    return re.sub('[a-k]','l',myString)