import sys
squ = set()
for cycle in range(4):
    x1, y1, x2, y2 = map(int, sys.stdin.readline().split())
    for checkx in range(x1, x2):
        for checky in range(y1, y2):
            squ.add((checkx, checky))
print(len(squ))