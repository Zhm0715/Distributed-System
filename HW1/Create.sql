create database CVoidData;

use CVoidData;

create table Continent(
	ContID int primary key,
    ContName varchar(10) not null
);

create table Country(
	CountID int primary key,
    CountName varchar(20) not null,
    ContID int,
    foreign key (ContID) references Continent(ContID)
);

create table InfectInfo(
	InfecInfoID int primary key,
    DataTime date,
    CountryID int,
    foreign key(CountryID) references Country(CountID),
    AllInfect int default 0,
    AddInfect int default 0,
    DeadNum int default 0
);

insert into Contient(ContID, ContName) value(1, "非洲"),
							(2, "南美洲"),
                            (3, "北美洲"),
                            (3, "欧洲"),
                            (4, "大洋洲");

insert into Country(CountID, CountName, ContID) value(1, "中国", 6),
													 (2, "日本", 6),
                                                     (3, "韩国", 6),
                                                     (4, "朝鲜", 6),
                                                     (5, "越南", 6),
                                                     (6, "泰国", 6),
                                                     (7, "澳大利亚", 5),
                                                     (8, "新西兰", 5),
                                                     (9, "英国", 4),
                                                     (10, "德国", 4),
                                                     (11, "比利时", 4),
                                                     (12, "俄罗斯", 4),
                                                     (13, "瑞士", 4),
                                                     (14, "波兰", 4),
                                                     (15, "加拿大", 3),
                                                     (16, "美国", 3),
                                                     (17, "古巴", 3),
                                                     (18, "巴拿马", 3),
                                                     (19, "牙买加", 3),
                                                     (20, "哥伦比亚", 2),
                                                     (21, "智利", 2),
                                                     (22, "阿根廷", 2),
                                                     (23, "乌拉圭", 2),
                                                     (24, "巴西", 2),
                                                     (25, "喀麦隆", 1),
                                                     (26, "埃及", 1),
                                                     (27, "毛里求斯", 1),
                                                     (28, "利比亚", 1),
                                                     (29, "摩洛哥", 1),
                                                     (30, "卢旺达", 1);

-- 疫情数据随机生成,见com.zhmhello.test