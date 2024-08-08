/*
    *서브쿼리
    -하나의 SQL문 안에 포함된 또 다른 SELECT문
    -메인 SQL문을 위해 보조 역할을 하는 쿼리
*/

--노옹철 사원과 같은 부서에 속한 사원들 조회

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


