package algoexpert;

import java.util.ArrayList;

public class ValidIPAddress {
    public ArrayList<String> validIPAddresses(String string) {
        ArrayList<String> ipAddressesFound = new ArrayList<>();
        for (int i = 1; i < Math.min(string.length(), 4); i++) {
            String[] currentIPAddressParts = new String[]{"", "", "", ""};
            currentIPAddressParts[0] = string.substring(0, i);
            if (!isValidPart(currentIPAddressParts[0])) {
                continue;
            }
            for (int j = i + 1; j < i + Math.min(string.length() - i, 4); j++) {
                currentIPAddressParts[1] = string.substring(i, j);
                if (!isValidPart(currentIPAddressParts[1])) {
                    continue;
                }
                for (int k = j + 1; k < j + Math.min(string.length() - j, 4); k++) {
                    currentIPAddressParts[2] = string.substring(j, k);
                    currentIPAddressParts[3] = string.substring(k);

                    if (isValidPart(currentIPAddressParts[2]) && isValidPart(currentIPAddressParts[3])) {
                        ipAddressesFound.add(join(currentIPAddressParts));
                    }
                }
            }
        }
        return ipAddressesFound;
    }

    public boolean isValidPart(String string) {
        int stringAsInt = Integer.parseInt(string);
        if (stringAsInt > 255) {
            return false;
        }
        return string.length() == Integer.toString(stringAsInt).length();
    }

    public String join(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (int l = 0; l < strings.length; l++) {
            sb.append(strings[l]);
            if (l < strings.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }
}
