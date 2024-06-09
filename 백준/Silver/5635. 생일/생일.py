import sys
N = int(sys.stdin.readline())
people = list()
for cycle in range(N):
    name, day, month, year = sys.stdin.readline().strip().split()
    people.append((name, int(day), int(month), int(year)))
people.sort(key=lambda x: (x[3], x[2], x[1]))
print(people[N-1][0])
print(people[0][0])