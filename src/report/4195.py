import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline


def find(x):
    if x == parent[x]:
        return x

    else:
        parent[x] = find(parent[x])
        return parent[x]


def union(a, b):
    a = find(a)
    b = find(b)
    if a != b:
        parent[b] = a
        num[a] += num[b]


N = int(input())
for _ in range(N):
    parent = {}
    num = {}
    F = int(input())
    for _ in range(F):
        x, y = map(str, input().split())
        if x not in parent:
            parent[x] = x
            num[x] = 1
        if y not in parent:
            parent[y] = y
            num[y] = 1

        union(x, y)
        print(num[find(x)])
