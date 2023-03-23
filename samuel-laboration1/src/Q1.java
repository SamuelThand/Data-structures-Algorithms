import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q1 {

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

        Coordinate currentCoordinate = new Coordinate(0, 0);
        SamuelFixedSizeStack<Coordinate> moves = new SamuelFixedSizeStack<>(50000000);

        moves.push(new Coordinate(0, 0)); // The starting position

        while (!moves.isEmpty()) {
            currentCoordinate = moves.pop();
            boolean isOnTheLastRow = currentCoordinate.X() == (maze.length - 1);
            boolean isOnTheLastColumn = currentCoordinate.Y() == (maze[0].length - 1);
            boolean canGoUp = currentCoordinate.X() > 0 && maze[currentCoordinate.X()-1][currentCoordinate.Y()] == 1;
            boolean canGoDown = currentCoordinate.X() < (maze.length - 1) && maze[currentCoordinate.X()+1][currentCoordinate.Y()] == 1;
            boolean canGoLeft = currentCoordinate.Y() > 0 && maze[currentCoordinate.X()][currentCoordinate.Y()-1] == 1;
            boolean canGoRight = currentCoordinate.Y() < (maze[0].length - 1) && maze[currentCoordinate.X()][currentCoordinate.Y()+1] == 1;

            if (isOnTheLastRow && isOnTheLastColumn) {
                maze[currentCoordinate.X()][currentCoordinate.Y()] = -1; // Marked as visited
                return true;
            }
            else {
                    maze[currentCoordinate.X()][currentCoordinate.Y()] = -1; // Marked as visited

                    if (canGoRight)
                        moves.push(new Coordinate(currentCoordinate.X(), currentCoordinate.Y() + 1));
                    if (canGoDown)
                        moves.push(new Coordinate(currentCoordinate.X() + 1, currentCoordinate.Y()));
                    if (canGoUp)
                        moves.push(new Coordinate(currentCoordinate.X() - 1, currentCoordinate.Y()));
                    if (canGoLeft)
                        moves.push(new Coordinate(currentCoordinate.X(), currentCoordinate.Y() - 1));
            }
        }

        return false;
    }

    public static void main(String[] args) {
        var inputFile = "samuel-laboration1/Q1-input.txt";
        try {
            int[][] maze = loadMaze(inputFile);
            boolean success = navigateMaze(maze);
            if (success) {
                System.out.println("Found way");
                for (int[] rows : maze) {
                    for (int j = 0; j < maze[0].length; j++) {
                        System.out.print(rows[j] + " ");
                    }
                    System.out.println();
                }
            }
            else {
                System.out.println("Did not find way");
                for (int[] ints : maze) {
                    for (int j = 0; j < maze[0].length; j++) {
                        System.out.print(ints[j]);
                    }
                    System.out.println();
                }
            }


        } catch (FileNotFoundException | IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
