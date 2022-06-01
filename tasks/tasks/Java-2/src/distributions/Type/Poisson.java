package distributions.Type;

import distributions.Distribution;

import java.util.ArrayList;
import java.util.List;

public class Poisson extends Distribution {
    double l;

    public Poisson(int size, double l) throws Exception {
        super(size);
        if (l > 0)  {
            this.l = l;
        } else {
            logs.info("Incorrect form");
            System.exit(-222);
        };
    }

    public double getNums() {
        int count = 0;
        double p = Math.exp(-l);
        double r = rand.nextDouble() - p;
        while (r > 0) {
            count++;
            p *= l / count;
            r -= p;
        }
        return count;
    }

    public List<Double> getNums(int size) {
        List<Double> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) list.add(getNums());
        return list;
    }
}
