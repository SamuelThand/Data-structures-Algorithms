import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        var inputFile = "samuel-laboration1/Q1-input.txt";
        try {
            int[][] maze = loadMaze(inputFile);
            if (navigateMaze(maze))
                printMaze(maze);
            else {
                PrintWriter writer = new PrintWriter("samuel-laboration1/Q1-output.txt");
                writer.println("PATH NOT FOUND");
                writer.close();
            }
        } catch (FileNotFoundException | IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public static int[][] loadMaze(String file) throws FileNotFoundException {
        var mazeInput = new File(file);
        var scanner = new Scanner(mazeInput);

        int rows = 0;
        int cols = 0;
        while (scanner.hasNextLine()) {
            cols = scanner.nextLine().split(" ").length;
            rows++;
        }

        if (rows != cols)
            throw new IllegalArgumentException("The file must have an equal amounts of rows and columns!");
        else {
            scanner = new Scanner(mazeInput);
            int[][] maze = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                var row = scanner.nextLine().split(" ");
                for (int j = 0; j < cols; j++) {
                    maze[i][j] = Integer.parseInt(row[j]);
                }
            }

            return maze;
        }
    }

    public static boolean navigateMaze(int[][] maze) {
        SamuelFixedSizeStack<Coordinate> moves = new SamuelFixedSizeStack<>(30);
        int[][] coordinatesBacktrackedFrom = new int[maze.length][maze[0].length];

        // Initialize coordinatesBacktrackedFrom with zeros
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                coordinatesBacktrackedFrom[i][j] = 0;
            }
        }

        moves.push(new Coordinate(0, 0)); // The starting position

        while (!moves.isEmpty()) {
            Coordinate currentCoordinate = moves.pop();
            maze[currentCoordinate.X()][currentCoordinate.Y()] = -1; // Marked as visited

            boolean isOnTheLastRow = currentCoordinate.X() == (maze.length - 1);
            boolean isOnTheLastColumn = currentCoordinate.Y() == (maze[0].length - 1);
            boolean canGoUp = currentCoordinate.X() > 0 && maze[currentCoordinate.X()-1][currentCoordinate.Y()] == 1;
            boolean canGoDown = currentCoordinate.X() < (maze.length - 1) && maze[currentCoordinate.X()+1][currentCoordinate.Y()] == 1;
            boolean canGoLeft = currentCoordinate.Y() > 0 && maze[currentCoordinate.X()][currentCoordinate.Y()-1] == 1;
            boolean canGoRight = currentCoordinate.Y() < (maze[0].length - 1) && maze[currentCoordinate.X()][currentCoordinate.Y()+1] == 1;
            boolean canBacktrackUp = currentCoordinate.X() > 0 && maze[currentCoordinate.X()-1][currentCoordinate.Y()] == -1 && coordinatesBacktrackedFrom[currentCoordinate.X()-1][currentCoordinate.Y()] == 0;
            boolean canBacktrackDown = currentCoordinate.X() < (maze.length - 1) && maze[currentCoordinate.X()+1][currentCoordinate.Y()] == -1 && coordinatesBacktrackedFrom[currentCoordinate.X()+1][currentCoordinate.Y()] == 0;
            boolean canBacktrackLeft = currentCoordinate.Y() > 0 && maze[currentCoordinate.X()][currentCoordinate.Y()-1] == -1 && coordinatesBacktrackedFrom[currentCoordinate.X()][currentCoordinate.Y()-1] == 0;
            boolean canBacktrackRight = currentCoordinate.Y() < (maze[0].length - 1) && maze[currentCoordinate.X()][currentCoordinate.Y()+1] == -1 && coordinatesBacktrackedFrom[currentCoordinate.X()][currentCoordinate.Y()+1] == 0;

            if (isOnTheLastRow && isOnTheLastColumn) {
                paintPath(maze, coordinatesBacktrackedFrom);
                return true;
            }
            else {
                boolean foundNewPath = false;
                if (canGoLeft) {
                    moves.push(new Coordinate(currentCoordinate.X(), currentCoordinate.Y() - 1));
                    foundNewPath = true;
                } if (canGoUp) {
                    moves.push(new Coordinate(currentCoordinate.X() - 1, currentCoordinate.Y()));
                    foundNewPath = true;
                } if (canGoDown) {
                    moves.push(new Coordinate(currentCoordinate.X() + 1, currentCoordinate.Y()));
                    foundNewPath = true;
                } if (canGoRight) {
                    moves.push(new Coordinate(currentCoordinate.X(), currentCoordinate.Y() + 1));
                    foundNewPath = true;
                } if (!foundNewPath) {
                    if (canBacktrackLeft) {
                        moves.push(new Coordinate(currentCoordinate.X(), currentCoordinate.Y() - 1));
                        coordinatesBacktrackedFrom[currentCoordinate.X()][currentCoordinate.Y()] = -1;
                    } if (canBacktrackUp) {
                        moves.push(new Coordinate(currentCoordinate.X() - 1, currentCoordinate.Y()));
                        coordinatesBacktrackedFrom[currentCoordinate.X()][currentCoordinate.Y()] = -1;
                    } if (canBacktrackDown) {
                        moves.push(new Coordinate(currentCoordinate.X() + 1, currentCoordinate.Y()));
                        coordinatesBacktrackedFrom[currentCoordinate.X()][currentCoordinate.Y()] = -1;
                    } if (canBacktrackRight) {
                        moves.push(new Coordinate(currentCoordinate.X(), currentCoordinate.Y() + 1));
                        coordinatesBacktrackedFrom[currentCoordinate.X()][currentCoordinate.Y()] = -1;
                    }
                }
            }
        }

        return false;
    }

    public static void paintPath(int[][] maze, int[][] coordinatesBacktrackedFrom) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == coordinatesBacktrackedFrom[i][j] && maze[i][j] == -1
                        || maze[i][j] == 1) {
                    maze[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == -1)
                    maze[i][j] = 1;

            }
        }
    }

    public static void printMaze(int[][] maze) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("samuel-laboration1/Q1-output.txt");
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                writer.print(maze[i][j] + " ");
            }
            writer.println();
        }
        writer.close();
    }
}
