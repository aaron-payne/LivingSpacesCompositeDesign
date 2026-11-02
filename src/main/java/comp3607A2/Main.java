/**
 * COMP 3607 - Assignment 2
 * NAME: @author Aaron Payne
 * ID#: 816009846
 * @version 1.0
 * @since 2026-10-31
 */

package comp3607A2;

public class Main {
    public static void main(String[] args) {

        /**Sample Data for Room in Appendix 1:
         * length=12, breadth=15, height=15, # of windows=3
         */
        LivingSpace room = new Room(12, 15, 15, 3);
        System.out.println(room.getAirQualityReport());
        //When room is ventilated x4:
        for (int i = 0; i < 4; i++) {
            room.ventilate();
            System.out.println(room.getAirQualityReport() + "\n");
        }
        //When room is sealed x4:
        for (int i = 0; i < 4; i++) {
            room.seal();
            System.out.println(room.getAirQualityReport() + "\n");
        }

        /**Sample Data for House in Appendix 2:
         * Room 1: length=12, breadth=15, height=15, # of windows=3
         * Room 2: length=10, breadth=10, height=18, # of windows=5
         */
        House house = new House();
        house.addLivingSpace(new Room(12, 15, 15, 3));
        house.addLivingSpace(new Room(10, 10, 18, 5));
        System.out.println(house.getAirQualityReport());
        //When house is ventilated x5:
        for (int i = 0; i < 5; i++) {
            house.ventilate();
            System.out.println(house.getAirQualityReport() + "\n");
        }
        //When house is sealed x5:
        for (int i = 0; i < 5; i++) {
            house.seal();
            System.out.println(house.getAirQualityReport() + "\n");
        }
    
         

    }
}