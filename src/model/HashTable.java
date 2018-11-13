package model;

public class HashTable {

	private int m = 40;
	private int[] memory = new int[m];
	private int index = 0;

	private int hashFunction(int x) {
		return x % m;
	}

	public HashTable() {
		for (int i = 0; i < m; i++) memory[i] = -1;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
		this.memory = new int[m];
	}

	public int[] getMemory() {
		return memory;
	}

	public String insert(int value) {
		int key = hashFunction(value);
		return insert(key, value);
	}

	private String insert(int key, int value) {	
		String result = "";
		if (index == m) result = "Table is full";

		if (memory[key] == -1) {
			memory[key] = value;
			index++;
			result = String.format("value %d inserted in the %d position", value, key);
		}
		else if (key+1 < m) result = insert(key+1, value);
		else if (key+1 >= m) result = insert(0, value);

		return result;
	}

	public String remove(int value) {
		int key = hashFunction(value);
		return remove(key, value);
	}

	private String remove(int key, int value) {
		String result = "";
		if (index == 0) result = "Table is Empty";

		if (memory[key] == value) {
			memory[key] = -1;
			index--;
			result = String.format("value %d removed of the %d position", value, key);
		}
		else if (key+1 < m) result = remove(key+1, value);
		else if (key+1 >= m) result = remove(0, value);

		return result;
	}

	public String show() {
		String result = "";
		if (index == 0) result = "Table is Empty";
		else {
			for (int i = 0; i < m; i++) {
				if (memory[i] == -1) result = result + "[] ";
				else result = result + "[" + memory[i] + "] ";
			}
		}
		return result.trim();
	}

}
