public class Service {

    boolean LOG;

    Service(){
        this(false);
    }

    Service(boolean log){
        LOG = log;
    }

    String getSubString(String str) {
        if (str.isEmpty()) throw new NullPointerException();

        int length = str.length();
        String buf = "";

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {

                if (str.charAt(j-1) > str.charAt(j) || j == length-1) {
                    logger(i, j, str);
                    if (buf.length() < j - i) {
                        buf = str.substring(i, j);
                        logger(buf);
                    }
                    i = j - 1;
                    break;
                }
            }
        }

        return buf.trim();
    }

    private void logger(int i, int j, String str) {
        if(!LOG) return;
        System.out.print(str.charAt(i));
        System.out.print(" (" + i + ") ");
        System.out.print(str.charAt(j));
        System.out.print(" (" + j + ") ");
        System.out.println(" s: " + str.substring(i, j));
    }

    private void logger(String str) {
        if(!LOG) return;
        System.out.println(" string : " + str);
    }
}