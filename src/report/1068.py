import sys
input = sys.stdin.readline
sys.setrecursionlimit(10 ** 6)


def DFS(r_node):
    tree[r_node] = -2
    for i in range(N):
        if r_node == tree[i]:
            DFS(i)


N = int(input())
tree = list(map(int, input().split()))
remove_node = int(input())
cnt = 0

DFS(remove_node)

for i in range(N):
    if tree[i] != -2:
        if i not in tree:
            cnt += 1

print(cnt)
