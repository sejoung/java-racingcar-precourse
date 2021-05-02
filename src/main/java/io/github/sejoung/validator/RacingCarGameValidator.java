package io.github.sejoung.validator;

import static io.github.sejoung.constants.GameConstants.*;

import io.github.sejoung.TextOutput;

public class RacingCarGameValidator {
	private final TextOutput output;

	public RacingCarGameValidator(TextOutput output) {
		this.output = output;
	}

	public boolean racingCycleValidation(String input) {
		try {
			int racingCycle = Integer.parseInt(input);
			if (racingCycle == 0) {
				output.printMessages("시도 횟수는 최소 1이상의 값이다.");
				return false;
			}
			return true;
		} catch (NumberFormatException e) {
			output.printMessages("숫자만 입력할수 있습니다.");
			return false;
		}
	}

	public boolean carNameValidation(String input) {
		try {
			carNameArraySizeValidation(input);
			carNameLengthValidation(input);
			output.printMessages("시도할 회수는 몇회인가요?");
			return true;
		} catch (IllegalArgumentException e) {
			output.printMessages(e.getMessage());
			return false;
		}
	}

	private void carNameArraySizeValidation(String input) {
		int MIN_SIZE = 1;
		if (input.split(CAR_NAME_SEPARATOR).length == MIN_SIZE) {
			throw new IllegalArgumentException("최소 2대 이상의 자동차가 필요합니다. 이름은 쉼표(,) 기준으로 구분");
		}
	}

	private void carNameLengthValidation(String input) {
		for (String carName : input.split(CAR_NAME_SEPARATOR)) {
			carNameLengthCheck(carName);
		}
	}

	private void carNameLengthCheck(String carName) {
		int MAX_LENGTH = 5;
		if (carName.length() > MAX_LENGTH) {
			throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
		}
	}
}
