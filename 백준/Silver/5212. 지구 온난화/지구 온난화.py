Input = input().split()
Map = []
afterMap = [['' for i in range(0, int(Input[1]), 1)] for j in range(0, int(Input[0]), 1)]
minIndex = [int(Input[1]), int(Input[0]), 0, 0]  # left, top, right, bottom
for i in range(0, int(Input[0]), 1):
    Map.append(input())
for i in range(0, int(Input[0]), 1):
    for j in range(0, int(Input[1]), 1):
        nearSea = 0
        afterMap[i][j] = Map[i][j]
        if Map[i][j] == 'X':
            if i == 0 or Map[i-1][j] == '.':
                nearSea += 1
            if j == 0 or Map[i][j-1] == '.':
                nearSea += 1
            if j == int(Input[1]) - 1 or Map[i][j+1] == '.':
                nearSea += 1
            if i == int(Input[0]) - 1 or Map[i+1][j] == '.':
                nearSea += 1
            if nearSea > 2:
                afterMap[i][j] = '.'
            else:
                if minIndex[0] > j:
                    minIndex[0] = j
                if minIndex[1] > i:
                    minIndex[1] = i
                if minIndex[2] < j:
                    minIndex[2] = j
                if minIndex[3] < i:
                    minIndex[3] = i
for i in range(minIndex[1], minIndex[3] + 1, 1):
    for j in range(minIndex[0], minIndex[2]+1, 1):
        print(afterMap[i][j], end='')
    print()