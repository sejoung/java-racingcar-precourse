package io.github.sejoung;

import java.util.concurrent.ThreadLocalRandom;

public class RandomPositiveIntegerMinZeroMaxNineGenerator implements PositiveIntegerMinZeroMaxNineGenerator {

	@Override
	public int generate() {
		int MIN_NUMBER = 1;
		int MAX_NUMBER = 9;
		return ThreadLocalRandom.current().nextInt(MIN_NUMBER, MAX_NUMBER);
	}
}
