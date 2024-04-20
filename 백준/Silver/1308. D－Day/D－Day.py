import sys

def calDay(year, month, day):
    result = 0
    for yC in range(1, year):
        if yC % 400 == 0:
            result += 366
        elif yC % 100 == 0:
            result += 365
        elif yC % 4 == 0:
            result += 366
        else:
            result += 365
    for mC in range(1, month):
        if mC == 1:
            result += 31
        elif mC == 2:
            result += 28
            if year % 400 == 0 or year % 100 != 0 and year % 4 == 0:
                result += 1
        elif mC == 3:
            result += 31
        elif mC == 4:
            result += 30
        elif mC == 5:
            result += 31
        elif mC == 6:
            result += 30
        elif mC == 7:
            result += 31
        elif mC == 8:
            result += 31
        elif mC == 9:
            result += 30
        elif mC == 10:
            result += 31
        elif mC == 11:
            result += 30
        elif mC == 12:
            result += 31
    result += day
    return result

CY, CM, CD = map(int, sys.stdin.readline().split())
NY, NM, ND = map(int, sys.stdin.readline().split())
cR = calDay(CY, CM, CD)
nR = calDay(NY, NM, ND)
limR = calDay(CY+1000,CM,CD)
if nR >= limR:
    print('gg')
else:
    result = (nR - cR)
    print('D-'+str(result))