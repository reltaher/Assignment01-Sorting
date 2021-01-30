import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InsertionSort {
  public void insertionSort(int[] A, int n) {
    for (int j = 1; j < n; j++) {
      int key = A[j];
      //Insert A[j] into the sorted sequence A[1..j-1]
      int i = j-1;
      while (i >= 0 && A[i] > key) {
        A[i+1] = A[i];
        i--;
      }
      A[i+1] = key;
    }
  }

  public void writeSortFile(int[] arr, int size) {
    try (Writer writer = new BufferedWriter(new OutputStreamWriter(
        new FileOutputStream("output.insertionSort." + size + ".keys.txt"), StandardCharsets.UTF_8))) {
      for (int k = 0; k < size; k++) {
        writer.write(arr[k] + "\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void readFile(int[] arr, int size) {
    try (BufferedReader reader = Files.newBufferedReader(
        Paths.get("output.insertionSort." + size + ".keys.txt"), StandardCharsets.UTF_8)) {
      String line;
      int i = 0;
      while ((line = reader.readLine()) != null) {
        arr[i] = Integer.parseInt(line);
        i++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
