package io.github.sejoung;

import java.util.concurrent.ThreadLocalRandom;

public class RandomCarForwardSelector implements CarForwardSelector {

	@Override
	public boolean isForward() {
		int MIN_NUMBER = 1;
		int MAX_NUMBER = 9;
		int random = ThreadLocalRandom.current().nextInt(MIN_NUMBER, MAX_NUMBER);
		int FORWARD_NUMBER = 4;
		System.out.println(random);
		return FORWARD_NUMBER <= random;
	}

}
