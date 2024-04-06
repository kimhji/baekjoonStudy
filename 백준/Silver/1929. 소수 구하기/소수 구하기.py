import sys
def check(num):
    global checklist
    for ch in range(2, int(num**(1/2))+1):
        tns = ch*2
        while tns <= num:
            checklist[tns] = False
            tns += ch

M, N = map(int, sys.stdin.readline().split())
checklist = [True for c in range(N+1)]
check(N)
checklist[1]=False
for cycle in range(M, N+1):
    if checklist[cycle]:
        print(cycle)
