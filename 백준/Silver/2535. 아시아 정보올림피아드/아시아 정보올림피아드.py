import sys
N = int(sys.stdin.readline())
parti = []
country = dict()
for cycle in range(N):
    parti.append(list(map(int, sys.stdin.readline().split())))
parti.sort(key=lambda x: x[2]*(-1))
count = 0
for check in parti:
    if check[0] in country:
        if country[check[0]] >= 2:
            continue
        country[check[0]] += 1
        print(check[0],check[1])
        count += 1
        if count > 2:
            break
    else:
        country[check[0]] = 1
        print(check[0], check[1])
        count += 1
        if count > 2:
            break