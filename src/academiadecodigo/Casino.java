package academiadecodigo;

import java.util.Scanner;

public class Casino {

    Scanner sc;
    Client client;
    public Casino(Client client, Scanner sc)
    {
    this.client = client;
    this.sc = sc;
    }

    public void goToCasino()
    {
        Roulette roulette = new Roulette();
        System.out.println(client.getName() + " welcome to the Casino! What do you want to play?\n(1)Roulette");
        int x = sc.nextInt();
        sc.nextLine();
        switch (x)
        {
            case 1:
            roulette.startGame(sc,client);
            break;
            default:
            System.out.println("invalid entry");
        }
    }
}
