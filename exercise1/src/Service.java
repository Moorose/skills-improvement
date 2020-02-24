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

        String buf = "";

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {

                if (str.charAt(i) >= str.charAt(j)) {
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

        return buf;
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