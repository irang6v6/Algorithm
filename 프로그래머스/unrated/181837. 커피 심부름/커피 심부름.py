def solution(order):
    answer = 0
    count = [0,0]
    for o in order:
        if "americano" in o or o == "anything":
            count[0] += 1
        else:
            count[1] += 1
    return count[0] * 4500 + count[1] * 5000