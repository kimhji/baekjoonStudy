import sys
N = int(sys.stdin.readline().strip())
k = int(sys.stdin.readline().strip())

numbers = set()

def makeNumber(count, bag, checked):
    if count == k:
        result = 0
        for sumC in checked:
            if sumC > 9:
                result *= 100
            else:
                result *= 10
            result += sumC
        numbers.add(result)
        return
    for cy in range(len(bag)):
        tnsBag = []
        for cy2 in range(len(bag)):
            if cy == cy2:
                continue
            tnsBag.append(bag[cy2])
        checked.append(bag[cy])
        makeNumber(count+1, tnsBag, checked)
        checked.pop()

cards = []
for inp in range(N):
    cards.append(int(sys.stdin.readline().strip()))
makeNumber(0, cards, list())

print(len(numbers))
