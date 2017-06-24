/*
   Description：仁爱药品管理系统----数据库设计文件
   Author：曾太[Johnny Zen]
   Last Modify Date:2017-6-22
   Content:
      Database[1]：
         MedicineMS
      tables[10]：
         Staff
         Customer
         Medicine
         MedicineStorage
         PurchaseProject
         PurchaseRecord
         MSaleRecord
         Register
         Feedback
*/

select * from msalerecord order by msrd_saleDate;
select * from medicinestorage order by msrd_saleDate;
#############################################################################
/*==============================================================*/
/* 1 Database: (创建)数据库 MedicineMS                  	    */
/*==============================================================*/

#删除已经存在的数据库
drop database IF EXISTS MedicineMS; 

#创建数据库
create database MedicineMS;

#设置数据库字符集
alter database MedicineMS character set utf8;

#给用户johnny授权
grant all privileges on MedicineMS.* to johnny;

USE MedicineMS;

#################################################################

/*==============================================================*/
/* 1 Table: 店员                                                */
/*==============================================================*/
DROP TABLE IF EXISTS Staff;

CREATE TABLE Staff(
   staf_accountId_PK                VARCHAR(30) NOT NULL   					     COMMENT'【主键】账号名(ID)（8）：(数据来源：服务器端插入)',
   staf_password                    VARCHAR(10) NOT NULL DEFAULT '123456' 	  COMMENT '密码(10)', 
   staf_userType                 	TINYINT 	NOT NULL DEFAULT '2' 		     COMMENT '角色类型:1 管理员(店主);2 营业员;3 保管员（暂时不用）;4 采购员',
   staf_realName                   	VARCHAR(50) NOT NULL 					     COMMENT '职员姓名',
   staf_sex                   		CHAR(1) 	NOT NULL DEFAULT 'M', 
   staf_accountState          		BOOL 		NOT NULL DEFAULT '1' 		     COMMENT '职员账号状态：1(true) 激活; 0 锁定(视为注销（离职）或者 账户被禁用)', 
   staf_telephone                 	VARCHAR(13)								        COMMENT '职员联系电话',		
   PRIMARY KEY(staf_accountId_PK)	
)ENGINE = InnoDB COMMENT='职员表(Staff)';

#插入职员账户
insert into Staff(staf_accountId_PK,staf_password,staf_realName,staf_sex,staf_userType) values('admin001','1234567','王明华','M',1);  #店主
insert into Staff(staf_accountId_PK,staf_password,staf_realName,staf_sex,staf_telephone) values('staff002','1234567','王琛','M','18382788898'); #营业员
insert into Staff(staf_accountId_PK,staf_password,staf_realName,staf_sex,staf_telephone,staf_userType) values('staff003','1234567','严清清','F','15336366666',3); #采购员
insert into Staff(staf_accountId_PK,staf_password,staf_realName,staf_sex,staf_telephone,staf_userType) values('staff004','1234567','熊天凯','F','15336366666',4); #库存管理员


#查询全体职员信息
select * from Staff

#更新职员信息
#update MedicineMS.Staff set staf_userType = staf_userType('1') where staf_accountId_PK='20170601' 
	
##################################################################

/*==============================================================*/
/* 2 Table: 药品                                                */
/*==============================================================*/
drop table if exists Medicine;

create table Medicine
(
   	mdcn_cmpn_PK   		         varchar(10)  NOT NULL                    COMMENT '【主键】国家药品准字号(Country Medicine Permit Number)',  
   	mdcn_name                   	varchar(254) NOT NULL                    COMMENT '',
   	mdcn_isPrescription				bool		 NOT null                       COMMENT '是否处方药？1(true):是 0：否',
   	mdcn_component 				 	varchar(254) NOT NULL                    COMMENT '药品成分',
   	mdcn_property                 varchar(254)                             COMMENT '性状',
   	mdcn_useType                  varchar(20)  NOT null DEFAULT '未知'     COMMENT '使用方式:0  未知；1 仅可食用；2 仅可外用；3 即可食用又可外用',
   	mdcn_mainFun                  varchar(254) NOT NULL                    COMMENT '主治功能',
   	mdcn_standard				 	   varchar(254)                             COMMENT '药品规格：（Eg:每片重x.xx克）',
   	mdcn_usage 					 	   varchar(1024)                            COMMENT '用法用量(Eg:口服)',
   	mdcn_forbid					 	   varchar(254) NOT NULL DEFAULT '尚不明确' COMMENT '禁忌',
   	mdcn_badEffect                varchar(254) NOT NULL                    COMMENT '不良反应',
   	mdcn_attention					   varchar(1024) NOT NULL DEFAULT '无'      COMMENT '注意事项',
   	mdcn_wrap						   varchar(254) NOT NULL  DEFAULT '未知'    COMMENT '包装', 	
   	mdcn_storageWay				 	varchar(50)  NOT NULL  DEFAULT '未知'    COMMENT '贮存方式',
   	PRIMARY KEY(mdcn_cmpn_PK)	   
)ENGINE = InnoDB COMMENT='药品(信息)表(Medicine)';


