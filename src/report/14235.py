from queue import PriorityQueue
n = int(input())
gift = PriorityQueue(maxsize=n)

for _ in range(n):
    a = list(map(int, input().split()))
    if a[0] == 0:
        print("gift.get()")
        print(gift.get())
        if gift.get() == 0:
            print(-1)
        else:
            print(-1*gift.get())
    else:
        for i in range(1, a[0] + 1):
            gift.put(-1*a[i])
