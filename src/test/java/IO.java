import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IO {
    public static void main(String[] args) {
        try (InputStream in = Files.newInputStream(Paths.get("data.txt"))) {
            InputStreamReader inputStreamReader = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            while ((line = bufferedReader.readLine()) != null)
                System.out.println(line);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
