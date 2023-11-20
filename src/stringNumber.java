public class stringNumber {

    public static void main(String[] args) {


        System.out.println(incrementString("129"));

    }

    public static String incrementString(String str) {

        StringBuilder strBuilder = new StringBuilder();
        strBuilder = strBuilder.append(str);
        int indexToWorkWith = strBuilder.length() - 1;
        if (str.isEmpty()) {
            return "1";
        }
        if (!Character.isDigit(strBuilder.charAt(strBuilder.length() - 1))) {
            return str + 1;
        }

        while ( indexToWorkWith > -1 && Character.isDigit(strBuilder.charAt(indexToWorkWith))) {
            if (strBuilder.charAt(indexToWorkWith) == '9') {
                strBuilder.setCharAt(indexToWorkWith, '0');
            } else {
                int summedInt = Integer.parseInt(String.valueOf(strBuilder.charAt(indexToWorkWith))) + 1;
                char[] summedIntToChar = String.valueOf(summedInt).toCharArray();
                strBuilder.setCharAt(indexToWorkWith, summedIntToChar[0]);
                str = strBuilder.toString();
                return str;
            } indexToWorkWith--;
        }

        strBuilder.insert(indexToWorkWith +1, '1');
        str = strBuilder.toString();

        return str;
    }
}


