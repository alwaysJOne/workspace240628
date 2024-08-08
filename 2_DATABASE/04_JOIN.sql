/*
    <JOIN>
    �ΰ� �̻��� ���̺��� �����͸� ��ȸ�ϰ��� �� �� ���Ǵ� ����
    ��ȸ ����� �ϳ��� ���(RESULT SET)�� ��ȯ�Ѵ�.

    ������ �����ͺ��̽������� �ּ����� �����͸� ������ ���̺� ��� ����
    (������ �� ��ȸ�� ���°� �ƴ϶� �� ���̺� �����(�ܷ�Ű)�� ���� �����͸� ��Ī���� ��ȸ�ؾ��Ѵ�)
    
    JOIN�� ũ�� "����Ŭ ���뱸��" "ANSI ����"
    
    [�������]
    
            ����Ŭ ���� ����           |           ANSI ����
    --------------------------------------------------------------------
                �����              |            ��������
              (EQUAL JOIN)           |   (INNER JOIN) -> JOIN USING/ON
    ---------------------------------------------------------------------
                ��������              |          �ܺ�����
              LEFT, RIGHT            |        LEFT, RIGHT, FULL
---------------------------------------------------------------------------
               ��ü����               |           JOIN ON
              ������ ����             |
*/  


--��ü ������� ���, �����, �μ��ڵ�, �μ���
SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE;

SELECT DEPT_ID, DEPT_TITLE
FROM DEPARTMENT;


/*
    1. �����(EQUAL JOIN) / ��������(INNER JOIN)
    �����Ű�� �÷��� ���� ��ġ�ϴ� ��鸸 ��ȸ(��ġ�ϴ� ���� ���� ���� ��ȸ ����)
*/

-----> ANSI����
--FROM���� �����̵Ǵ� ���̺� �ϳ� ���
--JOIN���� ���� �����ϰ����ϴ� ���̺� ��� + ��Ī��ų �÷������� ����
--JOIN USING / JOIN ON

--1. ������ �� �÷����� �ٸ� ���(EMPLOYEE : DEPT_CODE / DEPARMENT : DEPT_ID)
-- JOIN ON
--��ü ������� ���, �����, �μ��ڵ�, �μ���
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

--2. ������ �� �÷����� �����Ѱ��
--��ü ������� ���, �����, �����ڵ�, ���޸�
SELECT EMP_ID, EMP_NAME, E.JOB_CODE, JOB_NAME
FROM EMPLOYEE E
JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE);
--JOIN USING (�����ϴ� �÷����� ���� ��츸 ����)
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE);

-->����Ŭ ���뱸��
--FROM���� ��ȸ�ϰ����ϴ� ���̺�� ����(,�α���)
--WHERE���� ��Ī��ų �÷������� ������ ����
--1. ������ �� �÷����� �ٸ� ���(EMPLOYEE : DEPT_CODE / DEPARMENT : DEPT_ID)
--��ü ������� ���, �����, �μ��ڵ�, �μ���
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID;

--2. ������ �� �÷����� �����Ѱ��
--��ü ������� ���, �����, �����ڵ�, ���޸�
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE;

--�߰����� ��������
--������ �븮�� ����� ���, �����, ���޸�, �޿���ȸ
--����Ŭ
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE
  AND JOB_NAME = '�븮';

--ANSI
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '�븮';


--================================== �ǽ� ====================================
--1.�μ��� �λ�������� ������� ���, �̸�, ���ʽ� ��ȸ
SELECT EMP_ID, EMP_NAME, BONUS, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE DEPT_TITLE = '�λ������';

--2. DEPARTMENT�� LOCATION ���̺��� �����Ͽ� ��ü �μ���
-- �μ��ڵ�, �μ���, �����ڵ�, ������ ��ȸ
SELECT DEPT_ID, DEPT_TITLE, LOCATION_ID, LOCAL_NAME
FROM DEPARTMENT
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE);

--3. ���ʽ��� �޴� ������� ���, �����, ���ʽ�, �μ��� ��ȸ
SELECT EMP_ID, EMP_NAME, BONUS, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
WHERE BONUS IS NOT NULL;

