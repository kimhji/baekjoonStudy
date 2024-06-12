import sys
N = int(sys.stdin.readline())
result = 0
for cycle in range(N):
    word = sys.stdin.readline().strip()
    wordDict = dict()
    pre = ' '
    isNotGroup = False
    for check in list(word):
        if check in wordDict and pre != check:
            isNotGroup = True
            break
        pre = check
        wordDict[check] = 1
    if not isNotGroup:
        result += 1
print(result)