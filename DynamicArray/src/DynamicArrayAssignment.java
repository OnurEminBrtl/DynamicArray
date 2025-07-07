import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;

class DynamicArray {
    private int[] array;
    private int size;

    public DynamicArray(int initialCapacity) {
        array = new int[initialCapacity];
        size = 0;
    }

    public void add(int value) {
        if (size == array.length) {
            int[] newArray = new int[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }

        array[size] = value;
        size++;
    }

    public void insertAt(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }

        if (size == array.length) {
            int[] newArray = new int[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }

        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = value;
        size++;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        return array[index];
    }
}

public class DynamicArrayAssignment {
    public static void main(String[] args) {
        int the_value = 0;

        LocalTime startTime;
        LocalTime endTime;
        int buildTime, insertFirstIndexTime, insertLastIndexTime, readIndex900000Time, readIndex9Time;

        // Measure the time to build the DynamicArray from a file
        startTime = LocalTime.now();
        DynamicArray dynamicArray = new DynamicArray(1);

        try (BufferedReader reader = new BufferedReader(new FileReader("1Min.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int value = Integer.parseInt(line);
                dynamicArray.add(value);}
        } catch (IOException e) {
            e.printStackTrace();
        }

        endTime = LocalTime.now();
        System.out.println(dynamicArray.get(0));
        System.out.println("1a) The DynamicArray data structure is built from the file in " + Duration.between(startTime, endTime).toMillis() +" milliseconds.");


        // Measure the time to insert an integer into the first index
        startTime = LocalTime.now();
        dynamicArray.insertAt(0, the_value);
        endTime = LocalTime.now();
        insertFirstIndexTime = (int) Duration.between(startTime, endTime).toMillis();

        // Measure the time to insert an integer into the last index
        startTime = LocalTime.now();
        dynamicArray.add(the_value);
        endTime = LocalTime.now();
        insertLastIndexTime = (int) Duration.between(startTime, endTime).toMillis();

        // Measure the time to read an integer from index 900,000
        startTime = LocalTime.now();
        int valueAtIndex900000 = dynamicArray.get(900000);
        endTime = LocalTime.now();
        readIndex900000Time = (int) Duration.between(startTime, endTime).toMillis();

        // Measure the time to read an integer from index 9
        startTime = LocalTime.now();
        int valueAtIndex9 = dynamicArray.get(9);
        endTime = LocalTime.now();
        readIndex9Time = (int) Duration.between(startTime, endTime).toMillis();

        // Print the results
        System.out.println(dynamicArray.get(900000));
        System.out.println("1b) An integer is inserted into the first index of the DynamicArray data structure in " + insertFirstIndexTime + " milliseconds.");
        System.out.println("1c) An integer is inserted into the last index of the DynamicArray data structure in " + insertLastIndexTime + " milliseconds.");
        System.out.println("1d) An integer, which is " + the_value + ", is read from the index 900,000 of the DynamicArray data structure in " + readIndex900000Time + " milliseconds.");
        System.out.println("1e) An integer, which is " + the_value + ", is read from the index 9 of the DynamicArray data structure in " + readIndex9Time + " milliseconds.");
    }
}
