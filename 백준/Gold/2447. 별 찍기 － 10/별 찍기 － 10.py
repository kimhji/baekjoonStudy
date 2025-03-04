import sys

def star(size, idx):
    global lines

    if size == 3:
        lines[idx] += "***"
        lines[idx+1] += "* *"
        lines[idx+2] += "***"
    else:
        nextSize = size//3
        star(nextSize, idx)
        star(nextSize, idx)
        star(nextSize, idx)
        star(nextSize, idx+nextSize)
        for empty in range(idx+nextSize, idx+nextSize*2):
            lines[empty] += " "*nextSize
        star(nextSize, idx+nextSize)
        star(nextSize, idx+nextSize*2)
        star(nextSize, idx+nextSize*2)
        star(nextSize, idx+nextSize*2)


N = int(sys.stdin.readline().strip())
lines = ["" for init in range(N)]
star(N, 0)

for l in lines:
    print(l)