-- 코드를 입력하세요
WITH CHECKOK AS(
    SELECT CAR_ID, MAX(if (START_DATE <= '2022-10-16' and END_DATE >= '2022-10-16', 1, 0)) AS cannot
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    GROUP BY CAR_ID
)

SELECT HIS.CAR_ID, if(CH.cannot, '대여중', '대여 가능') AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY HIS
JOIN CHECKOK CH
ON HIS.CAR_ID = CH.CAR_ID
GROUP BY HIS.CAR_ID
ORDER BY HIS.CAR_ID DESC