import sys
while True:
    try:
        cycle = sys.stdin.readline().strip()
        if cycle == 'R0C0':
            break
        ind = cycle.index('C')
        beh = cycle[1:ind]
        num = int(cycle[ind + 1:])
        fro = ''
        while num > 0:
            num -= 1
            fro = chr(ord('A') + (num % 26)) + fro
            num //= 26

        print(fro + beh)
    except:
        break