###########################################################################测试数据

#新增药品信息

insert into Medicine values(
'Z19991005',
'蓝芩口服液',
false,
'板蓝根、黄芩、栀子、黄柏、胖大海。辅料为蔗糖、苯甲酸钠、聚山梨酯80。',
'本品为棕红色澄清液体；味甜，微苦。',
'口服',
'清热解毒，利咽消肿。用于急性咽炎、肺胃实热证所致的咽痛、咽干、咽部灼热。',
'每支装10毫升',
'口服，一次20毫升（2支），一日3次。',
'尚不明确。',
'个别患者服药后出现轻度腹泻，一般可自行缓解。',
'1.忌烟酒、辛辣、鱼腥食物。2.不宜在服药期间同时服用温补性中药。3.孕妇慎用。糖尿病患者、儿童应在医师指导下服用。4.脾虚大便溏者慎用。5.属风寒感冒咽痛者，症见恶寒发热、无汗、鼻流清涕者慎用。6.服药3天症状无缓解，应去医院就诊。7.对本品过敏者禁用，过敏体质者慎用。8.本品性状发生改变时禁止使用。9.儿童必须在成人监护下使用。10.请将本品放在儿童不能接触的地方。11.如正在使用其他药品，使用本品前请咨询医师或药师。',
'每盒装6支，每支10毫升。',
'密封，置阴凉（不超过20℃）处，在贮藏期间允许有少量轻摇易散的沉淀。'
);

alter table Medicine alter column 'mdcn_cmpn_PK' on delete no action;

insert into Medicine values(
'Z0000000',
'测试药品1',
false,
'板蓝根、黄芩、栀子、黄柏、胖大海。辅料为蔗糖、苯甲酸钠、聚山梨酯80。',
'本品为棕红色澄清液体；味甜，微苦。',
'口服',
'清热解毒，利咽消肿。用于急性咽炎、肺胃实热证所致的咽痛、咽干、咽部灼热。',
'每支装10毫升',
'口服，一次20毫升（2支），一日3次。',
'尚不明确。',
'个别患者服药后出现轻度腹泻，一般可自行缓解。',
'1.忌烟酒、辛辣、鱼腥食物。2.不宜在服药期间同时服用温补性中药。3.孕妇慎用。糖尿病患者、儿童应在医师指导下服用。4.脾虚大便溏者慎用。5.属风寒感冒咽痛者，症见恶寒发热、无汗、鼻流清涕者慎用。6.服药3天症状无缓解，应去医院就诊。7.对本品过敏者禁用，过敏体质者慎用。8.本品性状发生改变时禁止使用。9.儿童必须在成人监护下使用。10.请将本品放在儿童不能接触的地方。11.如正在使用其他药品，使用本品前请咨询医师或药师。',
'每盒装6支，每支10毫升。',
'密封，置阴凉（不超过20℃）处，在贮藏期间允许有少量轻摇易散的沉淀。'
);

insert into Medicine values(
'Z0000001',
'测试药品2',
false,
'胖大海。辅料为蔗糖、苯甲酸钠、聚山梨酯80。',
'棕红色澄清液体；味甜，微苦。',
'口服',
'清热解毒，利咽消肿。用于急性咽炎、肺胃实热证所致的咽痛、咽干、咽部灼热。',
'每支装10毫升',
'口服，一次20毫升（2支），一日3次。',
'尚不明确。',
'个别患者服药后出现轻度腹泻，一般可自行缓解。',
'1.忌烟酒、辛辣、鱼腥食物。2.不宜在服药期间同时服用温补性中药。3.孕妇慎用。糖尿病患者、儿童应在医师指导下服用。4.脾虚大便溏者慎用。5.属风寒感冒咽痛者，症见恶寒发热、无汗、鼻流清涕者慎用。6.服药3天症状无缓解，应去医院就诊。7.对本品过敏者禁用，过敏体质者慎用。8.本品性状发生改变时禁止使用。9.儿童必须在成人监护下使用。10.请将本品放在儿童不能接触的地方。11.如正在使用其他药品，使用本品前请咨询医师或药师。',
'每盒装6支，每支10毫升。',
'密封，置阴凉（不超过20℃）处，在贮藏期间允许有少量轻摇易散的沉淀。'
);



