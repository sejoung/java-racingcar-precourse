package io.github.sejoung.console;

import java.util.Scanner;

import io.github.sejoung.RacingCarGame;
import io.github.sejoung.RandomPositiveIntegerMinZeroMaxNineGenerator;

public class Application {
	public static void main(String[] args) {
		RacingCarGame game = new RacingCarGame(new RandomPositiveIntegerMinZeroMaxNineGenerator());
		Scanner scanner = new Scanner(System.in);
		playGame(game, scanner);
	}

	private static void playGame(RacingCarGame game, Scanner scanner) {
		while (game.isCompleted()) {
			System.out.println(game.flushOutput());
			game.processInput(scanner.nextLine());
		}
		System.out.println(game.flushOutput());
	}

}
