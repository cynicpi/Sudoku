package com.tatro.sudoku.model;

import com.tatro.sudoku.InvalidValueException;

public class SquareSudokuPuzzle implements SudokuPuzzle {
    private CellValue[][] puzzle;
    private int dimension;

    public SquareSudokuPuzzle() {
        this (3);//default sudoku dimension
    }
    public SquareSudokuPuzzle(int squareDimension) {
        this.puzzle = new CellValue[squareDimension*squareDimension][squareDimension*squareDimension];
        this.dimension = squareDimension;
    }

    public int getDimension() {
        return this.dimension;
    }

    @Override
    public boolean isSolved() {
        return false;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public CellValue getValue(int row, int column) {
        return this.puzzle[row][column];
    }

    @Override
    public void setValue(int row, int column, CellValue value) {
        if (value != null && (value.getValue() < 1 || value.getValue() > dimension * dimension)) throw new InvalidValueException();

        this.puzzle[row][column] = value;
    }
}
