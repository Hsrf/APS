package com.aps.aula11;
import java.sql.*;

// https://refactoring.guru/design-patterns/singleton

public final class Singleton_SQL {
    protected Connection connected_instance  = null;
    protected String dbName = "banco.db";

    public void connectOrInstance(){
        if(connected_instance != null){
            return;
        }
        try{
            Class.forName("org.sqlite.JDBC");
            connected_instance = DriverManager.getConnection("jdbc:sqlite:" + dbName);
        } catch(ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public boolean tableExists(String tableName){
        connectOrInstance();
        try{
            DatabaseMetaData md = connected_instance.getMetaData();
            ResultSet rs = md.getTables(null, null, tableName, null);
            rs.last();
            return rs.getRow() > 0;
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

}
