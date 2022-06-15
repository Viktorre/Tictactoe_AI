package OutputCreator;

public class OutputCreator {

    public static void print_field(String[] board) {
        System.out.println("|:::::::::::::::::|");
        for (int i = 1; i < board.length; i += 3) {
            System.out.println("|  " + board[i - 1] + "  :  " + board[i] + "  :  " + board[i + 1] + "  |");
            System.out.println("|:::::::::::::::::|");
        }
    }
}
