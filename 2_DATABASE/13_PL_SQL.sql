/*
    <PL/SQL>
    PROCEDURE LANGUAGE EXTGENSION TO SQL
    
    ����ũ ��ü�� ����Ǿ��ִ� ������ ���
    SQL���� ������ ������ ����, ����(IF), �ݺ�(FOR, WHILE)���� �����Ͽ� SQL������ ����
    �ټ��� SQL���� �ѹ��� ���డ��
    
    *PL/SQL����
    -[�����] : DECLARE�� ����, ������ ����� ����� �ʱ�ȭ�ϴ� �κ�
    -����� : BEGIN���� ����, SQL�� �Ǵ� ������� ������ ����ϴ� �κ�
    -[����ó����] : EXCEPTION���� ����, ���ܹ߻��� �ذ��ϱ����� ����
*/

SET SERVEROUTPUT ON;

--HELLO ORACLE���
BEGIN
    --SYSTEM.OUT.PRINT("HELLO ORACLE") �ڹ�
    DBMS_OUTPUT.PUT_LINE('HELLO ORACLE');
END;
/


---------------------------------------------------

/*
    1. DECLARE �����
    ���� �� ��� �����ϴ� ����
    �Ϲ�Ÿ�Ժ���, ���۷���Ÿ�Ժ���, ROWŸ�Ժ���
    
    1_1) �Ϲ�Ÿ�� ���� ����� �ʱ�ȭ
        [ǥ����] ������ [CONSTANT] �ڷ��� [:= ��]
*/

DECLARE
    EID NUMBER;
    ENAME VARCHAR2(20);
    PI CONSTANT NUMBER := 3.14;
BEGIN
    EID := 800;
    ENAME := '������';
    
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
    EID := &��ȣ;
    ENAME := '&�̸�';
    
    DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('PI : ' || PI);
END;
/

------------------------------------------------------------------------------
--1_2) ���۷��� Ÿ�� ���� ����� �ʱ�ȭ(��׺����� � �÷��� ������Ÿ���� ã���ؼ� �� Ÿ������ ����)

DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
BEGIN
    --EID := 800;
    --ENAME := '������';
    --SAL := 1000000;
    
    --����� 200���� ����� ���, �����, �޿� ��ȸ
    SELECT EMP_ID, EMP_NAME, SALARY
    INTO EID, ENAME, SAL
    FROM EMPLOYEE
    WHERE EMP_ID = &���;
    
    DBMS_OUTPUT.PUT_LINE('EID : ' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('SAL : ' || SAL);
END;
/
-------------------------- �ǽ�---------------------------------------
/*���۷���Ÿ�� ������ EID, ENAME, JCODE, SAL, DTITLE�� �����ϰ�
�� �ڷ��� EMPLOYEE(EMP_ID, EMP_NAME, JOB_CODE, SALARY), DEPARTMENT(DEPT_TITLE)���� �����ϵ���
����ڰ� �Է��� ����� ����� ���, �����, �����ڵ�, �޿�, �μ��� ��ȸ�� �� ������ ��� ���
*/

DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    JCODE EMPLOYEE.JOB_CODE%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
    DTITLE DEPARTMENT.DEPT_TITLE%TYPE;
BEGIN
    --����� 200���� ����� ���, �����, �޿� ��ȸ
    SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY, DEPT_TITLE
    INTO EID, ENAME,JCODE, SAL, DTITLE
    FROM EMPLOYEE
    JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
    WHERE EMP_ID = &���;
    
    DBMS_OUTPUT.PUT_LINE(EID || ', ' || ENAME || ', ' || JCODE || ', ' || SAL || ', ' || DTITLE);
END;
/

------------------------------------------------------------------------------------
--1_3) ROWŸ�� ���� ����
-- ���̺��� �� �࿡ ���� ��� �÷����� �ѹ��� ���� �� �ִ� ����
-- [ǥ����] ������ ���̺��%ROWTYPE

DECLARE
    E EMPLOYEE%ROWTYPE;
BEGIN
    SELECT *
    INTO E
    FROM EMPLOYEE
    WHERE EMP_ID = &���;
    
    DBMS_OUTPUT.PUT_LINE('����� : ' || E.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : ' || E.SALARY);
    DBMS_OUTPUT.PUT_LINE('���ʽ� : ' || E.BONUS);
END;
/

----------------------------------------------------------------------
--2. BEGIN �����
--<���ǹ�>
-- 1) IF ���ǽ� THEN ���೻�� END IF; (IF���� �ܵ����� ����� ��)

--�Է¹��� ����� �ش��ϴ� ����� ���, �̸�, �޿�, ���ʽ� ���
--��, ���ʽ��� ���� ���� ����� ���ʽ��� ��� �� '���ʽ��� ���޹��� �ʴ� ����Դϴ�' ���

DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
    BONUS EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY, NVL(BONUS, 0)
    INTO EID, ENAME, SAL, BONUS
    FROM EMPLOYEE
    WHERE EMP_ID = &���;
    
    DBMS_OUTPUT.PUT_LINE('��� : ' || EID);
    DBMS_OUTPUT.PUT_LINE('�̸� : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : ' || SAL);
    
    IF BONUS = 0
        THEN DBMS_OUTPUT.PUT_LINE('���ʽ��� ���޹��� �ʴ� ����Դϴ�');
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('���ʽ� : ' || BONUS);
END;
/
    
-- 2) IF ���ǽ� THEN ���೻�� ELSE ���೻�� END IF; (IF-ELSE)
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
    BONUS EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY, NVL(BONUS, 0)
    INTO EID, ENAME, SAL, BONUS
    FROM EMPLOYEE
    WHERE EMP_ID = &���;
    
    DBMS_OUTPUT.PUT_LINE('��� : ' || EID);
    DBMS_OUTPUT.PUT_LINE('�̸� : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('�޿� : ' || SAL);
    
    IF BONUS = 0
        THEN DBMS_OUTPUT.PUT_LINE('���ʽ��� ���޹��� �ʴ� ����Դϴ�');
    ELSE 
        DBMS_OUTPUT.PUT_LINE('���ʽ� : ' || BONUS);
    END IF;
END;
/
    
-----------------------------------�ǽ�------------------------------------------
--DECLARE
-- ���۷�������(EID, ENAME, DTITLE, NCODE)
--        ����(EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_CODE)
-- �Ϲ�Ÿ�Ժ���(TEAM ���ڿ�) - ������, �ؿ��� �и��ؼ� ����
--BEGIN
-- ����ڰ� �Է��� ����� ��������� ������ ���, �̸�, �μ���, �ٹ������ڵ� ��ȸ �� �� ������ ����
-- NCODE���� KO�� ��� -> TEAM --> ������
--           KO�� �ƴҰ�� -> TEAM -->�ؿ��� ����
-- ���, �̸�, �μ���, �Ҽ�(TEAM)�� ���

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
    WHERE EMP_ID = &���;
    
    IF NCODE = 'KO'
        THEN TEAM := '������';
    ELSE
        TEAM := '�ؿ���';
    END IF;
    
    
    DBMS_OUTPUT.PUT_LINE('��� : ' || EID);
    DBMS_OUTPUT.PUT_LINE('�̸� : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('�μ� : ' || DTITLE);
    DBMS_OUTPUT.PUT_LINE('�Ҽ� : ' || TEAM);
END;
/


--3) IF ���ǽ�1 THEN ���೻��1 ELSIF ���ǽ�2 THEN ���೻��2.... [ELSE ���೻��] END IF;

DECLARE
    SCORE NUMBER;
    GRADE VARCHAR2(1);
BEGIN
    SCORE := &����;

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
    
    DBMS_OUTPUT.PUT_LINE('����� ������ ' || SCORE || '���̸�, ������ ' || GRADE || '�����Դϴ�.');
END;
/

--------------------------------------------------------------------------
-- <�ݺ���>

/*
    1) BASIC LOOP��
    [ǥ����]
    LOOP
        �ݺ������� ������ ����
        *�ݺ����� �������� �� �ִ� ����
    END LOOP;
    
    *�ݺ����� �������� �� �ִ� ����
    1) IF ���ǽ� THEN EXIT; END IF;
    2) EXIT WHEN ���ǽ�;
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
    2) FOR LOOP��
    [ǥ����]
    FOR ���� IN [REVERSE] �ʱⰪ..������
    LOOP
        �ݺ������� ������ ����;
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
    WHILE LOOP��
    
    [ǥ����]
    WHILE �ݺ����� ����� ����
    LOOP
        �ݺ������� �۾�
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
    3. ����ó����
    ����(EXCEPTION) : ������ �߻��ϴ� ����
    
    EXCEPTION
        WHEN ���ܸ�1 THEN ó������1;
        WHEN ���ܸ�2 THEN ó������2;
        ...

    *�ý��� ����(����Ŭ���� �̸� �����ص� ����)
    -NO_DATE_FOUND: SELECT�� ����� ���൵ ���� ��
    -TOO_MANY_ROWS : SELECT�� ����� �������� ���
    -ZERO_DIVIDE: 0���� ���� ��
    -DUP_VAL_ON_INDEX : UNIQUE�������� ����
    ...
*/
--����ڰ� �Է��� ���� �������� ����� ���
DECLARE
    RESULT NUMBER;
BEGIN
    RESULT := 10/&����;
    DBMS_OUTPUT.PUT_LINE('��� : ' || RESULT);
EXCEPTION
    --WHEN ZERO_DIVIDE THEN DBMS_OUTPUT.PUT_LINE('������ ����� 0���� ���� �� �����ϴ�.');
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('������ ����� 0���� ���� �� �����ϴ�.');
END;
/

ALTER TABLE EMPLOYEE ADD PRIMARY KEY(EMP_ID);


BEGIN
    UPDATE EMPLOYEE
    SET EMP_ID = '&�����һ��'
    WHERE EMP_NAME = '���ö';
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN DBMS_OUTPUT.PUT_LINE('�̹� �����ϴ� ����Դϴ�.');
END;
/

























