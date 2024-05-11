import sys, collections
document = sys.stdin.readline().strip()
search = sys.stdin.readline().strip()
ind = 0
num = 0
bag = collections.deque()
lenSearch = len(search)
lenDoc = len(document)
check = 0
while check < lenDoc:
    if document[check] != search[ind]:
        ind = 0
        if len(bag) > 0:
            check = bag.popleft()
            continue
    if document[check] == search[0] and ind != 0:
        bag.append(check)
    if document[check] == search[ind]:
        ind += 1
        if ind == lenSearch:
            ind = 0
            num += 1
            bag = collections.deque()
    check += 1
print(num)