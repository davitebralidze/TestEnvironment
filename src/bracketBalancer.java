import java.util.*;
import java.lang.String;

public class bracketBalancer {

    public static void main(String[] args) {
        String[] validSymbols = {"{", "}", "[", "]", "(", ")"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Take in count, you must only use { } [ ] ( ) symbols");
        System.out.print("Insert your favourable combination of brackets: ");
        String[] randomReceived = scanner.next().split("");
        List<String> receivedList = new ArrayList<>(Arrays.asList(randomReceived));
        int randomReceivedLength = receivedList.size();


        for (int i = 0; i < randomReceivedLength; i++) {
            if (Arrays.stream(validSymbols).noneMatch(receivedList.get(i)::equals)) {
                System.out.println("One or more of the characters entered is invalid");
                System.exit(0);
            }
        }


        try {
            for (int tries = 0; tries <= randomReceivedLength; tries++) {
                if (!receivedList.isEmpty()) {
                    clusterRemover(receivedList, "{", "}");
                    clusterRemover(receivedList, "(", ")");
                    clusterRemover(receivedList, "[", "]");
                }
            }
        } catch (Exception ignored) {
        }


        if (receivedList.isEmpty()) {
            System.out.println("Your choice of brackets is balanced");
        } else System.out.println("Your choice of brackets is not balanced");

    }


    private static void clusterRemover(List<String> receivedList, String clusterHead, String clusterEnd) {
        int openerIndex = 0;

        while (openerIndex < receivedList.size())
            if (receivedList.get(openerIndex).equals(clusterHead) && receivedList.get(openerIndex + 1).equals(clusterEnd)) {
                receivedList.remove(openerIndex);
                receivedList.remove(openerIndex);
            } else openerIndex++;
    }
}
