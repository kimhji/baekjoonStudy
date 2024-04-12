import sys
N = int(sys.stdin.readline())
numbersSum = list()
numbers = list()
for inputC in range(N):
    numbersSum.append(int(sys.stdin.readline()))
Cal = numbersSum[0]
plus = False
for cycle in range(1, N-1):
    if plus:
        Cal += numbersSum[cycle]
        plus = False
    else:
        Cal -= numbersSum[cycle]
        plus = True
Cal += numbersSum[-1]
Cal //= 2
numbers.append(Cal)
for cycle in range(N-1):
    tns = numbersSum[cycle] - Cal
    Cal = tns
    numbers.append(Cal)
for printC in range(N):
    print(numbers[printC])