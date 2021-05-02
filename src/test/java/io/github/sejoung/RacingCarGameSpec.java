package io.github.sejoung;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarGameSpec {

	@DisplayName("게임 시작 메시지 확인")
	@Test
	void sut_first_game_message() {
		RacingCarGame game = new RacingCarGame(new PositiveIntegerMinZeroMaxNineGeneratorStub(1));
		assertThat(game.flushOutput()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}

	@DisplayName("게임 초기화시 완료상태 확인")
	@Test
	void sut_initialized_isCompleted_false() {
		RacingCarGame game = new RacingCarGame(new PositiveIntegerMinZeroMaxNineGeneratorStub(1));
		assertThat(game.isCompleted()).isFalse();
	}

	@DisplayName("2대 이상의 자동차가 필요하다.")
	@Test
	void sut_first_player_input() {
		RacingCarGame game = new RacingCarGame(new PositiveIntegerMinZeroMaxNineGeneratorStub(1));
		game.flushOutput();
		game.processInput("pobi");
		assertThat(game.flushOutput()).isEqualTo("최소 2대 이상의 자동차가 필요합니다. 이름은 쉼표(,) 기준으로 구분");
	}

	@DisplayName("자동차 이름은 최대 다섯 글자이다.")
	@Test
	void sut_first_player_input_car_name_max_five_length() {
		RacingCarGame game = new RacingCarGame(new PositiveIntegerMinZeroMaxNineGeneratorStub(1));
		game.flushOutput();
		game.processInput("pobi1,crongasd");
		assertThat(game.flushOutput()).isEqualTo("이름은 5자 이하만 가능합니다.");
	}

	@DisplayName("시도횟수 메시지 확인")
	@Test
	void sut_racing_cycle_player_input() {
		RacingCarGame game = new RacingCarGame(new PositiveIntegerMinZeroMaxNineGeneratorStub(1));
		game.flushOutput();
		game.processInput("pobi,crong,honux");
		assertThat(game.flushOutput()).isEqualTo("시도할 회수는 몇회인가요?");
	}

	@DisplayName("시도 횟수는 최소 1이상의 값이다.")
	@Test
	void sut_racing_cycle_player_input_min_one() {
		RacingCarGame game = new RacingCarGame(new PositiveIntegerMinZeroMaxNineGeneratorStub(1));
		game.flushOutput();
		game.processInput("pobi,crong,honux");
		game.flushOutput();
		game.processInput("0");
		assertThat(game.flushOutput()).isEqualTo("시도 횟수는 최소 1이상의 값이다.");
	}

	@DisplayName("시도 횟수는 숫자 값이다.")
	@Test
	void sut_racing_cycle_player_input_is_number() {
		RacingCarGame game = new RacingCarGame(new PositiveIntegerMinZeroMaxNineGeneratorStub(1));
		game.flushOutput();
		game.processInput("pobi,crong,honux");
		game.flushOutput();
		game.processInput("pobe");
		assertThat(game.flushOutput()).isEqualTo("숫자만 입력할수 있습니다.");
	}
}
