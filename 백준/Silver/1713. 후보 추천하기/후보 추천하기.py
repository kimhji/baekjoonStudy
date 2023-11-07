vote = [0 for _ in range(0, 101, 1)]
N = int(input())
repeat = int(input())
showin = [0 for _ in range(0, N, 1)]
Input = list(map(int, input().split()))
for i in range(0, repeat, 1):
    if not Input[i] in showin:
        minIndex = 0
        if 0 not in showin:
            delete = []
            for k in range(1, N, 1):
                if vote[showin[k]] < vote[showin[minIndex]]:
                    minIndex = k
                    delete = [k]
                elif vote[showin[k]] == vote[showin[minIndex]]:
                    delete.append(k)
            for k in delete:
                if Input.index(showin[k]) < Input.index(showin[minIndex]):
                    minIndex = k
            for j in range(0, i, 1):
                if showin[minIndex] not in Input or Input.index(showin[minIndex]) > i:
                    break
                elif Input.index(showin[minIndex]) < i:
                    Input[Input.index(showin[minIndex])] = 0
                    vote[showin[minIndex]] = 0
            showin[minIndex] = 0
        else:
            minIndex = showin.index(0)
        showin[minIndex] = Input[i]
    vote[Input[i]] += 1

for i in range(0, N, 1):
    for j in range(i, N, 1):
        if showin[i] > showin[j]:
            tns = showin[j]
            showin[j] = showin[i]
            showin[i] = tns
for i in range(0, N-1, 1):
    if showin[i] != 0:
        print(showin[i], end=' ')
if showin[N-1] != 0:
    print(showin[N-1], end='')