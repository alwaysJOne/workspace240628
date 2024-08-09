/*
    *서브쿼리
    -하나의 SQL문 안에 포함된 또 다른 SELECT문
    -메인 SQL문을 위해 보조 역할을 하는 쿼리
*/

--서브쿼리 예시1) 노옹철 사원과 같은 부서에 속한 사원들 조회

SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

--노옹철사원은 어떤부서일까?
SELECT DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '노옹철';

--위에 두 쿼리를 하나의 쿼리로 변경하자
SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '노옹철');

--서브쿼리 예시2)
--전 직원의 평균급여보다 더 많은 급여를 받는 사원들의 사번, 이름, 직급코드, 급여 조회
--1) 전직원의 평균급여
SELECT ROUND(AVG(SALARY))
FROM EMPLOYEE;

--2) 3047663원보다 급여가 많은 사람들의 사번, 이름, 직급코드, 급여 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3047663;

--두 쿼리를 하나로 합해보자.
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= (SELECT ROUND(AVG(SALARY))
                   FROM EMPLOYEE);

/*
    *서브쿼리의 구분
    서브쿼리를 수행한 결과값이 몇행 몇열로 나오느냐에 따라서 분류

    --단일행 서브쿼리 : 서브쿼리의 조회 결과값이 오로지 1개일 때
    --다중행 서브쿼리 : 서브쿼리의 조회 결과값이 여러행일 때(여러행 한열)
    --다중열 서브쿼리 : 서브쿼리의 조회 결과값이 한행이지만 컬럼이 여러개일 때
    --다중행 다중열 서브쿼리 : 서브쿼리의 조회 결과값이 여러행 여러컬럼일 때
    
    >> 서브쿼리의 결과값에 따라서 서브쿼리 앞쪽에 연산자가 달라진다.
*/

/*
    1. 단일행 서브쿼리
    서브쿼리의 조회 결과값이 오로지 1개일 때(한행 한열)
    일반 비교연산자 사용 가능
    = != > <= ...
*/

--1) 전 직원의 평균 급여보다 급여를 더 적게받는 사원들의 사원명, 직급코드, 급여 조회
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY < (SELECT AVG(SALARY)
                  FROM EMPLOYEE);

--2) 최저급여를 받는 사원의 사번, 이름, 급여, 입사일 조회
SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY = (SELECT MIN(SALARY)
                  FROM EMPLOYEE);

--3) 노옹철 사원의 급여보다 많이받는 사원들의 사번, 이름, 부서코드, 급여조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > (SELECT SALARY
                  FROM EMPLOYEE
                 WHERE EMP_NAME = '노옹철');

--4)노옹철 사원의 급여보다 많이받는 사원들의 사번, 이름, 부서명, 급여조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE SALARY > (SELECT SALARY
                  FROM EMPLOYEE
                 WHERE EMP_NAME = '노옹철');

--5) 부서별 급여합이 가장 큰 부서의 부서코드, 급여합
    --1) 부서별 급여합 가장 큰 부서
    SELECT MAX(SUM(SALARY))
      FROM EMPLOYEE
    GROUP BY DEPT_CODE;
    --2) 급여합이 17700000원인 부서코드, 급여합
    SELECT DEPT_CODE, SUM(SALARY)
    FROM EMPLOYEE
    GROUP BY DEPT_CODE
    HAVING SUM(SALARY) = 17700000;
    
-- 두 쿼리를 하나로 합해보자
    SELECT DEPT_CODE, SUM(SALARY)
    FROM EMPLOYEE
    GROUP BY DEPT_CODE
    HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY))
                          FROM EMPLOYEE
                          GROUP BY DEPT_CODE);


--6) '전지연'사원과 같은 부서의 사람들의 사번, 사원명, 전화번호, 입사일, 부서명 조회
--단, 전지연사원 제외
SELECT EMP_ID, EMP_NAME, PHONE, HIRE_DATE, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE DEPT_CODE = (SELECT DEPT_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '전지연')
 AND EMP_NAME != '전지연';

------------------------------------------------------------------------------
/*
    2. 다중행 서브쿼리
    서브쿼리를 수행한 결과값이 여러행일 때(컬럼은 한개)
    IN (서브쿼리) : 여러개의 결과값 중에서 한개라도 일치하는 값이 있다면 조회
    > ANY (서브쿼리) : 여러개의 결과값 중에서 한개라도 클경우 조회
    < ANY (서브쿼리) : 여러개의 결과값 중에서 한개라도 작을경우 조회
        비교대상 > ANY (서브쿼리의 결과값 -> 값1, 값2, 값3...)
        
    > ALL(서브쿼리) : 여러개의 모든 결과값들 보다 클 경우 조회
    < ALL(서브쿼리) : 여러개의 모든 결과값들 보다 작을 경우 조회
*/



--1) 유재식 또는 윤은해사원과 같은 직급인 사원들의 사번, 사원명, 직급코드, 급여조회
--1_1)유재식 또는 윤은해사원의 직급
SELECT JOB_CODE
FROM EMPLOYEE
WHERE EMP_NAME IN ('유재식', '윤은해');

--1_2)직급이 J3, J7인 사원들의  사번, 사원명, 직급코드, 급여조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE IN ('J3', 'J7');

