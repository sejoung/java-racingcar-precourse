package io.github.sejoung;

import java.util.ArrayList;
import java.util.List;

public class Racing {
	private final List<RacingCar> racingCars = new ArrayList<>();
	private final TextOutput output;

	public Racing(TextOutput output) {
		this.output = output;
	}

	public void race(int racingCycle) {
		for (int i = 0; i < racingCycle; i++) {
			runCars();
		}
		RacingWinner racingWinner = new RacingWinner(racingCars);
		output.print(racingWinner.getWinnersName() + "가 최종 우승했습니다.");
	}

	public void addRacingCar(RacingCar car) {
		racingCars.add(car);
	}

	public int getRacingCarCount() {
		return racingCars.size();
	}

	private void runCars() {
		racingCars.forEach(racingCar -> {
			racingCar.run();
			output.println(racingCar.flushOutput());
		});
		output.lineSeparator();
	}
}
