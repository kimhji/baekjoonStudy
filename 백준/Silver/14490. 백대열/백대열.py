import sys
def solve(x, y):
    if y == 0:
        return x
    else:
        return solve(y, x%y)

n, m = map(int, sys.stdin.readline().split(':'))
x = solve(n, m)
print(f"{n//x}:{m//x}")