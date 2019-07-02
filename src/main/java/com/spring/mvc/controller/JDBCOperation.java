package com.spring.mvc.controller;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class JDBCOperation {

    static class Student {
        private String Id;
        private String Name;
        private String Sex;
        private String Age;

        Student(String id, String Name, String Sex, String Age) {
            this.Id = id; //default
            this.Name = Name;
            this.Sex = Sex;
            this.Age = Age;
        }

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getSex() {
            return Sex;
        }

        public void setSex(String Sex) {
            this.Sex = Sex;
        }

        public String getAge() {
            return Age;
        }

        public void setAge(String Age) {
            this.Age = Age;
        }
    }


    private static Connection getConn() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test1";
        String username = "root";
        String password = "123456";
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static int insert(Student student) {
        Connection conn = getConn();
        int i = 0;
        String sql = "insert into test1 (student_id,name,sex,age) values(?,?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getSex());
            pstmt.setString(4, student.getAge());
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }


    public static Map getAll(Map map) {
        Connection conn = getConn();
        String sql = "select * from test1";
        PreparedStatement pstmt;
        int k=1;


        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            System.out.println("============================");
            while (rs.next()) {
                for (int i = 1; i <= col; i++) {

                    System.out.print(rs.getString(i) + "\t");

                    if (k%4==0){
                        map.put(k,(rs.getString(i)+"\r"));
                        k++;
                    }else{
                        map.put(k,(rs.getString(i)));
                        k++;
                    }
                    if ((i == 2) && (rs.getString(i).length() < 8)) {
                        System.out.print("\t");
                    }
                }
                System.out.println("");
            }
            System.out.println("============================");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    }





