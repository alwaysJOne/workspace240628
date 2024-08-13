/*
    DQL(QUERY 데이터 정의어) : SELECT
    DML(MANIPULATION 데이터 조작어) : INSERT, UPDATE, DELETE
    DDL(DEFINITION 데이터 정의어) : CREATE, ALTER, DROP
    DCL(CONTROL 데이터 제어어): GRANT, REVOKE
    TCL(TRANSACTION 트랜잭션 제어어) : COMMIT, ROLLBACK

    <DML>
    데이터 조작 언어
    테이블 값을 삽입(INSERT), 수정(UPDATE), 삭제(DELETE)하는 구문
*/

/*
    1. INSERT
    테이블에 새로운 행을 추가하는 구문

    [표현식]
    1) INSERT INTO 테이블명 VALUES(값,값,값....)
    테이블의 모든 컬럼에 대한 값을 직접 제시해서 한 행을 INSERT하고자 할 때
    컬럼의 순번을 지켜서 VALUES에 값을 나열해야함
    
    부족하게 값을 제시할 경우, 값을 더 많이 제시한 경우 => 에러
*/
SELECT * FROM EMPLOYEE;

INSERT INTO EMPLOYEE
VALUES(900, '이소근', '880914-1456789', 'SG8809@NAVER.COM', '01078945656', 'D7',
        'J5', 4000000, 0.2, 200, SYSDATE, NULL, 'N');

/*
    2) INSERT INTO 테이블명(컬럼, 컬럼, 컬럼..) VALUES(값, 값, 값...)
    테이블에 내가 선택한 컬럼에 대한 값만 INSERT할 때 사용
    그래도 한 행 단위로 추가되기 때문에 선택안된 컬럼은 기본적으로 NULL이 들어감
    => NOT NULL제약조건이 걸려있는 컬럼은 반드시 직접 값을 넣어줘야한다.
    단, 기본값이 지정되어 있으면 NULL이 아닌 기본값이 들어감
*/

INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, JOB_CODE, HIRE_DATE)
VALUES(901, '최지원', '440701-1234567', 'J7', SYSDATE);

SELECT * FROM EMPLOYEE;

INSERT
INTO EMPLOYEE(
             EMP_ID,
             EMP_NAME,
             EMP_NO,
             JOB_CODE,
             HIRE_DATE
            )
    VALUES(
            902,
            '김개똥',
            '870105-224510',
            'J7',
            SYSDATE
            );
------------------------------------------------------------------

/*
    3) INSERT INTO 테이블명 (서브쿼리);
    VALUES에 직접 값을 명시하는 것 대신 서브쿼리로 조회된 값을 통째로 INSERT가능
*/

CREATE TABLE EMP_01(
    EMP_ID NUMBER,
    EMP_NAME VARCHAR2(20),
    DEPT_TITLE VARCHAR2(20)
);

SELECT * FROM EMP_01;

INSERT INTO EMP_01(SELECT EMP_ID, EMP_NAME, DEPT_TITLE
                     FROM EMPLOYEE
                     LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID));

----------------------------------------------------------------------------------
/*
    2. INSERT ALL
    두개 이상의 테이블에 각각 INSERT할 때
    이때 사용되는 서브쿼리가 동일한 경우
*/

CREATE TABLE EMP_DEPT
AS (SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
      FROM EMPLOYEE
     WHERE 1 = 0);
     
CREATE TABLE EMP_MANAGER
AS (SELECT EMP_ID, EMP_NAME, MANAGER_ID
      FROM EMPLOYEE
     WHERE 1 = 0);

--부서코드가 D1인 사원들의 사번, 이름, 부서코드, 입사일, 사수사번을 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE, MANAGER_ID
FROM EMPLOYEE
WHERE DEPT_CODE = 'D1';

/*
    [표현식]
    INSERT ALL
    INTO 테이블명1 VALUES(컬럼, 컬럼, 컬럼...)
    INTO 테이블명2 VLAUES(컬럼, 컬럼...)
    서브쿼리;
*/

