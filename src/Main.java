import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the amount of keys to generate: ");
        int keySize = scan.nextInt();

        System.out.println(
            "Would you like to store these numbers in Random order, Ascending Order, or Descending Order?");
        System.out.println("Type 1 for Random, 2 for Ascending, or 3 for Descending");
        int userInput = scan.nextInt();
        int[] keys;
        RandomNumberGenerator rng;
        switch (userInput) {
            case 1:
                keys = new int[keySize];
                rng = new RandomNumberGenerator();
                rng.generateRandomNumbers(keys, keySize);
                break;
            case 2:
                keys = new int[keySize];
                rng = new RandomNumberGenerator();
                rng.generateRandomNumbersAscendingOrder(keys, keySize);
                break;
            case 3:
                keys = new int[keySize];
                rng = new RandomNumberGenerator();
                rng.generateRandomNumbersDescendingOrder(keys, keySize);
                break;
            default:
        }

        try (BufferedReader reader = Files.newBufferedReader(
            Paths.get(keySize + ".keys.txt"), StandardCharsets.UTF_8)) {
            String line;
            int i = 0;
            int[] sortedNumbers = new int[keySize];
            while ((line = reader.readLine()) != null) {
                sortedNumbers[i] = Integer.parseInt(line);
                i++;
            }

            System.out.println("Would you like to sort using Merge Sort or Insertion Sort?");
            System.out.println("Type 1 for Merge Sort, or 2 for Insertion Sort.");

            userInput = scan.nextInt();
            switch(userInput) {
                case 1:
                    MergeSort ms = new MergeSort();
                    System.out.println("Sorting numbers with Merge sort...");
                    long startMergeSort = System.nanoTime();
                    ms.mergeSort(sortedNumbers, 0, sortedNumbers.length-1);
                    long endMergeSort = System.nanoTime();
                    long timeMergeSort = (endMergeSort - startMergeSort);
                    ms.writeSortFile(sortedNumbers, keySize);
                    System.out.println("Merge Sort Complete. It took " + timeMergeSort + " nanoseconds.");
                    break;
                case 2:
                    InsertionSort is = new InsertionSort();
                    System.out.println("Sorting numbers with Insertion sort...");
                    long startInsertionSort = System.nanoTime();
                    is.insertionSort(sortedNumbers, sortedNumbers.length);
                    long endInsertionSort = System.nanoTime();
                    long insertionSortTime = endInsertionSort - startInsertionSort;
                    is.writeSortFile(sortedNumbers, keySize);
                    System.out.println("Insertion Sort Complete. It took " + insertionSortTime + " nanoseconds");
                    break;
                default:
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
