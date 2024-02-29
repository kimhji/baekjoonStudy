import sys
testcase = int(sys.stdin.readline())
for cycle in range(testcase):
    bag = set()
    N = int(sys.stdin.readline())
    for inputC in map(int, sys.stdin.readline().split()):
        bag.add(inputC)
    M = int(sys.stdin.readline())
    for askC in map(int, sys.stdin.readline().split()):
        if askC in bag:
            print(1)
        else:
            print(0)