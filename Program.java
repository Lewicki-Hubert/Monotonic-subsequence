import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Brak ścieżki do pliku z danymi wejściowymi.");
            System.exit(1);
        }

        String filePath = args[0];
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {
            if (scanner.hasNext()) {
                int n1 = scanner.nextInt();
                int maxLengthIncreasing = 1;
                int currentLengthIncreasing = 1;
                int maxSumIncreasing = n1;
                int currentSumIncreasing = n1;

                int maxLengthDecreasing = 1;
                int currentLengthDecreasing = 1;
                int maxSumDecreasing = n1;
                int currentSumDecreasing = n1;

                while (scanner.hasNext()) {
                    int n2 = scanner.nextInt();

                    // Sprawdzenie rosnącego podciągu
                    if (n2 >= n1) {
                        currentLengthIncreasing++;
                        currentSumIncreasing += n2;
                    } else {
                        maxLengthIncreasing = Math.max(maxLengthIncreasing, currentLengthIncreasing);
                        maxSumIncreasing = Math.max(maxSumIncreasing, currentSumIncreasing);
                        currentLengthIncreasing = 1;
                        currentSumIncreasing = n2;
                    }

                    // Sprawdzenie malejącego podciągu
                    if (n2 <= n1) {
                        currentLengthDecreasing++;
                        currentSumDecreasing += n2;
                    } else {
                        maxLengthDecreasing = Math.max(maxLengthDecreasing, currentLengthDecreasing);
                        maxSumDecreasing = Math.max(maxSumDecreasing, currentSumDecreasing);
                        currentLengthDecreasing = 1;
                        currentSumDecreasing = n2;
                    }

                    n1 = n2;
                }

                maxLengthIncreasing = Math.max(maxLengthIncreasing, currentLengthIncreasing);
                maxSumIncreasing = Math.max(maxSumIncreasing, currentSumIncreasing);

                maxLengthDecreasing = Math.max(maxLengthDecreasing, currentLengthDecreasing);
                maxSumDecreasing = Math.max(maxSumDecreasing, currentSumDecreasing);

                if (maxLengthIncreasing >= maxLengthDecreasing) {
                    System.out.println(maxLengthIncreasing + " " + maxSumIncreasing);
                } else {
                    System.out.println(maxLengthDecreasing + " " + maxSumDecreasing);
                }
            } else {
                System.out.println("Brak danych wejściowych. Koniec programu.");
            }
        } catch (IOException e) {
            System.out.println("Błąd odczytu pliku: " + e.getMessage());
        }
    }
}
