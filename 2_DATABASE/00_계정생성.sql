/* SELECT * FROM ALL_USERS; */
-- 한줄주석

/*
    계정 생성 방법
    CREATE USER 계정이름 IDENTIFIED BY 비밀번호;
    
    GRANT 권한 TO 계정명;
*/

CREATE USER KH IDENTIFIED BY KH;

-- KH계정에 최소한의 권한을 부여(접속, 데이터관리)
GRANT CONNECT, RESOURCE TO KH;



