import sys
T = int(sys.stdin.readline())
valueList = [[0, 0] for cycle in range(41)]
valueList[0][0] = 1
valueList[1][1] = 1
for ready in range(2, 41):
    valueList[ready][0] = valueList[ready-1][0] + valueList[ready-2][0]
    valueList[ready][1] = valueList[ready - 1][1] + valueList[ready - 2][1]
for inputC in range(T):
    n = int(sys.stdin.readline())
    print(valueList[n][0], valueList[n][1])