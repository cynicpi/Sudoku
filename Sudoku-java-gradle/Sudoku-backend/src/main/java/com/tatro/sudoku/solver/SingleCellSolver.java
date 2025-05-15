package com.tatro.sudoku.solver;

import com.tatro.sudoku.model.CellValue;
import com.tatro.sudoku.model.SudokuPuzzle;

import java.util.HashSet;
import java.util.Set;

public class SingleCellSolver implements Solver {
    @Override
    public SudokuPuzzle solve(SudokuPuzzle input) {
        SudokuPuzzle output = input;
        for (int row = 0; row < input.getDimension(); row++) {
            for (int column = 0; column < input.getDimension(); column++) {
                output = solve(output, row, column);
            }
        }
        return output;
    }

    private SudokuPuzzle solve (SudokuPuzzle input, int row, int column) {
        SudokuPuzzle output = input;

        //Assumes square sudoku
        int dimension    = input.getDimension();
        Set<CellValue> values = new HashSet<>();
        for (int testColumn = 0; testColumn < dimension * dimension; testColumn++) {
            values.add(output.getValue(row, testColumn));
        }
        for (int testRow = 0; testRow < dimension * dimension; testRow++) {
            values.add(output.getValue(testRow, column));
        }

        CellValue cell = input.getValue(row,column);
        if (cell == null) cell = new CellValue(input.getDimension());

        Set<Integer> impossibleValues = cell.getImpossibleValues();
        for (CellValue cellValue : values) {
            impossibleValues.add(cellValue.getValue());
        }

        output.setValue(row, column, cell);

        return output;
    }
}
