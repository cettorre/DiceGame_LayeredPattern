package com.example.cettorre.dicegame_layeredpattern.domain;


public class Game {

    private Dice dice1;
    private Dice dice2;

    public Game(){
        dice1=new Dice();
        dice2=new Dice();
    }

    public int getSumDices(){
        return dice1.getValue()+dice2.getValue();
    }

    public void rollDices(){
        dice1.rollDice();
        dice2.rollDice();
    }

    public boolean hasWon() {
        return getSumDices()==7;
    }

    public Dice getDice1() {
        return dice1;
    }

    public Dice getDice2() {
        return dice2;
    }

    @Override
    public String toString() {
        return "Game{" +
                "dice1=" + dice1 +
                ", dice2=" + dice2 +
                '}';
    }
}