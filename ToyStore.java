import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyStore {
	private List<Toy> toyList;
	private Random random;

	public ToyStore() {
		this.toyList = new ArrayList<>();
		this.random = new Random();
	}

	/**
	 * @apiNote метод добавления игрушки
	 * @param toy
	 */
	public void addToy(Toy toy) {
		toyList.add(toy);
	}

	/**
	 * @apiNote Метод выбирающий рандомную игрушку исходя из её веса
	 * @return Выпавшую игрушку
	 */
	public Toy selectRandomToyByWeight() {
		double totalWeight = toyList.stream().mapToDouble(Toy::getWeight).sum();
		double randomValue = random.nextDouble() * totalWeight;
		double currentWeight = 0;
		for (Toy toy : toyList) {
			currentWeight += toy.getWeight();
			if (currentWeight > randomValue) {
				return toy;
			}
		}
		return null;
	}

	/**
	 * @apiNote метод, записывающий в файл "toy.txt" выпавшую игрушку
	 * @param toy
	 */
	public void writeToyToFile(Toy toy) {
		try (FileWriter fWriter = new FileWriter("toy.txt", true)) {
			fWriter.write(toy.toFileString() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Toy> getToyList() {
		return toyList;
	}

	/**
	 * @apiNote Проверка на пустой лист
	 * @return true or false
	 */
	public boolean isEmpty() {
		return toyList.isEmpty();
	}
}
