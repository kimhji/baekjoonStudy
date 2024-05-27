import sys
String = sys.stdin.readline().strip()
result = ['U', 'C', 'P', 'C']
ind = 0
for check in String:
    if check == result[ind]:
        ind += 1
        if ind == 4: 
            break
if ind == 4:
    print("I love UCPC")
else :
    print("I hate UCPC")