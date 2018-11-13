package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;

import model.HashTable;

class HashTableTest {
	
	private Random rd = new Random();

	@Test
	void testInsertValue() {		
		HashTable table = new HashTable();
		int value = rd.nextInt(Integer.MAX_VALUE);
		int modFunc = value % table.getM();		

		table.insert(value);		
		
		assertEquals(value, table.getMemory()[modFunc]);
	}
	
	@Test
	void testInsertConflictedValue() {		
		HashTable table = new HashTable();
		int valueOne = 45;
		int valueTwo = 85;
		int modFunc = 5;

		table.insert(valueOne);		
		table.insert(valueTwo);	
		
		assertEquals(valueTwo, table.getMemory()[modFunc+1]);
	}
	
	@Test
	void testRemoveValue() {		
		HashTable table = new HashTable();		
		int value = rd.nextInt(Integer.MAX_VALUE);
		int modFunc = value % table.getM();		
		
		table.insert(value);
		table.remove(value);				
		
		assertEquals(-1, table.getMemory()[modFunc]);
	}
	
	@Test
	void testRemoveConflictedValue() {		
		HashTable table = new HashTable();		
		int valueOne = 45;
		int valueTwo = 85;
		int modFunc = 5;

		table.insert(valueOne);		
		table.insert(valueTwo);	
		table.remove(valueTwo);
		
		assertEquals(-1, table.getMemory()[modFunc+1]);
	}
	
	@Test
	void testShowEmptyTable() {		
		HashTable table = new HashTable();		
		
		String actResult = table.show();	
		String expResult = "Table is Empty";
		
		assertEquals(expResult, actResult);
	}
	
	@Test
	void testShowNotEmptyTable() {		
		HashTable table = new HashTable();		
		
		int value = 45;		
		table.insert(value);		
		
		String actResult = table.show();	
		String expResult = "[] [] [] [] [] [" + value + "] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] [] []";
		
		assertEquals(expResult, actResult);
	}

}
