package io.github.sejoung;

public class RacingCar {
	private final PositiveIntegerMinZeroMaxNineGenerator generator;
	private final String name;
	private int forwardCount;
	private final StringBuffer buffer = new StringBuffer();

	public RacingCar(PositiveIntegerMinZeroMaxNineGenerator generator, String name) {
		this.generator = generator;
		this.name = name;
	}

	public void run() {
		int number = generator.generate();
		int FORWARD_NUMBER = 4;
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
		String output = buffer.toString();
		buffer.setLength(0);
		return output;
	}

	private void generatorOutput() {
		buffer.append(name).append(" : ");
		for (int i = 0; i < forwardCount; i++) {
			buffer.append("-");
		}
	}
}
