import sys


def sorting(input_list, k):
    input_list[k:] = sorted(input_list[k:])


def start(input_list, k):
    for i in range(int(input_list[k - 1]) + 1, 10):
        for j in range(k, len(input_list)):
            if input_list[j] == str(i):
                input_list[j], input_list[k - 1] = input_list[k - 1], input_list[j]
                sorting(input_list, k)
                return


def solution(input_str):
    input_list = list(input_str)
    length = len(input_list)

    for i in range(length - 1, 0, -1):
        if input_list[i] > input_list[i - 1]:
            start(input_list, i)
            print("".join(input_list))
            return

    print("BIGGEST")


def main():
    t = int(sys.stdin.readline().strip())
    for _ in range(t):
        input_str = sys.stdin.readline().strip()
        solution(input_str)


main()
