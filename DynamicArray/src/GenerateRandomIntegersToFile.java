import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateRandomIntegersToFile {
    public static void main(String[] args) {
        String fileName = "1Min.txt";
        int numberOfIntegers = 1000000; // One million integers

        try (FileWriter fileWriter = new FileWriter(fileName);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            Random random = new Random();

            for (int i = 0; i < numberOfIntegers; i++) {
                int randomInt = random.nextInt(); // Generate a random integer
                bufferedWriter.write(Integer.toString(randomInt));
                bufferedWriter.newLine(); // Write a newline to separate integers
            }

            System.out.println("One million random integers written to " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
