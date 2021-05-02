package io.github.sejoung;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingWinnerTest {

	@DisplayName("우승자가 여러명일때")
	@Test
	void sut_winner_mutit() {
		List<RacingCar> racingCars = Arrays.asList(
			new RacingCar(new PositiveIntegerMinZeroMaxNineGeneratorStub(4), "abc"),
			new RacingCar(new PositiveIntegerMinZeroMaxNineGeneratorStub(4), "ccc"));
		racingCarsRun(racingCars);
		RacingWinner racingWinner = new RacingWinner(racingCars);
		assertThat(racingWinner.getWinnersName()).isEqualTo("abc, ccc");
	}

	@DisplayName("우승자가 한명일때")
	@Test
	void sut_winner_one() {
		List<RacingCar> racingCars = Arrays.asList(
			new RacingCar(new PositiveIntegerMinZeroMaxNineGeneratorStub(4), "abc"),
			new RacingCar(new PositiveIntegerMinZeroMaxNineGeneratorStub(3), "ccc"));
		racingCarsRun(racingCars);
		RacingWinner racingWinner = new RacingWinner(racingCars);
		assertThat(racingWinner.getWinnersName()).isEqualTo("abc");
	}

	private void racingCarsRun(List<RacingCar> racingCars) {
		racingCars.forEach(RacingCar::run);
	}
}