insert into Medicine values(
'Z0000003',
'测试药品4',
false,
'板蓝根、黄芩、栀子、黄柏、胖大海。辅料为蔗糖、苯甲酸钠、聚山梨酯80。',
'本品为棕红色澄清液体；味甜，微苦。',
'口服',
'清热解毒，利咽消肿。用于急性咽炎、肺胃实热证所致的咽痛、咽干、咽部灼热。',
'每支装10毫升',
'口服，一次20毫升（2支），一日3次。',
'尚不明确。',
'个别患者服药后出现轻度腹泻，一般可自行缓解。',
'1.忌烟酒、辛辣、鱼腥食物。2.不宜在服药期间同时服用温补性中药。3.孕妇慎用。糖尿病患者、儿童应在医师指导下服用。4.脾虚大便溏者慎用。5.属风寒感冒咽痛者，症见恶寒发热、无汗、鼻流清涕者慎用。6.服药3天症状无缓解，应去医院就诊。7.对本品过敏者禁用，过敏体质者慎用。8.本品性状发生改变时禁止使用。9.儿童必须在成人监护下使用。10.请将本品放在儿童不能接触的地方。11.如正在使用其他药品，使用本品前请咨询医师或药师。',
'每盒装6支，每支10毫升。',
'密封，置阴凉（不超过20℃）处，在贮藏期间允许有少量轻摇易散的沉淀。'
);

insert into Medicine values(
'Z0000004',
'测试药品5',
false,
'胖大海。辅料为蔗糖、苯甲酸钠、聚山梨酯80。',
'棕红色澄清液体；味甜，微苦。',
'口服',
'清热解毒，利咽消肿。用于急性咽炎、肺胃实热证所致的咽痛、咽干、咽部灼热。',
'每支装10毫升',
'口服，一次20毫升（2支），一日3次。',
'尚不明确。',
'个别患者服药后出现轻度腹泻，一般可自行缓解。',
'1.忌烟酒、辛辣、鱼腥食物。2.不宜在服药期间同时服用温补性中药。3.孕妇慎用。糖尿病患者、儿童应在医师指导下服用。4.脾虚大便溏者慎用。5.属风寒感冒咽痛者，症见恶寒发热、无汗、鼻流清涕者慎用。6.服药3天症状无缓解，应去医院就诊。7.对本品过敏者禁用，过敏体质者慎用。8.本品性状发生改变时禁止使用。9.儿童必须在成人监护下使用。10.请将本品放在儿童不能接触的地方。11.如正在使用其他药品，使用本品前请咨询医师或药师。',
'每盒装6支，每支10毫升。',
'密封，置阴凉（不超过20℃）处，在贮藏期间允许有少量轻摇易散的沉淀。'
);

insert into Medicine values(
'Z00002333',
'测试药品233',
false,
'板蓝根、黄芩、栀子、黄柏、胖大海。辅料为蔗糖、苯甲酸钠、聚山梨酯80。',
'本品为棕红色澄清液体；味甜，微苦。',
'口服',
'清热解毒，利咽消肿。用于急性咽炎、肺胃实热证所致的咽痛、咽干、咽部灼热。',
'每支装10毫升',
'口服，一次20毫升（2支），一日3次。',
'尚不明确。',
'个别患者服药后出现轻度腹泻，一般可自行缓解。',
'1.忌烟酒、辛辣、鱼腥食物。2.不宜在服药期间同时服用温补性中药。3.孕妇慎用。糖尿病患者、儿童应在医师指导下服用。4.脾虚大便溏者慎用。5.属风寒感冒咽痛者，症见恶寒发热、无汗、鼻流清涕者慎用。6.服药3天症状无缓解，应去医院就诊。7.对本品过敏者禁用，过敏体质者慎用。8.本品性状发生改变时禁止使用。9.儿童必须在成人监护下使用。10.请将本品放在儿童不能接触的地方。11.如正在使用其他药品，使用本品前请咨询医师或药师。',
'每盒装6支，每支10毫升。',
'密封，置阴凉（不超过20℃）处，在贮藏期间允许有少量轻摇易散的沉淀。'
);

insert into Medicine values(
'Z0000034',
'测试药品34',
false,
'胖大海。辅料为蔗糖、苯甲酸钠、聚山梨酯80。',
'棕红色澄清液体；味甜，微苦。',
'口服',
'清热解毒，利咽消肿。用于急性咽炎、肺胃实热证所致的咽痛、咽干、咽部灼热。',
'每支装10毫升',
'口服，一次20毫升（2支），一日3次。',
'尚不明确。',
'个别患者服药后出现轻度腹泻，一般可自行缓解。',
'1.忌烟酒、辛辣、鱼腥食物。2.不宜在服药期间同时服用温补性中药。3.孕妇慎用。糖尿病患者、儿童应在医师指导下服用。4.脾虚大便溏者慎用。5.属风寒感冒咽痛者，症见恶寒发热、无汗、鼻流清涕者慎用。6.服药3天症状无缓解，应去医院就诊。7.对本品过敏者禁用，过敏体质者慎用。8.本品性状发生改变时禁止使用。9.儿童必须在成人监护下使用。10.请将本品放在儿童不能接触的地方。11.如正在使用其他药品，使用本品前请咨询医师或药师。',
'每盒装6支，每支10毫升。',
'密封，置阴凉（不超过20℃）处，在贮藏期间允许有少量轻摇易散的沉淀。'
);

