import sys

N = int(sys.stdin.readline().strip())
popOrder = []
stackData = []
result = []
isNo = False

for inpC in range(N):
    popOrder.append(int(sys.stdin.readline().strip()))

curV = 1
for inp in popOrder:
    while curV <= inp:
        if curV > N:
            isNo = True
            break
        result.append("+")
        stackData.append(curV)
        curV += 1
    if len(stackData) > 0 and stackData[-1] == inp:
        result.append("-")
        stackData.pop()
    else:
        isNo = True
    if isNo:
        break
if isNo:
    print("NO")
else:
    for r in result:
        print(r)