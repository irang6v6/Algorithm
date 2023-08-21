def solution(my_string, overwrite_string, s):
    a = my_string[:s]
    b = my_string[s:]

    b = b.replace(my_string[s:s+len(overwrite_string)],overwrite_string,1)
    return a+b