package com.oaxdes;
import java.util.*;

public class Grid {
    private int Spaces = 9;
    private Player ActivePlayer= null;
    private Player DeactivePlayer= null;
    private Player Winner= null;
    private boolean End = false;
    private String row_1 = " 1 | 2 | 3 ";
    private String row_2 = " 4 | 5 | 6 ";
    private String row_3 = " 7 | 8 | 9 ";
    private String divider = "-----------";
    private ArrayList<Integer> played = new ArrayList<Integer>();

    private String win_1="1,2,3";
    private String win_2="1,4,7";
    private String win_3="2,5,8";
    private String win_4="3,6,9";
    private String win_5="3,5,7";
    private String win_6="4,5,6";
    private String win_7="7,8,9";
    private String win_8="9,5,1";

    public Grid(Player Player_one,Player Player_two){
        this.ActivePlayer = Player_one;
        this.DeactivePlayer = Player_two;
    }

    public int getSpaces() {
        return Spaces;
    }
    public Player getActivePlayer() { return ActivePlayer; }
    public void decreseSpaces(){
        this.Spaces = this.Spaces - 1;
   }
    public boolean getEnd(){ return this.End;}

    public void endTurn(){
        Player holder = this.ActivePlayer;
        this.ActivePlayer.setTurns();
        System.out.println(this.ActivePlayer.getTurns());
        if(this.ActivePlayer.getTurns() > 2){ this.declareWinner(); }
        this.ActivePlayer = this.DeactivePlayer;
        this.DeactivePlayer = holder;
    }

    private void declareWinner(){
        System.out.println("The Winner: " + this.ActivePlayer.getPname() + " Congratulation!!");
        this.End = true;
    }

    public boolean validatingMove(int move){
        boolean result = true;
        for(int i=0; i < this.played.size(); i++){
            if(move == this.played.get(i)){
                result = false;
                break;
            }
        }
        return result;
    }

    public void updateGrid(int spot, String mark){
        this.played.add(spot);
        this.ActivePlayer.setJugados(spot);
        if(spot < 4){ this.row_1 = this.row_1.replace(String.valueOf(spot), mark); }
        else if(spot < 7){ this.row_2 = this.row_2.replace(String.valueOf(spot), mark); }
        else if(spot < 10){ this.row_3 = this.row_3.replace(String.valueOf(spot), mark); }
        else{ System.out.println("Something went wrong"); }
    }

    public void printGird(){
        System.out.println("****** TIC-TAC-TOE ******");
        System.out.println(row_1);
        System.out.println(divider);
        System.out.println(row_2);
        System.out.println(divider);
        System.out.println(row_3);
    }

}
