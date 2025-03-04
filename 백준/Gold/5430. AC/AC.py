import sys

def ac(order, arr, n):
    isError = False
    f_idx = 0
    b_idx = n-1
    isFlipped = False

    for one in order:
        if one == "R":
            tns = f_idx
            f_idx = b_idx
            b_idx = tns
            isFlipped = not isFlipped
        elif one == "D":
            if n > 0:
                if isFlipped:
                    f_idx -= 1
                else:
                    f_idx += 1
                n -= 1
            else:
                isError = True
                break
    if isError:
        return "error"
    else:
        result = ""
        if n == 0:
            return "[]"
        if isFlipped:
            r_bidx = b_idx-1
            if r_bidx < 0:
                r_bidx = None
            result = ",".join(arr[f_idx:r_bidx:-1])
        else:
            result = ",".join(arr[f_idx:b_idx+1:1])
        return "["+result+"]"

T = int(sys.stdin.readline().strip())
for cycle in range(T):
    order = list(sys.stdin.readline().strip())
    N = int(sys.stdin.readline().strip())
    arr = sys.stdin.readline().strip().strip("[]").split(",")

    print(ac(order, arr, N))