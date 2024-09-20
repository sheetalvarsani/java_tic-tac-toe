public class TicTacToe {
    public static void main(String[] args) {
        runGame();  // Start the game
    }

    public static void runGame(){
        String[][] gameBoard = new String[3][3];

        // Initialise game board
        initialiseGameBoard(gameBoard);

        // Print board to check if it's working
        printCurrentBoard(gameBoard);
    }

    // Initialise game board with empty spaces
    public static void initialiseGameBoard(String[][] gameBoard) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                gameBoard[row][col] = " ";
            }
        }
    }

    // Print state of board
    public static void printCurrentBoard(String[][] gameBoard) {
        System.out.println("Current Board:");
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(" " + gameBoard[row][col] + " ");
                if (col < 2) System.out.print("|"); // Column separator
            }
            System.out.println();  // Move to the next line after each row
            if (row < 2) {
                System.out.println("-----------");  // Row separator
            }
        }
    }
}
