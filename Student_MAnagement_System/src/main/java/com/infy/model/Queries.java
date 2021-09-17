package com.infy.model;

public interface Queries {

    String query1="Select * from Employee";
    String query2="upsert into Employee(key,value)values('7',{'Name':'David','Salary':234000})";
    String query3="Select * from Employee where Name='David'";
}
