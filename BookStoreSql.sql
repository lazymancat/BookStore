Create DataBase BookStoreDB
go
use BookStoreDB

Create Table BookType(
	typeId int identity(1,1) Not Null Primary Key,--书籍类型
	typeName varchar(50) Not Null,--书籍类型名
	flag int Not Null --删除标记
)

insert into BookType values('儿童文学', 0)
insert into BookType values('科普百科', 0)
insert into BookType values('绘本|图画书', 0)
insert into BookType values('幼儿启蒙', 0)
insert into BookType values('中国古代文学', 0)
insert into BookType values('诗歌集', 0)
insert into BookType values('回忆录与口述', 0)
insert into BookType values('人物记实', 0)
insert into BookType values('推理小说', 0)
insert into BookType values('科幻小说', 0)
insert into BookType values('军事小说', 0)
insert into BookType values('世界名著', 0)
insert into BookType values('投资理财', 0)
insert into BookType values('管理学理论与方法', 0)
insert into BookType values('统计学', 0)
insert into BookType values('金融银行与货币', 0)


Create Table Books(
	id int identity(1,1) Primary Key,--书籍主标识,主键
	name varchar(100) Not Null,--书籍名称
	price numeric(10,2) Not Null,--网站定价
	stockStatus numeric(10,0) default 1,--库存数量
	publisher varchar(100) Not Null,--出版社名
	author varchar(100) Not Null, --作者
	typeId int Not Null,--书籍类型,外键
	isbn varchar(20) Not Null UNIQUE,--国际标准图书编号
	pageCount numeric(5,0) Not Null,--页数
	wordCount numeric(10,0) default 1,--字数
	introduction nvarchar(2000) default '无',--书籍介绍
	image varchar(100) Not Null,--书籍图片名称
	flag int Not Null --删除标记
	
	Constraint typeId_fk Foreign Key(typeId) References BookType(typeId)
)


