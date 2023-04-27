from queue import PriorityQueue

def solution(picks, minerals):
    answer = 0
    
    # fatigue 정리
    fatigue = [[1,1,1],[5,1,1],[25,5,1]]
    
    # 총 곡괭이의 수
    numOfPick = picks[0] + picks[1] + picks[2]
    
    # 캘 수 있는 광물의 수
    if(numOfPick * 5 < len(minerals)) :
        minerals = minerals[0:numOfPick*5]
    
    # 광물을 처음부터 5개씩 잘라서 다이아,철,돌의 개수를 구함
    numOfMineral = []
    for i in range(0,len(minerals),5):
        count = [0,0,0]
        for j in range (0,5):
            if i+j < len(minerals):
                if minerals[i+j] == "diamond":
                    count[0] = count[0] + 1
                elif minerals[i+j] == "iron":
                    count[1] = count[1] + 1
                else : 
                    count[2] = count[2] + 1
        numOfMineral.append(count)
    
    numOfMineral.sort(key=lambda x: (-x[0],-x[1],-x[2]))
    
    for i in numOfMineral:
        if numOfPick > 0 :
            p = 0
            if picks[0] > 0 :
                p = 0
            elif picks[1] > 0 :
                p = 1
            else :
                p = 2
            numOfPick -= 1
            picks[p] -= 1
            answer += fatigue[p][0] * i[0]
            answer += fatigue[p][1] * i[1]
            answer += fatigue[p][2] * i[2]
    
    return answer