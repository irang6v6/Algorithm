def solution(a, b):
    str_a = str(a)
    str_b = str(b)
    
    if str_a + str_b > str_b + str_a:
        return int(str_a + str_b)
    else : return int(str_b + str_a)