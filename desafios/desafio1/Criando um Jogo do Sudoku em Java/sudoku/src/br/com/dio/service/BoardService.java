package br.com.dio.service;

import br.com.dio.model.Board;
import br.com.dio.model.GameStatusEnum;
import br.com.dio.model.Space;

import java.util.*;

public class BoardService {

    private final static int BOARD_LIMIT = 9;

    private final Board board;

    public BoardService(final Map<String, String> gameConfig) {
        this.board = new Board(initBoard(gameConfig));
    }

    public List<List<Space>> getSpaces(){
        return board.getSpaces();
    }

    public void reset(){
        board.reset();
    }

    public boolean hasErrors(){
        return board.hasErrors();
    }

    public GameStatusEnum getStatus(){
        return board.getStatus();
    }

    public boolean gameIsFinished(){
        return board.gameIsFinished();
    }

    private List<List<Space>> initBoard(final Map<String, String> gameConfig) {
        List<List<Space>> spaces = new ArrayList<>();
        for (int i = 0; i < BOARD_LIMIT; i++) {
            spaces.add(new ArrayList<>());
            for (int j = 0; j < BOARD_LIMIT; j++) {
                var positionConfig = gameConfig.get("%s,%s".formatted(i, j));
                var expected = Integer.parseInt(positionConfig.split(",")[0]);
                var fixed = Boolean.parseBoolean(positionConfig.split(",")[1]);
                var currentSpace = new Space(expected, fixed);
                spaces.get(i).add(currentSpace);
            }
        }

        // Ensure no repeating numbers in each 3x3 sector
        for (int r = 0; r < BOARD_LIMIT; r += 3) {
            for (int c = 0; c < BOARD_LIMIT; c += 3) {
                Set<Integer> usedNumbers = new HashSet<>();
                for (int i = r; i < r + 3; i++) {
                    for (int j = c; j < c + 3; j++) {
                        int number = spaces.get(i).get(j).getExpected();
                        if (number != 0) {
                            usedNumbers.add(number);
                        }
                    }
                }
                for (int i = r; i < r + 3; i++) {
                    for (int j = c; j < c + 3; j++) {
                        if (spaces.get(i).get(j).getExpected() == 0) {
                            int number;
                            do {
                                number = new Random().nextInt(9) + 1;
                            } while (usedNumbers.contains(number));
                            usedNumbers.add(number);
                            spaces.get(i).get(j).setActual(number);
                        }
                    }
                }
            }
        }

        // Ensure no repeating numbers in each 3x3 sector after setting actual values
        for (int r = 0; r < BOARD_LIMIT; r += 3) {
            for (int c = 0; c < BOARD_LIMIT; c += 3) {
                Set<Integer> usedNumbers = new HashSet<>();
                for (int i = r; i < r + 3; i++) {
                    for (int j = c; j < c + 3; j++) {
                        Integer actual = spaces.get(i).get(j).getActual();
                        if (actual != null && actual != 0) {
                            usedNumbers.add(actual);
                        }
                    }
                }
                for (int i = r; i < r + 3; i++) {
                    for (int j = c; j < c + 3; j++) {
                        if (spaces.get(i).get(j).getActual() == null) {
                            int number;
                            do {
                                number = new Random().nextInt(9) + 1;
                            } while (usedNumbers.contains(number));
                            usedNumbers.add(number);
                            spaces.get(i).get(j).setActual(number);
                        }
                    }
                }
            }
        }

        return spaces;
    }
}
