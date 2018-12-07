import day1.ChronalCalibrator;
import day2.InventoryManagementSystem;
import day5.AlchemicalReduction;

public class Start {

    public static void main(String[] args) {
        ChronalCalibrator chronalCalibrator = new ChronalCalibrator();
        chronalCalibrator.frequencyAfterFirstLoopOfIterations();
        chronalCalibrator.findFirstDuplicate();

        InventoryManagementSystem inventoryManagementSystem = new InventoryManagementSystem();
        inventoryManagementSystem.scanBoxesForDuplicates();
        inventoryManagementSystem.findCommonLetters();

        AlchemicalReduction alchemicalReduction = new AlchemicalReduction();
        alchemicalReduction.scanOnePolymer();
        alchemicalReduction.findShortestPolymer();
    }
}
