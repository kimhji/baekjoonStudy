import sys

k, p, N = sys.stdin.readline().split()
k = list(k)
p = list(p)
N = int(N)
for cycle in range(N):
    order = sys.stdin.readline()
    oriK = k[:]
    oriP = p[:]
    error = False
    for move in order:
        if move == 'T':
            if ord(k[1]) < ord('8'):
                nextK = chr(ord(k[1])+1)
                p[1] = chr(ord(p[1])+1)
                k[1] = nextK
            else:
                error = True
                break
        elif move == 'B':
            if ord(k[1]) > ord('1'):
                nextK = chr(ord(k[1])-1)
                p[1] = chr(ord(p[1])-1)
                k[1] = nextK
            else:
                error = True
                break
        elif move == 'L':
            if ord(k[0]) > ord('A'):
                nextK = chr(ord(k[0])-1)
                p[0] = chr(ord(p[0])-1)
                k[0] = nextK
            else:
                error = True
                break
        elif move == 'R':
            if ord(k[0]) < ord('H'):
                nextK = chr(ord(k[0])+1)
                p[0] = chr(ord(p[0])+1)
                k[0] = nextK
            else:
                error = True
                break
    if error:
        k = oriK
        p = oriP
    else:
        if k != oriP:
            p = oriP
        else:
            if not(ord(p[0]) >= ord('A') and ord(p[0]) <= ord('H') and ord(p[1]) >= ord('1') and ord(p[1]) <= ord('8')):
                k = oriK
                p = oriP

print(''.join(k))
print(''.join(p))