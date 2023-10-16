package org.example;

import org.example.algorithms.HillClimbing;
import org.example.algorithms.SideWayHillClimbing;
import org.example.model.State;
import org.example.utils.Utils;

import java.util.ArrayList;

public class Main {
    static int NUMBER_OF_TRIES = 1000;
    static int MAXIMUM_SIDE_WAY_MOVES = 100;
    static int NUMBER_OF_QUEENS = 8;

    public static void main(String[] args) {
        int hillClimbingCorrectSolution = 0;
        ArrayList<Integer> hillClimbingCorrectSolutionsSteps = new ArrayList<>();
        int hillClimbingFailedSolution = 0;
        ArrayList<Integer> hillClimbingFailedSolutionsSteps = new ArrayList<>();
        for(int i=0 ; i< NUMBER_OF_TRIES ; i++){
            State state = HillClimbing.runNQueenWithHillClimbing(NUMBER_OF_QUEENS);
            if(state.getNumberOfConflicts() == 0){
                hillClimbingCorrectSolution++;
                hillClimbingCorrectSolutionsSteps.add(state.getCost());
//                System.out.println(state.getCost());
//                Utils.displaySolution(state.getQueenPlaces());
            } else{
                hillClimbingFailedSolution++;
                hillClimbingFailedSolutionsSteps.add(state.getCost());
            }
        }
        System.out.println("hill climbing rate of correct solutions: " + (1.0*hillClimbingCorrectSolution/NUMBER_OF_TRIES)*100);
        System.out.println("hill climbing rate of failed solutions: " + (1.0*hillClimbingFailedSolution/NUMBER_OF_TRIES)*100);
        System.out.println("hill climbing correct average steps: " + hillClimbingCorrectSolutionsSteps.stream().mapToInt(a->a).average());
        System.out.println("hill climbing failed average steps: " + hillClimbingFailedSolutionsSteps.stream().mapToInt(a->a).average());

        System.out.println();

        int sideWayCorrectSolution = 0;
        ArrayList<Integer> sideWayCorrectSolutionsSteps = new ArrayList<>();
        int sideWayFailedSolution = 0;
        ArrayList<Integer> sideWayFailedSolutionsSteps = new ArrayList<>();
        for(int i=0 ; i< NUMBER_OF_TRIES ; i++){
            State state = SideWayHillClimbing.runNQueenWithSideWayHillClimbing(NUMBER_OF_QUEENS, MAXIMUM_SIDE_WAY_MOVES);
            if(state.getNumberOfConflicts() == 0){
                sideWayCorrectSolution++;
                sideWayCorrectSolutionsSteps.add(state.getCost());
//                System.out.println(state.getCost());
//                Utils.displaySolution(state.getQueenPlaces());
            } else{
                sideWayFailedSolution++;
                sideWayFailedSolutionsSteps.add(state.getCost());
            }
        }
        System.out.println("sideway hill climbing rate of correct solutions: " + (1.0*sideWayCorrectSolution/NUMBER_OF_TRIES)*100);
        System.out.println("sideway hill climbing rate of failed solutions: " + (1.0*sideWayFailedSolution/NUMBER_OF_TRIES)*100);
        System.out.println("sideway hill climbing correct average steps: " + sideWayCorrectSolutionsSteps.stream().mapToInt(a->a).average().getAsDouble());
        System.out.println("sideway hill climbing failed average steps: " + sideWayFailedSolutionsSteps.stream().mapToInt(a->a).average().getAsDouble());
    }
}
