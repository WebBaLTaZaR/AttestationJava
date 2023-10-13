
public class Toy {
	private int id;
	private String name;

	private int quantity;
	private double weight;

	public Toy(int id, String name, int quantity, double weight) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * @apiNote метод уменьшает количество игрушек на 1
	 */
	public void decreaseQuantity() {
		this.quantity--;
	}

	@Override
	public String toString() {
		return id + " - " + name + " Количество: " + quantity + " Вес: " + weight;
	}

	/**
	 * @apiNote Аналог toString для вывода одного товара и записи его в 'toy.txt'
	 * @return Строку
	 */
	public String toFileString() {
		return id + " - " + name + " Количество: 1, Вес: " + weight;
	}

}
