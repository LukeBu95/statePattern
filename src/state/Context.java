package state;

public class Context {

	private State state;

	/**
	 * @return the state
	 */
	private State getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	private void setState(State state) {
		this.state = state;
	}

	
	public String getItem(int item) throws IllegalStateException {

		switch (item) {
		case 15:
			this.setState(new Cookie());
			break;
		case 38:
			this.setState(new Chocolate());
			break;
		case 41:
			this.setState(new Pepsi());
			break;
		default:
			throw new IllegalStateException();
		}

		return this.getState().getItem();
	}

}
