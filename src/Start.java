import day1.ChronalCalibrator;
import day5.AlchemicalReduction;

public class Start {

    public static void main(String[] args) {
        ChronalCalibrator chronalCalibrator = new ChronalCalibrator();
        chronalCalibrator.frequencyAfterFirstLoopOfIterations();
        chronalCalibrator.findFirstDuplicate();

        AlchemicalReduction alchemicalReduction = new AlchemicalReduction();
        alchemicalReduction.scanOnePolymer();
        alchemicalReduction.findShortestPolymer();
    }
}
