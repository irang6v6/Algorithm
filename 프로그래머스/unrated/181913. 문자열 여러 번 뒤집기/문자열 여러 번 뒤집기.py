def solution(my_string, queries):
    for s,e in queries:
        tmp = my_string[s:e+1]
        tmp = tmp[::-1]
        my_string = my_string[:s]+tmp+my_string[e+1:]
    return my_string