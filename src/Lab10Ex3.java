import java.io.*;
import java.nio.charset.StandardCharsets;

public class Lab10Ex3 {
    public static void main(String[] args) {
        String sourceFilePath = "source.txt";
        String destinationFilePath = "destination.txt";

        try (
                FileInputStream fis = new FileInputStream(sourceFilePath);
                FileOutputStream fos = new FileOutputStream(destinationFilePath);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis, StandardCharsets.UTF_8));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos, StandardCharsets.UTF_8))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String modifiedLine = line.replace(" ", "-");
                writer.write(modifiedLine);
                writer.newLine();
            }
            System.out.println("Plik został skopiowany i zmodyfikowany.");
        } catch (IOException e) {
            System.err.println("Wystąpił błąd podczas kopiowania pliku: " + e.getMessage());
        }
    }
}
