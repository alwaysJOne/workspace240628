/*
   <GROUP BY��>
   �׷������ ������ �� �ִ� ����(�ش� �׷���غ��� ���� �׷����� ���� �� ����)
   �������� ������ �ϳ��� �׷����� ��� ó���ϴ� �������� ���
*/

SELECT SUM(SALARY)
FROM EMPLOYEE; --��ü����� �ϳ��� �׷����� ��� �� ���� ���� ��

--�� �μ����� �޿� ����
--�� �μ����� ���� �׷�
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

--�� �μ��� �����
SELECT DEPT_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

SELECT DEPT_CODE, COUNT(*), SUM(SALARY) -- 3
FROM EMPLOYEE      -- 1
GROUP BY DEPT_CODE -- 2
ORDER BY DEPT_CODE; -- 4 ORDER BY ������ ���������� -> ������ ������ ���ִ� ���� �ƴϸ� �ǹ� X


---�� ���޺� �ѻ����, ���ʽ��� �޴� �����, �޿���, ��ձ޿�, �����޿�, �ְ�޿� (���� = ���� ��������)
SELECT JOB_CODE AS "����",
       COUNT(*) AS "�����",
       COUNT(BONUS) AS "���ʽ� �޴� ���",
       SUM(SALARY) AS "�޿���",
       ROUND(AVG(SALARY)) AS "�޿����",
       MIN(SALARY) AS "�����޿�",
       MAX(SALARY) AS "�ְ�޿�"
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE;

--GROUP BY���� �Լ��� ��� ����
SELECT DECODE(SUBSTR(EMP_NO, 8, 1), '1', '��', '2', '��'), COUNT(*)
FROM EMPLOYEE
GROUP BY SUBSTR(EMP_NO, 8, 1);

--GROUP BY���� �����÷��� ����� �� �ִ�.
SELECT DEPT_CODE, JOB_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE;

--=============================================================================
/*
    [HAVING ��]
    �׷쿡 ���� ������ ������ �� ���Ǵ� ����(�ַ� �����Լ����� ������ ������ �����)
*/

--�� �μ��� ��� �޿�(�μ��ڵ�, ��ձ޿�)
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE;

--�� �μ��� ��ձ޿��� 300���� �̻��� �μ��鸸 ��ȸ(�μ��ڵ� ��ձ޿�)
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
WHERE SALARY >= 3000000
GROUP BY DEPT_CODE;

SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING AVG(SALARY) >= 3000000;

-- ���޺� �����ڵ�, �ѱ޿���(��, ���޺� �ѱ޿����� 1000���� �̻��� ���޸� ��ȸ)
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
HAVING SUM(SALARY) >= 10000000;

--�μ��� ���ʽ��� �޴� ����� ���� �μ��� �μ��ڵ�
SELECT DEPT_CODE,COUNT(BONUS)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING COUNT(BONUS) = 0;

------------------------------------------------------------------------------
/*
    SELECT * | ��ȸ�ϰ���� �÷��� | �Լ��� | ������� ----------- 5
    FROM ��ȸ�ϰ���� ���̺� | DUAL               -------------- 1
    WHERE ���ǽ�                                --------------- 2
    GROUP BY �׷��� �����̵Ǵ� �÷� | �Լ���       --------------- 3
    HAVING ���ǽ�                               --------------- 4
    ORDER BY �÷� | ��Ī | ���� [ASC | DESC] [NULLS FIRST | NULLS LSAT] -- 6
*/

-----------------------------------------------------------------------------

/*
    ���տ�����
    �������� �������� �ϳ��� ���������� ����� ������
    
    -UNION : OR | ������(�� ������ ������ ������� ���Ѵ�)
    -INTERSECT : AND | ������(�� �������� ������ ������� �ߺ��� �����)
    -UNION ALL : ������ + ������ (�ߺ��Ǵ� �� ����ʰ� ���� ���� �����)
    -MINUS : ������(����������� ���������� �� ������)
*/

--1. UNION
--�μ��ڵ尡 D5�� ��� �Ǵ� �޿��� 300���� �ʰ��� ������� ���, �̸�, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' OR SALARY > 3000000;

--�μ��ڵ尡 D5�� ������� ���, �̸�, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';

--�޿��� 300���� �ʰ��� ������� ���, �̸�, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

-- UNION����ؼ� ��ġ��
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

--2. INTERSECT(������)
--�μ��ڵ尡 D5�̸鼭 �޿��� 300���� �ʰ��� ������� ���, �̸�, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' AND SALARY > 3000000;

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
INTERSECT
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

--------------------------------------------------------------
--���տ����� ���� ���ǻ���
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000
ORDER BY EMP_ID;
--�÷��� ������ �����ؾ��Ѵ�
--�÷��ڸ����� ������ Ÿ������ ����ؾ��Ѵ�.
--�����ϰ�ʹٸ� ORDER BY�� �������� ����Ѵ�.


--3. UNION ALL : �������� ��������� ������ �� ���Ѵ�(�ߺ� ���X)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION ALL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000
ORDER BY EMP_ID;

--4. MINUS : ���� SELECT������� ���� SELECT����� �� ������
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
MINUS
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000
ORDER BY EMP_ID;

