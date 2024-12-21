import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractAllMathFormulas {

    public static void main(String[] args) throws Exception {
        // Define the directory that contains the input files (HTML files)
        File directory = new File("src/WikiCorpus/MathTagArticles/wpmath0000016/Articles");

        // Define the directory where the extracted <math> content will be saved
        File outputDirectory = new File("src/WikiCorpus/Corpus1");

        // Ensure the output directory exists, if not create it
        if (!outputDirectory.exists()) {
            outputDirectory.mkdirs();
        }

        // Create a PrintWriter to append the elapsed time to the TSDResult.txt file
        PrintWriter pw2 = new PrintWriter(new FileOutputStream(new File("src/WikiCorpus/TResult.txt"), true));

        // Get a list of all files in the input directory
        File[] folder = directory.listFiles();

        // Start the timer to measure processing time
        long lStartTime = System.nanoTime();
        int count = 0;

        // Check if the folder contains any files
        if (folder != null) {
            for (File f : folder) {
                // Increment the file count and print the progress
                count++;
                System.out.println("Processing: " + count);

                // Create a new PrintWriter for each output file (corresponding to the input file)
                PrintWriter pw = new PrintWriter(new FileOutputStream(new File(outputDirectory, f.getName()), true));

                // Open the input file for reading
                BufferedReader br = new BufferedReader(new FileReader(f));

                // StringBuilder to store the entire content of the input file
                StringBuilder text = new StringBuilder();
                String line;

                // Read the file line by line and append it to the StringBuilder
                while ((line = br.readLine()) != null) {
                    text.append(line);
                }

                // Define a regular expression to find <math>...</math> tags in the text
                String regex1 = "<math.*?</math>";
                Matcher matcher1 = Pattern.compile(regex1, Pattern.DOTALL).matcher(text);

                // Extract all occurrences of <math> tags and write them to the output file
                while (matcher1.find()) {
                    String content1 = matcher1.group().trim();
                    pw.println(content1);
                }

                // Close the BufferedReader and flush/close the PrintWriter for the current file
                br.close();
                pw.flush();
                pw.close();
            }
        }

        // Stop the timer and calculate the elapsed time in nanoseconds
        long lEndTime = System.nanoTime();
        long output = lEndTime - lStartTime;

        // Print and log the elapsed time in milliseconds
        System.out.println("Elapsed time in milliseconds: " + output / 1000000);
        pw2.println(output);

        // Flush and close the PrintWriter for the result log
        pw2.flush();
        pw2.close();
    }
}
