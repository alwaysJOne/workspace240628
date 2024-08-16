/*
    <PL/SQL>
    PROCEDURE LANGUAGE EXTGENSION TO SQL
    
    오라크 자체에 내장되어있는 절차적 언어
    SQL문장 내에서 변수의 정의, 조건(IF), 반복(FOR, WHILE)등을 지원하여 SQL단점을 보완
    다수의 SQL문을 한번에 실행가능
    
    *PL/SQL구조
    -[선언부] : DECLARE로 시작, 변수나 상수를 선언및 초기화하는 부분
    -실행부 : BEGIN으로 시작, SQL문 또는 제어문등의 로직을 기술하는 부분
    -[예외처리부] : EXCEPTION으로 시작, 예외발생시 해결하기위한 구문
*/

SET SERVEROUTPUT ON;

--HELLO ORACLE출력
BEGIN
    --SYSTEM.OUT.PRINT("HELLO ORACLE") 자바
    DBMS_OUTPUT.PUT_LINE('HELLO ORACLE');
END;
/


---------------------------------------------------

/*
    1. DECLARE 선언부
    변수 및 상수 선언하는 공간
    일반타입변수, 래퍼런스타입변수, ROW타입변수
    
    1_1) 일반타입 변수 선언및 초기화
        [표현식] 변수명 [CONSTANT] 자료형 [:= 값]
*/

DECLARE
    EID NUMBER;
    ENAME VARCHAR2(20);
    PI CONSTANT NUMBER := 3.14;
BEGIN
    EID := 800;
    ENAME := '최지원';
    
    DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('PI : ' || PI);
END;
/

DECLARE
    EID NUMBER;
    ENAME VARCHAR2(20);
    PI CONSTANT NUMBER := 3.14;
BEGIN
    EID := &번호;
    ENAME := '&이름';
    
    DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('PI : ' || PI);
END;
/

------------------------------------------------------------------------------
--1_2) 래퍼런스 타입 변수 선언및 초기화(어떤테비을의 어떤 컬럼의 데이터타입을 찾조해서 그 타입으로 지정)

DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
BEGIN
    --EID := 800;
    --ENAME := '최지원';
    --SAL := 1000000;
    
    --사번이 200번인 사원의 사번, 사원명, 급여 조회
    SELECT EMP_ID, EMP_NAME, SALARY
    INTO EID, ENAME, SAL
    FROM EMPLOYEE
    WHERE EMP_ID = &사번;
    
    DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('SAL : ' || SAL);
END;
/
-------------------------- 실습---------------------------------------
/*래퍼런스타입 변수로 EID, ENAME, JCODE, SAL, DTITLE을 선언하고
각 자료형 EMPLOYEE(EMP_ID, EMP_NAME, JOB_CODE, SALARY), DEPARTMENT(DEPT_TITLE)등을 참조하도록
사용자가 입력한 사번의 사원의 사번, 사원명, 직급코드, 급여, 부서명 조회후 각 변수에 담아 출력
*/

DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    JCODE EMPLOYEE.JOB_CODE%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
    DTITLE DEPARTMENT.DEPT_TITLE%TYPE;
BEGIN
    --사번이 200번인 사원의 사번, 사원명, 급여 조회
    SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY, DEPT_TITLE
    INTO EID, ENAME,JCODE, SAL, DTITLE
    FROM EMPLOYEE
    JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
    WHERE EMP_ID = &사번;
    
    DBMS_OUTPUT.PUT_LINE(EID || ', ' || ENAME || ', ' || JCODE || ', ' || SAL || ', ' || DTITLE);
END;
/

------------------------------------------------------------------------------------
--1_3) ROW타입 변수 선언
-- 테이블의 한 행에 대한 모든 컬럼값을 한번에 담을 수 있는 변수
-- [표현식] 변수명 테이블명%ROWTYPE

DECLARE
    E EMPLOYEE%ROWTYPE;
BEGIN
    SELECT *
    INTO E
    FROM EMPLOYEE
    WHERE EMP_ID = &사번;
    
    DBMS_OUTPUT.PUT_LINE('사원명 : ' || E.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || E.SALARY);
    DBMS_OUTPUT.PUT_LINE('보너스 : ' || E.BONUS);
END;
/

----------------------------------------------------------------------
--2. BEGIN 실행부
--<조건문>
-- 1) IF 조건식 THEN 실행내용 END IF; (IF문을 단독으로 사용할 때)

--입력받은 사번의 해당하는 사원의 사번, 이름, 급여, 보너스 출력
--단, 보너스를 받지 않은 사원은 보너스율 출력 전 '보너스를 지급받지 않는 사원입니다' 출력

DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
    BONUS EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY, NVL(BONUS, 0)
    INTO EID, ENAME, SAL, BONUS
    FROM EMPLOYEE
    WHERE EMP_ID = &사번;
    
    DBMS_OUTPUT.PUT_LINE('사번 : ' || EID);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || SAL);
    
    IF BONUS = 0
        THEN DBMS_OUTPUT.PUT_LINE('보너스를 지급받지 않는 사원입니다');
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('보너스 : ' || BONUS);
END;
/
    
-- 2) IF 조건식 THEN 실행내용 ELSE 실행내용 END IF; (IF-ELSE)
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
    BONUS EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY, NVL(BONUS, 0)
    INTO EID, ENAME, SAL, BONUS
    FROM EMPLOYEE
    WHERE EMP_ID = &사번;
    
    DBMS_OUTPUT.PUT_LINE('사번 : ' || EID);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || SAL);
    
    IF BONUS = 0
        THEN DBMS_OUTPUT.PUT_LINE('보너스를 지급받지 않는 사원입니다');
    ELSE 
        DBMS_OUTPUT.PUT_LINE('보너스 : ' || BONUS);
    END IF;
