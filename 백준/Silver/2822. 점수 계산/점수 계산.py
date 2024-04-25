import sys
score = list()
for cycle in range(1,9):
    score.append([int(sys.stdin.readline()), cycle])
score.sort(reverse=True)
s = 0
bag = score[:5]
bag.sort(key=lambda x: x[1])
total = 0
for sumScore in bag:
    total += sumScore[0]
print(total)
for sumScore in bag:
    print(sumScore[1], end=' ')