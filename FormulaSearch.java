import java.io.*;
import java.util.*;

public class FormulaSearch {

    // Method to generate the formula vector from a given string
    public static int[] formulaVectorGenerator(String s) {
        int[] formulavector = new int[202];
        char[] content2array = s.trim().toCharArray();

        for (char ch : content2array) {
            if (ch == 'a' || ch == 'A') formulavector[0] = 1;
            if (ch == 'b' || ch == 'B') formulavector[1] = 1;
            if (ch == 'c' || ch == 'C') formulavector[2] = 1;
            if (ch == 'd' || ch == 'D') formulavector[3] = 1;
            if (ch == 'e' || ch == 'E') formulavector[4] = 1;
            if (ch == 'f' || ch == 'F') formulavector[5] = 1;
            if (ch == 'g' || ch == 'G') formulavector[6] = 1;
            if (ch == 'h' || ch == 'H' || ch == 'ℋ') formulavector[7] = 1;
            if (ch == 'i' || ch == 'I') formulavector[8] = 1;
            if (ch == 'j' || ch == 'J') formulavector[9] = 1;
            if (ch == 'k' || ch == 'K') formulavector[10] = 1;
            if (ch == 'l' || ch == 'L') formulavector[11] = 1;
            if (ch == 'm' || ch == 'M') formulavector[12] = 1;
            if (ch == 'n' || ch == 'N') formulavector[13] = 1;
            if (ch == '0' || ch == 'O') formulavector[14] = 1;
            if (ch == 'p' || ch == 'P') formulavector[15] = 1;
            if (ch == 'q' || ch == 'Q') formulavector[16] = 1;
            if (ch == 'r' || ch == 'R') formulavector[17] = 1;
            if (ch == 's' || ch == 'S') formulavector[18] = 1;
            if (ch == 't' || ch == 'T') formulavector[19] = 1;
            if (ch == 'u' || ch == 'U') formulavector[20] = 1;
            if (ch == 'v' || ch == 'V') formulavector[21] = 1;
            if (ch == 'w' || ch == 'W') formulavector[22] = 1;
            if (ch == 'x' || ch == 'X') formulavector[23] = 1;
            if (ch == 'y' || ch == 'Y') formulavector[24] = 1;
            if (ch == 'z' || ch == 'Z' || ch == 'ℤ') formulavector[25] = 1;

            if (ch == 'ϕ' || ch == '∅') formulavector[71] = 1;
            if (ch == 'ℏ') formulavector[72] = 1;
            if (ch == 'π') formulavector[73] = 1;
            if (ch == 'Δ') formulavector[74] = 1;
            if (ch == 'μ') formulavector[75] = 1;
            if (ch == 'Σ') formulavector[76] = 1;
            if (ch == 'ϵ') formulavector[77] = 1;
            if (ch == '…') formulavector[78] = 1;
            if (ch == 'δ') formulavector[79] = 1;
            if (ch == 'Ψ') formulavector[80] = 1;
            if (ch == 'Γ') formulavector[81] = 1;
            if (ch == '∞') formulavector[82] = 1;
            if (ch == 'ρ') formulavector[83] = 1;
            if (ch == 'β') formulavector[84] = 1;
            if (ch == 'λ') formulavector[85] = 1;
            if (ch == 'ξ') formulavector[86] = 1;
            if (ch == '□') formulavector[87] = 1;
            if (ch == '!') formulavector[89] = 1;
            if (ch == 'ℝ') formulavector[91] = 1;
            if (ch == 'θ') formulavector[92] = 1;
            if (ch == 'τ') formulavector[95] = 1;
            if (ch == 'η') formulavector[96] = 1;
            if (ch == 'σ') formulavector[97] = 1;
            if (ch == 'Ω') formulavector[98] = 1;
            if (ch == '#') formulavector[99] = 1;
            if (ch == '⌜') formulavector[100] = 1;
            if (ch == 'ℤ') formulavector[57] = 1;
            if (ch == 'ℕ') formulavector[58] = 1;
            if (ch == 'ℚ') formulavector[59] = 1;
            if (ch == '⌝') formulavector[60] = 1;
            if (ch == 'α') formulavector[61] = 1;
            if (ch == 'γ') formulavector[62] = 1;
            if (ch == 'ω') formulavector[63] = 1;
            if (ch == 'ϑ') formulavector[64] = 1;
            if (ch == '=') formulavector[26] = 1;
            if (ch == ' ') formulavector[27] = 1;
            if (ch == '-') formulavector[28] = 1;
            if (ch == ',') formulavector[29] = 1;
            if (ch == '+') formulavector[30] = 1;
            if (ch == '∇') formulavector[31] = 1;
            if (ch == '∂') formulavector[32] = 1;
            if (ch == '→') formulavector[33] = 1;
            if (ch == '.') formulavector[34] = 1;
            if (ch == '(') formulavector[35] = 1;
            if (ch == ')') formulavector[36] = 1;
            if (ch == '≡') formulavector[37] = 1;
            if (ch == '≫') formulavector[38] = 1;
            if (ch == '∝') formulavector[39] = 1;
            if (ch == '≈') formulavector[40] = 1;
            if (ch == '/') formulavector[41] = 1;
            if (ch == '⊆') formulavector[42] = 1;
            if (ch == '⊕') formulavector[43] = 1;
            if (ch == '∼') formulavector[44] = 1;
            if (ch == '|') formulavector[45] = 1;
            if (ch == '≠') formulavector[101] = 1;
            if (ch == '{') formulavector[102] = 1;
            if (ch == '}') formulavector[103] = 1;
            if (ch == '⊙') formulavector[104] = 1;
            if (ch == '≼' || ch == '≤' || ch == '≲') formulavector[105] = 1;
            if (ch == '∈') formulavector[106] = 1;
            if (ch == '[') formulavector[107] = 1;
            if (ch == ']') formulavector[108] = 1;
            if (ch == '*' || ch == '×') formulavector[109] = 1;
            if (ch == '∉') formulavector[110] = 1;
            if (ch == '^') formulavector[111] = 1;
            if (ch == '∑') formulavector[112] = 1;
            if (ch == ';') formulavector[113] = 1;
            if (ch == '¯') formulavector[114] = 1;
            if (ch == '⇔') formulavector[115] = 1;
            if (ch == '⟹') formulavector[116] = 1;
            if (ch == '⇒') formulavector[117] = 1;
            if (ch == '∫') formulavector[118] = 1;
            if (ch == '∮') formulavector[119] = 1;
            if (ch == 'λ') formulavector[120] = 1;
            if (ch == '⊤') formulavector[121] = 1;
            if (ch == '⊥') formulavector[122] = 1;
            if (ch == '∛') formulavector[123] = 1;
            if (ch == '≤') formulavector[124] = 1;
            if (ch == '≥') formulavector[125] = 1;
            if (ch == 'Σ') formulavector[126] = 1;
            if (ch == '⇒') formulavector[127] = 1;
            if (ch == '≥') formulavector[128] = 1;
        }
        return formulavector;
    }

    // Method to compare two vectors
    public static int compareVectors(int[] vector1, int[] vector2) {
        int matchCount = 0;
        for (int i = 0; i < vector1.length; i++) {
            if (vector1[i] == vector2[i]) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public static void main(String[] args) {
        // Predefined formula vector (this can be any formula for comparison)
        String predefinedFormula = "π + e = 3.14159 + 2.71828";
        int[] predefinedVector = formulaVectorGenerator(predefinedFormula);

        // User input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a formula string to compare:");
        String userInput = scanner.nextLine();

        // Generate vector for user input
        int[] userVector = formulaVectorGenerator(userInput);

        // Compare the vectors
        int matchCount = compareVectors(predefinedVector, userVector);

        // Display the result
        System.out.println("Matching bits: " + matchCount + " out of " + predefinedVector.length);
    }
}
