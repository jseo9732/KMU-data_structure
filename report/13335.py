n, W, L = map(int, input().split())
waiting_trucks = list(map(int, input().split()))
bridge = [0] * W
time = 0

while bridge:
    bridge.pop(0)
    if waiting_trucks:
        if sum(bridge) + waiting_trucks[0] <= L:
            tmp = waiting_trucks.pop(0)
            bridge.append(tmp)
            time += 1
            # print(bridge, time, waiting_trucks)
        else:
            bridge.append(0)
            time += 1
            # print(bridge, time, waiting_trucks)
print(time + W)
