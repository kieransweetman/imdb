import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Component
public class ImdbCsvParser {
    public void parseFiles(List<String> csvFilePaths) {
        for (String csvFilePath : csvFilePaths) {
            try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    // Process each line of the CSV file
                    processLine(line);
                }
            } catch (IOException e) {
                ImdbException.log(e);
            }
        }
    }

    private void processLine(String line) {
        // Implement your CSV line processing logic here
        // For example, you can split the line by commas and process each field
        String[] fields = line.split(",");
        // Process fields
    }
}