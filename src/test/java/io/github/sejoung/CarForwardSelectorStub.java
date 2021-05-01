package io.github.sejoung;

public class CarForwardSelectorStub implements CarForwardSelector {

	private final boolean isForward;

	public CarForwardSelectorStub(boolean isForward) {
		this.isForward = isForward;
	}

	@Override
	public boolean isForward() {
		return isForward;
	}
}