insert into Books values('笑猫日记：樱花巷的秘密',11.8,default,'明天出版社; 第1版 (2017年1月1日)','杨红樱','1','9787533290467',177,default,default,'71uwb1bI1L.jpg', 0)
insert into Books values('哈利·波特与死亡圣器(纪念版)',28.24,default,'人民文学出版社; 第1版 (2007年10月1日)','J.K.罗琳 (J.K.Rowling)','1','9787020103355',556,default,default,'71qkXEna6TL.jpg', 0)
insert into Books values('海豚文学馆·世界文学名著典藏:希腊神话故事(新版)',21.40,default,'花城出版社; 第1版 (2014年7月1日)','古斯塔夫·施瓦布 (Schwab G.) ','1','9787536069886',585,default,default,'81m2H0pCIsL.jpg', 0)
insert into Books values('希腊神话故事:诸神的传说',17.50,default,'中国华侨出版社; 第1版 (2016年6月1日)','施瓦布 ','1','9787511355775',275,default,default,'719W2gkgzJL.jpg', 0)
insert into Books values('纽伯瑞大奖精选书系(套装共20册)',235.80,default,'中国华侨出版社; 第1版 (2016年6月1日)','罗伯特•罗素 (作者), 罗拉•英格斯•怀德 (作者)','1','9787533675905',5195,default,default,'61qVmHoNB2L.jpg', 0)
insert into Books values('老鼠记者全球版(1-5)(套装共5册)',57.20,default,'二十一世纪出版社; 第1版 (2016年7月1日)','杰罗尼摩·斯蒂顿 (Geronimo Stilton.)','1','9787556819690',590,default,default,'9119jmhFq7L.jpg', 0)
insert into Books values('安徒生童话精选',16.00,default,'中国华侨出版社; 第1版 (2016年6月1日)','安徒生 (作者), 王悦 (译者)','1','9787511360434',590,default,default,'71pcV3DBuTL.jpg', 0)
insert into Books values('非常了不起的吹吹(套装共2册）',33.58,default,'二十一世纪出版社; 第1版 (2016年11月1日)','朱奎 (作者), 沈苑苑 (插图作者)','1','9789900376040',590,default,default,'81RHDtHGgPL.jpg', 0)
insert into Books values('绿野仙踪全集(套装共14册)',220.89,default,'北京时代华文书局; 第1版 (2016年10月1日)','莱曼•弗兰克•鲍姆 (作者), W.W.丹斯诺 (插图作者)','1','9787569910278',2884,default,default,'71ofFDX-5VL.jpg', 0)
insert into Books values('伊索寓言',20.00,default,'中国华侨出版社; 第1版 (2016年5月1日)','伊索 (作者), 花火 (译者)','1','9787511358264',203,default,default,'71wlCnTdIGL.jpg', 0)
insert into Books values('惊人的骨头:消失的恐龙+动物世界+头骨之谜(套装共3册)',130.50,default,'人民邮电出版社; 第1版 (2017年1月1日)','英国QED出版公司 (作者), 童趣出版有限公司 (编者)','2','9789900375937',283,default,default,'91ycsJF3HZL.jpg', 0)
insert into Books values('希利尔讲给孩子的世界史•世界地理•艺术史(套装共3册)',52.10,default,'哈尔滨出版社; 第1版 (2013年1月1日)','维吉尔•莫里斯•希利尔 (V.M.Hillyer)','2','bkbkav5526',1008,default,default,'911sv1ElruL.jpg', 0)
insert into Books values('杨红樱画本·校园童话系列(套装共6册)',105.00,default,'长江少年儿童出版社; 第1版 (2016年12月6日)','杨红樱 (作者)','2','9787556049547',956,default,default,'51aTd-xMVML._SY498_BO1,204,203,200_.jpg', 0)
insert into Books values('DK机械运转的秘密 动物园大逃亡！',91.10,default,'电子工业出版社; 第1版 (2017年4月1日)','大卫·麦考利 (David Macaulay)','2','9787121303401',32,default,default,'81S7cA2EwXL.jpg', 0)
insert into Books values('真正的蒙氏教育在家庭:50个经典数学游戏造就孩子思维力',36.50,default,'中信出版集团股份有限公司; 第1版 (2017年5月1日)','白玛琳 (作者)','2','9787508669083',176,default,default,'817Bb-050EL.jpg', 0)
insert into Books values('100个问题1000个秘密·课本里学不到的自然奥秘',19.80,default,'北京联合出版公司; 第1版 (2017年3月1日)','禹田 (作者)','2','9787550294295',183,default,default,'81h67yIH0PL.jpg', 0)
insert into Books values('化学变!变!变!',66.00,default,' 江西人民出版社; 第1版 (2017年5月1日)','原田佐和子 (harada·sawako) (作者), 小川真理子 (ogawa·mariko) (作者)','2','9787210088134',126,default,default,'71uIrqkWvVL.jpg', 0)
insert into Books values('快来帮帮我,我们要去大自然了!',53.50,default,'中信出版社; 第1版 (2017年2月10日)','路易•埃斯皮纳苏^弗雷德里克•利萨克 (作者), 时征 (译者)','2','9787508670041',144,default,default,'719FwdUFKJL.jpg', 0)
insert into Books values('我的好奇心橱柜',56.20,default,'中信出版集团; 第1版 (2017年4月1日)','戈登·格赖斯 (作者), 陈阳 (译者)','2','9787508673370',236,default,default,'71j5xObjZaL.jpg', 0)
insert into Books values('小黑鱼(1964年美国凯迪克大奖、美国图书馆协会年度好书)',23.50,default,'南海出版社; 第2版 (2010年1月1日)','李欧•李奥尼 (作者), 彭懿 (译者)','3','9787544245906',36,default,default,'911C0IZfXbL.jpg', 0)
insert into Books values('启发精选美国凯迪克大奖绘本·菲菲生气了:非常非常的生气',27.60,default,'河北教育出版社; 第1版 (2009年2月1日)','莫莉·卞 (Molly Bang) (作者), 李坤珊 (译者)','3','9787543470781',32,default,default,'81BOYtxgGhL.jpg', 0)
insert into Books values('让路给小鸭子',27.20,default,'河北教育出版社; 第1版 (2009年11月1日)','罗伯特•麦克洛斯基 (Robert McCloskey) (作者), 罗伯特•麦克洛斯基(Robert McCloskey)','3','9787543473577',63,default,default,'51xkcwEOakL.jpg', 0)
insert into Books values('启发精选美国凯迪克大奖绘本:疯狂星期二',27.00,default,'河北教育出版社; 第1版 (2009年2月1日)','大卫·威斯纳 (Wiesner D.) (作者, 插图作者)','3','9787543471412',28,default,default,'81VtTwcBguL.jpg', 0)
insert into Books values('李欧•李奥尼作品集(02):田鼠阿佛',22.20,default,'南海出版公司; 第1版 (2010年9月1日)','李欧•李奥尼 (插图作者), 阿甲 (译者)','3','9787544246620',36,default,default,'81sRR7qeNFL.jpg', 0)
insert into Books values('寻找维尼(2016凯迪克金奖,寻找心灵的家园，那是“爱”发生的地方)',39.80,default,'长江少年儿童出版社; 第1版 (2016年8月1日)','琳赛·马蒂克 (作者), 索菲·布莱科尔 (插图作者)','3','9787556045549',56,default,default,'61Pxm3PYCPL.jpg', 0)
insert into Books values('小白找朋友(2015年凯迪克金奖作品)',24.50,default,'中信出版集团; 第1版 (2015年7月20日)','丹·桑塔特 (作者), 丹·桑阿特 (插图作者), 彭懿 (译者), 玲玲 (译者)','3','9787508652542',48,default,default,'51h1ijiGimL.jpg', 0)
insert into Books values('我的第一本专注力训练书（专注的孩子更聪明）',28.60,default,'童趣出版有限公司,人民邮电出版社; 第1版 (2012年5月10日)','美国迪士尼公司 (作者), 童趣出版有限公司 (译者)','4','9787115274328',128,default,default,'91HK0GqTBhL.jpg', 0)
insert into Books values('幼儿启蒙知识库认知贴纸书(套书共8册)（两种封面随机发货）',34.00,default,'未来出版社; 第1版 (2009年12月1日)','米希莱 (作者), 荣信文化 (译者)','4','9787541739156',112,default,default,'71l8srKyMQL.jpg', 0)
insert into Books values('学前快读600字(套装共4册)',67.20,default,'化学工业出版社; 第1版 (2014年6月1日)','李征 (作者), 郭资佳 (插图作者)','4','9787122204080',312,default,default,'81KndvRkBIL.jpg', 0)
insert into Books values('比奇兔系列:情绪绘本(套装共10册)',49.00,default,'天津人民美术出版社; 第1版 (2017年1月1日)','陈彦 (编者)','4','9787530578629',220,default,default,'81Vi0baYTdL.jpg', 0)
insert into Books values('宝宝第一套好性格养成书:皮特猫(套装共6册)',62.80,default,'北京联合出版公司; 第1版 (2014年12月1日)','艾瑞克·利温 (Eric Litwin) (作者), 詹姆斯·迪安 (James Dean) (插图作者), 彭懿 (译者), 杨玲玲 (译者)','4','9787550239005',204,default,default,'51VECKzx4fL._AC_SR300,300_.jpg', 0)
insert into Books values('ABC幼儿双语启蒙认知绘本(套装共8册)',88.90,default,'晨光出版社; 第1版 (2016年9月1日)','赵君 (作者), 吴波 (插图作者), 罗玲 (译者)','4','9787541483356',224,default,default,'61a5fGwec7L.jpg', 0)
insert into Books values('真正的蒙氏教育在家庭:50个经典探索游戏造就孩子认知力',36.50,default,'中信出版集团股份有限公司; 第1版 (2017年5月1日)','白玛琳 (作者)','4','9787508669090',176,default,default,'81vPOR37TrL.jpg', 0)
insert into Books values('红楼梦(无删减版)(套装上下册)',47.20,default,'北京联合出版公司; 第1版 (2016年5月1日)','曹雪芹 (作者), 高鹗 (作者)','5','9787550276512',783,default,default,'71TzeZ1ew1L.jpg', 0)


