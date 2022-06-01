package distributions.Type;

import distributions.Distribution;

import java.util.ArrayList;
import java.util.List;

public class Uniform extends Distribution {
    double min;
    double max;

    public Uniform(int size, double min, double max) throws Exception {
        super(size);
        if (min < max) {
            this.min = min;
            this.max = max;
        } else {
            logs.info("Incorrect form");
            System.exit(-111);
        };
    }

    public List<Double> getNums(int size) {
        List<Double> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) list.add(min + rand.nextDouble() * (max - min));
        return list;
    }
}