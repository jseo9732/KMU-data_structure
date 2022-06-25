num = int(input())

for _ in range(num):
    case = input()
    left = []
    right = []
    for i in case:
        if i == '-':
            if len(left) != 0:
                left.pop()
                # print(left, right)
        elif i == '<':
            if len(left) != 0:
                tmp = left.pop()
                right.append(tmp)
                # print(left, right)
        elif i == '>':
            if len(right) != 0:
                tmp = right.pop()
                left.append(tmp)
                # print(left, right)
        else:
            left.append(i)
            # print(left, right)

    left.extend(reversed(right))
    print(''.join(left))
