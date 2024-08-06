SELECT EMP_ID, EMP_NAME, SALARY -- 3
FROM EMPLOYEE                   -- 1
WHERE DEPT_CODE IS NULL;        -- 2
-- NULL�� ���� ���� IS NULL �Ǵ� IS NOT NULL�� �ؾ��Ѵ�.

/*
    <ORDER BY��>
    SELECT�� ���� ������ �ٿ� �ۼ�, ����������� ���� �������� �����Ѵ�.
    
    [ǥ����]
    SELECT ��ȸ�� �÷�...
    FROM ��ȸ�� ���̺�
    WHERE ���ǽ�
    ORDER BY ���ı��ص� �÷� | ��Ī | �÷����� [ASC | DESC] [NULLS FIRST | NULLS LAST]
    
    -ASC : ��������(���� ������ �����ؼ� ���� ���� Ŀ���� ��) -> �⺻��
    -DESC : ��������(ū������ �����ؼ� ���� ���� �پ��� ��)

    --NULL�� �⺻������ ���� ū������ �з��ؼ� �����Ѵ�.
    - NULLS FIRST : �����ϰ����ϴ� �÷����� NULL�� ���� ��� �ش絥���� �� �տ� ��ġ(DESC�϶� �⺻��)
    - NULLS LAST : �����ϰ����ϴ� �÷����� NULL�� ���� ��� �ش絥���� �� �������� ��ġ(ASC�϶� �⺻��)
*/

SELECT *
FROM EMPLOYEE
--ORDER BY BONUS; -- �⺻���� ��������
--ORDER BY BONUS ASC;
--ORDER BY BONUS ASC NULLS FIRST;
--ORDER BY BONUS DESC; -- NULLS FIRST �⺻��
ORDER BY BONUS DESC, SALARY ASC;
--���ı��ؿ� �÷����� ������ ��� �״��������� ���ؼ� �������� ������ �� �ִ�.

--�� ����� �����, ����(���ʽ�����) ��ȸ(�� �� ������ �������� ����)
SELECT EMP_NAME, SALARY * 12 AS "����"
FROM EMPLOYEE
--ORDER BY SALARY * 12 DESC;
--ORDER BY ���� DESC;
ORDER BY 2 DESC; -- ������밡�� ����Ŭ�� ���� 1���� ����

--========================================================================================
/*
    <�Լ� FUNCTION>
    ���޵� �÷����� �޾Ƽ� �Լ��� ������ ����� ��ȯ
    
    -������ �Լ� : N���� ���� �о�鿩�� N���� ������� ����(���ึ�� �Լ����� ����� ��ȯ)
    -�׷��Լ� : N���� ���� �о�鿩�� 1���� ������� ����(�׷��� ��� �׷캰�� �Լ����� ����� ��ȯ)
    
     >> SELECT ���� �������Լ��� �׷��Լ��� �Բ� ������� ����
     -> ��� ���� ������ �ٸ��� ����
     
     >> �Լ��� ����� �� �ִ� ��ġ : SELECT�� WHERE�� ORDER BY�� HAVING��
*/

--=========================<������ �Լ�>====================================

/*
    <����ó���Լ�>

    *LENGTH(�÷� | '���ڿ�') : �ش� ���ڿ��� ���ڼ��� ��ȯ
    *LENGTHB(�÷� | '���ڿ�') : �ش� ���ڿ��� ����Ʈ ���� ��ȯ
    
    '��' '��' '��' �ѱ��� ���ڴ� 3BYTE
    ������, ����, Ư������ ���ڴ� 1BYTE
*/

SELECT LENGTH('����Ŭ'), LENGTHB('����Ŭ')
FROM DUAL;

SELECT LENGTH('ORACLE'), LENGTHB('ORACLE')
FROM DUAL;

SELECT EMP_NAME, LENGTH(EMP_NAME), LENGTHB(EMP_NAME)
FROM EMPLOYEE;

--=============================================================

