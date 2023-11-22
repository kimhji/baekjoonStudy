def solution(survey, choices):
    # RT, CF, JM, AN
    score = [[0, 0], [0, 0], [0, 0], [0, 0]]
    answer = ''
    for check in range(len(survey)):
        ans = 4 - choices[check]
        if ans >= 0:
            upscore = 0
        else:
            upscore = 1
            ans *= -1
        check_survey = survey[check][0]
        if check_survey == 'R':
            score[0][upscore] += ans
        elif check_survey == 'T':
            upscore -= 1
            score[0][upscore] += ans
        elif check_survey == 'C':
            score[1][upscore] += ans
        elif check_survey == 'F':
            upscore -= 1
            score[1][upscore] += ans
        elif check_survey == 'J':
            score[2][upscore] += ans
        elif check_survey == 'M':
            upscore -= 1
            score[2][upscore] += ans
        elif check_survey == 'A':
            score[3][upscore] += ans
        elif check_survey == 'N':
            upscore -= 1
            score[3][upscore] += ans
    if score[0][0] >= score[0][1]:
        answer = answer + 'R'
    else:
        answer = answer + 'T'
    if score[1][0] >= score[1][1]:
        answer = answer + 'C'
    else:
        answer = answer + 'F'
    if score[2][0] >= score[2][1]:
        answer = answer + 'J'
    else:
        answer = answer + 'M'
    if score[3][0] >= score[3][1]:
        answer = answer + 'A'
    else:
        answer = answer + 'N'
    return answer