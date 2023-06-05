package academiadecodigo;

import java.util.Scanner;

public class Eventos {

    private Client c;
    private Scanner sc;
    public Eventos(Client c, Scanner sc)
    {
         this.c = c;
         this.sc = sc;
    }

    public void generateEvent()
    {
        int rng = (int)(Math.random()*9);
        if(rng <= 6) {
            c.findMoney();
        }
           else if(rng == 7) {
            if (c.getWalletMoney() <= 0) {
                System.out.println("A bandit tried to rob you but failed, because you dont have money!");
            } else {

                int lossMoney = (int) (Math.random() * 500);
                c.spendMoney(lossMoney);
                System.out.println(c.getName() + " fell into the floor and loss " + lossMoney + "€");
            }
        }
            else
        {
            if (c.getWalletMoney() <= 0) {
                System.out.println("You fell like running!");
            } else
            new rockPaperScissor(c,sc);
        }

    }

}