Create Table Customer(
	id int identity(1,1),
	regName varchar(30) not null, --唯一
	mobile varchar(20) not null,
	email varchar(50) not null,
	password varchar(100) not null,
	flag int Not Null --删除标记
	
	constraint Cus_PK primary key(id)
)

insert into Customer values('ljm', '1234567890', '478153886@qq.com', '123456', 0)
insert into Customer values('lj456745m', '1234567890', '478153886@qq.com', '123456', 0)
insert into Customer values('lj57454m', '1234567890', '478153886@qq.com', '123456', 0)
insert into Customer values('lj2217m', '1234567890', '478153886@qq.com', '123456', 0)
insert into Customer values('lj242m', '1234567890', '478153886@qq.com', '123456', 0)
insert into Customer values('lj5223523m', '1234567890', '478153886@qq.com', '123456', 0)
insert into Customer values('l5jm', '1234567890', '478153886@qq.com', '123456', 0)
insert into Customer values('lj523m', '1234567890', '478153886@qq.com', '123456', 0)
insert into Customer values('lj532523m', '1234567890', '478153886@qq.com', '123456', 0)
insert into Customer values('lj325325m', '1234567890', '478153886@qq.com', '123456', 0)
insert into Customer values('l23jm', '1234567890', '478153886@qq.com', '123456', 0)
insert into Customer values('52523', '1234567890', '478153886@qq.com', '123456', 0)
insert into Customer values('l52535jm', '1234567890', '478153886@qq.com', '123456', 0)
insert into Customer values('lj33255m', '1234567890', '478153886@qq.com', '123456', 0)
insert into Customer values('l3232525jm', '1234567890', '478153886@qq.com', '123456', 0)
insert into Customer values('lj355m', '1234567890', '478153886@qq.com', '123456', 0)
insert into Customer values('lj34242m', '1234567890', '478153886@qq.com', '123456', 0)
insert into Customer values('ljm414', '1234567890', '478153886@qq.com', '123456', 0)
insert into Customer values('ljm21313', '1234567890', '478153886@qq.com', '123456', 0)
insert into Customer values('ljm23113', '1234567890', '478153886@qq.com', '123456', 0)

