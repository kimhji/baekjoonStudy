-- 코드를 입력하세요
WITH MAXMEM AS
(SELECT REV.MEMBER_ID, COUNT(*) AS countREV
FROM REST_REVIEW REV
 GROUP BY REV.MEMBER_ID
 ORDER BY countREV DESC
 LIMIT 1
)

SELECT PRO.MEMBER_NAME, RR.REVIEW_TEXT, DATE_FORMAT(RR.REVIEW_DATE, "%Y-%m-%d") AS REVIEW_DATE
FROM REST_REVIEW RR
JOIN MAXMEM MM
ON RR.MEMBER_ID = MM.MEMBER_ID
JOIN MEMBER_PROFILE PRO
ON RR.MEMBER_ID = PRO.MEMBER_ID
ORDER BY RR.REVIEW_DATE ASC, RR.REVIEW_TEXT ASC