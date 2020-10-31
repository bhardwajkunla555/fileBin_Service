# Spring-boot-application
Run this applicaton with 9190 server port for using backend services

Dont forget to make upload and downlaoad folder in local directory and specify path in "appication.properties"
Changes to be done in application.properties for local Directory:-

fileBin.uploadDir=E://fileBin//upload//
fileBin.downloadDir=E://fileBin//download//



This Application also establish connection with mysql so change application.properties accordingly
Changes to be done in application.properties for MySql Connection:-

viva.db.host=localhost
viva.db.port=3306
viva.db.schema=viva_holidays_test
spring.datasource.username=root
spring.datasource.password=pass123



Mysql table Schema:-

create table file_table (
    id int auto_increment,
    file_name varchar(50),
    unique_key varchar(20),
    created_by varchar(50),
    created_ts datetime default CURRENT_TIMESTAMP,
    updated_by varchar(50),
    updated_ts datetime ,
    primary key (id)
);

