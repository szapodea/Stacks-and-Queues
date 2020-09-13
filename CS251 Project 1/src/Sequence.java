import java.util.Arrays;
import java.util.Iterator;

public class Sequence {
    private Grid grid;
    private Stack<Loc> path; //stores the sequence path

    //constructor: create a new Sequence for the 
    //specified grid
    public Sequence(Grid grid) {
        this.grid = grid;
        this.path = new Stack<Loc>();
    }

    //resets the grid and the path
    public void reset(Grid grid) {
        this.grid = grid;
        this.path = new Stack<Loc>();
    }

    //(i, j)  is the starting location
    //val is the value that should end the sequence
    public void getSeq(int i, int j, int val) throws EmptyStackException {
        if (val <= 0) {
            return;
        }
        getSeqHelper(i, j, val, true);
        /*
        if (i >= grid.size() || j >= grid.size() || i < 0 || j < 0) {
            return;
        } else {
            grid.getLoc(i, j).hasBeen = true;
            path.push(grid.getLoc(i, j));
        }

        if ((null != grid.getLoc(i - 1, j)) && (i != 0) &&
                ((grid.getLoc(i, j).val + 1) == grid.getLoc(i - 1, j).val) && !grid.getLoc(i - 1, j).hasBeen) {
            getSeq(i - 1, j, val);
        }
        if ((null != grid.getLoc(i, j + 1)) && (j != grid.size() - 1) &&
                grid.getLoc(i, j).val + 1 == grid.getLoc(i, j + 1).val && !grid.getLoc(i, j + 1).hasBeen) {
            getSeq(i, j + 1, val);
        }
        if ((null != grid.getLoc(i + 1, j)) && (i != grid.size() - 1) &&
                grid.getLoc(i, j).val + 1 == grid.getLoc(i + 1, j).val && !grid.getLoc(i + 1, j).hasBeen) {
            getSeq(i + 1, j, val);
        }
        if ((null != grid.getLoc(i, j - 1)) && (j != 0) &&
                grid.getLoc(i, j).val + 1 == grid.getLoc(i, j - 1).val && !grid.getLoc(i, j - 1).hasBeen) {
            getSeq(i, j - 1, val);
        }
        if (path.peek().val == val) {
            return;
        }
        path.pop();

         */
    }
    public void getSeqHelper(int i, int j, int val, boolean first) throws EmptyStackException {
        if (i >= grid.size() || j >= grid.size() || i < 0 || j < 0) {
            return;
        } else {
            grid.getLoc(i, j).hasBeen = true;
            path.push(grid.getLoc(i, j));
        }
        if (!first && (path.peek().val == val)) {
            return;
        }

        if ((null != grid.getLoc(i - 1, j)) && (i != 0) &&
                ((grid.getLoc(i, j).val + 1) == grid.getLoc(i - 1, j).val) && !grid.getLoc(i - 1, j).hasBeen) {
            getSeqHelper(i - 1, j, val, false);
        }
        if ((null != grid.getLoc(i, j + 1)) && (j != grid.size() - 1) &&
                grid.getLoc(i, j).val + 1 == grid.getLoc(i, j + 1).val && !grid.getLoc(i, j + 1).hasBeen) {
            getSeqHelper(i, j + 1, val, false);
        }
        if ((null != grid.getLoc(i + 1, j)) && (i != grid.size() - 1) &&
                grid.getLoc(i, j).val + 1 == grid.getLoc(i + 1, j).val && !grid.getLoc(i + 1, j).hasBeen) {
            getSeqHelper(i + 1, j, val, false);
        }
        if ((null != grid.getLoc(i, j - 1)) && (j != 0) &&
                grid.getLoc(i, j).val + 1 == grid.getLoc(i, j - 1).val && !grid.getLoc(i, j - 1).hasBeen) {
            getSeq(i, j - 1, val);
        }
        if (path.peek().val == val) {
            return;
        }
        path.pop();
    }

    //return a String representation of the sequence
    //starting at the starting location and listing
    //all locations in the sequence in order
    public String toString() {
        int stackLength = path.size();
        String pathString = "";
        Stack<Loc> pathCopy = path;
        for (int i = 0; i < stackLength; i++) {
            try {
                Loc tempLoc = pathCopy.pop();
                //System.out.println("Row: " + tempLoc.row + " COL: " + tempLoc.col);
                String newString = "(" + tempLoc.row + ", " + tempLoc.col + ")" + pathString;
                pathString = newString;
            } catch (EmptyStackException e) {
                e.printStackTrace();
            }

        }
        System.out.println(pathString);
        return pathString;
    }
}