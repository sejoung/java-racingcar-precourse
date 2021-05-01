package io.github.sejoung.console;

import java.util.Scanner;

import io.github.sejoung.RacingCarGame;
import io.github.sejoung.RandomCarForwardSelector;

public class Application {
	public static void main(String[] args) {
		RacingCarGame game = new RacingCarGame(new RandomCarForwardSelector());
		Scanner scanner = new Scanner(System.in);
		playGame(game, scanner);
	}

	private static void playGame(RacingCarGame game, Scanner scanner) {
		for (int i = 0; i < 2; i++) {
			System.out.println(game.flushOutput());
			game.processInput(scanner.nextLine());
		}
		System.out.println(game.flushOutput());
	}

}
