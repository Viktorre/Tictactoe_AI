package AI;
import InputProcessor.InputProcessor;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AI {

    public static String make_random_move(String[] board) throws InterruptedException {
        System.out.println("AI easy is thinking...");
        TimeUnit.SECONDS.sleep(1);
        int random_int = new Random().nextInt(9)+1;
        while (InputProcessor.check_if_field_choice_is_taken(board, String.valueOf(random_int))) {
            //while field is taken draw other random int. I use a method form InputProcessor.
            // Somehow I do not need to import the class here...
            random_int = new Random().nextInt(9)+1;
        }
        return Integer.toString(random_int);
    }
    public static String make_smart_ai_move(String[] board) throws InterruptedException {
        //this fct will use a lot of if statements to recognize game situations and react to them.
        //if no if statement is triggered, it will move randomly.
        System.out.println("AI hard is thinking...");
        TimeUnit.SECONDS.sleep(1);
        if (check_if_middle_field_is_free(board)) {
            return Integer.toString(5);
        }
        if (fill_third_in_a_row(board)!="no two in a row") {
            return fill_third_in_a_row(board);
        }
        int random_int = new Random().nextInt(9)+1;
        while (InputProcessor.check_if_field_choice_is_taken(board, String.valueOf(random_int))) {
            //while field is taken draw other random int. I use a method form InputProcessor.
            // Somehow I do not need to import the class here...
            random_int = new Random().nextInt(9)+1;
        }
        return Integer.toString(random_int);
    }

    private static String fill_third_in_a_row(String[] board) {
        // this fct check all combinations of two on board and returns third piece if it finds a potential finish,
        // no matter for which player.
        if ((Objects.equals(board[0], board[1]))&&(!InputProcessor.check_if_field_choice_is_taken(board,"3")))
            return "3";
        else if ((Objects.equals(board[0], board[2]))&&(!InputProcessor.check_if_field_choice_is_taken(board,"2")))
            return "2";
        else if ((Objects.equals(board[0], board[3]))&&(!InputProcessor.check_if_field_choice_is_taken(board,"7")))
            return "7";
        else if ((Objects.equals(board[0], board[4]))&&(!InputProcessor.check_if_field_choice_is_taken(board,"9")))
            return "9";
        else if ((Objects.equals(board[0], board[8]))&&(!InputProcessor.check_if_field_choice_is_taken(board,"5")))
            return "5";
        else if ((Objects.equals(board[1], board[0]))&&(!InputProcessor.check_if_field_choice_is_taken(board,"3")))
            return "3";
        else if ((Objects.equals(board[1], board[2]))&&(!InputProcessor.check_if_field_choice_is_taken(board,"1")))
            return "1";
        else if ((Objects.equals(board[1], board[4]))&&(!InputProcessor.check_if_field_choice_is_taken(board,"8")))
            return "8";
        else if ((Objects.equals(board[1], board[7]))&&(!InputProcessor.check_if_field_choice_is_taken(board,"5")))
            return "5";
        else if ((Objects.equals(board[2], board[4]))&&(!InputProcessor.check_if_field_choice_is_taken(board,"7")))
            return "7";
        else if ((Objects.equals(board[2], board[5]))&&(!InputProcessor.check_if_field_choice_is_taken(board,"9")))
            return "9";
        else if ((Objects.equals(board[2], board[6]))&&(!InputProcessor.check_if_field_choice_is_taken(board,"5")))
            return "5";
        else if ((Objects.equals(board[2], board[8]))&&(!InputProcessor.check_if_field_choice_is_taken(board,"6")))
            return "6";
        else if ((Objects.equals(board[3], board[4]))&&(!InputProcessor.check_if_field_choice_is_taken(board,"6")))
            return "6";
        else if ((Objects.equals(board[3], board[5]))&&(!InputProcessor.check_if_field_choice_is_taken(board,"5")))
            return "5";
        else if ((Objects.equals(board[3], board[6]))&&(!InputProcessor.check_if_field_choice_is_taken(board,"1")))
            return "1";
        else if ((Objects.equals(board[4], board[5]))&&(!InputProcessor.check_if_field_choice_is_taken(board,"4")))
            return "4";
        else if ((Objects.equals(board[4], board[7]))&&(!InputProcessor.check_if_field_choice_is_taken(board,"2")))
            return "2";
        else if ((Objects.equals(board[5], board[8]))&&(!InputProcessor.check_if_field_choice_is_taken(board,"3")))
            return "3";
        else if ((Objects.equals(board[6], board[7]))&&(!InputProcessor.check_if_field_choice_is_taken(board,"9")))
            return "9";
        else if ((Objects.equals(board[6], board[8]))&&(!InputProcessor.check_if_field_choice_is_taken(board,"8")))
            return "8";
        else if ((Objects.equals(board[7], board[8]))&&(!InputProcessor.check_if_field_choice_is_taken(board,"7")))
            return "7";
        else if ((Objects.equals(board[8], board[3]))&&(!InputProcessor.check_if_field_choice_is_taken(board,"7")))
            return "7";
        else return "no two in a row";
    }


    private static boolean check_if_middle_field_is_free(String[] board) {
        if ((board[4] == "X") | (board[4] == "@")) {
            return false;
        }
        return true;
    }


}