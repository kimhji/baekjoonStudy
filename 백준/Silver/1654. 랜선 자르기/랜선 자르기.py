import sys
left = 0
right = -1
sumV = 0

K, N = map(int, sys.stdin.readline().strip().split(" "))
lines = []
numLines = [0 for init in range(K)]
for init in range(K):
    tns = int(sys.stdin.readline().strip())
    lines.append(tns)
    if right < tns:
        right = tns
while left < right:
    mid = (right+left)//2
    if (right+left) % 2 > 0 and mid+1 != right:
        mid += 1
    if mid <= 0:
        mid = 1
    for update in range(K):
        numLines[update] = lines[update] // mid
    sumV = sum(numLines)
    if sumV >= N:
        if right != mid and left == mid:
            right += 1
        left = mid
    else:
        right = mid-1
print(right)