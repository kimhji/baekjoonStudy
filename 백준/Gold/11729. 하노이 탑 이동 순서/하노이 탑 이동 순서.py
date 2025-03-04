import sys

def solve(n, start, to, via):
    if n == 1:
        print(start, to)
    else:
        solve(n-1, start, via, to)
        print(start, to)
        solve(n-1, via, to, start)

N = int(sys.stdin.readline().strip())
num = 2**N-1
print(num)
solve(N, 1, 3, 2)
