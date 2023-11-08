import math

Input = input().split()
N = int(Input[0])
M = int(Input[1])
K = int(Input[2])
Map = [[[] for _ in range(0, N, 1)] for _ in range(0, N, 1)]
for i in range(0, M, 1):
    fireball = []
    Input = input().split()
    fireball.append(int(Input[0]))
    fireball.append(int(Input[1]))
    fireball.append(int(Input[2]))
    fireball.append(int(Input[3]))
    fireball.append(int(Input[4]))
    Map[fireball[0] - 1][fireball[1] - 1].append(fireball)
for i in range(0, K, 1):
    for j in range(0, N, 1):
        for k in range(0, N, 1):
            if Map[j][k] != []:
                for p in Map[j][k]:
                    if p[4] == 1 or p[4] == 2 or p[4] == 3:
                        p[1] += p[3] % N
                        if p[1] > N:
                            p[1] = p[1] - N
                    if p[4] == 3 or p[4] == 4 or p[4] == 5:
                        p[0] += p[3] % N
                        if p[0] > N:
                            p[0] = p[0] - N
                    if p[4] == 5 or p[4] == 6 or p[4] == 7:
                        p[1] -= p[3] % N
                        if p[1]<1:
                            p[1] = N + p[1]
                    if p[4] == 7 or p[4] == 0 or p[4] == 1:
                        p[0] -= p[3] % N
                        if p[0]<1:
                            p[0] = N + p[0]
    for j in range(0, N, 1):
        for k in range(0, N, 1):
            if Map[j][k] != []:
                z = []
                for p in Map[j][k]:
                    if int(p[0]) - 1 != j or int(p[1]) - 1 != k:
                        x = int(p[0]) - 1
                        y = int(p[1]) - 1
                        Map[x][y].append(p)
                        z.append(p)
                for p in z:
                    Map[j][k].remove(p)
    for j in range(0, N, 1):
        for k in range(0, N, 1):
            if len(Map[j][k]) > 1:
                dirs = []
                speeds = 0
                weight = 0
                for p in Map[j][k]:
                    dirs.append(p[4] % 2)
                    speeds += p[3]
                    weight += p[2]
                weight = math.floor(float(weight) / 5.0)
                speeds = math.floor(float(speeds) / float(len(Map[j][k])))
                Map[j][k] = []
                if dirs:
                    if dirs.count(1) > 0 and dirs.count(0) > 0:
                        dirs = [1, 3, 5, 7]
                    else:
                        dirs = [0, 2, 4, 6]
                if weight != 0:
                    for p in range(0, 4, 1):
                        if dirs:
                            fireball = [j + 1, k + 1, weight, speeds, dirs[p]]
                            Map[j][k].append(fireball)
sum = 0
for j in range(0, N, 1):
    for k in range(0, N, 1):
        if len(Map[j][k]) > 0:
            for p in Map[j][k]:
                sum += p[2]
print(sum)
