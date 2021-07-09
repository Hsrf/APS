package com.aps.aula11;
import java.util.ArrayList;
import java.sql.*;
import com.aps.aula11.User;

public class RepositorioUser implements IRepositorioUser {
    // Como usar SQLite
    // Inserindo registros
    // statement.execute("INSERT INTO USER( EMAIL, SENHA ) VALUES ('VITOR', '123456'), ('CARLOS', '987654')");
    // Criando uma tabela
    // statement.execute("CREATE TABLE IF NOT EXISTS USER( EMAIL VARCHAR NOT NULL UNIQUE, SENHA NOT NULL UNIQUE, NICKNAME VARCHAR, ISVIP INTEGER, DURATIONVIP VARCHAR)");
    // Lendo os registros
    // PreparedStatement stmt = connection.prepareStatement("select * from USER");
    // ResultSet resultSet = stmt.executeQuery();

    @Override
    public ArrayList<User> getUsers(){
        ArrayList<User> array = new ArrayList<User>();
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:/home/vitor/Documentos/APS/Projeto/APS/Entrega1/src/main/resources/banco.db")) {
            Statement statement = connection.createStatement();
            System.out.println("Conexão realizada!");
            
            statement.execute("CREATE TABLE IF NOT EXISTS USER( EMAIL VARCHAR NOT NULL UNIQUE, PASSWORD VARCHAR NOT NULL UNIQUE, NICKNAME VARCHAR, ISVIP INTEGER, DURATIONVIP VARCHAR)");
            // statement.execute("INSERT INTO USER( EMAIL, PASSWORD, NICKNAME, ISVIP, DURATIONVIP ) VALUES ('vss2@cin.ufpe.br', '123456', 'Vitor', 0, '0/0/0'), ('carlos@cin.ufpe.br', '987654', 'Carlos', 1, '31/12/2021')");
            
            PreparedStatement stmt = connection.prepareStatement("select * from USER");
            ResultSet resultSet = stmt.executeQuery();


            while (resultSet.next()) {
                String email = resultSet.getString("EMAIL");
                String password = resultSet.getString("PASSWORD");
                String nickname = resultSet.getString("NICKNAME");
                Integer isVIP = resultSet.getInt("ISVIP");
                String[] data = resultSet.getString("DURATIONVIP").split("/");
                Date durationVIP = new Date(Integer.valueOf(data[0]), Integer.valueOf(data[1]), Integer.valueOf(data[2]));
                System.out.println("User do banco");
                System.out.printf(email, password, nickname, isVIP, durationVIP, "\n");

                array.add(new User(email, password, nickname, isVIP, durationVIP));
                // System.out.println("User identificado: " + nome);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return array;
        }
    
    public void main(){
        System.out.println("Repositório criado");
    }
}