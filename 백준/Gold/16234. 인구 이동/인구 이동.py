import sys, collections
N, L, R = map(int, sys.stdin.readline().split())

Board = list()

for inputCycle in range(N):
    line = list(map(int, sys.stdin.readline().split()))
    Board.append(line)

dequeOf1 = collections.deque()
day = -1
flag_changed = True
while flag_changed:
    flag_changed = False
    for x in range(N):
        for y in range(N):
            if x > 0:
                tmpValue = abs(Board[x-1][y] - Board[x][y])
                if tmpValue >= L and tmpValue <= R:
                    flag_added = False
                    for search in dequeOf1:
                        if (x-1, y, Board[x-1][y]) in search or (x, y, Board[x][y]) in search:
                            search.add((x, y, Board[x][y]))
                            search.add((x-1, y, Board[x-1][y]))
                            flag_added = True
                            break
                    if not flag_changed:
                        setInput = set()
                        setInput.add((x, y, Board[x][y]))
                        setInput.add((x-1, y, Board[x-1][y]))
                        dequeOf1.append(setInput)
            if x < N - 1:
                tmpValue = abs(Board[x+1][y] - Board[x][y])
                if tmpValue >= L and tmpValue <= R:
                    flag_added = False
                    for search in dequeOf1:
                        if (x+1, y, Board[x+1][y]) in search or (x, y, Board[x][y]) in search:
                            search.add((x, y, Board[x][y]))
                            search.add((x+1, y, Board[x+1][y]))
                            flag_added = True
                            break
                    if not flag_changed:
                        setInput = set()
                        setInput.add((x, y, Board[x][y]))
                        setInput.add((x+1, y, Board[x+1][y]))
                        dequeOf1.append(setInput)
            if y > 0:
                tmpValue = abs(Board[x][y-1] - Board[x][y])
                if tmpValue >= L and tmpValue <= R:
                    flag_added = False
                    for search in dequeOf1:
                        if (x, y-1, Board[x][y-1]) in search or (x, y, Board[x][y]) in search:
                            search.add((x, y, Board[x][y]))
                            search.add((x, y-1, Board[x][y-1]))
                            flag_added = True
                            break
                    if not flag_changed:
                        setInput = set()
                        setInput.add((x, y, Board[x][y]))
                        setInput.add((x, y-1, Board[x][y-1]))
                        dequeOf1.append(setInput)
            if y < N-1:
                tmpValue = abs(Board[x][y+1] - Board[x][y])
                if tmpValue >= L and tmpValue <= R:
                    flag_added = False
                    for search in dequeOf1:
                        if (x, y+1, Board[x][y+1]) in search or (x, y, Board[x][y]) in search:
                            search.add((x, y, Board[x][y]))
                            search.add((x, y+1, Board[x][y+1]))
                            flag_added = True
                            break
                    if not flag_changed:
                        setInput = set()
                        setInput.add((x, y, Board[x][y]))
                        setInput.add((x, y+1, Board[x][y+1]))
                        dequeOf1.append(setInput)
    dequeOf2 = collections.deque()
    while dequeOf1 != collections.deque():
        setTns = dequeOf1.popleft()
        if setTns != set():
            for searchSet in dequeOf1:
                if setTns.intersection(searchSet) != set():
                    setTns = setTns.union(searchSet)
                    searchSet.clear()
            dequeOf2.append(setTns)


    while dequeOf2 != collections.deque():
        flag_changed = True
        search = dequeOf2.popleft()
        sum = 0
        num = 0
        for value in search:
            sum += value[2]
            num += 1
        if num!= 0:
            sum //= num
        for value in search:
            Board[value[0]][value[1]] = sum
    day += 1
print(day)


