package io.github.sejoung;

public class RacingCarGame {

	private final StringBuffer buffer = new StringBuffer();

	public RacingCarGame(CarForwardSelector selector) {
		this.buffer.append("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}

	public boolean isCompleted() {
		return false;
	}

	public String flushOutput() {
		String output = buffer.toString();
		buffer.setLength(0);
		return output;
	}

	public void processInput(String input) {
		if(input.split(",").length == 1){
			buffer.append("최소 2대 이상의 자동차가 필요합니다. 이름은 쉼표(,) 기준으로 구분");
		}
	}
}
