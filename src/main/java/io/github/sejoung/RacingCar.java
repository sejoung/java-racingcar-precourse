package io.github.sejoung;

public class RacingCar {
	private static final int FORWARD_NUMBER = 4;
	private final PositiveIntegerMinZeroMaxNineGenerator generator;
	private final String name;
	private final TextOutput output = new TextOutput();
	private int forwardCount;

	public RacingCar(PositiveIntegerMinZeroMaxNineGenerator generator, String name) {
		this.generator = generator;
		this.name = name;
	}

	public void run() {
		int number = generator.generate();

		if (FORWARD_NUMBER <= number) {
			forwardCount++;
		}
		generatorOutput();
	}

	public int getForwardCount() {
		return forwardCount;
	}

	public String getName() {
		return name;
	}

	public String flushOutput() {
		return output.flush();
	}

	private void generatorOutput() {
		output.print(name);
		output.print(" : ");
		for (int i = 0; i < forwardCount; i++) {
			output.print("-");
		}
	}
}
