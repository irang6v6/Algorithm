def solution(my_string, m, c):
    answer = ''
    my_string = my_string[c-1:]
    answer += my_string[::m]
    return answer