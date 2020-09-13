public class ClosestPair {
    private Grid grid;
    private Queue<Loc> queue;

    //constructor: create a new ClosestPair object for grid
    public ClosestPair(Grid grid) {
        this.grid = grid;
        this.queue = new Queue<Loc>();
    }

    //search for the closest location with a value
    //that is equal to the value at start
    //return null if no match is found
    public Loc search(int x, int y) {
        if (x >= grid.size() || y >= grid.size() || x < 0 || y < 0) {
            return null;
        }
        int toFind = grid.getLoc(x, y).val;
        grid.getLoc(x, y).hasBeen = true;
        boolean isFound = false;
        int first = 1;
        queue.enqueue(grid.getLoc(x, y));
        int count = 1;
        try {
            while (!isFound && count != grid.size() * grid.size()) {
                count++;
                x = queue.peek().row;
                y = queue.peek().col;
                Loc current = queue.dequeue();
                if (first != 1) {
                    if ((current.val == toFind)) {
                        isFound = true;
                        return current;
                    }
                } else {
                    first = -1;
                }
                if ((x != 0) && (!grid.getLoc(x - 1, y).hasBeen)) {
                    if ((grid.getLoc(x -1, y).val == toFind)) {
                        return grid.getLoc(x - 1, y);
                    }
                    queue.enqueue(grid.getLoc(x - 1, y));
                    grid.getLoc(x - 1, y).hasBeen = true;
                }
                if ((y != grid.size() - 1) && !grid.getLoc(x, y + 1).hasBeen) {
                    if (grid.getLoc(x, y + 1).val == toFind) {
                        return grid.getLoc(x, y + 1);
                    }
                    queue.enqueue(grid.getLoc(x, y + 1));
                    grid.getLoc(x, y + 1).hasBeen = true;
                }
                if ((x != grid.size() - 1) && (!grid.getLoc(x + 1, y).hasBeen)) {
                    if ((grid.getLoc(x +1, y).val == toFind)) {
                        return grid.getLoc(x  + 1, y);
                    }
                    queue.enqueue(grid.getLoc(x + 1, y));
                    grid.getLoc(x + 1, y).hasBeen = true;
                }
                if ((y != 0) && !grid.getLoc(x, y - 1).hasBeen) {
                    if (grid.getLoc(x, y - 1).val == toFind) {
                        return grid.getLoc(x, y - 1);
                    }
                    queue.enqueue(grid.getLoc(x, y - 1));
                    grid.getLoc(x, y - 1).hasBeen = true;
                }
            }
        } catch (EmptyQueueException e) {
            e.printStackTrace();
        }
        /*
        try {
            return searchHelper(x, y, toFind, 1);
        } catch (EmptyQueueException e) {
            e.printStackTrace();
        }
         */
        return null;
    }

    public Loc searchHelper(int x, int y, int toFind, int first) throws EmptyQueueException {
        if (x > grid.size() || y > grid.size()) {
            return null;
        }
        if ((x != 0) && (!grid.getLoc(x - 1, y).hasBeen)) {
            queue.enqueue(grid.getLoc(x - 1, y));
            grid.getLoc(x - 1, y).hasBeen = true;
        }
        if ((y != grid.size() - 1) && !grid.getLoc(x, y + 1).hasBeen) {
            queue.enqueue(grid.getLoc(x, y + 1));
            grid.getLoc(x, y + 1).hasBeen = true;
        }
        if ((x != grid.size() - 1) && !grid.getLoc(x + 1, y).hasBeen) {
            queue.enqueue(grid.getLoc(x + 1, y));
            grid.getLoc(x + 1, y).hasBeen = true;
        }
        if ((y != 0) && !grid.getLoc(x, y - 1).hasBeen) {
            queue.enqueue(grid.getLoc(x, y - 1));
            grid.getLoc(x, y - 1).hasBeen = true;
        }
        if (first == 1) {
            x = queue.peek().row;
            y = queue.peek().col;
        }
        /*
        if (grid.getLoc(x, y).hasBeen) {

        } else {
            queue.enqueue(grid.getLoc(x, y));
            grid.getLoc(x, y).hasBeen = true;
        }
         */
        Loc current = queue.dequeue();
        if ((current.val == toFind)) {
            return current;
        }
        if ((x != 0) && !grid.getLoc(x - 1, y).hasBeen) {
            //queue.enqueue(grid.getLoc(x - 1, y));
            searchHelper(x - 1, y, toFind, -1);
        }
        if ((y != grid.size() - 1) && !grid.getLoc(x, y + 1).hasBeen) {
            //queue.enqueue(grid.getLoc(x, y + 1));
            searchHelper(x, y + 1, toFind, -1);
        }
        if ((x != grid.size() - 1) && !grid.getLoc(x + 1, y).hasBeen) {
            //queue.enqueue(grid.getLoc(x + 1, y));
            searchHelper(x + 1, y, toFind, -1);
        }
        if ((y != 0) && !grid.getLoc(x, y - 1).hasBeen) {
            //queue.enqueue(grid.getLoc(x, y - 1));
            searchHelper(x, y - 1, toFind, -1);
        }
        /*
        if (first == 1) {
            return searchHelper(queue.peek().row, queue.peek().col, toFind, -1);
        }
         */
        return null;
    }
}