package Q1;

import util.TobiasStack;

public class Rat {
    int[][] maze;
    int N;
    TobiasStack<Node> path;

    private enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    public Rat(int[][] maze) {
        this.maze = maze;
        this.N = maze.length;
        this.path = new TobiasStack<>();
    }

    private boolean isSafe(int row, int col) {
        return row >= 0 && row < N &&
                col >= 0 && col < N &&
                maze[row][col] == 1;
    }

    public boolean solveMaze() {
        return solveMaze(0, 0, Direction.RIGHT);
    }

    private boolean solveMaze(int row, int col, Direction direction) {
        // Base case, reached end of maze
        if (row == N - 1 && col == N - 1) {
            path.push(new Node(row, col, direction));
            return true;
        }
        // Recursive case, try all directions
        if (isSafe(row, col)) {
            path.push(new Node(row, col, direction));
            maze[row][col] = 0;
            if (solveMaze(row, col + 1, Direction.RIGHT)) {
                return true;
            }
            if (solveMaze(row + 1, col, Direction.DOWN)) {
                return true;
            }
            if (solveMaze(row - 1, col, Direction.UP)) {
                return true;
            }
            if (solveMaze(row, col - 1, Direction.LEFT)) {
                return true;
            }
            maze[row][col] = -1;
            path.pop();
        }
        return false;
    }

    public int[][] printMazePath() {
        int [][] mazePath = new int[N][N];
        while (!path.isEmpty()) {
            Node node = path.pop();
            mazePath[node.row][node.col] = 1;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(mazePath[i][j] + " ");
            }
            System.out.println();
        }
        return mazePath;
    }

    private static class Node {
        int row;
        int col;
        Direction direction;

        Node(int row, int col, Direction direction) {
            this.row = row;
            this.col = col;
            this.direction = direction;
        }
    }

}
