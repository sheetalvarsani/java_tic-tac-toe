import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        runGame();  // Start the game
    }

    public static void runGame() {
        String[][] gameBoard = new String[3][3]; // create 3x3 board
        boolean xTurn = true; // variable if its player X to start
        int col, row; // Declare col and row variables

        // Initialise game board
        initialiseGameBoard(gameBoard);

        // Main game loop
        while (true) {
            printCurrentBoard(gameBoard);
            getUserInput(gameBoard, xTurn); // Get user input

            // Check for a winner or tie here (to be implemented later)

            // Switch players
            xTurn = !xTurn; // Toggle turn
        }
    }

    // Initialise game board with empty spaces
    public static void initialiseGameBoard(String[][] gameBoard) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                gameBoard[col][row] = " "; // epmty space for each cell
            }
        }
    }

    // Print state of board
    public static void printCurrentBoard(String[][] gameBoard) {
        System.out.println("Current Board:");
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(" " + gameBoard[col][row] + " ");
                if (col < 2) System.out.print("|"); // Col separator
            }
            System.out.println();  // Move to the next line after each row
            if (row < 2) {
                System.out.println("-----------");  // Row separator
            }
        }
    }

    public static void getUserInput(String[][] gameBoard, boolean xTurn) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Player " + (xTurn ? "X" : "O") + ", enter your move (column and row [1-3] eg. 2 1): ");
            String input = scanner.nextLine();

            String[] parts = input.split(" "); // Split string by space
            if (parts.length == 2) { // Check if there are exactly two parts
                try {
                    int col = Integer.parseInt(parts[0]); // First number (column)
                    int row = Integer.parseInt(parts[1]); // Second number (row)

                    // Check both numbers are between 1 and 3
                    if (col >= 1 && col <= 3 && row >= 1 && row <= 3) {
                        col -= 1; // Convert to 0-based index for col
                        row -= 1; // Convert to 0-based index for row

                        // Check if cell is occupied already
                        if (!cellAlreadyOccupied(col, row, gameBoard)) {
                            gameBoard[col][row] = xTurn ? "X" : "O"; // Update the board based on turn
                            break; //
                        } else {
                            System.out.println("This cell is already occupied. Try again.");
                        }
                    } else {
                        System.out.println("Numbers must be between 1 and 3. Try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter two numbers separated by a space.");
                }
            } else {
                System.out.println("Invalid input. Please enter two numbers separated by a space.");
            }
        }
    }


    // Check if cell is occupied:
    public static boolean cellAlreadyOccupied(int col, int row, String[][] gameBoard) {
        return !gameBoard[col][row].equals(" ");
    }
}
