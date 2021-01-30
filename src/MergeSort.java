import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MergeSort {

  public void merge(int[] A, int p, int q, int r) {
    // A = merged array, p = left, q = mid, r = right
    int n1 = q - p + 1;
    int n2 = r - q;

    int[] L = new int[n1]; // Left Array
    int[] R = new int[n2]; // Right Array

    for (int i = 0; i < n1; i++) {
      L[i] = A[p + i];
    }
    for (int j = 0; j < n2; j++) {
      R[j] = A[q + j + 1];
    }

    int i = 0; // Left Index
    int j = 0; // Right Index

    for (int k = p; k <= r; k++) {
      if (i < L.length && j < R.length) {
        if (L[i] <= R[j]) {
          A[k] = L[i];
          i++;
        } else {
          A[k] = R[j];
          j++;
        }
      } else if (i < L.length) {
        A[k] = L[i];
        i++;
      } else if (j < R.length) {
        A[k] = R[j];
        j++;
      }
    }
  }

  public void mergeSort(int[] arr, int l, int r) {
    if (l < r) {
      int q = (l + r) / 2;
      mergeSort(arr, l, q);
      mergeSort(arr, q + 1, r);
      merge(arr, l, q, r);
    }
  }

  public void writeSortFile(int[] arr, int size) {
    try (Writer writer = new BufferedWriter(new OutputStreamWriter(
        new FileOutputStream("output.mergeSort." + size + ".keys.txt"), StandardCharsets.UTF_8))) {
      for (int k = 0; k < size; k++) {
        writer.write(arr[k] + "\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void readSortFile(int[] arr, int size) {
    try (BufferedReader reader = Files.newBufferedReader(
        Paths.get("output.mergeSort." + size + ".keys.txt"), StandardCharsets.UTF_8)) {
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


