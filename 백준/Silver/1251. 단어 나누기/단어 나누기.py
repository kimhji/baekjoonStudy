import sys
str1 = sys.stdin.readline().strip()
N = len(str1)
result = list()
for check1 in range(1, N-1):
    str2 = str1[:check1]
    for check2 in range(check1+1, N):
        str3 = str1[check1:check2]
        str4 = str1[check2:]
        rstr1 = str2[::-1]
        rstr2 = str3[::-1]
        rstr3 = str4[::-1]

        result.append(''.join([str(rstr1), str(rstr2), str(rstr3)]))

result.sort()
print(result[0])