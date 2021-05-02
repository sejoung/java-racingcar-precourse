package io.github.sejoung;

public class TextOutput {
	private final StringBuilder buffer = new StringBuilder();

	public TextOutput() {
	}

	public TextOutput(String initialOutput) {
		buffer.append(initialOutput);
	}

	public void print(String messages) {
		buffer.append(messages);
	}

	public void println(String messages) {
		buffer.append(messages);
		lineSeparator();
	}

	public void lineSeparator() {
		buffer.append(System.lineSeparator());
	}

	public String flush() {
		String output = buffer.toString();
		buffer.setLength(0);
		return output;
	}

}
