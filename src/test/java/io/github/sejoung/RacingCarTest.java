package io.github.sejoung;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

	@DisplayName("4 이상일 경우 전진")
	@Test
	void sut_forward_car() {
		RacingCar car = new RacingCar(new PositiveIntegerMinZeroMaxNineGeneratorStub(4), "sejoung");
		car.rush();
		assertThat(car.getForwardCount()).isOne();
	}

	@DisplayName("3 이하일 경우 정지")
	@Test
	void sut_stop_car() {
		RacingCar car = new RacingCar(new PositiveIntegerMinZeroMaxNineGeneratorStub(3), "sejoung");
		car.rush();
		assertThat(car.getForwardCount()).isZero();
	}
}
