package bank.managment.system;

import java.sql.*;
public class Connection {
    java.sql.Connection con;
    Statement statement;
    public Connection(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atmSystem","root","082002");
            statement = con.createStatement();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
