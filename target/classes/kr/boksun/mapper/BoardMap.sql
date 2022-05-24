drop table board
create table board(
	idx 		number(4)     ,
	title		varchar(1000) not null,
	contents	varchar(3000) not null,
	count		number(4) 		  default 0 not null,
	writer		varchar(100)  not null,
	indate		varchar(100),
	
	primary key(idx)
);

insert into board(idx, title, contents,count, writer, indate) values (1, '아이오티', '아이오티빡친다',1, '김민근','20120354');

select * from board