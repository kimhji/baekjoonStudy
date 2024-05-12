import sys
num = list(sys.stdin.readline())
num.sort(reverse=True)
print(''.join(num))