def solution(num_list):
    m = 1
    p = 0
    for i in num_list:
        m *= i
        p += i
    return int(m < p**2)