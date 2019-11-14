# Hive JDBC Storage Handler
Hive作为数据仓库的重要工具, 特别适合处理大数据场景的计算. 但是在实际的工作中, 会发现也会有数据量不大但是经常需要更新的情况. 
由于目前已经通过Hive的API实现了Hive on Phoenix/ElasticSearch/HBase等组件. 基于此, 我们也在寻找可以通过Hive操作MySQL的方式.
在Hive的源码中已经有相关的实现, 但是美中不足的是不支持我们正在使用的Hive 1.2.1版本. 
所以本仓库是将Hive的`jdbc-storage`包独立出来再进行修改的项目, 旨在支持低版本的Hive.

## 如何使用

### 打包
```
$ git clone https://github.com/bekylin/hive-jdbc-storage-handler.git 
$ mvn package
```

### 配置
1. 上传打包好的jar包到

`hdfs:///the/path/your/jdbc-storage-handler.jar`

由于本组件使用了DBCP数据库连接池, 需要下载相关依赖jar包. 点击下载: 

- [commons-dbcp2-2.6.0.jar](https://repo1.maven.org/maven2/org/apache/commons/commons-dbcp2/2.6.0/commons-dbcp2-2.6.0.jar)
- [commons-pool2-2.6.1.jar](https://repo1.maven.org/maven2/org/apache/commons/commons-pool2/2.6.1/commons-pool2-2.6.1.jar)

将下载的jar包放入Hive Server2的lib文件夹下. 总之可以让Hive Server2 可以正常取到即可.

### SQL语句例子 / Sample of SQL.
#### 1. 建表
```sql
add jar 
-- 建表语句
CREATE EXTERNAL TABLE hive_mysql (
  blacklist_id BIGINT,
  id_card string,
  level BOOLEAN,
  add_time INT,
  real_name STRING,
  expo_id BIGINT
)
STORED BY 'org.apache.hive.storage.jdbc.JdbcStorageHandler'
TBLPROPERTIES (
    "hive.sql.database.type" = "MYSQL",
    "hive.sql.jdbc.driver" = "com.mysql.jdbc.Driver",
    "hive.sql.jdbc.url" = "jdbc:mysql://192.168.0.1/test",
    "hive.sql.dbcp.username" = "mysql_user",
    "hive.sql.dbcp.password" = "mysql_password",
    "hive.sql.table" = "mysql_table",
    "hive.sql.dbcp.maxActive" = "1"
);
```

#### 2. 查询 & 插入
```sql
--  插入 insert
add jar hdfs:///user/hive/hive-jdbc-handler-1.2.1.jar;
INSERT INTO TABLE kirin_mysql2
SELECT
    user_id as blacklist_id,
    pagename as id_card,
    CASE WHEN user_id > 0 THEN TRUE ELSE FALSE END as level,
    cityid as add_time,
    `index` as real_name,
    user_id as expo_id
from
    kirin_flow_log_orc2
LIMIT 1;
 
 
-- 查询 select
add jar hdfs:///user/hive/hive-jdbc-handler-1.2.1.jar;
select * from kirin_mysql2;
```

## 参考
- https://www.qubole.com/blog/hive-jdbc-storage-handler/
- https://github.com/qubole/Hive-JDBC-Storage-Handler
- https://cwiki.apache.org/confluence/display/Hive/JdbcStorageHandler
- https://jira.apache.org/jira/browse/HIVE-1555
- https://arjon.es/2014/integrating-mysql/rds-with-hive/
 