#新增药品信息
insert into Medicine values(
'Z243645645',
'测试药品676',
false,
'仙鹤草、黄连、木香、蝉蜕、石菖蒲、桔梗',
'本品为薄膜衣片，除去包衣片后显棕黄色至褐棕色；味苦、涩',
'口服',
'清热燥湿，抗菌消炎。用于菌痢，胃肠炎等',
'每片重0.4g',
'口服，一次3片，一日3次。',
'尚不明确。',
'尚不明确。',
'尚不明确。',
'药用铝塑板，2板，每板3X6片。',
'密封。'
);

#新增药品信息
insert into Medicine values(
'Z440567565',
'测试药5675',
false,
'苦参，甲氧苄氨嘧啶',
'本品为糖衣片，除去糖衣后显棕色；味苦',
'口服',
'清热燥湿，健脾止泻。用于脾虚湿热内蕴所致的泄泻急迫，泻而不爽，或大便溏泻，食少倦怠，腹胀腹痛。',
'每片重0.4g',
'口服一次4-6片，一日3次',
'孕妇、哺乳期妇女禁用。',
'尚不明确。',
'1.饮食宜清淡，忌食辛辣、生冷、油腻食物。2.不宜在服药期间同时服用滋补性中药。3.有慢性结肠炎、溃疡性结肠炎便脓血等慢性病史者，患泄泻后应去医院就诊。4.有高血压、心脏病、糖尿病、肝病、肾病等慢性病严重者应在医师指导下服用。5.服药3天症状无缓解，应去医院就诊。6.严格按用法用量服用，儿童、年老体弱者应在医师指导下服用。7.对本品过敏者禁用，过敏体质者慎用。8.本品性状发生改变时禁止使用。9.儿童必须在成人监护下使用。10.请将本品放在儿童不能接触的地方。11.如正在使用其他药品，使用本品前请咨询医师或药师。',
'药用铝塑板，每板9片。',
'密封。'
);

#新增药品信息
insert into Medicine values(
'Z243645645',
'测试药品56765',
false,
'仙鹤草、黄连、木香、蝉蜕、石菖蒲、桔梗',
'本品为薄膜衣片，除去包衣片后显棕黄色至褐棕色；味苦、涩',
'口服',
'清热燥湿，抗菌消炎。用于菌痢，胃肠炎等',
'每片重0.4g',
'口服，一次3片，一日3次。',
'尚不明确。',
'尚不明确。',
'尚不明确。',
'药用铝塑板，2板，每板3X6片。',
'密封。'
);

#新增药品信息
insert into Medicine values(
'Z443475477',
'测试药品6578',
false,
'苦参，甲氧苄氨嘧啶',
'本品为糖衣片，除去糖衣后显棕色；味苦',
'口服',
'清热燥湿，健脾止泻。用于脾虚湿热内蕴所致的泄泻急迫，泻而不爽，或大便溏泻，食少倦怠，腹胀腹痛。',
'每片重0.4g',
'口服一次4-6片，一日3次',
'孕妇、哺乳期妇女禁用。',
'尚不明确。',
'1.饮食宜清淡，忌食辛辣、生冷、油腻食物。2.不宜在服药期间同时服用滋补性中药。3.有慢性结肠炎、溃疡性结肠炎便脓血等慢性病史者，患泄泻后应去医院就诊。4.有高血压、心脏病、糖尿病、肝病、肾病等慢性病严重者应在医师指导下服用。5.服药3天症状无缓解，应去医院就诊。6.严格按用法用量服用，儿童、年老体弱者应在医师指导下服用。7.对本品过敏者禁用，过敏体质者慎用。8.本品性状发生改变时禁止使用。9.儿童必须在成人监护下使用。10.请将本品放在儿童不能接触的地方。11.如正在使用其他药品，使用本品前请咨询医师或药师。',
'药用铝塑板，每板9片。',
'密封。'
);
#新增药品信息
insert into Medicine values(
'T245633455',
'测试药品766',
false,
'仙鹤草、黄连、木香、蝉蜕、石菖蒲、桔梗',
'本品为薄膜衣片，除去包衣片后显棕黄色至褐棕色；味苦、涩',
'口服',
'清热燥湿，抗菌消炎。用于菌痢，胃肠炎等',
'每片重0.4g',
'口服，一次3片，一日3次。',
'尚不明确。',
'尚不明确。',
'尚不明确。',
'药用铝塑板，2板，每板3X6片。',
'密封。'
);