/*
    *INSTR
    ���ڿ��κ��� Ư�� ������ ������ġ�� ã�Ƽ� ��ȯ
    
    INSTR(�÷� | '���ڿ�', 'ã�����ϴ� ����', ['ã�� ��ġ�� ���۰�, ����']) -> ����� NUMBER
*/
SELECT INSTR('AABAACAABBAA', 'B') FROM DUAL; --���ʿ� �ִ� ù B�� 3��° ��ġ�� �ִ�.
--ã�� ��ġ ���۰� : 1, ���� 1 => �⺻��
SELECT INSTR('AABAACAABBAA', 'B', 1) FROM DUAL;
SELECT INSTR('AABAACAABBAA', 'B', -1) FROM DUAL; -- �ڿ������� ã�� ��ġ�� ���� ���� �տ������� �о��ش�.
SELECT INSTR('AABAACAABBAA', 'B', 1, 2) FROM DUAL; -- ������ �����Ϸ��� ��ġ�� ���۰��� ǥ���ؾ��Ѵ�.
SELECT INSTR('AABAACAABBAA', 'B', 1, 3) FROM DUAL;

SELECT EMAIL, INSTR(EMAIL, '_',1,1), INSTR(EMAIL, '@')
FROM EMPLOYEE;

------------------------------------------------------------------------

/*
    *SUBSTR
    ���ڿ����� Ư�� ���ڿ��� �����ؼ� ��ȯ
    
    [ǥ����]
    SUBSTR(STRING, POSITION, [LENGTH])
    - STRING : ����Ÿ�� �÷� | '���ڿ�'
    - POSITION : ���ڿ� ������ ������ġ ��
    - LENTH : ������ ���� ����(�����ϸ� ������)
*/

SELECT SUBSTR('SHOWMETHEMONEY', 7) FROM DUAL; -- 7��° ��ġ���� ������ ����
SELECT SUBSTR('SHOWMETHEMONEY', 5, 2) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY', 1, 6) FROM DUAL;--SHOWME
SELECT SUBSTR('SHOWMETHEMONEY', -8, 3) FROM DUAL;

SELECT EMP_NAME, EMP_NO, SUBSTR(EMP_NO, 8, 1) AS "����"
FROM EMPLOYEE;

--������� ������鸸 EMP_NAME, EMP_NO ��ȸ
SELECT EMP_NAME, EMP_NO
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = '2' OR SUBSTR(EMP_NO, 8, 1) = '4'
ORDER BY EMP_NAME;

--�Լ� ��ø��� ����
--�̸����� ���̵�κ� ����
--�����Ͽ��� �����, �̸���, ���̵� ��ȸ
SELECT EMP_NAME, EMAIL, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@') - 1)
FROM EMPLOYEE;

----------------------------------------------------------------------
/*
    *LPAD / RPAD
    ���ڿ��� ��ȸ�� �� ���ϰ��ְ� ��ȸ�ϰ��� �� �� ���
    
    [ǥ����]
    LPAD/RPAD(STRING, ���������� ��ȯ�� ���ڿ��� ����, [�����̰����ϴ� ����])
    
    ���ڿ��� �����̰����ϴ� ���ڸ� ���� �Ǵ� �����ʿ� �ٿ��� ���� N���̸�ŭ ���ڿ��� ��ȯ
*/
--20��ŭ�� ���� �� EMAIL�÷����� ���������� �����ϰ� ������ �κ��� �������� ä���
SELECT EMP_NAME, LPAD(EMAIL, 20)
FROM EMPLOYEE;

SELECT EMP_NAME, LPAD(EMAIL, 20, '#')
FROM EMPLOYEE;

SELECT EMP_NAME, RPAD(EMAIL, 20, '#')
FROM EMPLOYEE;

--������� �����, �ֹε�Ϲ�ȣ ��ȸ("701011-1XXXXXX")
SELECT EMP_NAME, SUBSTR(EMP_NO, 1, 8) || 'XXXXXX'
--SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO, 1, 8), 14, 'x')
FROM EMPLOYEE;

