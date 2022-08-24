package charactercount;

public class CountCharacter {
    public static void main(String[] args) {
        String pos = "CAAAABBBBBCCYVVVVSFGJJJGKKKQQQQQCPOYMNNNNEEJJJGGGGGHHYZZ";
        String newpos = zipStr(pos);
        System.out.println(newpos);
    }

    private static String zipStr(String pos) {
        if (pos == null || pos.length() == 0) {
            return "Пусто";
        }
        char current = pos.charAt(0);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        System.out.println(pos);
        for (int i = 1; i < pos.length(); i++) {
            if (pos.charAt(i) == current) {
                count++;
                if (i == pos.length() - 1) {
                    sb.append(pos.charAt(i));
                    sb.append(count);
                }
            } else {
                sb.append(current);
                if (count > 1) {
                    sb.append(count);
                }
                if (i == pos.length() - 1) {
                    sb.append(pos.charAt(i));
                }
                current = pos.charAt(i);
                count = 1;
            }
        }
        return sb.toString();
    }
}
