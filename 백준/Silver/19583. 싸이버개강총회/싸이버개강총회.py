import sys
start, end, streamingEnd = sys.stdin.readline().split()
SHour, SMinu = map(int, start.split(':'))
EHour, EMinu = map(int, end.split(':'))
SEHour, SEMinu = map(int, streamingEnd.split(':'))
InStudent = set()
OutStudent = set()


while True:
    try:
        time, name = sys.stdin.readline().split()
        hour, minu = map(int, time.split(':'))
        if hour < SHour or hour == SHour and minu <= SMinu:
            InStudent.add(name)
        elif (hour < SEHour or hour == SEHour and minu <= SEMinu) and (hour > EHour or hour == EHour and minu >= EMinu):
            OutStudent.add(name)
    except:
        break
result = InStudent.intersection(OutStudent)
print(len(result))