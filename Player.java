package com.oaxdes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Player {
    private String pname = "";
    private String pSimbolo = "";
    private ArrayList<Integer> jugados = new ArrayList<Integer>();
    private int turns=0;


    public Player (String name, String simbol){
        this.pname= name;
        this.pSimbolo = simbol;
    }

    public String getPname() {
        return pname;
    }
    public String getPsimbolo(){
        return pSimbolo;
    }
    public void setTurns(){this.turns++;}
    public int getTurns(){ return this.turns; }
    public void getjugados(){ System.out.println(jugados); }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public void setJugados(int move) {
        this.jugados.add(move);
        getjugados();
    }

    public int turn()throws IOException{
        int spot = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Choose next move "+ this.pname +": ");
        try{
            spot = Integer.parseInt(br.readLine());
            System.out.println("Processing");

        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }
        return spot;

    }
}
