import re

def solution(myStr):
    answer = []
    for s in re.split('[abc]',myStr):
        if s:
            answer.append(s)
    return answer if answer else ["EMPTY"]