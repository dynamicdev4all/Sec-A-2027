import java.util.ArrayList;

public class SubSeq {
    public static void main(String[] args) {
        String str = "JOY";
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i); // J, O, Y

            if (list.isEmpty()) {
                list.add("");
                list.add(ch + "");
                continue;
            }

            int listSize = list.size();
            // ArrayList<String> list2 = new ArrayList<>();
            for (int j = 0; j < listSize; j++) {
                String temp = list.get(j) + ch;
                list.add(temp);
            }
        }
        System.out.println(list);
    }
}