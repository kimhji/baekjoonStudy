import sys, collections
N = int(sys.stdin.readline())
for testcase in range(N):
    fileNum, index = map(int, sys.stdin.readline().split())
    files = collections.deque(map(int, sys.stdin.readline().split()))
    result = 0
    while fileNum > 0:
        if files[0] < max(files):
            file = files.popleft()
            files.append(file)
            index -= 1
            if index < 0:
                index += fileNum
        else:
            result += 1
            if index == 0:
                print(result)
                break
            files.popleft()
            fileNum -= 1
            index -= 1
            if index < 0:
                index += fileNum