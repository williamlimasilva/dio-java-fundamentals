package br.com.dio;

import br.com.dio.ui.custom.screen.MainScreen;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class UIMain {

    public static void main(String[] args) {
        final var positions = (args.length == 0) ? generateRandomPositions() : Stream.of(args)
                .collect(toMap(k -> k.split(";")[0], v -> v.split(";")[1]));
        var mainScreen = new MainScreen(positions);
        mainScreen.buildMainScreen();
    }

    private static Map<String, String> generateRandomPositions() {
        Random random = new Random();
        Map<String, String> positions = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int number = random.nextInt(9) + 1;
                boolean fixed = random.nextBoolean();
                positions.put("%s,%s".formatted(i, j), "%s,%s".formatted(number, fixed));
            }
        }
        return positions;
    }
}