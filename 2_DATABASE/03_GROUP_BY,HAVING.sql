/*
   <GROUP BY절>
   그룹기준을 제시할 수 있는 구문(해당 그룹기준별로 여러 그룹으로 묵을 수 있음)
   여러개의 값들을 하나의 그룹으로 묶어서 처리하는 목적으로 사용
*/

SELECT SUM(SALARY)
FROM EMPLOYEE; --전체사원을 하나의 그룹으로 묶어서 총 합을 구한 것

--각 부서별로 급여 총합
--각 부서들이 전부 그룹
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

--각 부서별 사원수
SELECT DEPT_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

SELECT DEPT_CODE, COUNT(*), SUM(SALARY) -- 3
FROM EMPLOYEE      -- 1
GROUP BY DEPT_CODE -- 2
ORDER BY DEPT_CODE; -- 4 ORDER BY 무조건 마지막실행 -> 정렬은 마지막 해주는 것이 아니면 의미 X


---각 직급별 총사원수, 보너스를 받는 사람수, 급여합, 평균급여, 최저급여, 최고급여 (정렬 = 직급 오름차순)
SELECT JOB_CODE AS "직급",
       COUNT(*) AS "사원수",
       COUNT(BONUS) AS "보너스 받는 사람",
       SUM(SALARY) AS "급여합",
       ROUND(AVG(SALARY)) AS "급여평균",
       MIN(SALARY) AS "최저급여",
       MAX(SALARY) AS "최고급여"
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE;

--GROUP BY절에 함수식 사용 가능
SELECT DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '2', '여'), COUNT(*)
FROM EMPLOYEE
GROUP BY SUBSTR(EMP_NO, 8, 1);

--GROUP BY절에 여러컬럼을 기술할 수 있다.
SELECT DEPT_CODE, JOB_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE;














