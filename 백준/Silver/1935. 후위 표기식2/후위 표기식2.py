import sys, collections
def charToInt(charA):
    if charA == 'A':
        return 0
    elif charA == 'B':
        return 1
    elif charA == 'C':
        return 2
    elif charA == 'D':
        return 3
    elif charA == 'E':
        return 4
    elif charA == 'F':
        return 5
    elif charA == 'G':
        return 6
    elif charA == 'H':
        return 7
    elif charA == 'I':
        return 8
    elif charA == 'J':
        return 9
    elif charA == 'K':
        return 10
    elif charA == 'L':
        return 11
    elif charA == 'M':
        return 12
    elif charA == 'N':
        return 13
    elif charA == 'O':
        return 14
    elif charA == 'P':
        return 15
    elif charA == 'Q':
        return 16
    elif charA == 'R':
        return 17
    elif charA == 'S':
        return 18
    elif charA == 'T':
        return 19
    elif charA == 'U':
        return 20
    elif charA == 'V':
        return 21
    elif charA == 'W':
        return 22
    elif charA == 'X':
        return 23
    elif charA == 'Y':
        return 24
    elif charA == 'Z':
        return 25



N = int(sys.stdin.readline())
cal = collections.deque(sys.stdin.readline())
number = list()
stack = list()
for calCycle in range(N):
    num = int(sys.stdin.readline())
    number.append(num)
for order in cal:
    if order >= 'A' and order <= 'Z':
        stack.append(number[charToInt(order)])
    elif order == '+':
        num1 = stack.pop()
        num2 = stack.pop()
        stack.append(num1+num2)
    elif order == '-':
        num1 = stack.pop()
        num2 = stack.pop()
        stack.append(num2 - num1)
    elif order == '*':
        num1 = stack.pop()
        num2 = stack.pop()
        stack.append(num1 * num2)
    elif order == '/':
        num1 = stack.pop()
        num2 = stack.pop()
        stack.append(num2 / num1)
print("{:.2f}".format(stack[0]))