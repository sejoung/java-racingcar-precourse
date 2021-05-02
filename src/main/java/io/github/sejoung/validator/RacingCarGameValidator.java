package io.github.sejoung.validator;

import static io.github.sejoung.constants.GameConstants.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import io.github.sejoung.TextOutput;

public class RacingCarGameValidator {
	private final TextOutput output;

	public RacingCarGameValidator(TextOutput output) {
		this.output = output;
	}

	public boolean racingCycleValidation(String input) {
		try {
			return racingCycleCheck(Integer.parseInt(input));
		} catch (NumberFormatException e) {
			output.print("숫자만 입력할수 있습니다.");
			return false;
		}
	}

	public boolean carNameValidation(String input) {
		try {
			carNameArraySizeValidation(input);
			carNameLengthValidation(input);
			carNameDuplicateValidation(input);
			output.print("시도할 회수는 몇회인가요?");
			return true;
		} catch (IllegalArgumentException e) {
			output.print(e.getMessage());
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

	private void carNameDuplicateValidation(String input) {
		Set<String> nameSet = new HashSet<>();
		String[] names = input.split(CAR_NAME_SEPARATOR);
		Collections.addAll(nameSet, names);

		if (names.length != nameSet.size()) {
			throw new IllegalArgumentException("자동차 이름은 중복되게 입력 할 수 없습니다.");
		}
	}

	private void carNameLengthCheck(String carName) {
		int MAX_LENGTH = 5;
		if (carName.length() > MAX_LENGTH) {
			throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
		}
	}

	private boolean racingCycleCheck(int racingCycle) {
		if (racingCycle == 0) {
			output.print("시도 횟수는 최소 1이상의 값이다.");
			return false;
		}
		return true;
	}
}
