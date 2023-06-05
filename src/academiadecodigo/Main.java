package academiadecodigo;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Client cliente = new Client("Diogo",sc);
        Bank bank = new Bank(cliente);


        Casino casino = new Casino(cliente,sc);
        boolean run = true;
        System.out.println("Welcome " + cliente.getName());
        while (run) {
            System.out.println("What you want to do?\n(0)Explore\n(1)Deposit Money\n(2)Withdraw Money\n(3)Check Wallet\n(4)Check Bank Balance\n(5)Go to the Casino!\n" +
                    "(6)Exit");
            int x = sc.nextInt();
            sc.nextLine();
            int y;

            switch (x) {
                case 0:
                    cliente.explore();
                    break;
                case 1:
                    System.out.println("How much money you want to deposit?");
                    y = sc.nextInt();
                    sc.nextLine();
                    cliente.depositMoney(bank, y);
                    break;
                case 2:
                    System.out.println("How much money you want to withdraw?");
                    y = sc.nextInt();
                    sc.nextLine();
                    cliente.withdrawMoney(bank, y);
                    break;
                case 3:
                    cliente.checkMoney();
                    break;
                case 4:
                    bank.checkBalance();
                    break;
                case 5:
                    casino.goToCasino();
                    break;
                case 6:
                    run = false;
                default:
                    System.out.println("Please choose a right number");
            }
        }
        sc.close();
        System.out.println("THANK YOU COME AGAIN!");


    }


}
