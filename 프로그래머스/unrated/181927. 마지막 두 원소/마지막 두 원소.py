def solution(num_list):
    length = len(num_list)
    if num_list[length-1] > num_list[length-2]:
        num_list.append(num_list[length-1]-num_list[length-2])
    else:
        num_list.append(num_list[length-1]*2)
    return num_list