INSERT ALL
    INTO EMP_DEPT VALUES(EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE)
    INTO EMP_MANAGER VALUES(EMP_ID, EMP_NAME, MANAGER_ID)
         (SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE, MANAGER_ID
            FROM EMPLOYEE
            WHERE DEPT_CODE = 'D1');
            
SELECT * FROM EMP_DEPT;
SELECT * FROM EMP_MANAGER;

-------------------------------------------------------------------------------

/*
    3. UPDATE
    테이블에 기록되어있는 기존의 데이터를 수정하는 구문
    
    [표현식]
    UPDATE 테이블명
    SET 컬럼 = '값'
        컬럼 = '값'
        ...
    [WHERE 조건] -> 생략시 전체 모든 행의 데이터가 변경
    
    *업데이트시에도 제약조건 잘 확인해야한다.
*/

CREATE TABLE DEPT_TABLE
AS (SELECT * FROM DEPARTMENT);

SELECT * FROM DEPT_TABLE;

--D9부서의 부서명을 '전략기획팀으로 변경'
UPDATE DEPT_TABLE
SET DEPT_TITLE = '전략기획팀'
WHERE DEPT_ID = 'D9';

CREATE TABLE EMP_SALARY
AS (SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY, BONUS
      FROM EMPLOYEE);

--EMP_SALARY테이블에서
--노옹철 사원의 급여를 100만원으로 변경
UPDATE EMP_SALARY
  SET SALARY = 1000000
WHERE EMP_NAME = '노옹철';

--선동일 사원의 급여를 700만원, 보너스를 0.2로 변경
UPDATE EMP_SALARY
   SET SALARY = 7000000,
       BONUS = 0.2
WHERE EMP_NAME = '선동일';

SELECT * FROM EMP_SALARY;

--전체사원의 급여를 기존 급여에 10프로 인상된 금액으로 변경해라
UPDATE EMP_SALARY
   SET SALARY = SALARY * 1.1;

/*
    UPDATE에서 서브쿼리사용
    
    UPDATE 테이블명
    SET 컬럼명 = (서브쿼리)
    WHERE 조건
*/

--방명수 사원의 급여와 보너스값을 유재식사원의 급여와 보너스값으로 변경
UPDATE EMP_SALARY
   SET SALARY = (SELECT SALARY
                   FROM EMP_SALARY
                   WHERE EMP_NAME = '유재식'),
       BONUS = (SELECT BONUS
                   FROM EMP_SALARY
                   WHERE EMP_NAME = '유재식')
WHERE EMP_NAME = '방명수';

SELECT * FROM EMP_SALARY
WHERE EMP_NAME = '방명수' OR EMP_NAME = '유재식';

--ASIA지역에서 근무하는 사원들의 보너스값을 0.3으로 변경

--ASIA지역에서 근무하는 사원들(EMP_ID, EMP_NAME)
SELECT EMP_ID, EMP_NAME
FROM EMP_SALARY
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
WHERE LOCAL_NAME LIKE 'ASIA%';

--위에서 구한 사원들의 보너스값을 0.3으로 변경
UPDATE EMP_SALARY
SET BONUS = 0.3
WHERE EMP_ID IN (SELECT EMP_ID
                   FROM EMP_SALARY
                   JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
                   JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
                   WHERE LOCAL_NAME LIKE 'ASIA%');
                   
COMMIT;

/*
    4. DELETE
    테이블에 기록된 데이터를 삭제하는 구문(한 행 단위로 삭제가 된다.)
    
    [표현식]
    DELETE FORM 테이블명
    [WHERE 조건] -> WHERE절 제시안하면 전체행 다 삭제됨
*/

DELETE FROM EMPLOYEE;

SELECT * FROM EMPLOYEE;
ROLLBACK;

DELETE FROM EMPLOYEE
WHERE EMP_NAME = '이소근';

DELETE FROM EMPLOYEE
WHERE EMP_ID = '901';

COMMIT;

DELETE FROM DEPARTMENT
WHERE DEPT_ID = 'D1';
