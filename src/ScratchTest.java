import java.util.Objects;

public class ScratchTest {

    public static void main(String[] args) {
        parameterPlease(null);
    }

    static void parameterPlease(String string) {
        Objects.requireNonNull(string, "!!!");
    }

}

