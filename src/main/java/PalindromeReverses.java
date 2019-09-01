import java.math.BigInteger;

public class PalindromeReverses {


    public static int reverses(int number) {

        int reverses = 0;
        BigInteger sum = BigInteger.valueOf(number);

        while(!isPalindrome(sum)){
            sum = sum.add(reverseNumber(sum));
            reverses++;
            if (reverses > 30) {
                throw new RuntimeException("более 30!");
            }
        }
        return reverses;

    }


    static boolean isPalindrome(BigInteger number){
        return number.compareTo(reverseNumber(number)) == 0;
    }


    static BigInteger reverseNumber(BigInteger number) {
        boolean negative = number.compareTo(BigInteger.ZERO) < 0;

        StringBuilder stringBuilder = new StringBuilder(number.abs().toString());
        BigInteger reversedUnsigned = new BigInteger(stringBuilder.reverse().toString());

        return negative ? reversedUnsigned.multiply(BigInteger.valueOf(-1)) : reversedUnsigned;
    }




}
