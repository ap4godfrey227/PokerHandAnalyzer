// This is the code for assignment 2, slightly modified to be specifically for strings 
import java.util.NoSuchElementException;

public class MyArrayList {
	private int capacity = 5;
	private String[ ] array = new String [capacity];
	private int size = 0;

	
	public void add(String o) { // adds a string to the list
		if (size == capacity) {
			ensureCapacity(capacity*2);
		}
		
		array[size] = o;
		size++;
	}
	
	
	public void insert(int index, String o) { //inserts a string to the list
		if (index<0 || index>size) {
			throw new NoSuchElementException();
		}
		
		for (int i=size-1;i>=index;i--) {
			array[i+1] = array[i];
		}
		array[index] = o;
		size++;
	}

	
	public void remove(int index) { // removes a string from the list
		if (index<0 || index>size) {
			throw new NoSuchElementException();
		}
		
		for (int i=index;i<size-1;i++) {
			array[i] = array[i+1];
		}
		
		size--;
	}
	
	
	
	public String get(int index) { // returns a string from the list
		return array[index];

	}

	
	public int size() { // returns the size of the list
		return size;
		
	}

	public void ensureCapacity(int minCapacity) { // Ensures the list always has enough spots
		if (minCapacity<size) {
			return;
		}
		if (minCapacity<16) {
			capacity = 16;
		}
		else {
			capacity = minCapacity;
		}
		String[ ] temp = new String[capacity];
		for (int i = 0;i<size;i++) {
			temp[i] = array[i];
		}
		array = temp;
		
	}
	
	public void trimToSize() {
		ensureCapacity(size);
	}

	
}
