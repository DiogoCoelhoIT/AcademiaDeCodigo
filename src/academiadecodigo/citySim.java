package academiadecodigo;

import java.util.Scanner;

public class citySim {
    private Scanner sc;
    private Client client;
    private Bank bank;
    private Casino casino;

    public citySim()
    {
        sc = new Scanner(System.in);
        client = new Client("Diogo",sc);
        bank = new Bank(client);
        casino = new Casino(client,sc);
    }
    public void start()
    {
        boolean run = true;
        System.out.println("Welcome " + client.getName());
        while (run) {
            System.out.println("What you want to do?\n(0)Explore\n(1)Check Wallet\n(2)Go to the bank\n(3)Go to the Casino!\n" +
                    "(4)Exit");
            int x = sc.nextInt();
            sc.nextLine();

            switch (x) {
                case 0:
                    client.explore();
                    break;
                case 1:
                    client.checkMoney();
                    break;
                case 2:
                    client.goToBank(bank);
                    break;
                case 3:
                    client.goToCasino(casino);
                    break;
                case 4:
                    run = false;
                    break;
                default:
                    System.out.println("Please choose a right number");
            }
        }
        sc.close();
        System.out.println("THANK YOU COME AGAIN!");


    }
}

