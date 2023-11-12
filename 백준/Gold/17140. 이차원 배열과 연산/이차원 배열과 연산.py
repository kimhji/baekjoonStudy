Input = list(map(int, input().split()))
Array = [[0 for _ in range(3)] for _ in range(3)]
r = Input[0]
c = Input[1]
k = Input[2]
time = -1
Transpose = False

for _ in range(3):
    Input = list(map(int, input().split()))
    Array[_][0] = Input[0]
    Array[_][1] = Input[1]
    Array[_][2] = Input[2]

for cycle in range(101):
    Transpose = False
    if len(Array) > r - 1 and len(Array[r-1]) > c - 1:
        if Array[r-1][c-1] == k:
            time = cycle
            break
    if len(Array) < len(Array[0]):
        Array = list(zip(*Array))
        Transpose = True
    maxCol = 0
    for rNum in range(len(Array)):
        arrayTns = list()
        Array[rNum] = list(values for values in Array[rNum] if values != 0)
        while Array[rNum] != []:
            value = Array[rNum][0]
            arrayTns.append((value, Array[rNum].count(value)))
            Array[rNum] = list(values for values in Array[rNum] if values != value)
        arrayTns = sorted(arrayTns, key=lambda x: (x[1], x[0]))
        Array[rNum].clear()
        for ar in arrayTns:
            Array[rNum] += list(ar)
        if maxCol < len(Array[rNum]):
            maxCol = len(Array[rNum])
    if maxCol > 100:
        maxCol = 100
    for rNum in range(len(Array)):
        if maxCol < len(Array[rNum]):
            Array[rNum] = Array[rNum][:100]
        while maxCol > len(Array[rNum]):
            Array[rNum].append(0)
    if Transpose:
        Array = list(zip(*Array))
print(time)