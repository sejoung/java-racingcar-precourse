package io.github.sejoung;

import static io.github.sejoung.constants.GameConstants.*;

import io.github.sejoung.validator.RacingCarGameValidator;

public class RacingCarGame {

	private final TextOutput output;
	private final RacingCarGameValidator validator;
	private final PositiveIntegerMinZeroMaxNineGenerator selector;
	private final Racing racing;
	private boolean isCompleted;

	public RacingCarGame(PositiveIntegerMinZeroMaxNineGenerator selector) {
		this.selector = selector;
		this.output = new TextOutput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		this.validator = new RacingCarGameValidator(this.output);
		this.racing = new Racing(this.output);
		this.isCompleted = false;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public String flushOutput() {
		return output.flush();
	}

	public void processInput(String input) {
		int carSize = racing.getRacingCarCount();
		if (carSize == 0 && validator.carNameValidation(input)) {
			createRacingCar(input);
		}
		if (carSize > 0 && validator.racingCycleValidation(input)) {
			output.println("실행 결과");
			racing.race(Integer.parseInt(input));
			isCompleted = true;
		}
	}

	private void createRacingCar(String input) {
		String[] carNames = input.split(CAR_NAME_SEPARATOR);
		for (String carName : carNames) {
			racing.addRacingCar(new RacingCar(selector, carName));
		}
	}

}
