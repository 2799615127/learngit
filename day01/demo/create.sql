create table products(
pid int primary key,  --��Ʒ�ţ���ҵ���߼���
name nvarchar2(32) not null,
price number(10,1) not null,
detail nvarchar2(1000),
pic varchar2(120) not null,
createtime date not null
);

create table users(
 userid int primary key, --�û���ţ���ҵ���߼���
 username varchar2(32) not null, --�û���
 password varchar2(20) not null, --����
 birthday date default null, --����
 gender char(1) default null, --�Ա�
 address varchar2(256) default null --��ַ
);

create table orders(
oid int primary key,  --�����ţ���ҵ���߼���
userid int not null,
ordernumber varchar2(32) not null, --������ţ���ҵ���߼���
ordertime date not null, --����ʱ��
note varchar2(200), --��ע
constraint fk_userid  foreign key (userid) references users(userid)
);

create table orderitem(
  id int primary key, --�������
  oid int, --����������
  pid int, --��Ʒ��
  purchasenum int default null, --��������
  constraint fk_oid foreign key (oid) references orders(oid),
  constraint fk_pid foreign key (pid) references products(pid)
);

select * from users where username like '%z%';
select * from users;
select * from users where uid = 1001; 
insert into users values(1001,'zhangsan','zs',to_date('1990-01-01','yyyy-mm-dd'),1,'���ϳ�ɳ�껨��');
insert into users values(1002,'lishi','ls',to_date('1988-02-01','yyyy-mm-dd'),2,'����������');
insert into users values(1003,'wangwu','ww',to_date('1991-02-01','yyyy-mm-dd'),1,'���ϳ�ɳ������');
commit;
select * from products;
insert into products values(00001,'Lenovo ThinkPad T410',8888,'��������ʼǱ�','D:\',to_date('2008-01-01','yyyy-mm-dd'));
insert into products values(00002,'Dell Latitude E6400',10000,'��������ʼǱ�','D:\',to_date('2011-01-01','yyyy-mm-dd'));
insert into products values(00003,'Lenovo IdeaPad',8888,'������Ϸ�ʼǱ�','D:\',to_date('2008-01-01','yyyy-mm-dd'));
insert into products values(00004,'Dell Latitude E8700',6666,'��������ʼǱ�','D:\',to_date('2009-01-01','yyyy-mm-dd'));

select * from orders;

select * from orderitem;
select user_seq.nextval from dual
create sequence user_seq
minvalue 1000
maxvalue 9999
start with 2000
increment by 1;