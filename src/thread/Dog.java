package thread;

public class Dog implements Runnable {
	private String name;

	public void run() {
		shout();
	}

	public void shout() {
		System.out.println(name + "На");
	}

	public Dog() {

	}

	public Dog(String name) {
		super();
		this.name = name;
	}

	public String toString() {
		return getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