--두 쿼리를 하나로 합해보자
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE IN (SELECT JOB_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME IN ('유재식', '윤은해'));

--2) 대리집급임에도 과장 직급 급여들 중 최소 급여보다 많이받는 사원들의 사번, 이름, 직급, 급여 조회
--2_1)  과장 직급 급여들
SELECT SALARY
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '과장';

--2_2) 대리직급이면서 위의 결과값보다 하나라도 큰 사원
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리'
  AND SALARY > ANY(3760000, 2200000, 2500000);
  
--두쿼리를 하나로 합해보자
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리'
  AND SALARY > ANY(SELECT SALARY
                    FROM EMPLOYEE
                    JOIN JOB USING(JOB_CODE)
                    WHERE JOB_NAME = '과장');

---------------------------------------------------------------
/*
    3. 다중열 서브쿼리
    결과값은 한 행이지만 나열된 컬럼수가 여러개일 경우
*/

--1) 하이유 사원과 같은 부서코드, 같은 직급코드에 해당하는 사원들 조회
--(사원명, 부서코드, 직급코드, 입사일)
--> 단일행 서브쿼리
SELECT EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '하이유')
  AND JOB_CODE = (SELECT JOB_CODE
                    FROM EMPLOYEE
                   WHERE EMP_NAME = '하이유');

--다중열 서브쿼리
SELECT EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) = (SELECT DEPT_CODE, JOB_CODE
                                FROM EMPLOYEE
                                WHERE EMP_NAME = '하이유');

--박나라 사원과 같은 직급코드, 같은 사수를 가지고있는 사원들의 사번, 사원명, 직급코드, 사수번호
SELECT EMP_ID, EMP_NAME, JOB_CODE, MANAGER_ID
FROM EMPLOYEE
WHERE (JOB_CODE, MANAGER_ID) = (SELECT JOB_CODE, MANAGER_ID
                                  FROM EMPLOYEE
                                  WHERE EMP_NAME = '박나라')
 AND EMP_NAME != '박나라';


---------------------------------------------------
/*
    4.  다중행 다중열 서브쿼리
    서브쿼리의 조회 결과값이 여러행 여러열일 경우
*/

--1)각 직급별 최소급여를 받는 사원조회(사번, 사원명, 직급코드, 급여)
--> 각 직급별 최소급여
SELECT JOB_CODE, MIN(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE;

--> 각 직급별 최소급여를 받는 사원조회(사번, 사원명, 직급코드, 급여)
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE = 'J2' AND SALARY = 3700000
   OR JOB_CODE = 'J7' AND SALARY = 1380000
   OR JOB_CODE = 'J3' AND SALARY = 3400000
   OR JOB_CODE = 'J6' AND SALARY = 2000000
   OR JOB_CODE = 'J5' AND SALARY = 2200000
   OR JOB_CODE = 'J1' AND SALARY = 8000000
   OR JOB_CODE = 'J4' AND SALARY = 1550000;

--서브쿼리이용
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (SELECT JOB_CODE, MIN(SALARY)
                             FROM EMPLOYEE
                             GROUP BY JOB_CODE);
                             
--각 부서별 최고급여를 받는 사원들의 사번, 사원명, 부서코드, 급여
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE (DEPT_CODE, SALARY) IN (SELECT DEPT_CODE, MAX(SALARY)
                                FROM EMPLOYEE
                            GROUP BY DEPT_CODE);

--=========================================================
--1. 부서 별 급여 합계가 전체 급여 총 합의 20%보다 많은 부서의 부서 명, 부서 별 급여 합계 조회
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) > (SELECT SUM(SALARY) * 0.2
                        FROM EMPLOYEE);


--2. 나이 상 가장 막내의 사원 코드, 사원 명, 나이, 부서 명, 직급 명 조회
SELECT EMP_ID, EMP_NAME,
        EXTRACT(YEAR FROM SYSDATE) -
        CASE
            WHEN SUBSTR(EMP_NO, 1, 2) <= TO_CHAR(SYSDATE, 'YY') THEN
                2000 + TO_NUMBER(SUBSTR(EMP_NO, 1, 2))
            ELSE
                1900 + TO_NUMBER(SUBSTR(EMP_NO, 1, 2))
        END + 1 AS "나이",
        DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
WHERE EXTRACT(YEAR FROM SYSDATE) -
        CASE
            WHEN SUBSTR(EMP_NO, 1, 2) <= TO_CHAR(SYSDATE, 'YY') THEN
                2000 + TO_NUMBER(SUBSTR(EMP_NO, 1, 2))
            ELSE
                1900 + TO_NUMBER(SUBSTR(EMP_NO, 1, 2))
        END = (SELECT MIN(EXTRACT(YEAR FROM SYSDATE) -
                            CASE
                                WHEN SUBSTR(EMP_NO, 1, 2) <= TO_CHAR(SYSDATE, 'YY') THEN
                                    2000 + TO_NUMBER(SUBSTR(EMP_NO, 1, 2))
                                ELSE
                                    1900 + TO_NUMBER(SUBSTR(EMP_NO, 1, 2))
                            END)
                FROM EMPLOYEE);





