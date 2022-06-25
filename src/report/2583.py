M, N, K = map(int, input().split())

nemo = [[0]*N for i in range(M)]
# print(nemo)

for _ in range(K):
    start_x, start_y, end_x, end_y = map(int, input().split())
    for i in range(start_y, end_y):
        for j in range(start_x, end_x):
            # print(i, j)
            nemo[i][j] = 1

direct = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def DFS(y, x, cnt):
    nemo[y][x] = 1
    for direct_y, direct_x in direct:
        ny, nx = y + direct_y, x + direct_x
        if (0 <= ny < M) and (0 <= nx < N) and (nemo[ny][nx] == 0):
            cnt = DFS(ny, nx, cnt+1)
    return cnt


answer = []
for i in range(M):
    for j in range(N):
        if nemo[i][j] == 0:
            answer.append(DFS(i, j, 1))

print(len(answer))
print(*sorted(answer))


M, N, K = map(int, input().split())
nemo = [([0] * N) for i in range(M)]
for _ in range(K):
    start_x, start_y, end_x, end_y = map(int, input().split())
    for i in range(start_y, end_y):
        for j in range(start_x, end_x):
            nemo[i][j] = 1
d = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def dfs(y, x, cnt):
    nemo[y][x] = 1
    for direct_y, direct_x in direct:
        ny, nx = y+direct_y, x+direct_x
        if (0 <= ny < M) and (0 <= nx < N) and nemo[ny][nx] == 0:
            cnt = dfs(ny, nx, cnt+1)
    return cnt


res = []
for i in range(M):
    for j in range(N):
        if nemo[i][j] == 0:
            res.append(dfs(i, j, 1))
print(len(res))
print(*sorted(res))
