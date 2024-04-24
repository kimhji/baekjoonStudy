import sys
N = int(sys.stdin.readline())
test = 1
while N > 0:
    student = list()
    nasty = list()
    for cycle in range(N):
        student.append(list(sys.stdin.readline().split()))
    for cycle in range(N):
        for check in range(1, N):
            if student[cycle][check] == 'N':
                n = cycle - check
                if n < 0:
                    n += N
                nasty.append([student[n][0], student[cycle][0]])
    print(f"Group {test}")
    if len(nasty) != 0:
        for a, b in nasty:
            print(f"{a} was nasty about {b}")
    else:
        print("Nobody was nasty")
    N = int(sys.stdin.readline())
    test += 1
    print("")