END;
/
    
-----------------------------------실습------------------------------------------
--DECLARE
-- 래퍼런스변수(EID, ENAME, DTITLE, NCODE)
--        참조(EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_CODE)
-- 일반타입변수(TEAM 문자열) - 국내팀, 해외팀 분리해서 저장
--BEGIN
-- 사용자가 입력한 사번의 사원정보를 가져와 사번, 이름, 부서명, 근무국가코드 조회 후 각 변수에 대입
-- NCODE값이 KO일 경우 -> TEAM --> 국내팀
--           KO가 아닐경우 -> TEAM -->해외팀 대입
-- 사번, 이름, 부서명, 소속(TEAM)을 출력

DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    DTITLE DEPARTMENT.DEPT_TITLE%TYPE;
    NCODE LOCATION.NATIONAL_CODE%TYPE;
    TEAM VARCHAR2(10);
BEGIN
    SELECT EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_CODE
    INTO EID, ENAME, DTITLE, NCODE
    FROM EMPLOYEE
    JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
    JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE)
    WHERE EMP_ID = &사번;
    
    IF NCODE = 'KO'
        THEN TEAM := '국내팀';
    ELSE
        TEAM := '해외팀';
    END IF;
    
    
    DBMS_OUTPUT.PUT_LINE('사번 : ' || EID);
    DBMS_OUTPUT.PUT_LINE('이름 : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('부서 : ' || DTITLE);
    DBMS_OUTPUT.PUT_LINE('소속 : ' || TEAM);
END;
/


--3) IF 조건식1 THEN 실행내용1 ELSIF 조건식2 THEN 실행내용2.... [ELSE 실행내용] END IF;

DECLARE
    SCORE NUMBER;
    GRADE VARCHAR2(1);
BEGIN
    SCORE := &점수;

    IF SCORE >= 90 
        THEN GRADE := 'A';
    ELSIF SCORE >= 80
        THEN GRADE := 'B';
    ELSIF SCORE >= 70
        THEN GRADE := 'C';
    ELSIF SCORE >= 60
        THEN GRADE := 'D';
    ELSE GRADE := 'F';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('당신의 점수는 ' || SCORE || '점이며, 학점은 ' || GRADE || '학점입니다.');
END;
/

--------------------------------------------------------------------------
-- <반복문>

/*
    1) BASIC LOOP문
    [표현식]
    LOOP
        반복적으로 실행할 구문
        *반복문을 빠져나갈 수 있는 구문
    END LOOP;
    
    *반복문을 빠져나갈 수 있는 구문
    1) IF 조건식 THEN EXIT; END IF;
    2) EXIT WHEN 조건식;
*/

DECLARE
    I NUMBER := 0;
BEGIN
    LOOP
        --IF I = 10 THEN EXIT; END IF;
        EXIT WHEN I = 10;
        DBMS_OUTPUT.PUT_LINE(I);
        
        I := I + 1;   
    END LOOP;
END;
/

-----------------------------------------------

/*
    2) FOR LOOP문
    [표현식]
    FOR 변수 IN [REVERSE] 초기값..최종값
    LOOP
        반복적으로 실행할 문장;
    END LOOP;
*/


BEGIN
    FOR I IN 1..5
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
    END LOOP;
END;    
/

BEGIN
    FOR I IN REVERSE 1..5
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
    END LOOP;
END;    
/

DROP TABLE TEST;

CREATE TABLE TEST(
    TNO NUMBER PRIMARY KEY,
    TDATE DATE
);

CREATE SEQUENCE SEQ_TNO;

BEGIN
    FOR I IN 1..100
    LOOP
        INSERT INTO TEST VALUES(SEQ_TNO.NEXTVAL, SYSDATE);
    END LOOP;
END;
/

SELECT * FROM TEST;

-------------------------------------------------------------------------------
/*
    WHILE LOOP문
    
    [표현식]
    WHILE 반복문이 수행될 조건
    LOOP
        반복수행할 작업
    END LOOP;
*/

DECLARE
    I NUMBER := 0;
BEGIN
    WHILE I < 10
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
        I := I + 1;
    END LOOP;
END;
/

----------------------------------------------------------------------
/*
    3. 예외처리부
    예외(EXCEPTION) : 실행중 발생하는 오류
    
    EXCEPTION
        WHEN 예외명1 THEN 처리구문1;
        WHEN 예외명2 THEN 처리구문2;
        ...

    *시스템 예외(오라클에서 미리 정의해둔 예외)
    -NO_DATE_FOUND: SELECT한 결과가 한행도 없을 때
    -TOO_MANY_ROWS : SELECT한 결과가 여러행일 경우
    -ZERO_DIVIDE: 0으로 나눌 때
    -DUP_VAL_ON_INDEX : UNIQUE제약조건 위배
    ...
*/
--사용자가 입력한 수로 나눗셈한 결과를 출력
DECLARE
    RESULT NUMBER;
BEGIN
    RESULT := 10/&숫자;
    DBMS_OUTPUT.PUT_LINE('결과 : ' || RESULT);
EXCEPTION
    --WHEN ZERO_DIVIDE THEN DBMS_OUTPUT.PUT_LINE('나누기 연산시 0으로 나눌 수 없습니다.');
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('나누기 연산시 0으로 나눌 수 없습니다.');
END;
/

ALTER TABLE EMPLOYEE ADD PRIMARY KEY(EMP_ID);


BEGIN
    UPDATE EMPLOYEE
    SET EMP_ID = '&변경할사번'
    WHERE EMP_NAME = '노옹철';
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN DBMS_OUTPUT.PUT_LINE('이미 존재하는 사원입니다.');
END;
/

























