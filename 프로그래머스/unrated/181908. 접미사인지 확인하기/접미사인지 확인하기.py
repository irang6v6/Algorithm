def solution(my_string, is_suffix):
    l = len(is_suffix)
    return int(my_string[-l:] == is_suffix)