package com.oaxdes;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Player P1 = new Player ("Zoa","X");
        Player P2 = new Player ("Near","O");
        Grid Juego = new Grid(P1,P2);

        Juego.printGird();

        try{
            do {
                int position = Juego.getActivePlayer().turn();
                if (Juego.validatingMove(position)) {
                    Juego.updateGrid(position, Juego.getActivePlayer().getPsimbolo());
                    Juego.decreseSpaces();
                    Juego.endTurn();
                    Juego.printGird();
                    if( Juego.getEnd()){break;}
                }
                else{
                    System.out.println("Sorry "+Juego.getActivePlayer().getPname()+" Spot already taken, try another one!");
                }
            }while(Juego.getSpaces() > 0 );
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
