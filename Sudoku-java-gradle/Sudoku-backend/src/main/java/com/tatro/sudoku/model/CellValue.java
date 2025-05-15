package com.tatro.sudoku.model;

import java.util.HashSet;
import java.util.Set;

public class CellValue {
    private Integer value;
    private Integer maxRange;
    private Set<Integer> impossibleValues;

    public CellValue (Integer maxRange) {
        this.maxRange = maxRange;
        this.impossibleValues = new HashSet<>();
    }

    public CellValue (Integer value, Integer maxRange) {
        this.value = value;
        this.maxRange = maxRange;
        this.impossibleValues = new HashSet<>();
    }

    public Integer getValue() {
        return value;
    }

    public Integer getMaxRange() {
        return this.maxRange;
    }

    public void setValue (Integer value) {
        this.value = value;
        this.impossibleValues = new HashSet<>();
        for (Integer i = 1; i < this.maxRange; i++) {
            if (!i.equals(value)) this.impossibleValues.add(i);
        }
    }

    public Set<Integer> getImpossibleValues() {
        return new HashSet<>(impossibleValues);
    }

    public void addPossibleValue (Integer value) {
        this.impossibleValues.add(value);
    }
}
