package learnio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LearnIO {
    public static void main(String[] args) {
        try {
            String readInput = read();
            System.out.println(readInput);
            write(readInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(String input) throws IOException {
        try {
            File dest = new File("./learnio/output.txt");

            FileWriter writer = new FileWriter(dest);
            BufferedWriter buffered = new BufferedWriter(writer);
            buffered.write(input);
            buffered.flush();
            buffered.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static String read() throws IOException {
        String line = null;
        StringBuffer lines = new StringBuffer();
        try {
            File source = new File("./learnio/input.txt");
            FileReader reader = new FileReader(source);
            BufferedReader bufferedReader = new BufferedReader(reader);
            while ( (line = bufferedReader.readLine()) != null) {
                lines.append(line);
                lines.append("\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        System.out.println(lines.toString());
        return lines.toString();
    }
}