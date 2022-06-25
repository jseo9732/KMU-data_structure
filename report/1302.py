N = int(input())
seller = {}

for _ in range(N):
    book = input()
    if book not in seller:
        seller[book] = 1
    else:
        seller[book] += 1

best_seller = []
max_value = max(seller.values())

for i, v in seller.items():
    if v == max_value:
        best_seller.append(i)

# print(best_seller)
s_seller = sorted(best_seller)
print(s_seller[0])
