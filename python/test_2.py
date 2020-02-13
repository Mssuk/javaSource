def solution(v):
        
        
    answer = []
    dic = {}
    dic2 = {}
    for i in range (0,len(a)):
        if(v[i][0] in dic):
            dic[v[i][0]]+=1
        else:
            dic[v[i][0]]=1
            
        if(v[i][1] in dic2):
            dic2[v[i][1]]+=1
        else:
            dic2[v[i][1]]=1
    
    for key, value in dic.items():
        if(value == 1):
            answer.append(key)
    
    for key, value in dic2.items():
        if(value == 1):
            answer.append(key)

    return answer

a = [[1, 4], [3, 4], [3, 10]]
print(solution(a))