import java.io.*;
import java.nio.file.*;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class FormulaExtractor {

    // Regex pattern to match content between <math> tags
    private static final Pattern MATH_TAG_PATTERN = Pattern.compile("<math>.*?</math>");

    public static void main(String[] args) {
        String directoryPath = "/Users/siddharthjoshi/IdeaProjects/Minor Project/src/WikiCorpus/Corpus2"; // Replace with the path to your HTML files directory
        String outputPath = "output_formulas.csv"; // Output CSV file

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            // Write header to CSV file
            writer.write("file_name,formula\n");

            // Get all files in the specified directory
            Files.walk(Paths.get(directoryPath))
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".html")) // Process only .html files
                    .forEach(filePath -> extractFormulas(filePath.toFile(), writer));

            System.out.println("Extraction completed. Formulas saved in " + outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void extractFormulas(File file, BufferedWriter writer) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            List<String> formulas = new ArrayList<>();

            // Read each line in the file
            while ((line = reader.readLine()) != null) {
                // Find all matches of <math>...</math> in the line
                Matcher matcher = MATH_TAG_PATTERN.matcher(line);
                while (matcher.find()) {
                    formulas.add(matcher.group()); // Add the entire <math>...</math> tag
                }
            }

            // Write formulas to CSV file
            for (String formula : formulas) {
                writer.write(file.getName() + ",\"" + formula.replace("\"", "\"\"") + "\"\n");
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + file.getName());
            e.printStackTrace();
        }
    }
}
