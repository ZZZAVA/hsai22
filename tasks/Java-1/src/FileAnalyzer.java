import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class FileAnalyzer {
    int spaces;
    TreeMap<Integer, Integer> words = new TreeMap<>();           //длинна/количество
    LinkedHashMap<Character, Integer> chars = new LinkedHashMap<>(); //хеш тк символы уникальны, символ/количество

    public void Sort(File inputFile) {
        spaces = 0;
        String line = null;
        BufferedReader br = null;

        try {
            br = Files.newBufferedReader(inputFile.toPath());
            line = br.readLine();
            int charCount = 0;
            while (line != null) {
                for (char c : line.toCharArray()) {
                    if (c == '-' || c == '\'') continue;   //исключаем символы, участвующие в образовании слова ru/eng

                    chars.merge(c, 1, Integer::sum);

                    if (Character.isAlphabetic(c) || (charCount > 0 && (c == '-' || c == '\''))) charCount++;
                    else {
                        if (c == ' ') spaces++;

                        words.merge(charCount, 1, Integer::sum);
                        charCount = 0;
                    }
                }
                line = br.readLine();
            }

            words.merge(charCount, 1, Integer::sum);
            words.remove(0);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Access error");
            System.exit(111);
        }

    }

    public void PrintResult(File outputFile, String string) {

        StringBuilder sb = new StringBuilder();
        sb.append("Words: ").append(words.values().stream().mapToInt(Integer::intValue).sum()).append(" ; ");
        sb.append("Spaces: ").append(spaces);

        sb.append("\nList of word lengths:\n-----------------\n");
        for (var entry : words.entrySet()) {
            sb.append(entry.getKey()).append("character word: ").append(entry.getValue()).append('\n');
        }

        if (!string.isEmpty()) {
            sb.append("\nSpecial character list\n-----------------\n");
            for (char c : string.toCharArray()) {
                sb.append("Character ").append(c).append(": ").append(chars.getOrDefault(c, 0)).append('\n');
            }
        }


        if (outputFile.getName()==""){
            System.out.println(sb);
        }
        else{
            try {
                Files.writeString(outputFile.toPath(), sb);
                System.out.println("Success, write to "+ outputFile.getName());
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Access error");
                System.exit(222);
            }
        }
    }


}
