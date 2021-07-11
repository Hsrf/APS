package com.aps.aula11;
import java.util.ArrayList;

public interface IRepositoryUser extends AbstractFactory_Repository {
    public ArrayList<User> getUsers();

    // https://www.devmedia.com.br/java-interface-aprenda-a-usar-corretamente/28798
    // public void main(){
    //     getUsers();
    //     System.out.println("Interface de Repositório e User iniciada!");
    // }
}