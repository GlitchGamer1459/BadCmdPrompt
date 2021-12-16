package Application.control;

import java.util.HashMap;

public class CommandIndexList {

    public final HashMap<String, Integer> PRIMARY_CMDS = new HashMap<>();

    public final HashMap<String, Integer> PLAY_CMDS = new HashMap<>();

    public final HashMap<String, Integer> CALCULATE_CMDS = new HashMap<>();

    private void setIndexPairs() {
        PRIMARY_CMDS.put("stop", 0);
        PRIMARY_CMDS.put("help", 1);
        PRIMARY_CMDS.put("play", 2);
        PRIMARY_CMDS.put("calculate", 3);
        PRIMARY_CMDS.put("cls", 4);

        PLAY_CMDS.put("hangman", 0);
        PLAY_CMDS.put("tictactoe", 1);
        PLAY_CMDS.put("guessgame", 2);

        CALCULATE_CMDS.put("sqrt", 0);
        CALCULATE_CMDS.put("add", 1);
        CALCULATE_CMDS.put("subtract", 2);
    }

    public CommandIndexList() {
        setIndexPairs();
    }
}
