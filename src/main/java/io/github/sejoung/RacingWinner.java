package io.github.sejoung;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingWinner {
	private final List<RacingCar> racingCars;
	private final List<String> winnersName = new ArrayList<>();

	public RacingWinner(List<RacingCar> racingCars) {
		this.racingCars = racingCars;
		selection();
	}

	private void selection() {
		int winnerForwardCount = getWinnerForwardCount();
		racingCars.forEach(racingCar -> winnersCheck(winnerForwardCount, racingCar));
	}

	private int getWinnerForwardCount() {
		List<Integer> forwardCountList = new ArrayList<>();
		racingCars.forEach(car -> forwardCountList.add(car.getForwardCount()));
		return Collections.max(forwardCountList);
	}

	private void winnersCheck(int winnerForwardCount, RacingCar car) {
		if (winnerForwardCount == car.getForwardCount()) {
			winnersName.add(car.getName());
		}
	}

	public String getWinnersName() {
		return String.join(", ", winnersName);
	}
}
