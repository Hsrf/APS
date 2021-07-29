package com.aps.aula11;
import java.util.ArrayList;
import java.util.Deque;
import java.sql.*;
import com.aps.aula11.SingletonSQL;
import com.aps.aula11.IRepositoryUser;
import com.aps.aula11.User;

public class RepositoryUser implements IRepositoryUser {
    // Como usar SQLite
    // Inserindo registros
    // Criando uma tabela
    // statement.execute("CREATE TABLE IF NOT EXISTS USER( EMAIL VARCHAR NOT NULL UNIQUE, SENHA NOT NULL UNIQUE, NICKNAME VARCHAR, ISVIP INTEGER, DURATIONVIP VARCHAR)");
    // Lendo os registros
    // PreparedStatement stmt = connection.prepareStatement("select * from USER");
    // ResultSet resultSet = stmt.executeQuery();

    public boolean getUser(String email, String password){
        boolean answer = false;
        String vitorDatabasePath = "/home/vitor/Documentos/APS/Projeto/APS/Entrega1/src/main/resources/banco.db";
        String teixaDatabasePath = "/Meus Documentos/Documentos/Códigos/APS/APS/Entrega1/src/main/resources/banco.db";
        String hugoDatabasePath = "/home/hsrf/Desktop/PersonalProjects/APS/Entrega1/src/main/resources/banco.db";

        try {
            SingletonSQL sql = SingletonSQL.connectOrInstance();
            PreparedStatement stmt = sql.connected_instance.prepareStatement(
                "SELECT EMAIL " +
                "FROM USER " +
                "WHERE EMAIL = '" + email + "'" +
                "AND PASSWORD = '" + password + "'" + 
                ";"
            );
            ResultSet resultSet = stmt.executeQuery();
            int size = 0;
            while(resultSet.next()){
                size++;
            }
            if(size == 0){
                answer = false;
            } else {
                answer = true;
            }

        } catch (SQLException e) { System.out.println(e.getMessage()); }
        
        if(!answer) System.out.printf("Login error: "+ email + " " + password + " " + "\n\n");
        return answer;

    }

    @Override
    public ArrayList<User> getUsers(){
        ArrayList<User> array = new ArrayList<User>();
        String vitorDatabasePath = "jdbc:sqlite:/home/vitor/Documentos/APS/Projeto/APS/Entrega1/src/main/resources/banco.db";
        String teixaDatabasePath = "jdbc:sqlite:E:/Meus Documentos/Documentos/Códigos/APS/APS/Entrega1/src/main/resources/banco.db";
        String hugoDatabasePath = "jdbc:sqlite:/home/hsrf/Desktop/PersonalProjects/APS/Entrega1/src/main/resources/banco.db";
        try (Connection connection = DriverManager.getConnection(vitorDatabasePath)) {
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO USER( EMAIL, PASSWORD ) VALUES ('teste@cin', 'teste')");
            statement.execute("CREATE TABLE IF NOT EXISTS USER( USERID INT PRIMARY KEY, EMAIL VARCHAR NOT NULL UNIQUE, PASSWORD VARCHAR NOT NULL UNIQUE, NICKNAME VARCHAR, ISVIP INTEGER, DURATIONVIP VARCHAR )");
            System.out.println("Conexão banco de users realizada!");
            
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
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return array;
        }
    
    public void main(){
        System.out.println("Repositório criado");
    }

	@Override
	public Deque<Integer> getMusicsFromPlaylist(int playlistId) {
		// TODO Auto-generated method stub
		return null;
	}

}