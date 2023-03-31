package Q6;

public class Q6 {

        public static void main(String[] args) {
            var inomhusCorporation = new Q6Inomhus();

            System.out.println("20Warehouses x 15Trucks x 100Boxes x 6Stacks x 30Trays x 100 eggs = 540.000.000 eggs");

            var num = inomhusCorporation.getEggId(
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0);

            var num2 = inomhusCorporation.getEggId(
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    1);

            var num3 = inomhusCorporation.getEggId(
                    0,
                    0,
                    0,
                    0,
                    2,
                    0,
                    0);

            var num4 = inomhusCorporation.getEggId(
                    19,
                    14,
                    99,
                    5,
                    29,
                    9,
                    9);



            System.out.println("1st egg:");
            System.out.println(num);
            System.out.println("2nd egg:");
            System.out.println(num2);
            System.out.println("1st egg in third tray:");
            System.out.println(num3);
            System.out.println("Last egg");
            System.out.println(num4);
        }


}
