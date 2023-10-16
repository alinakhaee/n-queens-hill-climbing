package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class State {
    private ArrayList<Integer> queenPlaces;
    private int numberOfConflicts;
    private int cost;

    @Override
    public String toString(){
        return queenPlaces.toString();
    }
}