-----------------------------------------------------------------------
/*
    *LTRIM/RTIRM
    ���ڿ����� Ư�� ���ڸ� ������ �������� ��ȯ
    LTRIM/RTRIM(STRING, [�����ϰ����ϴ� ���ڵ�])
    
    ���ڿ��� ���� Ȥ�� �����ʿ��� �����ϰ����ϴ� ���ڵ��� ã�Ƽ� ������ ������ ���ڿ� ��ȯ
*/
SELECT LTRIM('     K    H      ') FROM DUAL;
SELECT LTRIM('ACBABCAABCKKH', 'ABC') FROM DUAL;
SELECT RTRIM('513543213KH1543542', '0123456789') FROM DUAL;

/*
    * TRIM
    ���ڿ��� ��/��/���ʿ� �ִ� ������ ���ڵ��� ������ ������ ���ڿ� ��ȯ
    TRIM([LEADING | TRAILING | BOTH] �����ϰ����ϴ� ���ڿ� FROM ���ڿ�)
*/

SELECT TRIM('     K    H      ') FROM DUAL; --���ʿ��ִ� ���� ����
SELECT TRIM('Z' FROM 'ZZZZKHZZZZZZZZ') FROM DUAL; --���ʿ��ִ� ���� ����

SELECT TRIM(LEADING 'Z' FROM 'ZZZZKHZZZZZZZZ') FROM DUAL; --LTRIM
SELECT TRIM(TRAILING 'Z' FROM 'ZZZZKHZZZZZZZZ') FROM DUAL; --RTRIM

----------------------------------------------------------------------------------

/*
    *LOWER / UPPER / INITCAP
    LOWER : �� �ҹ��ڷ� ������ ���ڿ� ��ȯ
    UPPER : �� �빮�ڷ� ������ ���ڿ� ��ȯ
    INITCAP : ���� ���� ù���ڸ��� �빮�ڷ� ������ ���ڿ� ��ȯ
*/

SELECT LOWER('Welcome To My KH') FROM DUAL;
SELECT UPPER('Welcome To My KH') FROM DUAL;
SELECT INITCAP('welcome to my kH') FROM DUAL;


-------------------------------------------------------------------------------------

/*
    *CONCAT
    ���ڿ� �ΰ� ���޹޾� �ϳ��� ��ģ �� ��ȯ
    CONCAT(STRING1, STRING2)
*/

SELECT CONCAT('������', 'ABC') FROM DUAL;
SELECT '������' || 'ABC' FROM DUAL;

---------------------------------------------------------------
/*
    *REPLACE
    Ư�����ڿ����� Ư���κ��� �ٸ� �κ����� ��ü
    REPLACE(���ڿ�, ã�� ���ڿ�, �����ҹ��ڿ�)
*/
SELECT EMAIL, REPLACE(EMAIL, 'KH.or.kr', 'gmail.com')
FROM EMPLOYEE;

--======================================================================================
/*
    <���� ó�� �Լ�>
    
    *ABS
    ������ ���밪�� �����ִ� �Լ�
*/

SELECT ABS(-10), ABS(-6.3) FROM DUAL;

-------------------------------------------------------------------------

/*
    *MOD
    �� ���� ���� ���������� ��ȯ
    MOD(NUMBER,NUMBER)
*/

SELECT MOD(10,3) FROM DUAL;
SELECT MOD(10.9,3) FROM DUAL;

--------------------------------------------------------------------------
/*
    *ROUND
    �ݿø��� ����� ��ȯ
    ROUND(NUMBER, [��ġ])
*/

SELECT ROUND(123.456) FROM DUAL; -- �⺻�ڼ��� �Ҽ��� ù��° �ڸ����� �ݿø�
SELECT ROUND(123.456, 1) FROM DUAL; -- ����� �����Ҽ��� �Ҽ��� �ڷ� ��ĭ�� �̵�
SELECT ROUND(123.456, -1) FROM DUAL; -- ������ ������ ���� �Ҽ��� ���ڸ��� �̵�

