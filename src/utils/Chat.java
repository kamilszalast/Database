package utils;

import java.util.Scanner;

public class Chat {
    public String getFilePath() {
        System.out.println("Podaj ścieżkę do pliku, z którego chcesz utworzyć bazę klientów: ");
        return new Scanner(System.in).nextLine();
    }
}
