import sys

N = int(sys.stdin.readline().strip())
for i in range(N):
    A = int(sys.stdin.readline().strip())
    if A % 9 == 0 or A % 3 == 2:
        print('TAK')
    else:
        print('NIE')