#新增药品信息
insert into Medicine values(
'X44090906',
'中华神药',
true,
'苦参，甲氧苄氨嘧啶',
'本品为糖衣片，除去糖衣后显棕色；味苦',
'口服',
'清热燥湿，健脾止泻。用于脾虚湿热内蕴所致的泄泻急迫，泻而不爽，或大便溏泻，食少倦怠，腹胀腹痛。',
'每片重0.4g',
'口服一次4-6片，一日3次',
'孕妇、哺乳期妇女禁用。',
'尚不明确。',
'1.饮食宜清淡，忌食辛辣、生冷、油腻食物。2.不宜在服药期间同时服用滋补性中药。3.有慢性结肠炎、溃疡性结肠炎便脓血等慢性病史者，患泄泻后应去医院就诊。4.有高血压、心脏病、糖尿病、肝病、肾病等慢性病严重者应在医师指导下服用。5.服药3天症状无缓解，应去医院就诊。6.严格按用法用量服用，儿童、年老体弱者应在医师指导下服用。7.对本品过敏者禁用，过敏体质者慎用。8.本品性状发生改变时禁止使用。9.儿童必须在成人监护下使用。10.请将本品放在儿童不能接触的地方。11.如正在使用其他药品，使用本品前请咨询医师或药师。',
'药用铝塑板，每板9片。',
'密封。'
);

#新增药品信息
insert into Medicine values(
'N44453477',
'测试药品99',
false,
'苦参，甲氧苄氨嘧啶',
'本品为糖衣片，除去糖衣后显棕色；味苦',
'口服',
'清热燥湿，健脾止泻。用于脾虚湿热内蕴所致的泄泻急迫，泻而不爽，或大便溏泻，食少倦怠，腹胀腹痛。',
'每片重0.4g',
'口服一次4-6片，一日3次',
'孕妇、哺乳期妇女禁用。',
'尚不明确。',
'1.饮食宜清淡，忌食辛辣、生冷、油腻食物。2.不宜在服药期间同时服用滋补性中药。3.有慢性结肠炎、溃疡性结肠炎便脓血等慢性病史者，患泄泻后应去医院就诊。4.有高血压、心脏病、糖尿病、肝病、肾病等慢性病严重者应在医师指导下服用。5.服药3天症状无缓解，应去医院就诊。6.严格按用法用量服用，儿童、年老体弱者应在医师指导下服用。7.对本品过敏者禁用，过敏体质者慎用。8.本品性状发生改变时禁止使用。9.儿童必须在成人监护下使用。10.请将本品放在儿童不能接触的地方。11.如正在使用其他药品，使用本品前请咨询医师或药师。',
'药用铝塑板，每板9片。',
'密封。'
);


#新增药品信息
insert into Medicine values(
'Z20080195',
'复方仙鹤草肠炎片',
false,
'仙鹤草、黄连、木香、蝉蜕、石菖蒲、桔梗',
'本品为薄膜衣片，除去包衣片后显棕黄色至褐棕色；味苦、涩',
'口服',
'清热燥湿，抗菌消炎。用于菌痢，胃肠炎等',
'每片重0.4g',
'口服，一次3片，一日3次。',
'尚不明确。',
'尚不明确。',
'尚不明确。',
'药用铝塑板，2板，每板3X6片。',
'密封。'
);

#新增药品信息
insert into Medicine values(
'Z44021906',
'消炎止痢灵片',
false,
'苦参，甲氧苄氨嘧啶',
'本品为糖衣片，除去糖衣后显棕色；味苦',
'口服',
'清热燥湿，健脾止泻。用于脾虚湿热内蕴所致的泄泻急迫，泻而不爽，或大便溏泻，食少倦怠，腹胀腹痛。',
'每片重0.4g',
'口服一次4-6片，一日3次',
'孕妇、哺乳期妇女禁用。',
'尚不明确。',
'1.饮食宜清淡，忌食辛辣、生冷、油腻食物。2.不宜在服药期间同时服用滋补性中药。3.有慢性结肠炎、溃疡性结肠炎便脓血等慢性病史者，患泄泻后应去医院就诊。4.有高血压、心脏病、糖尿病、肝病、肾病等慢性病严重者应在医师指导下服用。5.服药3天症状无缓解，应去医院就诊。6.严格按用法用量服用，儿童、年老体弱者应在医师指导下服用。7.对本品过敏者禁用，过敏体质者慎用。8.本品性状发生改变时禁止使用。9.儿童必须在成人监护下使用。10.请将本品放在儿童不能接触的地方。11.如正在使用其他药品，使用本品前请咨询医师或药师。',
'药用铝塑板，每板9片。',
'密封。'
);




/*==============================================================*/
/* 3 Table: 药品库存     MedicineStorage                        */
/*==============================================================*/
drop table if exists MedicineStorage;

