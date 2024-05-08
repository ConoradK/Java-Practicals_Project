package Practical_20;
//the SierpinskiCarpet class is part of package 20

import java.lang.Math;
//the Math library is imported to this file

//the below class contains all methods and attributes to produce
//a sierpinski carpet
public class SierpinskiCarpet {

    //the full board is initialised
    private char[][] board;
    //the size of the board is initialised
    private int size;


    //the constructor takes in the size of the board
    // through the parameter
    public SierpinskiCarpet(int size) {
        //the parameter size is used as the size attribute value
        this.size = (size);
        //the board has its dimension set to the desired size
        this.board = new char[size][size];
        //the below method is to fill out the board
        initializeBoard();
    }


    //the below method is responsible for filling out each unit
    //with "*"
    private void initializeBoard() {
        //a for loop that loops through each row
        for (int unit_y = 0; unit_y < size; unit_y++) {
            //a for loop that goes through every column
            for (int unit_x = 0; unit_x < size; unit_x++) {
                //the current position in the board is filled with *
                board[unit_y][unit_x] = '*';
            }
        }
    }

    //this method is responsible for calling the method
    // remove sub array without levels
    public void generateSierpinskiCarpetWithoutLevels() {
        //the below method caller passes the size of the board
        //and the off set values for x and y as 0
        //and the board itself
        removeSubArrayWithoutLevels(board,size,0, 0);
    }

    //this method is responsible for calling the method
    // remove sub array with levels

    public void generateSierpinskiCarpetWithLevels() {
        //the below method caller passes the size of the board
        //and the off set values for x and y as 0
        //also the current level of recursion is passed as 0
        //and the board itself
        removeSubArrayWithLevels(board,size, 0, 0, 0);
    }


    //the below method is responsible for calling itself and replacing the center of the
    //carpet design at each recursion
    private void removeSubArrayWithoutLevels(char[][]board,int subSize,int offSet_y,int offSet_x) {
        //this if statement checks if the subdivision
        // of the current size of the board is equal to 1
        if (subSize == 1) {
        }
        else {
            //if not then subdivide the current board by 3
            int third = subSize / 3;

            //this for loop goes through all central subdivision central
            //positions in the y-axis
            for (int pattern_hole_y = third; pattern_hole_y < (2 * third); pattern_hole_y++) {
                //this for loop goes through all central subdivision central
                //positions in the x-axis
                for (int pattern_hole_x = third; pattern_hole_x < (2 * third); pattern_hole_x++) {
                    //here the current position is replaced
                    // with empty space
                    board[pattern_hole_y + offSet_y][pattern_hole_x + offSet_x] = ' ';

                }
            }

            //this for loop goes through each column of each
            // subdivision of the current board
            for (int surrounding_carpet_y = 0; surrounding_carpet_y < 3; surrounding_carpet_y++) {
                //this for loop goes through each row of each
                // subdivision of the current board
                for (int surrounding_carpet_x = 0; surrounding_carpet_x < 3; surrounding_carpet_x++) {
                    //if the current subdivision isn't the central one
                    if (!(surrounding_carpet_y == 1 && surrounding_carpet_x == 1)) {
                        //if the above statement is met  then the method called
                        //again with the subdivision size and the x/y new off-set positions
                        //as the parameters
                        removeSubArrayWithoutLevels(board,third, offSet_y + (surrounding_carpet_y*third),
                                offSet_x + (surrounding_carpet_x*third));
                    }
                }
            }
        }
    }



    //the below method is responsible for calling itself and replacing the center of the
    //carpet design at each recursion
    private void removeSubArrayWithLevels(char[][]board,int subSize, int level,int offSet_y,int offSet_x) {
        //this if statement checks if the subdivision
        // of the current size of the board is equal to 1
        if (subSize == 1) {
        }
        else {
            //if not then subdivide the current board by 3
            int third = subSize / 3;

            //this for loop goes through all central subdivision central
            //positions in the y-axis
            for (int pattern_hole_y = third; pattern_hole_y < (2 * third); pattern_hole_y++) {
                //this for loop goes through all central subdivision central
                //positions in the x-axis
                for (int pattern_hole_x = third; pattern_hole_x < (2 * third); pattern_hole_x++) {
                    //here the current position is replaced
                    // with the current recursion level
                    board[pattern_hole_y + offSet_y][pattern_hole_x + offSet_x] = Character.forDigit(level,10);
                }
            }

            //this for loop goes through each column of each
            // subdivision of the current board
            for (int surrounding_carpet_y = 0; surrounding_carpet_y < 3; surrounding_carpet_y++) {
                //this for loop goes through each row of each
                // subdivision of the current board
                for (int surrounding_carpet_x = 0; surrounding_carpet_x < 3; surrounding_carpet_x++) {
                    //if the current subdivision isn't the central one
                    if (!(surrounding_carpet_y == 1 && surrounding_carpet_x == 1)) {
                        //if the above statement is met  then the method called
                        //again with the subdivision size and the x/y new off-set positions
                        //and the next recursion level as the parameters
                        removeSubArrayWithLevels(board,third, level + 1,offSet_y + (surrounding_carpet_y*third),
                                offSet_x + (surrounding_carpet_x*third));
                    }
                }
            }
        }
    }


    //the below method displays the sierpinski carpet
    public void printSierpinskiCarpet() {
        //this for loop goes through each row of the board
        for (int unit_y = 0; unit_y < size; unit_y++) {
            //this for loop goes through each column of the board
            for (int unit_x = 0; unit_x < size; unit_x++) {
                //the current position of the board is displayed
                System.out.print(this.board[unit_y][unit_x] +"  ");
            }
            System.out.println();
        }
    }


    //this is the main console method
    public static void main(String[] args) {

        //here enter the depth of level recursion
        int number_of_levels = 3;

        //this if statement check if the depth level of recursion is not
        // between 1 and 5 inclusively
        if (!(number_of_levels > 0 && number_of_levels < 6)){
            //the message eis displayed what the problem is
            System.out.println("\nthe input length must be between 1 and 5 inclusively");
            System.exit(0);
        }
        //the size of the board is calculated by the equation 3^n
        int size = (int) Math.pow(3,number_of_levels);

        //the two instances(one with level and one without)
        // of the class are initialised as
        SierpinskiCarpet sierpinskiCarpetWithoutLevels = new SierpinskiCarpet(size);
        SierpinskiCarpet sierpinskiCarpetWithLevels = new SierpinskiCarpet(size);

        //below the methods of the instance are called to produce
        //the sierpinski carpet without the depth recursion level
        System.out.println("\nSierpinski Carpet Without Levels:\n");
        sierpinskiCarpetWithoutLevels.generateSierpinskiCarpetWithoutLevels();
        sierpinskiCarpetWithoutLevels.printSierpinskiCarpet();

        //below the methods of the instance are called to produce
        //the sierpinski carpet with the depth recursion level
        System.out.println("\nSierpinski Carpet With Levels:\n");
        sierpinskiCarpetWithLevels.generateSierpinskiCarpetWithLevels();
        sierpinskiCarpetWithLevels.printSierpinskiCarpet();

    }
}

