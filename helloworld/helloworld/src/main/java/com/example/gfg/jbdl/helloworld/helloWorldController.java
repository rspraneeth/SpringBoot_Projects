package com.example.gfg.jbdl.helloworld;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController
public class helloWorldController {
    @RequestMapping("/")
    public String hello()
    {
        return "Hello User";
    }

    @RequestMapping(value = "/dbConnectionTest")
    public String dbConnectionTest(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "password");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from actor");
            while (rs.next()){
                System.out.println("ID is "+rs.getInt(1)+" and name is "+rs.getString(2));
            }
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return "API service is working";
    }
}



