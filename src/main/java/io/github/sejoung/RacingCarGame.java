package io.github.sejoung;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

	private final StringBuffer buffer = new StringBuffer();
	private final List<RacingCar> racingCars = new ArrayList<>();
	private static final String CAR_NAME_SEPARATOR = ",";
	private final PositiveIntegerMinZeroMaxNineGenerator selector;
	private int racingCycle;

	public RacingCarGame(PositiveIntegerMinZeroMaxNineGenerator selector) {
		this.selector = selector;
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
		int carSize = racingCars.size();
		if (carSize == 0 && carNameValidation(input)) {
			createRacingCar(input);
		}
		if (carSize > 0 && racingCycleValidation(input)) {

		}
	}

	private boolean racingCycleValidation(String input) {
		try {
			this.racingCycle = Integer.parseInt(input);
			if (this.racingCycle == 0) {
				buffer.append("시도 횟수는 최소 1이상의 값이다.");
				return false;
			}
			return true;
		} catch (NumberFormatException e) {
			buffer.append("숫자만 입력할수 있습니다.");
			return false;
		}
	}

	private boolean carNameValidation(String input) {
		if (input.split(CAR_NAME_SEPARATOR).length == 1) {
			buffer.append("최소 2대 이상의 자동차가 필요합니다. 이름은 쉼표(,) 기준으로 구분");
			return false;
		}
		buffer.append("시도할 회수는 몇회인가요?");
		return true;
	}

	private void createRacingCar(String input) {
		String[] carNames = input.split(CAR_NAME_SEPARATOR);
		for (String carName : carNames) {
			racingCars.add(new RacingCar(selector, carName));
		}
	}

}
