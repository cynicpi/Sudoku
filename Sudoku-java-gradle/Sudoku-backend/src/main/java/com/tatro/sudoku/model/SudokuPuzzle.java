package com.tatro.sudoku.model;

public interface SudokuPuzzle {
    public boolean isValid();
    public boolean isSolved();
    public int getDimension();
    public void setValue(int row, int column, CellValue value);
    public CellValue getValue(int row, int column);
}
