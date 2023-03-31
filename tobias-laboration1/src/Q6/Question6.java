package Q6;

public class Question6 {
    public static void main(String[] args) {
        THEggFirm firm = new THEggFirm();
        long barcode = 181133020356L;
        int egg = firm.getEgg(barcode);
        System.out.println("Egg: " + egg);
    }
}
