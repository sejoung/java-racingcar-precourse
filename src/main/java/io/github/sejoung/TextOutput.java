package io.github.sejoung;

public class TextOutput {
	private final StringBuffer buffer = new StringBuffer();

	private final String LINE_SEPARATOR = System.lineSeparator();

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
		buffer.append(LINE_SEPARATOR);
	}

	public String flush() {
		String output = buffer.toString();
		buffer.setLength(0);
		return output;
	}

}
