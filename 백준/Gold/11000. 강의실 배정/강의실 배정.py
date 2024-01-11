import sys
import heapq

N = int(sys.stdin.readline())
classroom = []

for cycle in range(N):
    checkTimeS, checkTimeT = map(int, sys.stdin.readline().split())
    classroom.append((checkTimeS, checkTimeT))
classroom.sort(key=lambda x: (x[0], x[1]))
Endtimes = [classroom[0][1]]
MaxNum = 1
for classroomSearch in range(1, N):
    if Endtimes[0] > classroom[classroomSearch][0]:
        MaxNum += 1
        heapq.heappush(Endtimes, classroom[classroomSearch][1])
    else:
        heapq.heappop(Endtimes)
        heapq.heappush(Endtimes, classroom[classroomSearch][1])
print(MaxNum)

