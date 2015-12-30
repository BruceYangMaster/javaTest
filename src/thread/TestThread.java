package thread;

public class TestThread {
	public static void main(String[] args) {
		Runnable dog[] = new Dog[20];
		int[] degree = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		for (int i = 0; i < 20; i++) {
			Runnable dog1 = new Dog("旺财" + i);
			dog[i] = dog1;

		}
		for (int i = 0; i < 19; i++) {
			int j = (i * 8+7) % degree.length;
			Thread thread = new Thread(dog[i]);
			thread.setPriority(degree[j]);
			thread.start();
		}

		// Dog dog2 = new Dog("旺财2");
		// Dog dog3 = new Dog("旺财3");
		// Dog dog4 = new Dog("旺财4");
		// Dog dog5 = new Dog("旺财5");
		//
		// new Thread(dog2).start();
		// new Thread(dog3).start();
		// new Thread(dog4).start();
		// new Thread(dog5).start();
	}
}
