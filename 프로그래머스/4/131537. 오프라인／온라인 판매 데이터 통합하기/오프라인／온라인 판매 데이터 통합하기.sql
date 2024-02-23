-- 코드를 입력하세요
SELECT DATE_FORMAT(ONS.SALES_DATE,'%Y-%m-%d') AS SALES_DATE, ONS.PRODUCT_ID, ONS.USER_ID, ONS.SALES_AMOUNT
FROM ONLINE_SALE ONS
WHERE YEAR(ONS.SALES_DATE) = 2022 AND MONTH(ONS.SALES_DATE) = 3

UNION ALL

SELECT DATE_FORMAT(OFFS.SALES_DATE,'%Y-%m-%d') AS SALES_DATE, OFFS.PRODUCT_ID, NULL AS USER_ID, OFFS.SALES_AMOUNT
FROM OFFLINE_SALE OFFS
WHERE YEAR(OFFS.SALES_DATE) = 2022 AND MONTH(OFFS.SALES_DATE) = 3
ORDER BY SALES_DATE ASC, PRODUCT_ID ASC, USER_ID ASC