create table MedicineStorage(
	msto_id_PK						int(10) NOT NULL AUTO_INCREMENT   COMMENT '【主键】药品库存编号',
	msto_cmpn_FK					varchar(10)  NOT NULL             COMMENT '【外键】国家药品准字号(Country Medicine Permit Number)',  
   msto_name                  varchar(254) NOT NULL             COMMENT '药品品名',
   msto_batchNum					varchar(20)  NOT NULL	          COMMENT '生产批次号(数据引用：药品销售记录)',
   msto_manufcName            varchar(254) NOT null             COMMENT '生产企业名',
   msto_recomdPrice           decimal(5,2) NOT NULL             COMMENT '厂家推荐销售价格（单位：元）',
   msto_productTele		      varchar(13)                       COMMENT '厂商联系电话',
   msto_productFax				varchar(13)                       COMMENT '厂家传真号码',
   msto_productAddr				varchar(254)                      COMMENT '生产地址',		
   msto_elecMonitCode			char(20) NOT NULL DEFAULT '00000000000000000000' COMMENT '电子监管码(0值：无监管码)',	
   msto_productDate				date NOT null                     COMMENT '生产日期(数据来源：采购记录)',
   msto_expireDate				date NOT NULL                     COMMENT '有效日期(数据来源：采购记录)',
   msto_sotorageNum				int NOT NULL DEFAULT 0            COMMENT '库存数目（数据影响方：药品销售记录）',
   FOREIGN KEY(msto_cmpn_FK) 	REFERENCES Medicine(mdcn_cmpn_PK), 
   PRIMARY KEY(msto_id_PK)	
)ENGINE = InnoDB COMMENT='药品库存表(MedicineStorage):同一个国药准字号的药品，有0-n种不同生产批次的药品;一种药品可以有库存，也可以没有库存。';

insert into MedicineStorage values(
	0000000001,
	'Z20080195',
	'复方仙鹤草肠炎片',
	'201602003',
	'鹤壁市中药有限公司',
	18.23,
	'0392-2160058',
	'0392-2437969',
	'鹤壁市鹤俊路中段',
	'83255550001986140553',
	'2016-02-18',
	'2018-01-01',
	98
);

insert into MedicineStorage values(
	0000000002,
	'Z44021906',
	'消炎止痢灵片',
	'4140022',
	'广州白云山制药有限公司',
	12.00,
	'020-87063679',
	'020-87061739',
	'广东广州市广州市广州大道北',
	'00000000000000000000',
	'2015-11-23',
	'2017-11-23',
	203
);

insert into MedicineStorage values(
	0000000003,
	'Z19991005',
	'蓝芩口服液',
	'42048607',
	'扬子江药业集团',
	40.00,
	'0523-86983550',
	'020-87061739',
	'江苏省泰州市高港区扬子江路1号',
	'00000000000000000000',
	'2016-02-11',
	'2018-02-01',
	63
);

##################################################################

/*==============================================================*/
/* 4 Table: 采购项目                                            */
/*==============================================================*/
DROP TABLE IF EXISTS PurchaseProject;

CREATE TABLE PurchaseProject  
(
   ppro_id_PK   		CHAR(11) NOT NULL					         COMMENT '【主键】采购项目编号：时间(8)+顺序号(3)',
   ppro_name          	VARCHAR(50) NOT NULL				      COMMENT '项目名称',
   ppro_desc          	VARCHAR(255) NOT NULL DEFAULT '无'	COMMENT '对项目的一个简单概述',
   ppro_sponsorId_FK    varCHAR(30) NOT NULL  			      COMMENT '【外键】发起者编号（通常:店长）',
   ppro_startTime       TIMESTAMP NOT NULL DEFAULT now() 	COMMENT '项目发起时间',
   ppro_endTime         DATETIME  NOT NULL DEFAULT '2038-01-01 00:00:00' COMMENT '截止时间由 店长自行设置(默认：最迟时间)',
   ppro_seek			INT(4)	NOT NULL  					      COMMENT '采购项目下记录的种子值,手动增长', 
   ppro_state           INT  NOT NULL DEFAULT 1 			   COMMENT '项目状态：1：激活状态 0：关闭状态', 
   FOREIGN KEY(ppro_sponsorId_FK) REFERENCES Staff(staf_accountId_PK), 
   PRIMARY KEY(ppro_id_PK)		
)ENGINE = InnoDB COMMENT='采购项目表(PurchaseProject)';  


insert into PurchaseProject values(
	'20170608001',
	'日常采购计划-0608',
	'无',
	'admin001',
	'2017-06-08 13:26:00',
	'2038-01-01 00:00:00',
	1,
	1
);

##################################################################

/*==============================================================*/
/* 5 Table: 采购记录   PurchaseRecord                           */
/*==============================================================*/
DROP TABLE IF EXISTS PurchaseRecord;

