import sys
n,d = sys.stdin.readline().split()
strResult = ""
count = 0
for cy in range(1, int(n)+1):
    strResult += str(cy)
for check in strResult:
    if check == d:
        count += 1
print(count)