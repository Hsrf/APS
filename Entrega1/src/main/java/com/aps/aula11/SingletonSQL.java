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

public final class SingletonSQL {
    private static SingletonSQL INSTANCE;
    public static Connection connected_instance;
    private static String vitorDatabasePath = "/home/vitor/Documentos/APS/Projeto/APS/Entrega1/src/main/resources/banco.db";
    private static String teixaDatabasePath = "/Meus Documentos/Documentos/Códigos/APS/APS/Entrega1/src/main/resources/banco.db";
    private static String hugoDatabasePath = "/home/hsrf/Desktop/PersonalProjects/APS/Entrega1/src/main/resources/banco.db";
    private static String dbName = vitorDatabasePath;

    private SingletonSQL(String dbName){
        try {
            this.connected_instance = DriverManager.getConnection("jdbc:sqlite:" + dbName);
        } catch (Exception e) {
            System.out.println("Erro no construtor: "+e);
        }
    }

    public static SingletonSQL connectOrInstance(){
        if(connected_instance == null){
            try {
                connected_instance = DriverManager.getConnection("jdbc:sqlite:" + dbName);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            return INSTANCE;
        }
        System.out.println("O Singleton está funcionando!");
        try{
            Class.forName("org.sqlite.JDBC");
        } catch(Exception e) {
            System.err.println(e.getMessage());
        } finally {
            return INSTANCE;
        }
    }
}
