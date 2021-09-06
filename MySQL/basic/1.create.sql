# 创建库
# CREATE DATABASE dbname;
# create database learn;

# 创建表
# CREATE TABLE table_name
# (
# column_name1 data_type(size),
# column_name2 data_type(size),
# column_name3 data_type(size),
# ....
# );

# CREATE TABLE learn.Persons
# (
#     PersonID  int,
#     LastName  varchar(255),
#     FirstName varchar(255),
#     Address   varchar(255),
#     City      varchar(255)
# );

# CREATE TABLE learn.Children
# (
#     PersonID int,
#     ParentID int,
#     JsonObj  json
# );