Create Table BookComment(
	id int identity(1,1),
	cusId int not null,
	bookId int not null,
	content nvarchar(1000) not null,
	contentDate date not null,
	star numeric(1,0) not null,
	flag int not null
	
	constraint BC_PK Primary Key(id),
	constraint BC_FK1 Foreign Key(cusId) references Customer(id),
	constraint BC_FK2 Foreign Key(bookId) references Books(id)
)

insert into BookComment values(1, 1, '1111111111111111111', '2017-01-01', 3, 0)
insert into BookComment values(1, 1, '2222222222222222222', '2017-01-01', 1, 0)
insert into BookComment values(1, 1, '3333333333333333333', '2017-01-01', 2, 0)
insert into BookComment values(1, 1, '4444444444444444444', '2017-01-01', 5, 0)
insert into BookComment values(1, 1, '5555555555555555555', '2017-01-01', 1, 0)
insert into BookComment values(1, 1, '6666666666666666666', '2017-01-01', 2, 0)
insert into BookComment values(1, 1, '7777777777777777777', '2017-01-01', 3, 0)
insert into BookComment values(1, 1, '8888888888888888888', '2017-01-01', 5, 0)
insert into BookComment values(1, 1, '9999999999999999999', '2017-01-01', 4, 0)
insert into BookComment values(1, 1, '0000000000000000000', '2017-01-01', 2, 0)
insert into BookComment values(1, 1, '1111111111111111111', '2017-01-01', 3, 0)

Create Table ConsignmentAddress(
	id int identity(1,1),
	cusId int not null,
	consignmentName varchar(50) not null,
	address varchar(200) not null,
	postCode varchar(10) not null,
	phone varchar(20) not null,
	flag int Not Null --删除标记
	
	constraint CA_PK Primary Key(id),
	constraint CA_FK1 Foreign Key(cusId) references Customer(id)
)

insert into ConsignmentAddress values(1, 'm', '1111111111111111111111', '519088','13160688888', 0)
insert into ConsignmentAddress values(1, 'm112', '111saffsaasf11111111111', '519088','13160688888', 0)
insert into ConsignmentAddress values(1, 'm24', '1111111111qaewase111111111111', '519088','13160688888', 0)
insert into ConsignmentAddress values(1, 'm34', '11111safsaf11111111111111', '519088','13160688888', 0)


Create Table Orders(
	id int identity(1,1),
	cusId int not null,
	addressId int not null,
	payType numeric(1,0) not null,
	price numeric(10,2) not null,
	createDate datetime not null,
	orderStatus numeric(1,0) not null,
	
	constraint Orders_PK Primary Key(id),
	constraint Orders_FK1 Foreign Key(cusId) references Customer(id),
	constraint Orders_FK2 Foreign Key(addressId) references ConsignmentAddress(id)
)

Create Table OrderItems(
	id int identity(1,1),
	ordId int not null,
	bookId int not null,
	quantity numeric(10,0) not null,
	subtotal numeric(10,2) not null,
	
	constraint OI_PK Primary Key(id),
	constraint OI_FK1 Foreign Key(ordId) references Orders(id),
	constraint OI_FK2 Foreign Key(bookId) references Books(id)
)

Create Table Administrator(
	id int identity(1,1),
	name varchar(50) not null,
	password varchar(50) not null
)
insert into Administrator values('ad', '123456')


