import sys
N, M = map(int,sys.stdin.readline().split())
password = dict()
for inputC in range(N):
    site, word = sys.stdin.readline().split(' ')
    password[site] = word.strip()
for outputC in range(M):
    site = sys.stdin.readline().strip()
    print(password[site])