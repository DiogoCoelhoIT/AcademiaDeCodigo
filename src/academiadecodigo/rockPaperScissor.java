package academiadecodigo;

import java.util.Scanner;

public class rockPaperScissor {
   private Client c;
    private Scanner sc;
    private  int bet;
    private int reward;
    public rockPaperScissor(Client c, Scanner sc)
    {
        this.c = c;
        this.sc = sc;
        bet = (c.getWalletMoney() / 10);
        reward = (c.getWalletMoney() / 5);
        startGame();
    }

    public void startGame()
    {
        System.out.println("A Lunatic asks you to play Rock Paper Scissor, if you win or draw you get "+bet+"€, if you lose you lose "+reward+"€");
        System.out.println("What do you choose?\n(1)Rock\n(2)Paper\n(3)Scissor");
        boolean run = true;
        int lunatic = ((int)(Math.random()*3))+1;
        int input = sc.nextInt();
        sc.nextLine();
        while (run) {
            switch (input) {
                case 1:
                    if(lunatic== 2)
                    {
                        System.out.println("Lunatic plays Paper!You loose!");
                        c.spendMoney(reward);
                    }
                    else{
                        System.out.println("You win!");
                        c.receiveMoney(bet);
                    }
                    run = false;
                    break;
                case 2:
                    if(lunatic== 3)
                {
                    System.out.println("Lunatic plays Scissor!You loose!");
                    c.spendMoney(reward);
                }
                else{
                    System.out.println("You win!");
                    c.receiveMoney(bet);
                }
                    run = false;
                    break;
                case 3:
                    if(lunatic== 1)
                    {
                        System.out.println("Lunatic plays Paper!You loose!");
                        c.spendMoney(reward);
                    }
                    else{
                        System.out.println("You win!");
                        c.receiveMoney(bet);
                    }
                    run = false;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }

    }

}