CREATE TABLE PurchaseRecord
(
   prcd_id_PK       		   	int(10) 	NOT NULL AUTO_INCREMENT  			COMMENT '【主键】采购记录编号：自动增长',
   prcd_purchaserId_FK     		VARCHAR(30) NOT NULL							COMMENT '【外键】采购者编号：账号（8）：入职日期（6，年（4）+月（2））+员工顺序号（2）',
   prcd_finishTime              DATETIME NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT '采购项(记录)的完成时间',
   prcd_isFinish               	BOOL 		 NOT NULL DEFAULT '0'  				COMMENT '采购记录完成状态 1:已经完成 0（false）：待完成',
   prcd_cmpn_FK                 VARCHAR(10)  NOT NULL							COMMENT '【外键】国药准字号（长度限制在9-10位数）',
   prcd_productNum              VARCHAR(10)  NOT NULL   DEFAULT '0000000000'    COMMENT '生产批次号',
   prcd_medicineName            VARCHAR(50)	 NOT NULL	DEFAULT '尚未可知' 		COMMENT '药品品名 ',
   prcd_type                   	VARCHAR(1) 	 NOT NULL	DEFAULT '0'     		COMMENT '药品型号',
   prcd_price 	                DECIMAL(5,2) NOT NULL	DEFAULT	'0.00'	  	    COMMENT '采购价格',
   prcd_productDate             DATE 		 NOT NULL   DEFAULT '1970-01-01 00:00:00' COMMENT '生产日期(8):(YYYY-MM-DD)（数据引用：药品库存）',
   prcd_expireDate	            DATE 		 NOT NULL   DEFAULT '1970-01-01 00:00:00' COMMENT '有效截止日期（数据引用：药品库存）',
   prcd_medicineNum             INT 		 NOT NULL   DEFAULT '0'					  COMMENT '药品数目',
   FOREIGN KEY(prcd_purchaserId_FK) REFERENCES Staff(staf_accountId_PK), 
   FOREIGN KEY(prcd_cmpn_FK) REFERENCES Medicine(mdcn_cmpn_PK), 
   PRIMARY KEY(prcd_id_PK)	
)ENGINE = InnoDB COMMENT='采购记录';

insert into PurchaseRecord(
	prcd_id_PK,
	prcd_purchaserId_FK,
	prcd_finishTime,
	prcd_isFinish,
	prcd_cmpn_FK
) 
values(
	'0000000001',
	'admin001',
	'2017-06-09 12:01',
	'0',
	'Z20080195'
);

##################################################################

/*==============================================================*/
/* 6 Table: 顾客表   Customer	                                */
/*==============================================================*/

create table Customer(
   cstm_accountId_PK                VARCHAR(30) NOT NULL  					COMMENT'【主键】账号（8）：服务器端插入(0000000000 视为匿名顾客)',
   cstm_password                   	VARCHAR(10) NOT NULL DEFAULT '123456' 	COMMENT '密码(10)', 
   cstm_userType                 	TINYINT NOT NULL DEFAULT '0'			COMMENT '顾客类型:0 普通顾客 1 会员顾客 ',
   cstm_realName                   	VARCHAR(50) NOT NULL DEFAULT '匿名顾客' COMMENT '顾客真实姓名',
   cstm_sex                   		CHAR(1) NOT NULL DEFAULT 'M', 
   cstm_accountState          		BOOL NOT NULL DEFAULT '1' 				COMMENT '顾客账号状态：1(true) 激活; 0 锁定(视为注销 or 账户被禁用)', 
   cstm_telephone                 	VARCHAR(13)								COMMENT '顾客联系电话',		
   cstm_age							TINYINT									COMMENT '年龄',
   cstm_consumpTotal				decimal(5,2) 		 NOT NULL 			COMMENT '消费总额(单位：元)',
   PRIMARY key(cstm_accountId_PK)
)ENGINE = InnoDB;

select * from customer;

#创建匿名顾客账号
insert into Customer values(
	'0000000000',
	'123456',
	'0',
	'匿名顾客',
	'M',
	'1',
	'00000000000',
	'-1',
	0.00
)	

#创建普通顾客账号
insert into Customer values(
	'cust001',
	'123456',
	'0',
	'罗雪',
	'F',
	'1',
	'00000000000',
	'20',
	36.46 #2盒复方仙鹤草
)

##################################################################

/*==============================================================*/
/* 7 Table: 药品销售记录	MSaleRecord			                */
/*==============================================================*/
drop table if EXISTS MSaleRecord;

