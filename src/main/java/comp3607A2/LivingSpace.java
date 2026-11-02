/**
 * COMP 3607 - Assignment 2
 * NAME: @author Aaron Payne
 * ID#: 816009846
 * @version 1.0
 * @since 2026-10-31
 */
package comp3607A2;

/**Represents a living space that can be assessed for air quality and managed for ventilation and sealing. Can either be a room or a house.*/
public interface LivingSpace {

    /**Returns the cubic footage of the living space. */
    public double getCubicFootage();
   
    /**Assesses the air quality of the living space. If fully ventilated, calculates based on windows open and cubic footage.  If fully sealed, return = 0.00%. */
    public double assessAirQuality();

    /**Opens windows in a living space. If all windows open/ full ventilation, return = true. */
    public boolean ventilate();

    /**Closes windows in a living space. If all windows closed/ no ventilation, return = true. */
    public boolean seal();

    /**Returns a report on the air quality of the living space. */
    public String getAirQualityReport();

    /**Returns the number of windows in the living space. */
    public int getNumWindows();
}
