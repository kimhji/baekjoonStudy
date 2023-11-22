from collections import deque
def solution(q1, q2):
    q1 = deque(q1)
    q2 = deque(q2)
    answer = 0
    n = len(q1)
    sumQ1 = sum(q1)
    sumQ2 = sum(q2)
    _loopBool = True
    if (sumQ1+sumQ2)%2==1:
        answer = -1
        _loopBool = False
    while sumQ1 != sumQ2 and _loopBool:
        if sumQ1 > sumQ2:
            tns = q1.popleft()
            q2.append(tns)
            sumQ1-=tns
            sumQ2+=tns
        elif sumQ2 > sumQ1:
            tns = q2.popleft()
            q1.append(tns)
            sumQ1+=tns
            sumQ2-=tns
        answer += 1
        if answer > n*3:
            answer = -1
            break
    return answer