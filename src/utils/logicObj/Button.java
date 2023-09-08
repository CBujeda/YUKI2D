package utils.logicObj;

public class Button {

	private String name;
	private boolean select;
	private int acction;
	public Button(String name, int acction) {
		super();
		this.name = name;
		this.acction = acction;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSelect() {
		return select;
	}
	public void setSelect(boolean select) {
		this.select = select;
	}
	public int getAcction() {
		return acction;
	}
	public void setAcction(int acction) {
		this.acction = acction;
	}
	
	
}
