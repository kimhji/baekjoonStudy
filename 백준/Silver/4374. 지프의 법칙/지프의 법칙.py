low_li = [ chr(i) for i in range(97,123)] #소문자가 들어간 리스트
up_li = [] #대문자를 담을 리스트
for i in low_li:
    up_li.append(i.upper())
for i in up_li: #low li에 대문자도 추가해서 대,소문자가 모두 들어간 list로 만든다.
    low_li.append(i)

while True:
    try:
        N = int(input())
        li= dict()
        new_word= [] #단어를 구분지어서 넣을 리스트 
        while True:
            word = list(map(str,input().split()))
            if len(word)==1 and word[0] == "EndOfText": #EndOfText가 입력되면
                new_word.sort()
                check = 0
                li = sorted(li.items(), key= lambda x:(x[0])) #dictionary를 문자열 오름차순 정렬
                li = dict(li)
                for key,values in li.items():
                    if values == N: #N번 나온 단어를 찾으면
                        print(key) #출력하고
                        check += 1 #There is no such word가 출력되지 않게한다.
                if check == 0: #출력된 단어가 없으면 실행됨
                    print("There is no such word.")
                break

            for i in word: # 띄어쓰기로 분리된 단어를 돌면서
                alp = ""
                for j in i: # 단어의 글자가 low_li에 들어가있으면
                    if j in low_li:
                        alp += j.lower() #소문자로 바꿔서 새로운 단어를 만든다.
                    elif j not in low_li: 
                        if len(alp) != 0: 
                            new_word.append(alp) # 만약 알파벳이 아닌 다른 문자가나오면 지금까지 저장된 alp를 new_word에 추가한다.
                            if alp not in li.keys():
                                li[alp] = 1
                            else:
                                li[alp] += 1
                            alp = ""

                if len(alp) != 0: #다음 띄어쓰기가 나올때까지 특수문자, 숫자등이 나오지 않았다면 
                    new_word.append(alp) #그 단어는 그대로 append하면 된다.
                    if alp not in li.keys():
                        li[alp] = 1
                    else:
                        li[alp] += 1
        print()
    except:
        break        