import java.io.*;
import java.util.*;

public class FormulaSearchEngine {
    static class FormulaRecord {
        String fileName;
        String bitVector;
        int matchingBits;

        FormulaRecord(String fileName, String bitVector, int matchingBits) {
            this.fileName = fileName;
            this.bitVector = bitVector;
            this.matchingBits = matchingBits;
        }
    }

    public static void main(String[] args) throws IOException {
        // User query as a 202-bit vector
        String userQuery = "0001100000000000010010000010000000011000010000000000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        char[] formulaVector = userQuery.toCharArray();

        // List of CSV files to search
        List<String> csvFiles = new ArrayList<>();

        // Add corresponding CSV files based on conditions
        if (formulaVector[30] == '1'|| formulaVector[28] == '1'|| formulaVector[109] == '1'|| formulaVector[124] == '1'|| formulaVector[41] == '1'|| formulaVector[27] == '1'|| formulaVector[141] == '1'|| formulaVector[120] == '1'|| formulaVector[70] == '1'|| formulaVector[99] == '1')  {
            csvFiles.add("/Users/siddharthjoshi/IdeaProjects/Minor Project/final/index/arithmetic.csv");
        }
        if (formulaVector[33] == '1' || formulaVector[137] == '1') {
            csvFiles.add("/Users/siddharthjoshi/IdeaProjects/Minor Project/final/index/arrow.csv");
        }
        if (formulaVector[31] == '1' || formulaVector[32] == '1' || formulaVector[127] == '1' ||
                formulaVector[121] == '1' || formulaVector[139] == '1') {
            csvFiles.add("/Users/siddharthjoshi/IdeaProjects/Minor Project/final/index/calculus.csv");
        }
        if (formulaVector[47] == '1' || formulaVector[147] == '1' || formulaVector[149] == '1' ||
                formulaVector[88] == '1' || formulaVector[93] == '1') {
            csvFiles.add("/Users/siddharthjoshi/IdeaProjects/Minor Project/final/index/digit.csv");
        }
        if (formulaVector[26] == '1' || formulaVector[37] == '1' || formulaVector[40] == '1' ||
                formulaVector[44] == '1' || formulaVector[145] == '1' || formulaVector[146] == '1' ||
                formulaVector[101] == '1' || formulaVector[143] == '1' || formulaVector[115] == '1' ||
                formulaVector[116] == '1' || formulaVector[105] == '1' || formulaVector[38] == '1' ||
                formulaVector[39] == '1') {
            csvFiles.add("/Users/siddharthjoshi/IdeaProjects/Minor Project/final/index/Equivalence.csv");
        }
        if (formulaVector[87] == '1' || formulaVector[60] == '1' || formulaVector[126] == '1' ||
                formulaVector[130] == '1' || formulaVector[43] == '1' || formulaVector[122] == '1' ||
                formulaVector[117] == '1' || formulaVector[118] == '1') {
            csvFiles.add("/Users/siddharthjoshi/IdeaProjects/Minor Project/final/index/Geometric.csv");
        }
        if (formulaVector[61] == '1' || formulaVector[62] == '1' || formulaVector[63] == '1' ||
                formulaVector[64] == '1' || formulaVector[66] == '1' || formulaVector[73] == '1' ||
                formulaVector[75] == '1' || formulaVector[76] == '1' || formulaVector[79] == '1' ||
                formulaVector[80] == '1' || formulaVector[83] == '1' || formulaVector[84] == '1' ||
                formulaVector[85] == '1' || formulaVector[86] == '1' || formulaVector[95] == '1' ||
                formulaVector[96] == '1' || formulaVector[97] == '1' || formulaVector[98] == '1' ||
                formulaVector[4] == '1' || formulaVector[71] == '1' || formulaVector[92] == '1' ||
                formulaVector[74] == '1' || formulaVector[125] == '1' || formulaVector[140] == '1' ||
                formulaVector[106] == '1' || formulaVector[110] == '1' || formulaVector[119] == '1' ||
                formulaVector[77] == '1' || formulaVector[81] == '1') {
            csvFiles.add("/Users/siddharthjoshi/IdeaProjects/Minor Project/final/index/latin.csv");
        }
        if (formulaVector[0] == '1' || formulaVector[1]  == '1'|| formulaVector[2]  == '1'|| formulaVector[3]  == '1' || formulaVector[4]  == '1' || formulaVector[5]  == '1'|| formulaVector[6]  == '1'|| formulaVector[7]  == '1'
                || formulaVector[8]  == '1'|| formulaVector[9]  == '1'|| formulaVector[10]  == '1' || formulaVector[11]  == '1'|| formulaVector[12]  == '1'|| formulaVector[13]  == '1' || formulaVector[14] == '1' || formulaVector[15]  == '1'
                || formulaVector[16]  == '1'|| formulaVector[17] == '1' || formulaVector[18] == '1' || formulaVector[19]  == '1'|| formulaVector[20]  == '1'|| formulaVector[21]  == '1'|| formulaVector[22]  == '1'|| formulaVector[23] == '1'
                || formulaVector[24] == '1' || formulaVector[25] == '1' || formulaVector[57] == '1' || formulaVector[58] == '1' || formulaVector[59] == '1' || formulaVector[91]  == '1'|| formulaVector[72] == '1') {
            csvFiles.add("/Users/siddharthjoshi/IdeaProjects/Minor Project/final/index/letter.csv");
        }

        if (formulaVector[69]== '1' || formulaVector[144]== '1' || formulaVector[60]== '1' || formulaVector[126]== '1' ){
            csvFiles.add("/Users/siddharthjoshi/IdeaProjects/Minor Project/final/index/Measurement.csv");
        }
        if (formulaVector[77]== '1' || formulaVector[106]== '1' || formulaVector[110] == '1'|| formulaVector[135] == '1'|| formulaVector[136] == '1'|| formulaVector[138]== '1' || formulaVector[42]== '1'
                || formulaVector[134]== '1' || formulaVector[124] == '1'|| formulaVector[126]== '1' || formulaVector[125] == '1'|| formulaVector[119]== '1' || formulaVector[130] == '1'|| formulaVector[104]== '1'
                || formulaVector[43]== '1' || formulaVector[131]== '1' || formulaVector[132]== '1' || formulaVector[133] == '1'|| formulaVector[142] == '1'|| formulaVector[148] == '1'|| formulaVector[71]== '1'
                || formulaVector[44] == '1'|| formulaVector[94]== '1'){

            csvFiles.add("/Users/siddharthjoshi/IdeaProjects/Minor Project/final/index/set.csv");
        }
        if (formulaVector[112]== '1' || formulaVector[75]== '1' || formulaVector[82] == '1'|| formulaVector[139]== '1' ){
            csvFiles.add("/Users/siddharthjoshi/IdeaProjects/Minor Project/final/index/Statistics.csv");
        }
        if (formulaVector[45] == '1' || formulaVector[46]== '1' || formulaVector[49] == '1'|| formulaVector[50]== '1' || formulaVector[51] == '1'|| formulaVector[52]== '1' || formulaVector[53]== '1'
                || formulaVector[54] == '1'|| formulaVector[55] == '1'|| formulaVector[56] == '1'|| formulaVector[29]== '1' || formulaVector[34]== '1' || formulaVector[35]== '1' || formulaVector[36]== '1'
                || formulaVector[102]== '1' || formulaVector[103] == '1'|| formulaVector[107]== '1' || formulaVector[108]== '1' || formulaVector[117] == '1'|| formulaVector[118]== '1' || formulaVector[128]== '1'
                || formulaVector[129] == '1'|| formulaVector[99] == '1'|| formulaVector[113]== '1' || formulaVector[114]== '1' || formulaVector[68] == '1'|| formulaVector[89] == '1') {
            csvFiles.add("/Users/siddharthjoshi/IdeaProjects/Minor Project/final/index/Structural.csv");
        }

        if (formulaVector[90]=='1' ){
            csvFiles.add("/Users/siddharthjoshi/IdeaProjects/Minor Project/final/index/trigonometric.csv");
        }
            // Output CSV file for results
        String outputCsvFile = "/Users/siddharthjoshi/IdeaProjects/Minor Project/final/results1.csv";

        // Search and rank results for all selected files
        List<FormulaRecord> results = new ArrayList<>();
        for (String csvFile : csvFiles) {
            results.addAll(searchFormulas(csvFile, userQuery));
        }

        // Print top 10 results
        System.out.println("Top 10 Matching Formulas:");
        results.stream()
                .limit(10)
                .forEach(record -> System.out.println(
                        "File: " + record.fileName + ", Matches: " + record.matchingBits));

        // Write top 10 results to CSV
        writeResultsToCsv(results, outputCsvFile);
    }

