import java.io.*;

class FileEncryptionDecryption {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter key for encryption/decryption: ");
            int key = Integer.parseInt(reader.readLine());

            System.out.print("Enter input file name: ");
            String inputFileName = reader.readLine();

            System.out.print("Enter output file name: ");
            String outputFileName = reader.readLine();

            encryptDecryptFile(key, inputFileName, outputFileName);

            System.out.println("Operation completed successfully!");
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void encryptDecryptFile(int key, String inputFileName, String outputFileName) throws IOException {
        try (BufferedReader inputFileReader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter outputFileWriter = new BufferedWriter(new FileWriter(outputFileName))) {

            int ch;
            while ((ch = inputFileReader.read()) != -1) {
                char originalChar = (char) ch;
                char encryptedChar = encryptDecryptChar(originalChar, key);
                outputFileWriter.write(encryptedChar);
            }
        }
    }

    private static char encryptDecryptChar(char ch, int key) {
        if (Character.isLetter(ch)) {
            char base = Character.isUpperCase(ch) ? 'A' : 'a';
            return (char) ((ch - base + key + 26) % 26 + base);
        } else {
            return ch;
        }
    }
}
