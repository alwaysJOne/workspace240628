/*
    <DCL : ������ ���>
    
    �������� �ý��� ���� �Ǵ� ��ü���� ������ �ο��ϰų� ȸ���ϴ� ����
    
    >�ý��۱��� : DB�� �����ϴ� ����, ��ü�� ������ �� �ִ� ����
    >��ü���ٱ���: Ư�� ��ü���� ������ �� �ִ� ����
    
    CREATE USER ������ IDENTIFIED BY ��й�ȣ;
    GRANT ����(RESOURCE, CONNECT) TO ����;
*/
SELECT *
FROM ROLE_SYS_PRIVS;

/*
    <TCL : Ʈ����� ���>
    
    *Ʈ�����
    -�����ͺ��̽��� ���� �������
    -�������� �������(DML)���� �ϳ��� Ʈ����ǿ� ��� ó��
     DML�� �Ѱ��� ������ �� Ʈ������� �������� �ʴ´ٸ� Ʈ������� ���� ����
                          Ʈ������� �����Ѵٸ� �ش� Ʈ����ǿ� ��� ó��
    COMMIT�ϱ� �������� ������׵��� �ϳ��� Ʈ����ǿ� ��´�.
    - Ʈ����ǿ� ����� �Ǵ� SQL : INSERT, UPDATE, DELETE
    
    COMMIT(Ʈ����� ���� ó�� �� Ȯ��)
    ROLLBACK(Ʈ����� ���)
    SAVEPOINT(�ӽ�����)
    
    -COMMIT : �� Ʈ����ǿ� ����ִ� ������׵��� ���� DB�� �ݿ���Ű�ڴٴ� �ǹ�
    -ROLLBACK : �� Ʈ����ǿ� ����ִ� ������׵��� ����(���) �� �� ������ COMMIT�������� ���ư�
    -SAVEPOINT ����Ʈ�� : ���� ������ �ش� ����Ʈ������ �ӽ������� �صδ� ��
*/

DROP TABLE EMP_01;

CREATE TABLE EMP_01
AS (SELECT EMP_ID, EMP_NAME, DEPT_TITLE
    FROM EMPLOYEE
    JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID));

SELECT * FROM EMP_01;

--����� 200, 201���� ��� ����
DELETE FROM EMP_01
WHERE EMP_ID = 200;

DELETE FROM EMP_01
WHERE EMP_ID = 201;
    
ROLLBACK;

SELECT * FROM EMP_01;

----------------------------------------------------------------
--����� 200, 201���� ��� ����
DELETE FROM EMP_01
WHERE EMP_ID = 200;
DELETE FROM EMP_01
WHERE EMP_ID = 201;

COMMIT;
ROLLBACK;
SELECT * FROM EMP_01;


-------------------------------------------------------

--217, 216, 214��� ����
DELETE FROM EMP_01
WHERE EMP_ID IN (217, 216, 214);

SELECT * FROM EMP_01;

SAVEPOINT SP;

INSERT INTO EMP_01
VALUES(801, '�踻��', '���������');

DELETE FROM EMP_01
WHERE EMP_ID = 210;

SELECT * FROM EMP_01;

ROLLBACK TO SP;
COMMIT;

------------------------------------------------
DELETE FROM EMP_01
WHERE EMP_ID = 210;

--DDL�� ����
CREATE TABLE TEST(
    TID NUMBER
);

ROLLBACK;

SELECT * FROM EMP_01;

--DDL��(CREATE, ALTER, DROP)�� �����ϴ� ���� ���� Ʈ����ǿ� �ִ� ������׵��� 
--������ COMMIT�� �ȴ�(���� DB�ݿ��� �ȴ�.)
--��, DDL�� ������ ������׵��� �ִٸ� ��Ȯ�ϰ� �Ƚ��ϰ� �ض�!