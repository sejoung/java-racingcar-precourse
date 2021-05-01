package io.github.sejoung;

public class RacingCar {
	private final PositiveIntegerMinZeroMaxNineGenerator generator;
	private final String name;
	private int forwardCount;

	public RacingCar(PositiveIntegerMinZeroMaxNineGenerator generator, String name) {
		this.generator = generator;
		this.name = name;
	}

	public void rush() {
		int number = generator.generate();
		int FORWARD_NUMBER = 4;
		if (FORWARD_NUMBER <= number) {
			forwardCount++;
		}
	}

	public int getForwardCount() {
		return forwardCount;
	}
}
