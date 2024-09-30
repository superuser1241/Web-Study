select *from member; -- alt+x

drop table member;
--회원가입 테이블 생성

create table member(
   id varchar2(20) primary key ,
   pwd varchar2(20) not null,
   name varchar2(20) not null,
   age int,
   phone varchar2(15),
   addr varchar2(50),
   join_date date not null
)

select * from member;
--레코드 추가
insert into member(id,pwd,name,age,phone,addr, join_date)
values('kim','1234','김희선',20,'010-8875-8253','서울시 광진구', sysdate)

commit
