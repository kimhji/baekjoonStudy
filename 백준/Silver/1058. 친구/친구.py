import sys

N = int(input().strip())
friendBoolBoard = [[False for two in range(N)] for one in range(N)]

for i in range(N):
    f_idx = 0
    for word in list(input().strip()):
        if word == "Y":
            friendBoolBoard[i][f_idx] = True
        f_idx += 1

maxV = 0
for i in range(N):
    friendSet = set()
    bag = []
    for j in range(N):
        if friendBoolBoard[i][j]:
            bag.append(j)
            friendSet.add(j)

    for friend in bag:
        for j in range(N):
            if j != i and friendBoolBoard[friend][j]:
                friendSet.add(j)
    count = len(friendSet)
    if maxV < count:
        maxV = count
print(maxV)
