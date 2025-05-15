package com.tatro.sudoku.solver;

import com.tatro.sudoku.model.SudokuPuzzle;

public interface Solver {
    SudokuPuzzle solve(SudokuPuzzle input);
}
