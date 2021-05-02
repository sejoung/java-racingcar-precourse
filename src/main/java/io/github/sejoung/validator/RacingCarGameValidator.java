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
		if (input.split(CAR_NAME_SEPARATOR).length == 1) {
			output.printMessages("최소 2대 이상의 자동차가 필요합니다. 이름은 쉼표(,) 기준으로 구분");
			return false;
		}
		output.printMessages("시도할 회수는 몇회인가요?");
		return true;
	}
}
