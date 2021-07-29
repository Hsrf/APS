package com.aps.aula11;
import java.sql.*;

// https://refactoring.guru/design-patterns/singleton
// public final class Singleton_SQL {
//     protected Connection connected_instance  = null;
//     protected String dbName = "banco.db";
//     public void connectOrInstance(){
//         if(connected_instance != null){
//             return;
//         }
//         try{
//             Class.forName("org.sqlite.JDBC");
//             connected_instance = DriverManager.getConnection("jdbc:sqlite:" + dbName);
//         } catch(ClassNotFoundException | SQLException e) {
//             System.err.println(e.getClass().getName() + ": " + e.getMessage());
//         }
//     }
//     public boolean tableExists(String tableName){
//         connectOrInstance();
//         try{
//             DatabaseMetaData md = connected_instance.getMetaData();
//             ResultSet rs = md.getTables(null, null, tableName, null);
//             rs.last();
//             return rs.getRow() > 0;
//         } catch(SQLException ex) {
//             System.out.println(ex.getMessage());
//         }
//         return false;
//     }
// }

public final class Singleton_SQL {
    private static Singleton_SQL INSTANCE;
    public Connection connected_instance;
    private String dbName = "banco.db";

    public Singleton_SQL(String dbName){
        try {
            this.connected_instance = DriverManager.getConnection("jdbc:sqlite:" + dbName);
        } catch (Exception e) {
            System.out.println("Erro no construtor: "+e);
        }
        this.dbName = dbName;
    }

    public Connection connectOrInstance(){
        if(connected_instance != null){
            try {
                this.connected_instance = DriverManager.getConnection("jdbc:sqlite:" + dbName);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            return this.connected_instance;
        }
        System.out.println("O Singleton está funcionando!");
        try{
            Class.forName("org.sqlite.JDBC");
        } catch(Exception e) {
            System.err.println(e.getMessage());
        } finally {
            return connected_instance;
        }
    }
}
