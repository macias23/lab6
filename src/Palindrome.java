import java.io.Serializable;

public class Palindrome implements Serializable {
    /**
     * Counters
     */
    public static int countFindLongestPalindrome;
    public static int countAnalyzeSubstring;
    public static int countIsPalindrome;
    Palindrome(String text){
        palindrome=text;
        rawPalindrome=makeRawPalindrome();
    }

    /**
     * Text of this palindrome.
     */
    private String palindrome = null;
    /**
     * Text of rawPalindrome;
     */
    private String rawPalindrome;

    @Override
    public boolean equals(Object anObject) {
        if (anObject==null) return false;
        if (anObject.getClass()!=Palindrome.class) return false;
        else{
            Palindrome ob = (Palindrome) anObject;
            if (!rawPalindrome.equals((ob.getRawPalindrome()))) return false;
        }
        return true;
    }
    @Override
    public int hashCode(){
        int result=7;
        result=31*result*rawPalindrome.hashCode();
        return result;
    }
    /**
     * @return Method returning palindrome.
     */
    public String getPalindrome() {
        return palindrome;
    }
    /**
     * @return Method returning raw palindrome.
     */
    public String getRawPalindrome(){
        return rawPalindrome;
    }
    /**
     * Method creating raw palindrome.
     */
    public String makeRawPalindrome(){
        StringBuilder word = new StringBuilder(palindrome);
        for(int i=0; i<word.length(); i++){
            if(!Character.isLetter(word.charAt(i))){
                word.deleteCharAt(i);
                i--;
            }
            if (Character.isUpperCase(word.charAt(i))) {
                word.setCharAt(i,Character.toLowerCase(word.charAt(i)));
            }
        }
        return word.toString();
    }
    @Override
    public String toString() {
    return palindrome+" "+rawPalindrome;
    }
    public static boolean isPalindrome(String word){
        countIsPalindrome++;
        int i1=0;
        int i2=word.length()-1;
        while(i2>i1){
            if (word.charAt(i1)!=word.charAt(i2)){
                return false;
            }
            i1++;
            i2--;
        }
        return true;
    }
    public static String analyzeSubstring (String word){
        countAnalyzeSubstring++;
        if(isPalindrome(word)){
            return word;
        }
        else return "";
    }
    public static String findLongestPalindrome(String word){
        countFindLongestPalindrome++;
        String longestPalindrome="";
        String current="";
        for (int i=0;i<word.length();i++){
            String subword=word.substring(i,word.length());
            int index=subword.length();
            while (index>0){
                String substring=subword.substring(0,index);
                current=analyzeSubstring(substring);
                if(longestPalindrome.length()<current.length())
                    longestPalindrome=current;
                index--;
            }
        }
        return longestPalindrome;
    }
    public static void main(String[] args) {
        /*Palindrome p1 = new Palindrome("kobyłamamałybok");
        Palindrome p2 = new Palindrome("kobyła ma mały bok!");
        Palindrome p3 = new Palindrome("elf układał kufle");
        System.out.println(p2.toString());
        System.out.println("p1 == p2 : " + (p1 == p2));
        System.out.println("p1.equals(p2) : " + p1.equals(p2));
        Hashtable<Palindrome, String> ps = new Hashtable<>();
        ps.put(new Palindrome("a car boso kokos obraca"), "Andrzej Pacierpnik");
        ps.put(p2, "autor nieznany");
        ps.put(new Palindrome("muzo, raz daj jad za rozum"), "Julian Tuwim");
        ps.put(p3, "Tadeusz Morawski");
        System.out.println("Autorem palindromu " + p3 + " jest " + ps.get(p3));
        String word = "rrrrr abccba kobyłamamałybok";
        String longestPalindrome = findLongestPalindrome(word);
        System.out.println("longestPalindrome: " + longestPalindrome);
        Palindrome test=new Palindrome("Ala! ma kota!!!!!");
        System.out.println(test.getRawPalindrome());*/
        String N ="ala";
        String Nten="qwertyuiopasdfghjklzxcvbnmjhgf";
        String Nhundred="qwertyuiopasdfghjklzxcvbnm" +
                "mnbbzabvcxzasfghsfjloytwildoiequdaalallalalalalalkamilifhuaedzkjlkdanfeqlk";
        System.out.println(findLongestPalindrome(N));
        System.out.println("liczCzyPalindrom: " +countIsPalindrome);
        System.out.println("liczAnalizujSubslowo: " +countAnalyzeSubstring);
        System.out.println("liczZnajdzNadluzszyPalindrom " +countFindLongestPalindrome);
        System.out.println();
        countIsPalindrome=-0;
        countAnalyzeSubstring=0;
        countFindLongestPalindrome=0;
        System.out.println(findLongestPalindrome(Nten));
        System.out.println("liczCzyPalindrom: " +countIsPalindrome);
        System.out.println("liczAnalizujSubslowo: " +countAnalyzeSubstring);
        System.out.println("liczZnajdzNadluzszyPalindrom " +countFindLongestPalindrome);
        System.out.println();
        countIsPalindrome=-0;
        countAnalyzeSubstring=0;
        countFindLongestPalindrome=0;
        System.out.println(findLongestPalindrome(Nhundred));
        System.out.println("liczCzyPalindrom: " +countIsPalindrome);
        System.out.println("liczAnalizujSubslowo: " +countAnalyzeSubstring);
        System.out.println("liczZnajdzNadluzszyPalindrom " +countFindLongestPalindrome);
        WritePalindrome.write(new Palindrome("Kobyła ma mały bok."), "palindrome.plr");
        ReadPalindrome.read("palindrome.plr");
    }
}
