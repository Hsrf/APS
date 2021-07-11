package com.aps.aula11;
import java.util.Deque;
import java.util.ArrayDeque;
import com.aps.aula11.Playlist;
import com.aps.aula11.Singleton_SQL;
import java.sql.*;

public class RepositoryPlaylist implements IRepositoryPlaylist {

    @Override
	public Deque<Integer> getMusicsFromPlaylist(int playlistId){
        Deque<Integer> deque= new ArrayDeque<Integer>();
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:/home/vitor/Documentos/APS/Projeto/APS/Entrega1/src/main/resources/banco.db")) {
            Statement statement = connection.createStatement();
            
            statement.execute("CREATE TABLE IF NOT EXISTS PLAYLIST( PLAYLISTID INT PRIMARY KEY, NAME VARCHAR NOT NULL, OWNERID NOT NULL, ISPRIVATE INT NOT NULL )");
            statement.execute("CREATE TABLE IF NOT EXISTS PLAYLISTMUSICS( PLAYLISTID INT NOT NULL, MUSICID INT NOT NULL)");
            
            // statement.execute("INSERT INTO PLAYLIST( NAME, OWNERID, ISPRIVATE ) VALUES ('BREGA', 0, 0), ('MPB', 1, 1)");

            System.out.println("Conexão banco de playlists e playlistmusics realizada!");
            
            // PreparedStatement stmt = connection.prepareStatement(String.format("select * from PLAYLIST WHERE (PLAYLISTID = %i)", playlistId));
            // ResultSet resultSet = stmt.executeQuery();
            PreparedStatement stmt = connection.prepareStatement(String.format("select * from PLAYLISTMUSICS WHERE (PLAYLISTID = %i)", playlistId));
            ResultSet resultSet = stmt.executeQuery();
            
            while (resultSet.next()) {
                int musicId = resultSet.getInt("MUSICID");
                System.out.println("Música do banco playlistmusics");
                System.out.printf("%i",musicId, "\n");
                deque.add(musicId);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return deque;
	}
	
}