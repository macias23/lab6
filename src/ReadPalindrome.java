import java.io.*;

public class ReadPalindrome {
    public static void read(String fileName) {
        Palindrome odczytany;
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(fileName))) {
            odczytany= (Palindrome) ois.readObject();
        } catch (IOException|ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
