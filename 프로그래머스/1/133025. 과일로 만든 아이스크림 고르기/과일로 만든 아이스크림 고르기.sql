-- 코드를 입력하세요
SELECT ORD.FLAVOR
FROM FIRST_HALF ORD
LEFT JOIN ICECREAM_INFO INFO
    ON ORD.FLAVOR = INFO.FLAVOR
WHERE TOTAL_ORDER > 3000 AND INGREDIENT_TYPE = 'fruit_based'