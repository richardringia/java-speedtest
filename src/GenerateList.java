import java.util.stream.IntStream;

public class GenerateList {

    public static int[] generateIntArray() {
        return IntStream.range(0, 1000).toArray();
    }

    public static Integer[] generate() {
        return IntStream.range(0, 10000000).boxed().toArray(Integer[]::new);
    }
    public static Integer[] generate(int size) {
        return IntStream.range(0, size).boxed().toArray(Integer[]::new);
    }

}
