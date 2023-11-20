public class isUppercase {

    public static void main(String[] args) {


        String input = "lPersonPublicHaveHighSay";
        char space = ' ';
        int indexToCheck = 0;
        StringBuilder inputToStringBuilder = new StringBuilder();
        inputToStringBuilder.append(input);
        int sizeOfString = inputToStringBuilder.length() - 1;

        for (int i = 0; i < sizeOfString; i++) {
            if(Character.isUpperCase(inputToStringBuilder.charAt(i))) {
                inputToStringBuilder.insert(i, space);
                sizeOfString++;
                i = i+1;
            }
        }

        input = inputToStringBuilder.toString();

        System.out.println(input);

    }
}
