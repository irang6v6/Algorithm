def solution(arr, k):
    unique = []
    for a in arr:
        if a not in unique:
            unique.append(a)
            
    if len(unique) < k:
        return unique + (k - len(unique)) * [-1]
    elif len(unique) == k:
        return unique
    else:
        return unique[:k]