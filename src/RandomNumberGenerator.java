import java.io.BufferedWriter;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class RandomNumberGenerator {

  Random rand;

  public void generateRandomNumbers(int[] randomNumbers, int size) {
    rand = new Random();
    try (Writer writer = new BufferedWriter(new OutputStreamWriter(
        new FileOutputStream(size + ".keys.txt"), StandardCharsets.UTF_8))) {
      for (int i = 0; i < size; i++) {
        randomNumbers[i] = rand.nextInt(Integer.MAX_VALUE);
        writer.write(randomNumbers[i] + "\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void generateRandomNumbersAscendingOrder(int[] randomNumbers, int size) {
    rand = new Random();

    for (int i = 0; i < size; i++) {
      randomNumbers[i] = rand.nextInt(Integer.MAX_VALUE);
    }
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < randomNumbers.length; j++) {
        if (randomNumbers[i] < randomNumbers[j]) {
          int temp = randomNumbers[i];
          randomNumbers[i] = randomNumbers[j];
          randomNumbers[j] = temp;
        }
      }
    }
    try (Writer writer = new BufferedWriter(new OutputStreamWriter(
        new FileOutputStream(size + ".keys.txt"), StandardCharsets.UTF_8))) {
      for (int i = 0; i < size; i++) {
        writer.write(randomNumbers[i] + "\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void generateRandomNumbersDescendingOrder(int[] randomNumbers, int size) {
    rand = new Random();

    for (int i = 0; i < size; i++) {
      randomNumbers[i] = rand.nextInt(Integer.MAX_VALUE);
    }
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < randomNumbers.length; j++) {
        if (randomNumbers[i] > randomNumbers[j]) {
          int temp = randomNumbers[i];
          randomNumbers[i] = randomNumbers[j];
          randomNumbers[j] = temp;
        }
      }
    }
    try (Writer writer = new BufferedWriter(new OutputStreamWriter(
        new FileOutputStream(size + ".keys.txt"), StandardCharsets.UTF_8))) {
      for (int i = 0; i < size; i++) {
        writer.write(randomNumbers[i] + "\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

