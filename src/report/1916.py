import sys
from heapq import heappush, heappop

input = sys.stdin.readline
INF = sys.maxsize


def dijkstra(start):
    distance[start] = 0
    heappush(heap, [0, start])
    while heap:
        w, now = heappop(heap)
        if distance[now] < w:
            continue

        for dest, wei in graph[now]:
            n_cost = wei + w
            if n_cost < distance[dest]:
                distance[dest] = n_cost
                heappush(heap, [n_cost, dest])


N = int(input())
M = int(input())
graph = [[] for _ in range(N + 1)]
distance = [INF] * (N + 1)
heap = []

for _ in range(M):
    start_num, end_num, cost = map(int, input().split())
    graph[start_num].append([end_num, cost])

start_city, end_city = map(int, input().split())

dijkstra(start_city)
print(distance[end_city])