/*
    *CEIL
    �ø�ó���� ���� �Լ�
    
    CEIL(NUMBER)
*/

SELECT CEIL(123.456) FROM DUAL;

/*
    TRUNC, FLOOR
    ����ó���Լ�
    
    TRUNC(NUMBER, [��ġ])
    FLOOR(NUMBER)
*/

SELECT TRUNC(123.952) FROM DUAL;
SELECT TRUNC(123.952, 1) FROM DUAL;
SELECT TRUNC(123.952, -1) FROM DUAL;

--------------------------����--------------------------
--�˻��ϰ����ϴ� ����
--JOB_CODE�� J7�̰ų� J6�̸鼭 SALARY���� 200���� �̻��̰�
--BONUS�� �ְ� ������ �����
--�̸�, �ֹε�Ϲ�ȣ, �����ڵ�, �μ��ڵ�, �޿�, ���ʽ��� ��ȸ�ϰ�ʹ�.

SELECT EMP_NAME, EMP_NO, JOB_CODE, SALARY, BONUS
FROM EMPLOYEE
WHERE (JOB_CODE = 'J7' OR JOB_CODE = 'J6') AND SALARY >= 2000000
      AND BONUS IS NOT NULL AND (SUBSTR(EMP_NO, 8, 1) = '2' OR SUBSTR(EMP_NO, 8, 1) = '4');

--==============================================================================================

/*
    <��¥ ó�� �Լ�>
*/


-- *SYSDATE : �ý����� ���� ��¥�� �ð��� ��ȯ
SELECT SYSDATE FROM DUAL;

-- *MONTHS_BETWEEN : �� ��¥ ������ ���� ��
-- ������� �����, �Ի���, �ٹ��ϼ�, �ٹ������� ��ȸ
SELECT EMP_NAME, HIRE_DATE, FLOOR(SYSDATE - HIRE_DATE),
       CEIL(MONTHS_BETWEEN(SYSDATE, HIRE_DATE))
FROM EMPLOYEE;

--*ADD_MONTHS : Ư�� ��¥�� NUMBER�������� ���ؼ� ��ȯ
SELECT ADD_MONTHS(SYSDATE, 4) FROM DUAL;

--�ٷ��� ���̺��� �����, �Ի���, �Ի��� 3������ ��¥ ��ȸ
SELECT EMP_NAME, HIRE_DATE, ADD_MONTHS(HIRE_DATE, 3)
FROM EMPLOYEE;

-- *NEXT_DAY(DATE, ����(���� | ����)) : Ư����¥ ���� ���� ����� ������ ��¥�� ��ȯ
SELECT NEXT_DAY(SYSDATE, '�����') FROM DUAL;
SELECT NEXT_DAY(SYSDATE, '��') FROM DUAL;

-- 1: �� , ~ 7: ��
SELECT NEXT_DAY(SYSDATE, 7) FROM DUAL;

--����
ALTER SESSION SET NLS_LANGUAGE = KOREAN;
ALTER SESSION SET NLS_LANGUAGE = AMERICAN;

-- *LAST_DAY(DATE) : �ش���� ������ ��¥ ���ؼ� ��ȯ
SELECT LAST_DAY(SYSDATE) FROM DUAL;

/*
    *EXTRACT : Ư�� ��¥�κ��� ��|��|�� ���� �����ؼ� ��ȯ�ϴ� �Լ�
    
    [ǥ����]
    EXTRACT(YEAR FROM DATE) : ������ ����
    EXTRACT(MONTH FROM DATE) : ���� ����
    EXTRACT(DAY FROM DATE) : �ϸ� ����
*/

-- ����� �����, �Ի�⵵, �Ի��, �Ի����� ��ȸ
SELECT EMP_NAME,
      EXTRACT(YEAR FROM HIRE_DATE) AS "�Ի�⵵",
      EXTRACT(MONTH FROM HIRE_DATE) AS "�Ի��",
      EXTRACT(DAY FROM HIRE_DATE) AS "�Ի���"
FROM EMPLOYEE
ORDER BY 2, 3, 4;




