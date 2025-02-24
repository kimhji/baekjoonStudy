import sys
words = []

while True:
    line = sys.stdin.readline().strip()
    if line == "-":
        break
    wordDict = dict()
    wordSet = set()
    chars = list(line)
    for ch in chars:
        if ch in wordSet:
            wordDict[ch] = wordDict.get(ch)+1
        else:
            wordSet.add(ch)
            wordDict[ch] = 1
    words.append([wordSet, wordDict])

while True:
    line = sys.stdin.readline().strip()
    if line == "#":
        break
    wordDict = dict()
    wordNeedDict = dict()
    wordSet = set()
    chars = list(line)
    for ch in chars:
        if ch in wordSet:
            wordDict[ch] = wordDict.get(ch) + 1
        else:
            wordSet.add(ch)
            wordDict[ch] = 1
            wordNeedDict[ch] = 0

    for word in words:
        included = True
        for c in word[0]:
            if c not in wordSet:
                included = False
                break
            if word[1].get(c) > wordDict.get(c):
                included = False
                break
        if included:
            for c in word[0]:
                wordNeedDict[c] = wordNeedDict.get(c) + 1

    minV = 200001
    minBag = []

    maxV = 0
    maxBag = []

    for c in wordSet:
        if wordNeedDict.get(c) == minV:
            minBag.append(c)
        elif wordNeedDict.get(c) < minV:
            minV = wordNeedDict.get(c)
            minBag = [c]
        if wordNeedDict.get(c) == maxV:
            maxBag.append(c)
        elif wordNeedDict.get(c) > maxV:
            maxV = wordNeedDict.get(c)
            maxBag = [c]
    minBag.sort()
    maxBag.sort()
    print("".join(minBag)+" "+str(minV)+" "+"".join(maxBag)+" "+str(maxV))