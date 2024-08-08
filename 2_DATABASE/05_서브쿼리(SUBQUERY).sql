/*
    *��������
    -�ϳ��� SQL�� �ȿ� ���Ե� �� �ٸ� SELECT��
    -���� SQL���� ���� ���� ������ �ϴ� ����
*/

--���ö ����� ���� �μ��� ���� ����� ��ȸ

SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

--���ö����� ��μ��ϱ�?
SELECT DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '���ö';

--���� �� ������ �ϳ��� ������ ��������
SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '���ö');


