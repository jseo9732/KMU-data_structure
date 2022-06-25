N = int(input())
tree = {}

for _ in range(N):
    root, l, r = input().split()
    tree[root] = [l, r]


def preorder(root):
    if root == '.':
        return
    else:
        print(root, end='')
        preorder(tree[root][0])
        preorder(tree[root][1])


def inorder(root):
    if root == '.':
        return
    else:
        inorder(tree[root][0])
        print(root, end='')
        inorder(tree[root][1])


def postorder(root):
    if root == '.':
        return
    else:
        postorder(tree[root][0])
        postorder(tree[root][1])
        print(root, end='')


preorder('A')
print()
inorder('A')
print()
postorder('A')
