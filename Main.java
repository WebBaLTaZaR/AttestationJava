
public class Main {
	public static void main(String[] args) {
		ToyStore store = new ToyStore();
		SaverLoader saverLoader = new SaverLoader(store);
		saverLoader.loadToysFromFile("toys.txt");

		Toy toy1 = new Toy(1, "Teddy Bear", 5, 10.0);
		Toy toy2 = new Toy(2, "Robot", 4, 5.0);
		Toy toy3 = new Toy(3, "Puzzle", 6, 8.5);

		if (store.isEmpty()) {
			store.addToy(toy1);
			store.addToy(toy2);
			store.addToy(toy3);
		}
		Toy selectedToy = store.selectRandomToyByWeight();
		if (selectedToy != null) {
			selectedToy.decreaseQuantity();
			store.writeToyToFile(selectedToy);
		}

		saverLoader.saveToysToFile("toys.txt");
	}
}
