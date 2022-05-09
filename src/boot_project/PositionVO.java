package boot_project;

public class PositionVO {
	
	long number;
	String position;
	
	public PositionVO() {}

	public PositionVO(long number, String position) {
		this.number = number;
		this.position = position;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return  number + "." + position;
	}

	
	
}
