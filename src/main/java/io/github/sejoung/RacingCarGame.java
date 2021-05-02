package io.github.sejoung;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

	private final TextOutput output;
	private final List<RacingCar> racingCars = new ArrayList<>();
	private static final String CAR_NAME_SEPARATOR = ",";
	private final PositiveIntegerMinZeroMaxNineGenerator selector;
	private int racingCycle;
	private final String LINE_SEPARATOR = System.lineSeparator();

	public RacingCarGame(PositiveIntegerMinZeroMaxNineGenerator selector) {
		this.selector = selector;
		this.output = new TextOutput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

	}

	public boolean isCompleted() {
		return false;
	}

	public String flushOutput() {
		return output.flush();
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
				output.printMessages("시도 횟수는 최소 1이상의 값이다.");
				return false;
			}
			return true;
		} catch (NumberFormatException e) {
			output.printMessages("숫자만 입력할수 있습니다.");
			return false;
		}
	}

	private boolean carNameValidation(String input) {
		if (input.split(CAR_NAME_SEPARATOR).length == 1) {
			output.printMessages("최소 2대 이상의 자동차가 필요합니다. 이름은 쉼표(,) 기준으로 구분");
			return false;
		}
		output.printMessages("시도할 회수는 몇회인가요?");
		return true;
	}

	private void createRacingCar(String input) {
		String[] carNames = input.split(CAR_NAME_SEPARATOR);
		for (String carName : carNames) {
			racingCars.add(new RacingCar(selector, carName));
		}
	}

}