    public static List<FormulaRecord> searchFormulas(String filePath, String userQuery) throws IOException {
        List<FormulaRecord> matchingRecords = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 2);
                String fileName = parts[0];
                String bitVector = parts[1];

                int matchingBits = calculateMatchingBits(userQuery, bitVector);
                if (matchingBits > 0) {
                    matchingRecords.add(new FormulaRecord(fileName, bitVector, matchingBits));
                }
            }
        }

        // Sort results by matching bits in descending order
        matchingRecords.sort((a, b) -> Integer.compare(b.matchingBits, a.matchingBits));

        return matchingRecords;
    }

    public static int calculateMatchingBits(String query, String bitVector) {
        int matchingBits = 0;
        for (int i = 0; i < query.length(); i++) {
            if (query.charAt(i) == '1' && bitVector.charAt(i) == '1') {
                matchingBits++;
            }
        }
        return matchingBits;
    }

    public static void writeResultsToCsv(List<FormulaRecord> results, String outputCsvFile) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputCsvFile))) {
            // Write header
            writer.write("File Name,Bit Vector,Matching Bits");
            writer.newLine();

            // Use a set to track file names already written
            Set<String> writtenFileNames = new HashSet<>();

            // Write top 10 unique records
            results.stream()
                    .filter(record -> writtenFileNames.add(record.fileName)) // Add to set and filter duplicates
                    .limit(10)
                    .forEach(record -> {
                        try {
                            writer.write(record.fileName + "," + record.bitVector + "," + record.matchingBits);
                            writer.newLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
        System.out.println("Top 10 unique results written to CSV file: " + outputCsvFile);
    }

}
