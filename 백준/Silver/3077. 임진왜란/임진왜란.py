import sys
N = int(sys.stdin.readline())
answer = sys.stdin.readline().split()
student = sys.stdin.readline().split()
Ans = dict(zip(answer, list(i for i in range(N))))
score = 0
for x in range(N):
    for y in range(x):
        if Ans[student[x]] > Ans[student[y]]:
            score += 1
maximum = int(N*(N-1)/2)
print(str(score)+'/'+str(maximum))