create table MSaleRecord(
	msrd_id_PK 		char(32)   				 					COMMENT '【主键】药品销售记录编号【使用UUID创建】',
	msrd_cmpn_FK  	varchar(10)  	NOT NULL					COMMENT '【外键】国药准字号',
	msrd_batchNum	varchar(20)  	NOT NULL	   				COMMENT '生产批次号(数据来源：药品库存表-药品生产批次号)',
	msrd_saleDate	DATETIME		NOT NULL DEFAULT now()		COMMENT '销售时间',
	msrd_name		varchar(254)    NOT NULL  					COMMENT '药品品名(数据来源：药品库存表 或者 营业员自填)',
	msrd_saleNum    int         	NOT NULL 					COMMENT '销售数目',
	msrd_salePrice	decimal(5,2)	NOT NULL 					COMMENT '销售价格（可能与厂商推荐价格不一样，默认：推荐价格）',
	msrd_customerId_FK	varchar(30) NOT NULL					COMMENT '【外键】顾客账号（8）：自动增长(0000000000 视为匿名顾客)',
	msrd_salerId_FK	varchar(30)		NOT NULL   			 		COMMENT '【外键】销售员账号（8）：服务器端插入',	
	FOREIGN KEY(msrd_cmpn_FK) 		REFERENCES Medicine(mdcn_cmpn_PK),
	FOREIGN KEY(msrd_customerId_FK) 	REFERENCES Customer(cstm_accountId_PK),
	FOREIGN KEY(msrd_salerId_FK) 		REFERENCES Staff(staf_accountId_PK),
	PRIMARY KEY(msrd_id_PK) 
)ENGINE = InnoDB;


insert into MSaleRecord values(
	'00000000000000000000000000000001',
	'Z20080195',
	'201602003',
	'2017-06-08 14:45:13',
	'复方仙鹤草肠炎片',
	2,
	18.23,
	'cust001',
	'staff002'
);

insert into MSaleRecord values(
	'00000000000000000000000000000002',
	'Z44021906',
	'4140022',
	'2017-06-14 10:34:09',
	'消炎止痢灵片',
	1,
	12.00,
	'cust001',
	'staff002'
);

insert into MSaleRecord values(
	'00000000000000000000000000000003',
	'Z19991005',
	'42048607',
	'2017-06-01 17:03:59',
	'蓝芩口服液',
	5,
	40.00,
	'cust001',
	'staff002'
);

use medicinems



alter table Customer modify column cstm_telephone varchar(13); 
alter table Staff modify column staf_telephone varchar(13); 

use medicinems

select * from customer

select * from staff

update Staff set staf_password='1486'

insert into staff values('staff008','123456','1','林晓晓','F','1','1837868338');








#注册申请表

create table Register(
	rgst_id_PK 		char(32)  not null primary KEY 		COMMENT '【主键】注册账户的申请者的编号[使用UUID创建]', 
	rgst_email 		varchar(254) not null        			COMMENT '注册者申请的邮箱地址',
	rgst_realName 	VARCHAR(50)            					COMMENT '申请者姓名',
	rgst_telephone  varchar(13)                        COMMENT '申请者电话',
	rgst_state      char(3)		 not null default '000' COMMENT '申请账号状态[000:仅申请，未处理 | 001：已经处理(发送邮箱)]',
	rgst_accountId  varchar(30)	 							COMMENT '【隐形外键】申请成功后的账户名[作为记录留存]'	                           
);

insert into register(rgst_id_PK,rgst_email,rgst_realName,rgst_telephone,rgst_state,rgst_accountId) values(
	'00000000000000000000000000000001',
	'1125418540@qq.com',
	'曾泰',
	'15202843104',
	'000',
	'/'
); 

a612322d0e554453858044a25716200a | johnnyztsd@gmail.com | 林小小        | 18937907076    | 000        | /
b11512bb9ae34bc39bb83451f4fda9f5 | 34543646@qq.com      | 黄琳琳        | 1837878998     | 000        | /

#用户反馈表

create table FeedBack(
   fdbc_id_PK     char(32)     not null primary KEY      COMMENT '【主键】用户反馈记录的编号[使用UUID创建]', 
   fdbc_email     varchar(254)                           COMMENT '用户的邮箱地址',
   fdbc_realName  VARCHAR(50)                            COMMENT '用户姓名',
   fdbc_telephone varchar(13)                            COMMENT '用户电话',
   fdbc_message   varchar(255)                           COMMENT  '用户反馈的消息',
   fdbc_readState char(3)       default '000'            COMMENT '反馈记录阅读状态：000未读 001：已读',                            
   fdbc_sendDate  datetime      not null  DEFAULT now()  COMMENT '反馈消息创建时间'    
);

insert into FeedBack values(
   '00000000000000000000000000000001',
   '1119611545@qq.com',
   '黄慧敏',
   '18678787786',
   '这软件还是有很多瑕疵嘞。比如说：这账户为什么不能当场申请？55555555~',
   '000',
   '2017-06-21 20:46'
); 




#END
###############################################################################
#**************************** THANK YOU **************************************#
###############################################################################