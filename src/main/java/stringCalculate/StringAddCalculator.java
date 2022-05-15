package stringCalculate;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public int splitAndSum(String string) {
        if(string == "" || string == null){
            return 0;
        }

        String[] strings;

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(string);
        if (m.find()) {
            String customDelimiter = m.group(1);
            strings = m.group(2).split(customDelimiter);
        } else {
            strings = splitStrings(string);
        }

        return sumString(strings);
    }

    private Integer sumString(String[] strings) {

        List<Integer> intList = new ArrayList<>();

        for (int i=0; i<strings.length; i++) {
            String partString = strings[i];
            String intString = partString.replaceAll("[^0-9]]", "");
            int integer = Integer.parseInt(intString);
            if (integer < 0) {
                throw new RuntimeException();
            }
            intList.add(integer);
        }

        return intList.stream().mapToInt(Integer::intValue).sum();
    }

    private String[] splitStrings(String string) {
        return string.split(",|:");
    }

}
