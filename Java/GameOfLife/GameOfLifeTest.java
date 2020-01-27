package com.company;

import org.junit.Assert;
import org.junit.Test;

public class GameOfLifeTest {
    @Test
    public void getRowTest(){
        Grid fiveCrossFiveGrid = new Grid(5,5);
        Assert.assertEquals(5,fiveCrossFiveGrid.getNumberOfRows());
    }

    @Test
    public void getColumnTest(){
        Grid fiveCrossFiveGrid = new Grid(5,5);
        Assert.assertEquals(5,fiveCrossFiveGrid.getNumberOfColumn());
    }

    @Test
    public void deadCellTest(){
        Grid fiveCrossFiveGrid = new Grid(5,5);
        Assert.assertEquals(false,fiveCrossFiveGrid.isAlive(0,0));
    }

    @Test
    public void aliveCellTest(){
        Grid fiveCrossFiveGrid = new Grid(5,5);
        fiveCrossFiveGrid.changeToAliveCell(0,0);

        Assert.assertEquals(true,fiveCrossFiveGrid.isAlive(0,0));
    }

    @Test
    public void allCellDeadTest(){
        Grid fiveCrossFiveGrid = new Grid(5,5);
        for (int i = 0; i < fiveCrossFiveGrid.getNumberOfRows(); i++){
            for (int j = 0; j < fiveCrossFiveGrid.getNumberOfColumn(); j++){
                Assert.assertFalse(fiveCrossFiveGrid.isAlive(i, j));
            }
        }
    }

    @Test
    public void numberOfAliveNeighbourTest(){
        Grid fiveCrossFiveGrid = new Grid(5,5);

        fiveCrossFiveGrid.changeToAliveCell(0,0);
        fiveCrossFiveGrid.changeToAliveCell(0,2);
        fiveCrossFiveGrid.changeToAliveCell(2,0);
        fiveCrossFiveGrid.changeToAliveCell(2,2);

        Assert.assertEquals(4,fiveCrossFiveGrid.aliveNeighbour(1,1));
        Assert.assertEquals(0,fiveCrossFiveGrid.aliveNeighbour(0,0));
    }

    @Test
    public void equalGridTest(){
        Grid fiveCrossFiveGrid1 = new Grid(5,5);
        Grid fiveCrossFiveGrid2 = new Grid(5,5);

        Assert.assertEquals(fiveCrossFiveGrid1,fiveCrossFiveGrid2);
    }

    @Test
    public void notEqualGridTest(){
        Grid fiveCrossFiveGrid = new Grid(5,5);
        Grid fourCrossFourGrid = new Grid(4,4);

        Assert.assertNotEquals(fiveCrossFiveGrid,fourCrossFourGrid);
    }

    @Test
    public void nexGenerationTest(){
        Grid fiveCrossFiveGrid = new Grid(5,5);

        fiveCrossFiveGrid.changeToAliveCell(1,1);
        fiveCrossFiveGrid.changeToAliveCell(1,2);
        fiveCrossFiveGrid.changeToAliveCell(1,3);
        fiveCrossFiveGrid.changeToAliveCell(2,2);
        fiveCrossFiveGrid.changeToAliveCell(2,3);
        fiveCrossFiveGrid.changeToAliveCell(2,4);
        fiveCrossFiveGrid.nextGeneration();

        Grid outputGrid = new Grid(5,5);

        outputGrid.changeToAliveCell(0,2);
        outputGrid.changeToAliveCell(1,1);
        outputGrid.changeToAliveCell(1,4);
        outputGrid.changeToAliveCell(2,1);
        outputGrid.changeToAliveCell(2,4);
        outputGrid.changeToAliveCell(3,3);

        Assert.assertEquals(outputGrid,fiveCrossFiveGrid);




        Grid fourCrossFourGrid = new Grid(4,4);

        fourCrossFourGrid.changeToAliveCell(1,0);
        fourCrossFourGrid.changeToAliveCell(1,1);
        fourCrossFourGrid.changeToAliveCell(1,2);

        fourCrossFourGrid.nextGeneration();

        Grid outputGrid2 = new Grid(4,4);

        outputGrid2.changeToAliveCell(1,1);
        outputGrid2.changeToAliveCell(0,1);
        outputGrid2.changeToAliveCell(2,1);

        Assert.assertNotEquals(fourCrossFourGrid,outputGrid);
        Assert.assertEquals(outputGrid2,fourCrossFourGrid);
    }
}
