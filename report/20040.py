import sys
input = sys.stdin.readline
n, m = map(int, input().split())
arr = [i for i in range(n)]


def find(x):
    if x == arr[x]:
        return x
    else:
        arr[x] = find(arr[x])
        return arr[x]


def union(a, b):
    a = find(a)
    b = find(b)
    if a < b:
        arr[b] = a
    else:
        arr[a] = b


for i in range(m):
    c, d = map(int, input().split())
    if find(c) == find(d):
        print(i + 1)
        exit()
    union(c, d)
print(0)
