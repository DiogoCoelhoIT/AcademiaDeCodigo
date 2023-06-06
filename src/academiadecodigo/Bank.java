package academiadecodigo;

import java.util.Scanner;

public class Bank {

    private Client client;
    private int balance;
    private double commission;
    public Bank(Client client)
    {
          commission = 0.1;
          this.client = client;
          balance = 0;
    }

    public void welcomeToBank(Scanner sc) {
        boolean run = true;
        while (run) {
            System.out.println("Welcome to the Bank!What do you want to do?\n(1)Check Balance\n(2)Deposit Money\n(3)Withdraw Money\n(4)Leave");
            int x = sc.nextInt();
            sc.nextLine();
            switch (x) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.println(client.getName() + " currently have " + client.getWalletMoney() + "€ in his wallet!");
                    System.out.println("How much do you want to deposit?");
                    int deposit = sc.nextInt();
                    sc.nextLine();
                    client.depositMoney(this, deposit);
                    break;
                case 3:
                    System.out.println(client.getName() + " currently have " + balance + "€ in his account!");
                    System.out.println("How much do you want to withdraw?");
                    int withdraw = sc.nextInt();
                    sc.nextLine();
                    client.withdrawMoney(this, withdraw);
                    break;
                case 4:
                    run = false;
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }
    }
    public void depositMoney(int x)
    {
        if(x>0) {
            System.out.println("Bank - You just deposited " + x + "€!Thanks for your trust!\nCommission: " + commissionValue(x) + "€");
            balance += x;
            balance -= commissionValue(x);
            System.out.println("Bank - Your Balance is: " + checkBalance());
        }else{
            System.out.println("Bank - Invalid Value");
        }
    }

    public int checkBalance()
    {
        System.out.println("Bank - You have "+balance+"€ in your account");
        return balance;
    }
    public int withdraw(int x)
    {
        if(x >0) {
            if (balance >= withCommission(x)) {
                balance -= withCommission(x);
                System.out.println("Bank - You just withdraw " + x + "€!Thanks for your trust!");
                return withCommission(x);
            } else
                System.out.println("Bank - Cant withdraw money because, not enough money!\nBank - Your Balance is: " + checkBalance() + "€\n Value of withdraw asked: " + x + "€, plus commission " + commissionValue(x) + "€");
            return 0;
        }
        System.out.println("Bank - Invalid Value");
        return 0;
    }

    private int withCommission(int x)
    {
        return (int)(x + (x*commission));
    }
    private int commissionValue(int x)
    {
        return (int)(x*commission);
    }
}
