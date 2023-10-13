import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaverLoader {

	ToyStore toyStore;

	public SaverLoader(ToyStore toyStore) {
		this.toyStore = toyStore;
	}

	/**
	 * @apiNote метод, сохраняющий текущее количество игрушек на складе в файл
	 * @param Название файла (склада)
	 */
	public void saveToysToFile(String filename) {
		try (FileWriter writer = new FileWriter(filename)) {
			for (Toy toy : toyStore.getToyList()) {
				writer.write(toy.toString() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @apiNote метод, позволяющий выгружать данные из файла,
	 *          сохранённые с помощью saveToysToFile
	 *          для дальнейшей работы розыгрыша
	 * @param Название файла (склада)
	 */
	public void loadToysFromFile(String filename) {
		File file = new File(filename);
		if (!file.exists()) {
			try {
				file.createNewFile();
				return;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		}
		try (Scanner scanner = new Scanner(new File(filename))) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				String[] mainParts = line.split("Количество:");

				if (mainParts.length == 2) {
					String[] idAndName = mainParts[0].split(" - ");
					String[] qtyAndWeight = mainParts[1].split("Вес:");

					if (idAndName.length == 2 && qtyAndWeight.length == 2) {
						int id = Integer.parseInt(idAndName[0].trim());
						String name = idAndName[1].trim();
						int quantity = Integer.parseInt(qtyAndWeight[0].trim());
						double weight = Double.parseDouble(qtyAndWeight[1].trim());

						Toy toy = new Toy(id, name, quantity, weight);
						toyStore.getToyList().add(toy);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
