import sys
n = int(sys.stdin.readline())
toy= list()
for cycle in range(n):
    j, p = map(int,sys.stdin.readline().split())
    toy.append((cycle+1, j, p, j/p))
toy.sort(key=lambda x:x[3]*(-1))
pay = 0
for cy in range(3):
    pay += toy[cy][2]
print(pay)
for cy in range(3):
    print(toy[cy][0])