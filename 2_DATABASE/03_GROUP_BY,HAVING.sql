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














