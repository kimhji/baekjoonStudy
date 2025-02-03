import sys

def merge_sort(A, p, r, beforeV, maxV):
    if(beforeV == maxV):
        return beforeV
    curV = beforeV

    if (p < r):
        q = (p + r) // 2
        curV = merge_sort(A, p, q, curV, maxV)
        curV = merge_sort(A, q + 1, r, curV, maxV)
        curV = merge(A, p, q, r, curV, maxV)
    return curV
def merge(A, p, q, r, beforeV, maxV) :
    i = p
    j = q + 1
    tmp = []
    curV = beforeV
    if(beforeV == maxV):
        return beforeV
    while (i <= q and j <= r) :
        if (A[i] <= A[j] or curV>=maxV):
            tmp.append(A[i])
            i=i+1
        else:
            tmp.append(A[j])
            j+=1

    while (i <= q):
        tmp.append(A[i])
        i+=1
    while (j <= r):
        tmp.append(A[j])
        j+=1
    i = p
    t = 0
    while i <= r:
        A[i] = tmp[t]
        i += 1
        t += 1
        curV+=1
        if(curV>=K):
            return K
    return curV


line = sys.stdin.readline().strip().split(" ")
N = int(line[0])
K = int(line[1])
A = list(map(int, sys.stdin.readline().strip().split(" ")))

curV = merge_sort(A, 0, N-1, 0, K)
if(curV<K):
    print(-1)
else:
    print(' '.join(map(str,A)))