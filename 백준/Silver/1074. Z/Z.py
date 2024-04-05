import sys

def searchCycle(sizer, sizec, indR, indC):
    global value, r, c
    if sizer == 1 or sizec == 1:
        return
    halfr = sizer//2
    halfc = sizec//2
    nextindR = indR
    nextindC = indC
    if r >= indR + halfr:
        value += halfr * halfc * 2
        nextindR += halfr
    if c >= indC + halfc:
        value += halfr * halfc
        nextindC += halfc
    searchCycle(halfr, halfc, nextindR, nextindC)
N, r, c = map(int, sys.stdin.readline().split())
value = 0
size = 2**N
searchCycle(size, size, 0, 0)
print(value)
