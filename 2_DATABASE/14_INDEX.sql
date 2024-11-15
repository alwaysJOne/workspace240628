/*
    <INDEX>
    -�ε��� : �����͸� ������ �˻��ϱ� ���� �������� ���İ�, Ž���� ���� DMBS�� ���� ���� �������� �����ϴ� ��ü
             �˻��ӵ��� ���˴ϴ�. 
             ��, ��� ��쿡 ���Ǵ� ���� �ƴ�.
             ������ ������ ����� �÷��� �������� ������ ������ ������ ���ϵ� �� �ִ�.
*/

--��ü ������ Ȯ��
select * 
from user_mock_data; 

--user_index_data�� ������ user_mock_data����
create table user_index_data
as select * from user_mock_data;

select count(*)
from user_index_data; 

--�������� pk�߰� -> �ε��� ����
alter table user_index_data
add constraint pk_user_index_id primary key(id);

--�������� uq�߰�
alter table user_index_data
add constraint uq_user_index_email unique(email);

select * from user_indexes;

--�ε��� ���� �ȵ� ���̺�(user_mock_data)
/*
------------------------------------------------------------------------------------
| Id  | Operation         | Name           | Rows  | Bytes | Cost (%CPU)| Time     |
------------------------------------------------------------------------------------
|   0 | SELECT STATEMENT  |                |     5 |   665 |   136   (0)| 00:00:02 |
|*  1 |  TABLE ACCESS FULL| USER_MOCK_DATA |     5 |   665 |   136   (0)| 00:00:02 |
------------------------------------------------------------------------------------
cost : ���� ���� ��� -> ���� ���� ���� ���� ������� �˻��� ������ �� �ִ�.

rows(cardinality) : ���� ��ȹ���� access�� row ��

bytes : ���� ��ȹ���� access�� bytes ��

TABLE ACCESS FULL : ��ü ���̺��� Ž���Ͽ� ����� �����ϰ� �� ���̴�.
*/
explain plan for
select * from user_mock_data where id = 30000;

select * from table(dbms_xplan.display);

--�ε��� ���� �� ���̺�(user_index_data)
/*
------------------------------------------------------------------------------------------------
| Id  | Operation                   | Name             | Rows  | Bytes | Cost (%CPU)| Time     |
------------------------------------------------------------------------------------------------
|   0 | SELECT STATEMENT            |                  |     1 |   133 |     2   (0)| 00:00:01 |
|   1 |  TABLE ACCESS BY INDEX ROWID| USER_INDEX_DATA  |     1 |   133 |     2   (0)| 00:00:01 |
|*  2 |   INDEX UNIQUE SCAN         | PK_USER_INDEX_ID |     1 |       |     1   (0)| 00:00:01 |
------------------------------------------------------------------------------------------------
INDEX (UNIQUE) SCAN : �ε��� ��ü�� �����Ͽ� Ž�� �� ����� �����ϰ� �� ���� �����Ѵ�.
TABLE ACCESS (BY INDEX ROWID) : �ε��� ��ü�� ������ INDEX ROWID�� Ž���Ͽ� ����� �����ϰ� �ɰ��� �����Ѵ�.
*/
explain plan for
select * from user_index_data where id = 30000;

select * from table(dbms_xplan.display);

--�ε��� ����
CREATE INDEX USER_INDEX_FIRST_NAME ON USER_INDEX_DATA(FIRST_NAME); 

--���÷����� ��ȸ
explain plan for
SELECT *
FROM USER_MOCK_DATA
WHERE ID = 49977
AND FIRST_NAME = 'Gaston';

select * from table(dbms_xplan.display);

explain plan for
SELECT *
FROM USER_INDEX_DATA
WHERE ID = 49977
AND FIRST_NAME = 'Gaston';

select * from table(dbms_xplan.display);

--���� �ε��� ����
CREATE INDEX USER_INDEX_FSTNAME_ID ON USER_INDEX_DATA(ID, FIRST_NAME); 

explain plan for
SELECT *
FROM USER_INDEX_DATA
WHERE ID = 49977
AND FIRST_NAME = 'Gaston';

select * from table(dbms_xplan.display);


