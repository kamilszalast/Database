package configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class PasswordInserter {
    public static String[] passwordInsert() {
        String[] userdata = new String[2];
        System.out.println("Podaj ścieżkę do pliku z loginem i hasłem: ");
        Scanner sc = new Scanner(System.in);
        String filePath = sc.nextLine();
        File test1 = new File(filePath);

        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(test1);
            bufferedReader = new BufferedReader(fileReader);
            String nextLine;
            int i = 0;
            while ((nextLine = bufferedReader.readLine()) != null) {
                userdata[i] = nextLine;
                i++;
            }
            return userdata;
        } catch (
                Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
