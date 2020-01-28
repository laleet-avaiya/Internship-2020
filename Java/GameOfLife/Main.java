package com.company;

import java.util.*;


class Pair{
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class Grid {
    private int numberOfRows;
    private int numberOfColumn;
    private char[][] grid;

    private int[] rowDirection = {-1,-1,0,1,1,1,0,-1};
    private int[] columnDirection = {0,1,1,1,0,-1,-1,-1};

    public Grid(int numberOfRows, int numberOfColumn) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumn = numberOfColumn;

        grid = new char[numberOfRows][numberOfColumn];
        for (char[] row : grid)
            Arrays.fill(row, '-');
    }

    public void nextGeneration(){
        char[][] nextGrid = new char[numberOfRows][numberOfColumn];

        for(int i = 0; i < numberOfRows; i++)
        {
            for(int j = 0; j < numberOfColumn; j++)
            {
                int numberOfLiveNeighbours = aliveNeighbour(i,j);

                if(numberOfLiveNeighbours == 3 && grid[i][j] == '-') {
                    nextGrid[i][j] = 'X';
                }
                else if(numberOfLiveNeighbours < 2 || numberOfLiveNeighbours > 3 ) {
                    nextGrid[i][j] = '-';
                }
                else {
                    nextGrid[i][j] = grid[i][j];
                }
            }
        }
        this.grid = nextGrid;
    }

    public void changeToAliveCell(int x,int y){
        grid[x][y] = 'X';
    }

    public void printGrid(){
        for(int i = 0; i < grid.length ; i++){
            for(int j=0; j < grid[0].length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public void printGridAliveCell(){
        for(int i = 0; i < grid.length ; i++){
            for(int j=0; j < grid[0].length; j++){
                if(grid[i][j] == 'X')
                    System.out.println(i + "," + j);
            }
        }
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumn() {
        return numberOfColumn;
    }

    public char[][] getGrid() {
        return grid;
    }

    public boolean isAlive(int x,int y){
        return grid[x][y]=='X'?true:false;
    }

    public int aliveNeighbour(int i,int j){
        int numberOfLiveNeighbours = 0;

        for(int k = 0; k < 8; k++)
        {
            int newRowIndex = i + rowDirection[k];
            int newColumnIndex = j + columnDirection[k];


            if(newRowIndex >= 0 && newRowIndex < numberOfRows && newColumnIndex >= 0 && newColumnIndex < numberOfColumn){
                if( grid[newRowIndex][newColumnIndex] == 'X'){
                    numberOfLiveNeighbours++;
                }
            }

        }

        return numberOfLiveNeighbours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grid)) return false;
        char[][] grid1 = ((Grid) o).getGrid();

        if(getNumberOfRows() != grid1.length || getNumberOfColumn() != grid1[0].length)
            return false;


        for (int i = 0; i < grid.length; i++) {
            if (!Arrays.equals(grid[i], grid1[i])) {
                return false;
            }
        }
        return  true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getNumberOfRows(), getNumberOfColumn());
        result = 31 * result + Arrays.hashCode(getGrid());
        return result;
    }
}


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Pair> listOfAliveCells = new ArrayList<Pair>();

        int numberOfRow = 0;
        int numberOfColumn = 0;
        System.out.println("Input:");
        System.out.println("How many cells alive?")
        int numberOfAliveCell = Integer.parseInt(scanner.nextLine());

        while(numberOfAliveCell > 0){
            String[] inputLine = scanner.nextLine().split(",");
            int xCoordinate = Integer.parseInt(inputLine[0].trim());
            int yCoordinate = Integer.parseInt(inputLine[1].trim());

            if(xCoordinate < 0 || yCoordinate < 0)
            {
                System.out.println( "("+xCoordinate +"," +yCoordinate + ") Invalid Input Try Again.");
                continue;
            }

            listOfAliveCells.add(new Pair(xCoordinate,yCoordinate));

            numberOfRow = Math.max(numberOfRow,xCoordinate);
            numberOfColumn = Math.max(numberOfColumn,yCoordinate);

            numberOfAliveCell--;
        }

        numberOfRow = Math.max(numberOfRow,numberOfColumn) + 1;
        numberOfColumn = numberOfRow;

        Grid grid = new Grid(numberOfRow,numberOfColumn);


        for (Pair pair:listOfAliveCells) {
            int x = pair.getX();
            int y = pair.getY();

            grid.changeToAliveCell(x,y);
        }

        System.out.println("Input Grid:");
        grid.printGrid();
        System.out.println(" ");
        grid.printGridAliveCell();
        grid.nextGeneration();
        System.out.println(" ");
        System.out.println("Output Grid");
        grid.printGrid();
        System.out.println(" ");
        grid.printGridAliveCell();

    }
}
