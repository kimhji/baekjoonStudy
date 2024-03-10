import sys
vowels = {'a', 'e', 'o', 'u', 'i'}
while True:
    password = sys.stdin.readline().rstrip()
    if password == "end":
        break
    BeforeVowelWhat = ' '
    continueVowel = False
    existVowel = False
    inARowBool = False
    inARow = ['vowel', 0]
    for check in password:
        if BeforeVowelWhat == check:
            if not (check == 'e' and BeforeVowelWhat == 'e' or check == 'o' and BeforeVowelWhat == 'o'):
                continueVowel = True
                break
        if check in vowels:
            existVowel = True
            if inARow[0] == 'vowel':
                inARow[1] += 1
                if inARow[1] >= 3:
                    inARowBool = True
                    break
            else:
                inARow = ['vowel', 1]
        else:
            if inARow[0] == 'consonant':
                inARow[1] += 1
                if inARow[1] >= 3:
                    inARowBool = True
                    break
            else:
                inARow = ['consonant', 1]
        BeforeVowelWhat = check
    if inARowBool or not existVowel or continueVowel:
        print('<'+password+'>', "is not acceptable.")
    else:
        print('<'+password+'>', "is acceptable.")