create table products(
pid int primary key,  --商品号（无业务逻辑）
name nvarchar2(32) not null,
price number(10,1) not null,
detail nvarchar2(1000),
pic varchar2(120) not null,
createtime date not null
);

create table users(
 userid int primary key, --用户编号（无业务逻辑）
 username varchar2(32) not null, --用户名
 password varchar2(20) not null, --密码
 birthday date default null, --生日
 gender char(1) default null, --性别
 address varchar2(256) default null --地址
);

create table orders(
oid int primary key,  --订单号（无业务逻辑）
userid int not null,
ordernumber varchar2(32) not null, --订单编号（有业务逻辑）
ordertime date not null, --订单时间
note varchar2(200), --备注
constraint fk_userid  foreign key (userid) references users(userid)
);

create table orderitem(
  id int primary key, --订单项号
  oid int, --所属订单号
  pid int, --商品号
  purchasenum int default null, --购买数量
  constraint fk_oid foreign key (oid) references orders(oid),
  constraint fk_pid foreign key (pid) references products(pid)
);

select * from users where username like '%z%';
select * from users;
select * from users where uid = 1001; 
insert into users values(1001,'zhangsan','zs',to_date('1990-01-01','yyyy-mm-dd'),1,'湖南长沙雨花区');
insert into users values(1002,'lishi','ls',to_date('1988-02-01','yyyy-mm-dd'),2,'北京崇文区');
insert into users values(1003,'wangwu','ww',to_date('1991-02-01','yyyy-mm-dd'),1,'湖南长沙天心区');
commit;
select * from products;
insert into products values(00001,'Lenovo ThinkPad T410',8888,'经典商务笔记本','D:\',to_date('2008-01-01','yyyy-mm-dd'));
insert into products values(00002,'Dell Latitude E6400',10000,'经典商务笔记本','D:\',to_date('2011-01-01','yyyy-mm-dd'));
insert into products values(00003,'Lenovo IdeaPad',8888,'经典游戏笔记本','D:\',to_date('2008-01-01','yyyy-mm-dd'));
insert into products values(00004,'Dell Latitude E8700',6666,'经典商务笔记本','D:\',to_date('2009-01-01','yyyy-mm-dd'));

select * from orders;

select * from orderitem;
select user_seq.nextval from dual
create sequence user_seq
minvalue 1000
maxvalue 9999
start with 2000
increment by 1;