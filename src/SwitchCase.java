public class SwitchCase {
    public static void main(String[] args) {

        System.out.println(monthQuarter("JULY"));


    }

    public static String monthQuarter (String month) {

        //return switch <<-- only for enhanced switch
        //case 1 , 2 , 3 : <<-- only for enhanced switch
        //case 1: case 2: case3: <<-- old switch

        return switch (month) {
            case "JANUARY" , "FEBRUARY" , "MARCH" -> "1st quarter";
//            case "JANUARY" , "FEBRUARY" , "MARCH" -> {yield "1st quarter";}
//            yield is needed if we are using curly braces
            case "APRIL" , "MAY" , "JUNE" -> "2nd quarter";
            case "JULY" , "AUGUST" , "SEPTEMBER" -> "3rd quarter";
            case "OCTOBER" , "NOVEMBER" , "DECEMBER" -> "4th quarter";
            default -> month + " is not a month";
//            default -> {
////                String badResponse = month + " is not a month";
////                yield badResponse;
////            } when writing return switch statement, in case of curly braces we need "yield";
        };
    }

}
