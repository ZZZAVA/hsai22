package output;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputCSV
{
    public static void write(String path,  List<Double> numbers)
    {
        File file = new File(path);
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            String distributionLine = IntStream.range(0, numbers.size()).mapToObj(i -> numbers.get(i) + "").collect(Collectors.joining(", "));

            bw.write(distributionLine);
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}
