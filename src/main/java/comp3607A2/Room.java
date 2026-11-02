/**
 * COMP 3607 - Assignment 2
 * NAME: @author Aaron Payne
 * ID#: 816009846
 * @version 1.0
 * @since 2026-10-31
 */

package comp3607A2;

/** Room class representing a room which is a living space. Rooms can exist in a House*/
public class Room implements LivingSpace {

    static final double AVERAGE_WINDOW_SIZE = 25.0; // Average size of a window in square feet
    static final double MIN_AERATION_RATE = 0.05; // Minimum aeration rate (5% of cubic footage of a living space)

    private int cubicFootage;
    private int numWindows;
    private boolean ventilated;
    private int numWindowsOpen;

    public Room (double length, double breadth, double height, int numWindows){
        this.cubicFootage = (int) Math.round(length * breadth * height);
        this.numWindows = Math.max(0, numWindows);
        this.numWindowsOpen = 0;
        this.ventilated = false;
    }
    
    @Override
    public double getCubicFootage() {
        return cubicFootage;
    }

    /**Returns the number of windows in the room. */
    @Override
    public int getNumWindows() {
        return numWindows;
    }

    @Override
    public double assessAirQuality() {
        double currentAeration = numWindowsOpen * AVERAGE_WINDOW_SIZE;
        double minimumAeration = MIN_AERATION_RATE * cubicFootage;
        if (minimumAeration <= 0) {
            return 0.0;
        }
        return (currentAeration / minimumAeration) * 100.0;
    }

    @Override
    public boolean ventilate() {
        if (numWindowsOpen >= numWindows) {
            return false; 
        }
        numWindowsOpen+=1;
        ventilated = numWindowsOpen > 0;
        return true;
    }   

    @Override
    public boolean seal(){
        if (numWindowsOpen <= 0) {
            return false; 
        }
        numWindowsOpen-=1;
        ventilated = numWindowsOpen > 0;
        return true;
    }

    @Override
    public String getAirQualityReport() {
        return "------------------------------\n"
                + "ROOM Cubic Footage: " + getCubicFootage() + "\n"
                + "Windows open: " + numWindowsOpen + "\n"
                + "Ventilated: " + ventilated + "\n"
                + String.format("Air Quality: %.2f%%", assessAirQuality()) + "\n"
                + "------------------------------";
    }
}
