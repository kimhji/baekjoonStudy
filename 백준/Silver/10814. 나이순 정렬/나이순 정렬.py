import sys
N = int(sys.stdin.readline())
bag = list()
for inputC in range(N):
    age, name = sys.stdin.readline().split()
    bag.append((int(age), name))

bag.sort(key= lambda x: x[0])
for printC in range(N):
    print(bag[printC][0], bag[printC][1])