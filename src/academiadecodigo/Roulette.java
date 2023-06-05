package academiadecodigo;

import java.util.Scanner;

public class Roulette {
    private int[] black = {2,4,6,8,11,10,15,13,17,20,22,24,26,29,28,31,33,35};
    private int[] red = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};

    public int launchBall()
    {int x = (int)(Math.random()*37);
        System.out.println("The Ball is ROLLING!\nThe ball hitted number "+ x);
       return x;
    }
    private boolean isODD(int x)
    {
        return x % 2 ==0 ? false : true;
    }
    private boolean isFirst(int x)
    {
        return x >= 1 && x<=12 ? true : false;
    }
    private boolean isSecond(int x)
    {
        return x > 12 && x<=24 ? true:false;
    }
    private boolean isThird(int x)
    {
        return x > 24 && x<=36 ? true:false;
    }
    private boolean isLowerMiddle(int x)
    {
        return x >= 1 && x<=18 ? true:false;
    }
    private boolean isUpperMiddle(int x)
    {
        return x > 18 && x<=36 ? true:false;
    }
    private boolean isPick(int x, int y)
    {

        return x == y ? true:false;
    }
    private boolean isBlack(int x)
    {
        for (int i = 0; i < black.length; i++)
        {
            if(x == black[i])
            {
                return true;
            }
        }
        return false;
    }
    private boolean isRed(int x)
    {
        for (int i = 0; i < red.length; i++)
        {
            if(x == red[i])
            {
                return true;
            }
        }
        return false;
    }

    public void startGame(Scanner sc, Client client)
    {
        boolean play = true;
        while(play) {
            System.out.println("Welcome to the game of the roullete!\n(0)Choose a number between 0-36\n(1)Bet on 1st 12\n(2)Bet on 2nd 12\n(3)Bet on 3rd 12\n" +
                    "(4)Bet on 1-18\n(5)Bet on 19-36\n(6)Bet on EVEN number\n(7)Bet on ODD Number\n(8)Bet on Black\n(9)Bet on Red\n(10)Dont Play");
            int ball;
            int pick = sc.nextInt();
            sc.nextLine();
            if(pick==10) {
                play= false;
                break;
            }

            System.out.println("How much you want to bet? ");
            int bet = sc.nextInt();
            sc.nextLine();
            client.enoughMoney(bet);
            if (client.getWalletMoney() >= bet) {
                client.spendMoney(bet);
                switch (pick) {
                    case 0:
                        System.out.println("Pick a number between 0 -36");
                        int player = sc.nextInt();
                        sc.nextLine();
                        ball = launchBall();
                        if (isPick(player, ball)) {
                            System.out.println("Congrats!!!You won");
                            client.receiveMoney(bet * 36);
                        } else {
                            System.out.println("Better luck next time");
                        }
                        break;
                    case 1:
                        ball = launchBall();
                        if (isFirst(ball)) {
                            System.out.println("Congrats!!!You won");
                            client.receiveMoney(bet * 3);
                        } else {
                            System.out.println("Better luck next time");
                        }
                        break;
                    case 2:
                        ball = launchBall();
                        if (isSecond(ball)) {
                            System.out.println("Congrats!!!You won");
                            client.receiveMoney(bet * 3);
                        } else {
                            System.out.println("Better luck next time");
                        }
                        break;
                    case 3:
                        ball = launchBall();
                        if (isThird(ball)) {
                            System.out.println("Congrats!!!You won");
                            client.receiveMoney(bet * 3);
                        } else {
                            System.out.println("Better luck next time");
                        }
                        break;
                    case 4:
                        ball = launchBall();
                        if (isLowerMiddle(ball)) {
                            System.out.println("Congrats!!!You won");
                            client.receiveMoney(bet * 2);
                        } else {
                            System.out.println("Better luck next time");
                        }
                        break;
                    case 5:
                        ball = launchBall();
                        if (isUpperMiddle(ball)) {
                            System.out.println("Congrats!!!You won");
                            client.receiveMoney(bet * 2);
                        } else {
                            System.out.println("Better luck next time");
                        }
                        break;
                    case 6:
                        ball = launchBall();
                        if (!isODD(ball)) {
                            System.out.println("Congrats!!!You won");
                            client.receiveMoney(bet * 2);
                        } else {
                            System.out.println("Better luck next time");
                        }
                        break;
                    case 7:
                        ball = launchBall();
                        if (isODD(ball)) {
                            System.out.println("Congrats!!!You won");
                            client.receiveMoney(bet * 2);
                        } else {
                            System.out.println("Better luck next time");
                        }
                        break;
                    case 8:
                        ball = launchBall();
                        if (isBlack(ball)) {
                            System.out.println("Congrats!!!You won");
                            client.receiveMoney(bet * 2);
                        } else {
                            System.out.println("Better luck next time");
                        }
                        break;
                    case 9:
                        ball = launchBall();
                        if (isRed(ball)) {
                            System.out.println("Congrats!!!You won");
                            client.receiveMoney(bet * 2);
                        } else {
                            System.out.println("Better luck next time");
                        }
                        break;
                    default:
                        System.out.println("Please choose a correct Option");
                }

            }
        }
    }
}
