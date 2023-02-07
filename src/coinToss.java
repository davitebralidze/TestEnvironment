import java.util.Random;

public class coinToss {

    public static void main(String[] args) {

        String[] coinSides = new String[]{"Heads", "Tails"};
        Random random = new Random();
        int index = random.nextInt(coinSides.length);
        String coinResult = coinSides[index];
        System.out.println(coinResult);


    }
}