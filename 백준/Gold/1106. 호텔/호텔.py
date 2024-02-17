import sys
C, N = map(int, sys.stdin.readline().split())
costList = list()
customerlist = [0 for customers in range(C+1)]

MinCost = 100000000
for cycle in range(N):
    cost, customer = map(int, sys.stdin.readline().split())
    costList.append((cost, customer))
costList.sort(key=lambda x: x[1], reverse=True)

for cycle in range(C):
    if cycle != 0 and customerlist[cycle] == 0:
        continue
    for check in range(N):
        nextCustomer = cycle + costList[check][1]
        nextCost = customerlist[cycle] + costList[check][0]
        if nextCustomer >= C:
            if customerlist[C] > nextCost or customerlist[C] == 0:
                customerlist[C] = nextCost
        else:
            if customerlist[nextCustomer] > nextCost or customerlist[nextCustomer] == 0:
                customerlist[nextCustomer] = nextCost

print(customerlist[C])