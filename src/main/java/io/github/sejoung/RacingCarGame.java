package io.github.sejoung;

import static io.github.sejoung.constants.GameConstants.*;

import java.util.ArrayList;
import java.util.List;

import io.github.sejoung.validator.RacingCarGameValidator;

public class RacingCarGame {

	private final TextOutput output;
	private final List<RacingCar> racingCars = new ArrayList<>();
	private final RacingCarGameValidator validator;
	private final PositiveIntegerMinZeroMaxNineGenerator selector;
	private int racingCycle;

	public RacingCarGame(PositiveIntegerMinZeroMaxNineGenerator selector) {
		this.selector = selector;
		this.output = new TextOutput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		this.validator = new RacingCarGameValidator(this.output);
	}

	public boolean isCompleted() {
		return false;
	}

	public String flushOutput() {
		return output.flush();
	}

	public void processInput(String input) {
		int carSize = racingCars.size();
		if (carSize == 0 && validator.carNameValidation(input)) {
			createRacingCar(input);
		}
		if (carSize > 0 && validator.racingCycleValidation(input)) {

		}
	}

	private void createRacingCar(String input) {
		String[] carNames = input.split(CAR_NAME_SEPARATOR);
		for (String carName : carNames) {
			racingCars.add(new RacingCar(selector, carName));
		}
	}

}
