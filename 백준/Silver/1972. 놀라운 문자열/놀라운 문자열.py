import sys
inp = sys.stdin.readline().strip()
while inp != '*':
    leng = len(inp)
    List = list()
    isUnique = True
    for check in range(leng-1):
        chList = set()
        num = 0
        for ch2 in range(leng-check-1):
            chList.add((inp[ch2]+inp[ch2+check+1]))
            num += 1
        if num != len(chList):
            isUnique = False
            break
        if not isUnique:
            break
    result = 'surprising'
    if not isUnique:
        result = "NOT surprising"
    print(f"{inp} is {result}.")
    inp = sys.stdin.readline().strip()