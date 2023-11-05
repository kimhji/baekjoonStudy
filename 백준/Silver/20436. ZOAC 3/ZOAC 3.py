
keyboard = [['q','w','e','r','t','y','u','i','o','p']]
keyboard.append(['a','s','d','f','g','h','j','k','l'])
keyboard.append(['z','x','c','v','b','n','m'])


Input = (input().split())
left = Input[0]
right = Input[1]

Input = input()
sum = 0
lLoc = [0,0]
rLoc = [0,0]
for j in range(0, 3, 1):
    for k in range(0, len(keyboard[j]), 1):
        if left == keyboard[j][k]:
            lLoc = [k, j]
        if right == keyboard[j][k]:
            rLoc = [k, j]

for i in Input:
    for j in range(0,3,1):
        for k in range (0,len(keyboard[j]),1):
            if i == keyboard[j][k]:
                if j == 0 and k < 5 or j == 1 and k < 5 or j == 2 and k < 4 :
                    sum += abs(lLoc[0] - k)
                    sum += abs(lLoc[1] - j)
                    sum += 1
                    left = i
                    lLoc = [k, j]
                else:
                    sum += abs(rLoc[0] - k)
                    sum += abs(rLoc[1] - j)
                    sum += 1
                    right = i
                    rLoc = [k, j]
print(sum)