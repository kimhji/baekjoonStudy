import sys
N = int(sys.stdin.readline())
student = list()
leng = 0
for inputC in range(N):
    student.append(int(sys.stdin.readline()))
d = student[0]
while d > 0 :
    d //= 10
    leng += 1
for cycle in range(1, leng+1):
    allSame = True
    setStu = set()
    cal = 1
    cal *= 10 ** cycle
    for stu in range(N):
        setStu.add(student[stu] % cal)
    for ind in range(leng-cycle, leng):
        if len(setStu) >= N:
            allSame = False
            break
    if not allSame:
        print(cycle)
        break
