import sys
N = int(sys.stdin.readline())
for inputC in range(N):
    stringInp = sys.stdin.readline().rstrip()
    index = 0
    pole = {'A', 'B', 'C', 'D', 'E', 'F'}
    infected = True
    appearedA = False
    appearedF = False
    appearedC = False

    for check in stringInp:
        if index == 0:
            if check not in pole:
                infected = False
                break
            if check == 'A':
                appearedA = True
        else:
            if not appearedA:
                if check != 'A':
                    infected = False
                    break
                else:
                    appearedA = True
            elif not appearedF:
                if check != 'F' and check != 'A':
                    infected = False
                    break
                elif check == 'F':
                    appearedF = True
            elif not appearedC:
                if check != 'F' and check != 'C':
                    infected = False
                    break
                elif check == 'C':
                    appearedC = True
        index += 1
    if stringInp[-1] not in pole:
        infected = False
    if appearedA and appearedC and appearedF and infected:
        print("Infected!")
    else:
        print("Good")