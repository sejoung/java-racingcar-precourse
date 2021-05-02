package io.github.sejoung;

import java.util.concurrent.ThreadLocalRandom;

public class RandomPositiveIntegerMinZeroMaxNineGenerator implements PositiveIntegerMinZeroMaxNineGenerator {

	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;

	@Override
	public int generate() {
		return ThreadLocalRandom.current().nextInt(MIN_NUMBER, MAX_NUMBER);
	}
}
