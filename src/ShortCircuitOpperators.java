public class ShortCircuitOpperators {
    private static boolean f1true() {
        System.out.format("f1true()%n");
        //System.out.printf("f1true()%n");// try this
        // System.out.println("f1true()");// try this
        return true;
    }
    private static boolean f1false() {
        System.out.printf("f1false()%n");
        return false;
    }
    private static int movingRightSigned(int liczba, int oIle){
        int przesunięta = liczba>>oIle;
        String liczbabinarna=Integer.toBinaryString(liczba);
        String liczbabinarna32= String.format("%32s", liczbabinarna).replaceAll(" ", "0");
        String binarnaprzesunięta=Integer.toBinaryString(przesunięta);
        String binarnaprzesunięta32=String.format("%32s",binarnaprzesunięta).replaceAll(" ", "0");
        System.out.println("Liczba " + liczba+
                " binarnie: "+ liczbabinarna32+
                " to po przesunięciu bez znaku: "+binarnaprzesunięta32+
                " dzesiętnie "+ przesunięta);
        return przesunięta;
    }
    private static int movingRightUnigned(int liczba, int oIle){
        int przesunięta = liczba>>>oIle;
        String liczbabinarna=Integer.toBinaryString(liczba);
        String liczbabinarna32= String.format("%32s", liczbabinarna).replaceAll(" ", "0");
        String binarnaprzesunięta=Integer.toBinaryString(przesunięta);
        String binarnaprzesunięta32=String.format("%32s",binarnaprzesunięta).replaceAll(" ", "0");
        System.out.println("Liczba " + liczba+
                " binarnie: "+ liczbabinarna32+
                " to po przesunięciu bez znaku: "+binarnaprzesunięta32+
                " dzesiętnie "+ przesunięta);
        return przesunięta;
    }
    private static int movingLeft(int liczba, int oIle){
        int przesunięta = liczba<<oIle;
        String liczbabinarna=Integer.toBinaryString(liczba);
        String liczbabinarna32= String.format("%32s", liczbabinarna).replaceAll(" ", "0");
        String binarnaprzesunięta=Integer.toBinaryString(przesunięta);
        String binarnaprzesunięta32=String.format("%32s",binarnaprzesunięta).replaceAll(" ", "0");
        System.out.println("Liczba " + liczba+
                " binarnie: "+ liczbabinarna32+
                " to po przesunięciu bez znaku: "+binarnaprzesunięta32+
                " dzesiętnie "+ przesunięta);
        return przesunięta;
    }

    public static void main(String[] args) {
        boolean b1, b2, b3, b4, b5, b6, b7, b8;
        b1 = f1true() & f1true();
        b2 = f1true() && f1true();
        b3 = f1false() & f1false();
        b4 = f1false() && f1false();
        b5 = f1true() | f1true();
        b6 = f1true() || f1true();
        b7 = f1false() | f1false();
        b8 = f1false() || f1false();
        movingLeft(1,32);
        movingRightSigned(0x8000_0000,32);
        movingRightUnigned(0x8000_0000,32);
    }
}
