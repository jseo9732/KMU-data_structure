N = int(input())
num = list(map(int, input().split()))
answer = []

for i in range(N):
    answer.insert(i-num[i], i+1)

for j in answer:
    print(j, end=" ")
