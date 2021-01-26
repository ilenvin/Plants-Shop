import java.util.ArrayList;
import java.util.Scanner;

public class PlantShop {

    static Scanner sc = new Scanner(System.in);

    ArrayList<Plant> plantList = new ArrayList<Plant>();


    public void addPlant() {
        System.out.print("Input Plant Name: ");
        String name = sc.nextLine();

        System.out.print("Input price for size (S): ");
        double sPrice = sc.nextDouble();
        System.out.print("Input price for size (M): ");
        double mPrice = sc.nextDouble();
        System.out.print("Input price for size (L): ");
        double lPrice = sc.nextDouble();

        Price price = new Price(sPrice, mPrice, lPrice);
        Plant newPlant = new Plant(price, name);

        plantList.add(newPlant);

    }

    public void listPlants() {
        System.out.println("---------------> All Plants <-------------");
        for (int i = 0; i < plantList.size(); i++) {
            System.out.printf("\n%d/ Plant Name: %s\n", i+1, plantList.get(i).name);
            System.out.printf("Price for size (S): $%.2f | ", plantList.get(i).price.sPrice);
            System.out.printf("Price for size (M): $%.2f | ", plantList.get(i).price.mPrice);
            System.out.printf("Price for size (L): $%.2f\n", plantList.get(i).price.lPrice);
            
        }
    }

    public void deletePlant() {
        listPlants();
    
        System.out.print("\nInput index of Plant: ");
        int index = sc.nextInt();

        for (int i = 0; i<plantList.size(); i++){

            if(index-1 == i){
                plantList.remove(i);
                System.out.println("**** Plant removed!");
            }

        }

    }

    public void plantBilling() {
        double totalPrice=0, finalPrice =0;
        boolean isRepeated = true;
        
    do{
        System.out.println("\n");
        listPlants();
        System.out.println("\nWhich plant do you want to buy?");
        System.out.print("Choice: ");
        int choice = sc.nextInt();

        for (int i =0; i<plantList.size(); i++){
            double price = 0;
            int amount = 0;
         
            if(choice-1 == i){

                System.out.println("\nWhich size do you want?");
                System.out.println("1. Small\n2. Medium\n3. Large");
                System.out.print("Choice: ");
                int size = sc.nextInt();

                switch (size) {
                    case 1:
                        System.out.println("How many do you want?");
                        System.out.print("Amount: ");
                        amount = sc.nextInt();
                        price = plantList.get(i).price.sPrice; 

                        totalPrice += (price * amount);
                        
                        break;
                    case 2:
                        System.out.println("How many do you want?");
                        System.out.print("Amount: ");
                        amount = sc.nextInt();
                        price = plantList.get(i).price.mPrice; 

                        totalPrice += (price * amount);
                        
                        break;
                    case 3:
                        System.out.println("How many do you want?");
                        System.out.print("Amount: ");
                        amount = sc.nextInt();
                        price = plantList.get(i).price.lPrice; 

                        totalPrice += (price * amount);
                        
                        break;
                
                    default:
                        break;
                }

            }
            
        }

        System.out.println("Buy more? Y for Yes");
        System.out.print("Choice: ");
        String cont = sc.next();
        if(cont.equals("Y") || cont.equals("y")){
            isRepeated = true;
        }else{
            isRepeated = false;
        }
    }while(isRepeated);


    // Discount product
    if(totalPrice >= 200){
        finalPrice = totalPrice - totalPrice*0.15;
        System.out.println("\nDISCOUNT 15%");
    }
    else if(totalPrice >=100 && totalPrice < 200){
        finalPrice = totalPrice - totalPrice*0.1;
        System.out.println("\nDISCOUNT 10%");

    }else if(totalPrice >=50 && totalPrice < 100){
        finalPrice = totalPrice - totalPrice*0.05;
        System.out.println("\nDISCOUNT 5%");

    }else{
        finalPrice = totalPrice;
    }

    // Show Price
    
    System.out.printf("TOTAL PRICE: %.2f", totalPrice);
    System.out.printf("\nFINAL PRICE: %.2f\n", finalPrice);

}










    public static void main(String[] args) {
        PlantShop app = new PlantShop();
        boolean isRunning=true;

        while(isRunning){

            System.out.println("-------------> PlantShop System Management <-------------");
            System.out.println("1. Manage Product");
            System.out.println("2. Bill Product");
            System.out.println("3. Exit Program");

            System.out.print("Choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                boolean isRunning1 = true;

                while(isRunning1){

                    System.out.println("\n-------------> PlantShop Product Management <-------------\n");
                    System.out.println("1. Add New Plant");
                    System.out.println("2. List All Plant");
                    System.out.println("3. Delete A Plant");
                    System.out.println("4. Exit to main menu");

                    System.out.print("Choice: ");

                    int opt = sc.nextInt();
                    String empty = sc.nextLine();
                    switch (opt) {
                        case 1:
                            app.addPlant();
                            break;
                        case 2:
                            app.listPlants();
                            break;
                        case 3:

                            app.deletePlant();
                            break;
                        case 4:
                            isRunning1 = false;
                            break;
                    
                        default:
                            break;
                    }
                }
                   



                    break;
                case 2:
                

                        System.out.println("-------------> PlantShop Bill Management <-------------");
                        app.plantBilling();



                    
                    break;
                case 3:
                    isRunning= false;
                    break;
                default:
                    break;
            }
        }
    }
}
