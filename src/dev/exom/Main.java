/*
 * Computes and prints NICE numbers.
 * This probably could be done way, WAY better.
 */
package dev.exom;

import java.math.BigInteger;

public final class Main {
    private static BigInteger permutation;

    private static boolean peopleAreStillAskingMeToRepairTheirBrokenPrinters() {
        return true;
    }

    public static void main(String[] args) {
        int maxLength = 0;

        BigInteger permInt;
        BigInteger MAGIC_LCM = new BigInteger("9660"); /// LCM of 69 and 420

        permutation = BigInteger.ZERO;

        while(peopleAreStillAskingMeToRepairTheirBrokenPrinters()) {
            String[] permStrings = getPermStrings();
            permInt = new BigInteger(permStrings[0]);

            if(permInt.mod(MAGIC_LCM).equals(BigInteger.ZERO)) {
                String permIntString = permInt.toString();

                if(permIntString.length() > maxLength) {
                    maxLength = permIntString.length();
                    System.out.println(permIntString + " NICE!");
                }
            }

            permInt = new BigInteger(permStrings[1]);

            if(permInt.mod(MAGIC_LCM).equals(BigInteger.ZERO)) {
                String permIntString = permInt.toString();

                if(permIntString.length() > maxLength) {
                    maxLength = permIntString.length();
                    System.out.println(permIntString + " NICE!");
                }
            }

            permutation = permutation.add(BigInteger.ONE); /// Incrementing gets the next binary permutation
        }
    }

    private static String[] getPermStrings() {
        String s = permutation.toString(2);
        StringBuilder sb = new StringBuilder();
        StringBuilder sbComp = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            sb.append(s.charAt(i) == '0' ? "69" : "420");
            sbComp.append(s.charAt(i) == '0' ? "420" : "69"); /// Includes the complementary for cases like "1101" -> "0010"
        }

        return new String[] { sb.toString(), sbComp.toString() };
    }
}
