import sys

N = int(sys.stdin.readline().strip())
storeName = sys.stdin.readline().strip()
storeL = len(storeName)
result = 0
for cy in range(N):
    oldName = sys.stdin.readline().strip()
    oldL = len(oldName)
    idxList = [[], []]
    for check in range(oldL):
        if oldName[check] == storeName[0]:
            idxList[0].append(check)
        if oldName[check] == storeName[1]:
            idxList[1].append(check)
    isValid = False
    for cy1 in idxList[0]:
        for cy2 in idxList[1]:
            if cy2 - cy1 <= 0:
                continue
            isValid = True
            step = cy2 - cy1
            idx = 2
            c = cy2+step
            while True:
                if idx >= storeL:
                    break
                if c >= oldL:
                    isValid = False
                    break
                if oldName[c] == storeName[idx]:
                    idx += 1
                    c += step
                else:
                    isValid = False
                    break
            if isValid:
                break
        if isValid:
            break

    if isValid:
        result += 1
print(result)