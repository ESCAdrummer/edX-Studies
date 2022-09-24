public class stringShifter {
    public String shiftLeft(String s) {

        if (s == null || s == "") {
            return s;
        }
        String temp = "";

        temp = s.substring(1, s.length()) + "" + s.charAt(0);

        return temp;

    }

    public String shiftRight(String s) {

        if (s == null || s == "") {
            return s;
        }
        String temp = "";

        temp = "" + s.charAt(s.length()-1) + s.substring(0, s.length()-1);

        return temp;

    }


}
