package io.github.sejoung;

public class PositiveIntegerMinZeroMaxNineGeneratorStub implements PositiveIntegerMinZeroMaxNineGenerator {

	private final int[] numbers;
	private int index;

	public PositiveIntegerMinZeroMaxNineGeneratorStub(int... numbers) {
		this.numbers = numbers;
	}

	@Override
	public int generate() {
		int number = this.numbers[index];
		index = (index + 1) % numbers.length;
		return number;
	}
}
