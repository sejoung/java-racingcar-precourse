package io.github.sejoung;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarGameSpec {

	@DisplayName("게임 시작 메시지 확인")
	@Test
	void sut_first_game_message() {
		RacingCarGame game = new RacingCarGame(new CarForwardSelectorStub(true));
		assertThat(game.flushOutput()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}
}
