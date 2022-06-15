package InputProcessor;

import java.util.Objects;

import static AI.AI.make_random_move;
import static AI.AI.make_smart_ai_move;

public class InputProcessor {

    public static String[] update_board(String[] board, String input, String sign) {
        for (int i = 0; i < board.length; i++) {
            if (Objects.equals(board[i], input)) {
                board[i] = sign;
            }
        }
        return board;
    }

    public static boolean check_if_field_choice_is_taken(String[] board, String input) {
        int field = Integer.parseInt(input);
        if ((board[field - 1] == "X") | (board[field - 1] == "@")) {
            return true;
        }
        return false;
    }

    public static boolean check_if_game_is_won_and_notify_if_so(String[] board) {
        int[][] array_win_combos = { {0, 1, 2},{3, 4, 5},{6, 7, 8},{0, 3, 6},
                {1, 4, 7},{2, 5, 8},{0, 4, 8},{2, 4, 6} };
        for (int i = 0; i < array_win_combos.length; ++i) {
            if ((Objects.equals(board[array_win_combos[i][0]], board[array_win_combos[i][1]])) &&
                    (Objects.equals(board[array_win_combos[i][1]], board[array_win_combos[i][2]]))) {
                //if 3 board elements in one of the win_combos are equal, execute following lines:
                if (board[array_win_combos[i][0]] == "X") {
                    System.out.println("Player 1 has won!");
                }
                if (board[array_win_combos[i][0]] == "@") {
                    System.out.println("Player 2 has won!");
                }
                return true;
            }
        }

        return false;
    }

    public static boolean check_if_game_is_a_draw_and_notify_if_so(String[] board) {
        String default_board[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < default_board.length; ++j) {
                //this double loop checks if any board element is still a default number from the start
                // and returns true if that is the case.
                if (Objects.equals(board[i], default_board[j])) {
                    return false;
                }
            }
        }
        System.out.println("Game ended in a draw!");
        return true;
    }

    public static boolean check_validity_of_input_for_player_setting_and_warn_if_not(String input) {
        if (Objects.equals(input, "human")) {
            return true;
        }
        if (Objects.equals(input, "AI easy")) {
            return true;
        }
        if (Objects.equals(input, "AI hard")) {
            return true;
        }
        if (Objects.equals(input, "s")) {
            return false; //for when the loop in game engine methods starts and the input is still "s"
        }
        System.out.println('"'+input+'"'+" is not a valid input. Type again!");
        return false;
    }

    public static boolean check_if_player_wants_to_quit(String input) {
        if (Objects.equals(input, "q")) {
            return true;
        } else {
            return false;}
    }
}