--4. �μ��� �ѹ��ΰ� �ƴ� ������� �����, �޿� ��ȸ
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
WHERE DEPT_TITLE != '�ѹ���';

SELECT *
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE);

----------------------------------------------------------------------------
/*
    2. �������� / �ܺ�����(OUTER JOIN)
    �� ���̺��� JOIN�� ��ġ���� �ʴ� �൵ ���Խ��� ��ȸ ����
    ��, �ݵ�� LEFT/RIGHT�� �����ؾߵȴ�.(� ���̺��� �����̳�)

*/

--�ܺ����ΰ� ���Ҹ��� ��������
-- �����, �μ���, �޿�, ����
-- �μ���ġ�� �������� 2���� ������� ������

--1) LEFT [OUTER] JOIN : �� ���̺� �� ���� ����� ���̺��� �������� JOIN
--ANSI
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

--����Ŭ
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID(+);

--2) RIGHT [OUTER] JOIN : �� ���̺� �� ������ ����� ���̺���� �������� JOIN
--ANSI
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE
RIGHT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

--����Ŭ
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE(+) = DEPT_ID;

--FULL [OUTER] JOIN : �� ���̺��� ���� ��� ���� ��ȸ�� �� �ִ�.
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12
FROM EMPLOYEE
FULL JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

---------------------------------------------------------------------------------------
/*
    3.�����(NON EQUAL JOIN)
    ��Ī��ų �÷��� ���� ���� �ۼ��� '='�� ������� �ʴ� ���ι�
    ANSI�������� JOIN ON�� ��밡��
*/

--�����, �޿�, �޿����� ��ȸ
--ANSI
SELECT EMP_NAME, SALARY, SAL_LEVEL
FROM EMPLOYEE
JOIN SAL_GRADE ON (SALARY >= MIN_SAL AND SALARY <= MAX_SAL);

--����Ŭ
SELECT EMP_NAME, SALARY, SAL_LEVEL
FROM EMPLOYEE, SAL_GRADE
WHERE SALARY BETWEEN MIN_SAL AND MAX_SAL;


---------------------------------------------------------------------
/*
    4. ��ü����
    ���� ���̺��� �ٽ��ѹ� �����ϴ� ���
*/

-- ��ü����� ������, �����, ����μ��ڵ� -->  EMPLOYEE E
--           ������, �����, ����μ��ڵ� -->  EMPLOYEE M
-- ANSI
SELECT E.EMP_ID, E.EMP_NAME, E.DEPT_CODE,
        M.EMP_ID, M.EMP_NAME, M.DEPT_CODE
FROM EMPLOYEE E
LEFT JOIN EMPLOYEE M ON (E.MANAGER_ID = M.EMP_ID);

--����Ŭ
SELECT E.EMP_ID, E.EMP_NAME, E.DEPT_CODE,
        M.EMP_ID, M.EMP_NAME, M.DEPT_CODE
FROM EMPLOYEE E, EMPLOYEE M
WHERE E.MANAGER_ID = M.EMP_ID;

-----------------------------------------------------------------------
/*
    <��������>
    2�� �̻��� ���̺��� ������ JOIN�� �� �ִ�.
*/

--���, �����, �μ���, ���޸�
--ANSI
SELECT EMP_ID,EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE);
--����Ŭ
SELECT EMP_ID,EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE E, DEPARTMENT, JOB J
WHERE E.DEPT_CODE = DEPT_ID
AND E.JOB_CODE = J.JOB_CODE;


--���, �����, �μ���, ������ ��ȸ
SELECT * FROM EMPLOYEE; -- DEPT_CODE
SELECT * FROM DEPARTMENT;-- DEPT_ID     LOCATION_ID
SELECT * FROM LOCATION;              -- LOCAL_CODE

--ANSI
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE);

----------------�ǽ�---------------------
--1. ���, �����, �μ���, ������, ������ ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME, NATIONAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING(NATIONAL_CODE);

--2. ���, �����, �μ���, ���޸�, ������, ������, �޿���� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, LOCAL_NAME, NATIONAL_NAME, SAL_LEVEL
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING(NATIONAL_CODE)
JOIN SAL_GRADE ON (SALARY BETWEEN MIN_SAL AND MAX_SAL);















































