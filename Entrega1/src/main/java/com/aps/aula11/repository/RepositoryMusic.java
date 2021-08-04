package com.aps.aula11;
import java.sql.*;
import com.aps.aula11.SingletonSQL;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositoryMusic {
    
    public static byte[] readFile(String file) {
        ByteArrayOutputStream bos = null;
        try {
            File f = new File(file);
            FileInputStream fis = new FileInputStream(f);
            byte[] buffer = new byte[1024];
            bos = new ByteArrayOutputStream();
            for (int len; (len = fis.read(buffer)) != -1;) {
                bos.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e2) {
            System.err.println(e2.getMessage());
        }
        return bos != null ? bos.toByteArray() : null;
    }

    public static FileOutputStream findAll(String busca){
        SingletonSQL sql = SingletonSQL.connectOrInstance();
        // try {
        //     Statement statement = sql.connected_instance.createStatement();
        //     statement.execute("CREATE TABLE IF NOT EXISTS MUSIC( TITLE VARCHAR NOT NULL, FILE BLOB UNIQUE )");
        //     String inserirMusica = "INSERT into MUSIC(TITLE, FILE)" + "values (?,?)";
        //     PreparedStatement pstmt = sql.connected_instance.prepareStatement(inserirMusica);
        //     pstmt.setBytes(1, readFile("/home/vitor/Documentos/APS/Projeto/APS/Entrega1/src/main/resources/songs/Ludwig van Beethoven - Symphony Number 9.mp3"));
        //     pstmt.setString(2, "Ludwig van Beethoven - Symphony Number 9");
        //     pstmt.executeUpdate();
        //     System.out.println("Inseri música no banco");
        // } catch (Exception e){
        //     System.out.println(e.getMessage());
        // }
        ResultSet resultSet;
        try {
            PreparedStatement stmt = sql.connected_instance.prepareStatement(
                    "SELECT FILE " +
                    "FROM MUSIC " +
                    "WHERE TITLE = '" + busca + "'" +
                    ";"
                );
                resultSet = stmt.executeQuery();
                System.out.println("Achei a música no banco");
                int iteracao = 0;
                FileOutputStream fos = null;
                while (resultSet.next()) { 
                    File fileMusic = new File("music" + iteracao + "_.mp3"); 
                    fos = new FileOutputStream(fileMusic); 
          
                    byte[] buffer = new byte[1];         
                    InputStream is = resultSet.getBinaryStream(2); 
                    while (is.read(buffer) > 0) { 
                      fos.write(buffer); 
                    } 
                    fos.close(); 
                }
                return fos;
                // Codar adapter para que ele retorne várias, uma ou nenhuma música.
                // Aparentemente o esse return ai está matando a query, então tem que retornar esse adapter já prontinho.
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        // return resultSet;
    }
}