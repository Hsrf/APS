package com.aps.aula11;

public class Date {
    private int dia;
    private int mes;
    private int ano;

    public Date(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public Date getDate(){
        return new Date(this.dia, this.mes, this.ano);
    }

    public int getDia(){
        return this.dia;
    }

    public void setDia(int dia){
        this.dia = dia;
    }

    public int getMes(){
        return this.mes;
    }

    public void setMes(int mes){
        this.mes = mes;
    }

    public int getAno(){
        return this.ano;
    }

    public void setAno(int ano){
        this.ano=ano;
    }
}