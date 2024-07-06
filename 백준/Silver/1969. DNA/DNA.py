import sys
N, L = map(int, sys.stdin.readline().split())
DNA = []
for i in range(N):
    DNA.append(sys.stdin.readline().strip())

result = ""
left = 0
for i in range(L):
    wordCount = [[0,"A"], [0,"C"], [0,"G"], [0,"T"]]
    for j in range(N):
        if DNA[j][i] == "A":
            wordCount[0][0] += 1
        elif DNA[j][i] == "C":
            wordCount[1][0] += 1
        elif DNA[j][i] == "G":
            wordCount[2][0] += 1
        elif DNA[j][i] == "T":
            wordCount[3][0] += 1
    wordCount.sort(key = lambda x: (-x[0],x[1]))
    result += wordCount[0][1]
    for k in range(1,4):
        left += wordCount[k][0]

print(result)
print(left)
