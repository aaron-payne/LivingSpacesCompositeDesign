/**
 * COMP 3607 - Assignment 2
 * NAME: @author Aaron Payne
 * ID#: 816009846
 * @version 1.0
 * @since 2026-10-31
 */

package comp3607A2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/** A house containing zero or more living spaces    */
public class House implements LivingSpace {
    private final Collection<LivingSpace> spaces;
    private boolean ventilated;
    private int sealCursor = -1; 

    public House() {
        this.spaces = new ArrayList<>();
        this.ventilated = false;
    }

    public void addLivingSpace(LivingSpace space) {
        if (space != null) {
            spaces.add(space);
            sealCursor = -1; 
        }
    }
        
    @Override
    public double getCubicFootage() {
        double totalSpaces = 0;
        for (LivingSpace s : spaces) {
            totalSpaces += s.getCubicFootage();
        }
        return totalSpaces;
    }

    @Override
    public double assessAirQuality() {
        if (spaces.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (LivingSpace s : spaces) {
            sum += s.assessAirQuality();
        }
        return sum/spaces.size();
    }

    @Override
    public boolean ventilate() {
        for (LivingSpace s : spaces) {
            if (s.ventilate()) {
                ventilated = assessAirQuality() > 0;
                return true;
            }
        }
        return false;
    }

    /**Returns the total number of windows in the house. */
    @Override
    public int getNumWindows() {
        int totalWindows = 0;
        for (LivingSpace s : spaces) {
            totalWindows += s.getNumWindows();
        }
        return totalWindows;
    }

    @Override
    public boolean seal() {
        List<LivingSpace> list = new ArrayList<>(spaces);
        int n = list.size();
        if (n == 0) return false;

        if (sealCursor < 0 || sealCursor >= n) sealCursor = n - 1;
        for (int i = 0; i < n; i++) {
            int index = (sealCursor - i + n) % n;
            if (list.get(index).seal()) {
                sealCursor = (index - 1 + n) % n;
                ventilated = assessAirQuality() > 0;
                return true;
            }
        }
        ventilated = false;
        return false;
    }

    @Override
    public String getAirQualityReport(){
        return "------------------------------\n"
                + "HOUSE Cubic Footage: " + getCubicFootage() + "\n"
                + "Ventilated: " + ventilated + "\n"
                +String.format("Air Quality: %.2f%%\n", assessAirQuality()) + "\n"
                + "------------------------------";
    }
    

}
