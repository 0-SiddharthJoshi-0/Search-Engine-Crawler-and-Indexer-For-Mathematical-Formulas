import java.io.*;

public class set {

    public static void main(String[] args) {
        String inputFile = "/Users/siddharthjoshi/IdeaProjects/Minor Project/final/index.csv";
        String outputFile = "/Users/siddharthjoshi/IdeaProjects/Minor Project/final/set.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length < 2) continue;  // Skip malformed lines

                String filename = columns[0];
                String bitString = columns[1];

                // Ensure the bitString has exactly 202 bits
                if (bitString.length() != 202) {
                    System.out.println("Skipping malformed entry: " + filename);
                    continue;
                }

                // Convert bitString to formulaVector (boolean array representing 202 bits)
                boolean[] formulaVector = new boolean[202];
                for (int i = 0; i < 202; i++) {
                    formulaVector[i] = bitString.charAt(i) == '1';
                }

                // Check if any of the specified positions are 1 (indicating presence of arithmetic operation)
                if (formulaVector[77] || formulaVector[106] || formulaVector[110] || formulaVector[135] || formulaVector[136] || formulaVector[138] || formulaVector[42] 
                || formulaVector[134] || formulaVector[124] || formulaVector[126] || formulaVector[125] || formulaVector[119] || formulaVector[130] || formulaVector[104]
                || formulaVector[43] || formulaVector[131] || formulaVector[132] || formulaVector[133] || formulaVector[142] || formulaVector[148] || formulaVector[71]
                || formulaVector[44] || formulaVector[94]) {
                    // Write the entry to the new file if the condition is met
                    writer.write(line);
                    writer.newLine();
                }
            }

            System.out.println("Extraction complete. Entries written to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
