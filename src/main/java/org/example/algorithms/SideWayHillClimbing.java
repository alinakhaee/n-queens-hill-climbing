package org.example.algorithms;

import org.example.model.State;
import org.example.utils.Utils;

import java.util.ArrayList;
import java.util.Random;

public class SideWayHillClimbing {

    public static State runNQueenWithSideWayHillClimbing(int n, int maximumSideWayMoves) {
        ArrayList<Integer> initialPlacement = Utils.initializeBoard(n);
        int initialConflicts = Utils.calculateConflicts(initialPlacement);
        State currentState = new State(initialPlacement, initialConflicts, 0);
        int sideWayMoves = 0;

        while (currentState.getNumberOfConflicts() > 0 && sideWayMoves <= maximumSideWayMoves) {
            State bestNeighbourState = getBestNeighbour(currentState);

            if (bestNeighbourState.getNumberOfConflicts() > currentState.getNumberOfConflicts()) {
                break;
            }
            if(bestNeighbourState.getNumberOfConflicts() == currentState.getNumberOfConflicts()){
                sideWayMoves++;
            } else {
                sideWayMoves = 0;
            }
            currentState = bestNeighbourState;
        }
        return currentState;
    }

    private static State getBestNeighbour(State state){
        int bestNeighbourConflicts = Integer.MAX_VALUE;
        ArrayList<State> bestStates = new ArrayList<>();
        for (int i = 0; i < state.getQueenPlaces().size(); i++) {
            int currentPlace = state.getQueenPlaces().get(i);

            for (int j = 0; j < state.getQueenPlaces().size(); j++) {
                if (j != currentPlace) {
                    ArrayList<Integer> neighbourQueenPlacement = new ArrayList<>(state.getQueenPlaces());
                    neighbourQueenPlacement.set(i, j);
                    int neighbourConflicts = Utils.calculateConflicts(neighbourQueenPlacement);
                    if (neighbourConflicts <= bestNeighbourConflicts) {
                        bestNeighbourConflicts = neighbourConflicts;
                    }
                }
            }
        }

        for (int i = 0; i < state.getQueenPlaces().size(); i++) {
            int currentPlace = state.getQueenPlaces().get(i);

            for (int j = 0; j < state.getQueenPlaces().size(); j++) {
                if (j != currentPlace) {
                    ArrayList<Integer> neighbourQueenPlacement = new ArrayList<>(state.getQueenPlaces());
                    neighbourQueenPlacement.set(i, j);
                    int neighbourConflicts = Utils.calculateConflicts(neighbourQueenPlacement);
                    if (neighbourConflicts == bestNeighbourConflicts) {
                        bestStates.add(new State(neighbourQueenPlacement, neighbourConflicts, state.getCost()+1));
                    }
                }
            }
        }
        return bestStates.get(new Random().nextInt(bestStates.size()));
    }
}
