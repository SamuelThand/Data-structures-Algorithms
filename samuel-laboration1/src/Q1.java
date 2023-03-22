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

    public static void main(String[] args) {
        var inputFile = "samuel-laboration1/Q1-input.txt";
        try {
            int[][] maze = loadMaze(inputFile);

        } catch (FileNotFoundException | IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
