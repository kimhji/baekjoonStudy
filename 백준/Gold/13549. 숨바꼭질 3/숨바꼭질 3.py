import sys, collections
N, K = map(int, sys.stdin.readline().split())
checkSet = set()
def findShortest(lists):
    while True:
        findTns = lists.popleft()
        if findTns[0] == K or findTns[0]*2 == K:
            print(findTns[1])
            return
        else:
            findTns2 = findTns[0]
            while findTns2 < K and findTns2 != 0:
                findTns2 = findTns2*2
                if findTns2 not in checkSet:
                    lists.append((findTns2, findTns[1]))
                    checkSet.add(findTns2)
                    if findTns2 == K:
                        print(findTns[1])
                        return
            if findTns[0] < K and findTns[0]+1 not in checkSet:
                lists.append((findTns[0]+1, findTns[1]+1))
                checkSet.add(findTns[0]+1)
            if findTns[0]-1 not in checkSet and findTns[0]>0:
                lists.append((findTns[0]-1, findTns[1]+1))
                checkSet.add(findTns[0]-1)

lists = collections.deque()
lists.append((N, 0))
checkSet.add(N)
findShortest(lists)