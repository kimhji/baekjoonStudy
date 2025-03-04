import sys

def isMo(str):
    if str == "a" or str == "i" or str == "o" or str == "u" or str == "e":
        return True
    else:
        return False

def possible(idx, l, sets, curW, MoNum, JaNum):
    global L, C
    nextL = l+1
    for cycle in range(idx, C):
        nextIdx = cycle+1
        curM = MoNum
        curJ = JaNum
        if isMo(sets[cycle]):
            curM += 1
        else:
            curJ += 1
        if nextL == L:
            if curM > 0 and curJ > 1:
                print(curW+sets[cycle])
        else:
            possible(nextIdx, nextL, sets, curW+sets[cycle], curM, curJ)

L, C = map(int, sys.stdin.readline().strip().split(" "))
words = list(sys.stdin.readline().strip().split(" "))
words.sort()

possible(0, 0, words, "", 0, 0)