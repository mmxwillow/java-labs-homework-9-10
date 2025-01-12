import java.io.*;
import java.net.*;
import java.util.*;

public class Lab10Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj pierwsze 3 cyfry numeru konta: ");
        String firstThreeDigits = scanner.nextLine().trim();

        if (firstThreeDigits.length() != 3 || !firstThreeDigits.matches("\\d{3}")) {
            System.out.println("Błędny format. Podaj dokładnie 3 cyfry.");
            return;
        }

        String urlString = "https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt";
        try {
            URL url = new URL(urlString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" \t");
                if (parts.length >= 2) {
                    String bankCode = parts[0].trim();
                    String bankName = parts[1].trim();

                    if (bankCode.startsWith(firstThreeDigits)) {
                        System.out.println("Twój bank to: " + bankName);
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                System.out.println("Nie znaleziono banku dla podanych cyfr.");
            }

            reader.close();

        } catch (IOException e) {
            System.err.println("Wystąpił błąd podczas pobierania pliku: " + e.getMessage());
        }
    }
}

