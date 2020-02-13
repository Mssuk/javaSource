# li = []
# s = 0
# for i in range(4):
#     m,p = map(int, input().split())
#     s = s-m+p
#     li.append(s)

# print(max(li))

a, b = map(int, input().strip().split(' '))
for i in range(b):
    for j in range(a):
        print("*", end='')
    if(i!=b-1):
        print()
