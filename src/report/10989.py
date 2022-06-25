import sys

N = int(sys.stdin.readline())
s_list = [0] * 10001

for _ in range(N):
    el = int(sys.stdin.readline())
    s_list[el] += 1

for i in range(len(s_list)):
    if s_list[i] != 0:
        for j in range(s_list[i]):
            print(i)
