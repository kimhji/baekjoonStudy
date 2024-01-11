import sys, heapq
input = sys.stdin.readline
N = int(input())
office = []
for inputOffice in range(N):
    start, end = map(int, input().split())
    office.append((start, end))
office.sort(key=lambda x: (x[0], x[1]))
EndTimes = [0]
for cycleOffice in office:
    endtime = EndTimes[0]
    if endtime <= cycleOffice[0]:
        heapq.heappop(EndTimes)
    heapq.heappush(EndTimes, cycleOffice[1])
print(len(EndTimes))
