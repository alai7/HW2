package com.CSC340.HW2;

public class Cards {
    public String deck_id;
    public Double remaining;
    public Boolean shuffled;

    public Cards(String deck_id, Double remaining, Boolean shuffled) {
        this.deck_id = deck_id;
        this.remaining = remaining;
        this.shuffled = shuffled;
    }

    public String getDeck_id(){
        return deck_id;
    }

    public Double getRemaining(){
        return remaining;
    }

    public Boolean isShuffled(){
        return shuffled;
    }

    public void setDeck_id(String deck_id){
        this.deck_id = deck_id;
    }

    public void setRemaining(Double remaining){
        this.remaining = remaining;
    }

    public void setShuffled(Boolean shuffled){
        this.shuffled = shuffled;
    }

}
