import sys

def isPal(string):
    L = len(string)
    result = True
    for i in range(int(L/2+0.5)):
        if string[i] != string[L-i-1]:
            result = False
            break
    return result

standard = sys.stdin.readline().strip()
tns = ""
idx = 0
while not (isPal(standard+tns)):
    tns = standard[idx]+tns

    idx += 1
print(len(standard)+len(tns))