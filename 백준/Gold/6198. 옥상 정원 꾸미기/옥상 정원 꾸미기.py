import sys
N = int(sys.stdin.readline())
L1 = list()
for inputC in range(N):
    L1.append(int(sys.stdin.readline()))
L2 = list()
num = 0
sum = 0
for cycle in L1:
    if num == 0:
        L2.append(cycle)
        num+=1
    else:
        while num > 0 and L2[-1] <= cycle:
            L2.pop()
            num -= 1
        sum += num
        L2.append(cycle)
        num += 1
print(sum)