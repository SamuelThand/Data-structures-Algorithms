package Q1;

import java.io.*;

import static java.lang.System.exit;

public class Question1 {

    private static String inputFile;


    public static void main(String[] args) {
        inputFile = "tobias-laboration1/src/Q1/input.txt";
        int[][] maze = loadMaze(inputFile);
        if (maze == null) {
            System.out.println("Error loading maze");
            exit(1);
        }
        THRat rat = new THRat(maze);
        if (rat.solveMaze()) {
            System.out.println("Path found");
            int[][] mazePath = rat.printMazePath();
            saveMaze(mazePath);
        } else {
            System.out.println("No path found");
            writeToFile("tobias-laboration1/src/Q1/output.txt", "PATH NOT FOUND");

        }
    }

    private static int[][] loadMaze(String inputFile) {
        int[][] maze;
        File file = new File(inputFile);
        try ( BufferedReader reader = new BufferedReader(new FileReader(file)) ) {
            String line = reader.readLine();
            int N = line.split(" ").length;
            maze = new int[N][N];
            for (int i = 0; i < N; i++) {
                String[] row = line.split(" ");
                for (int j = 0; j < N; j++) {
                    maze[i][j] = Integer.parseInt(row[j]);
                }
                line = reader.readLine();
            }
            return maze;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return null;
    }

    private static void saveMaze(int[][] maze) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : maze) {
            for (int i : row) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        writeToFile("tobias-laboration1/src/Q1/output.txt", sb.toString());
    }

    private static void writeToFile(String fileName, String text) {
        try ( PrintWriter writer = new PrintWriter(fileName) ) {
            writer.println(text);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

}
