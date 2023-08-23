def solution(my_string, s, e):
    sub = my_string[s:e+1][::-1]
    return my_string[:s]+sub+my_string[e+1:]