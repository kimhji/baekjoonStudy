import sys
N = int(sys.stdin.readline())
numOfBroken = int(sys.stdin.readline())
if numOfBroken > 0:
    BrokenButton = set(list(map(int, sys.stdin.readline().split())))
else:
    BrokenButton = set()
diff = 0
notBroken = False
isDecrease = False
cycleResult = 0
allPlusMinus = abs(N - 100)
isPM = False
while not notBroken:
    notBroken = True
    decrease = N-diff
    increase = N+diff
    if diff >= allPlusMinus:
        isPM = True
        break
    if decrease < 0:
        notBroken = False
    elif decrease == 0:
        if decrease in BrokenButton:
            notBroken = False
    while decrease>0:
        tns = decrease%10
        decrease //= 10
        if tns in BrokenButton:
            notBroken = False
            break
    if not notBroken:
        notBroken = True
        if increase == 0:
            if increase in BrokenButton:
                notBroken = False
        else:
            while increase>0:
                tns = increase%10
                increase //= 10
                if tns in BrokenButton:
                    notBroken = False
                    break
    else:
        isDecrease = True
    diff+=1
    if notBroken:
        break
diff-=1
result = 0
if isPM:
    result = allPlusMinus
else:
    if isDecrease:
        cycleResult = N-diff
    else:
        cycleResult = N+diff
    numSize = 0
    if cycleResult == 0:
        numSize = 1
    while cycleResult > 0:
        cycleResult //= 10
        numSize += 1
    result = numSize + diff
    if result > allPlusMinus:
        result = allPlusMinus
print(result)