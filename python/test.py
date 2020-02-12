li = []
s = 0
for i in range(4):
    m,p = map(int, input().split())
    s = s-m+p
    li.append(s)

print(max(li))