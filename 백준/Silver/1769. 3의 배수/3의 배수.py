import sys
NumberL = list(sys.stdin.readline().strip())
Number = sum(map(int, NumberL))
result = 0
isOver10 = False
while Number >= 10:
    isOver10 = True
    result += 1
    x = 0
    while Number > 0:
        x += Number % 10
        Number //= 10
    Number = x
if isOver10:
    result += 1
print(result)
if Number % 3 == 0:
    print('YES')
else:
    print('NO')