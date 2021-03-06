package com.aps.aula11;
import java.util.ArrayList;
import com.aps.aula11.Date;
import com.aps.aula11.Playlist;

public class User {
    private String email;
    private String password;
    private String nickname;
    private boolean isVIP;
    private Date durationVIP;
    private ArrayList<Playlist> playlists;
    private int userId;

    public User(String email, String password, String nickname, int isVIP, Date durationVIP){
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        if(isVIP == 0){
            this.isVIP = false;
        } else {
            this.isVIP = true;
        }
        this.durationVIP = durationVIP;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }

    public boolean getIsVIP(){
        return this.isVIP;
    }

    public void setIsVIP(boolean isVIP){
        this.isVIP = isVIP;
    }

	public ArrayList<Playlist> getPlaylists() {
		return playlists;
	}

	public void addOnePlaylist(Playlist playlist) {
		this.playlists.add(playlist);
	}

	public int getUserId() {
		return userId;
	}
}