package leetcode500.P15_design_data_structure.plan1;

import java.util.HashMap;

public class P631_DesignExcelSumFormula {

  Cell[][] table;

  public P631_DesignExcelSumFormula(int height, char width) {
    table = new Cell[height + 1][width - 'A' + 1];
  }

  public void set(int row, char column, int val) {
    if (table[row][column - 'A'] == null) table[row][column - 'A'] = new Cell(val);
    else table[row][column - 'A'].setValue(val);
  }

  public int get(int row, char column) {
    if (table[row][column - 'A'] == null) return 0;
    else return table[row][column - 'A'].getValue();
  }

  public int sum(int row, char column, String[] numbers) {
    if (table[row][column - 'A'] == null) {
      table[row][column - 'A'] = new Cell(numbers);
    } else {
      table[row][column - 'A'].setFormula(numbers);
    }

    return table[row][column - 'A'].getValue();
  }

  private class Cell {
    int val = 0;
    HashMap<Cell, Integer> formula = new HashMap<>(); // one cell might appear multiple times

    public Cell(int val) {
      setValue(val);
    }

    public Cell(String[] formulaStr) {
      setFormula(formulaStr);
    }

    public void setFormula(String[] formulaStr) {
      formula.clear();
      for (String str : formulaStr) {
        if (str.indexOf(":") < 0) {
          int[] pos = getPos(str);
          addFormulaCell(pos[0], pos[1]);
        } else {
          String[] pos = str.split(":");
          int[] startPos = getPos(pos[0]);
          int[] endPos = getPos(pos[1]);
          for (int r = startPos[0]; r <= endPos[0]; r++) {
            for (int c = startPos[1]; c <= endPos[1]; c++) {
              addFormulaCell(r, c);
            }
          }
        }
      }
    }

    private int[] getPos(String str) {
      int[] pos = new int[2];
      pos[1] = str.charAt(0) - 'A';
      pos[0] = Integer.parseInt(str.substring(1));
      return pos;
    }

    private void addFormulaCell(int r, int c) {
      if (table[r][c] == null) table[r][c] = new Cell(0);
      Cell rangeCell = table[r][c];
      formula.put(rangeCell, (formula.containsKey(rangeCell) ? formula.get(rangeCell) : 0) + 1);
    }

    // recursive method
    private int getValue() {
      if (this.formula.isEmpty()) return this.val;
      int sum = 0;
      for (Cell cell : formula.keySet()) {
        sum += cell.getValue() * formula.get(cell);
      }
      return sum;
    }

    public void setValue(int val) {
      formula.clear(); // will not be treated as a formula cell anymore
      this.val = val;
    }
  }
}
