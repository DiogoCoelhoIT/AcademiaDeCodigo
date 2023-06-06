package academiadecodigo;

import java.util.Scanner;

public class Client {

    private String name;
    private Wallet wallet;
    private Eventos eventos;
    Scanner sc;

    public Client(String name, Scanner sc) {
        this.name = name;
        this.sc = sc;
        wallet = new Wallet(this);
        eventos = new Eventos(this, sc);
    }

    public void findMoney() {
        int x = (int) (Math.random() * 200);
        System.out.println("Found " + x + "€");
        saveMoney(x);
    }

    public void explore() {
        eventos.generateEvent();
    }

    private void saveMoney(int x) {
        wallet.addBalance(x);
    }

    public void depositMoney(Bank bank, int x) {
        if (wallet.getBalance() >= x) {
            bank.depositMoney(x);
        }
        wallet.lessBalance(x);

    }

    public void goToBank(Bank b) {
        b.welcomeToBank(sc);
    }

    public void goToCasino(Casino c)
    {
        c.goToCasino();
    }
    public void spendMoney(int x)
    {

        wallet.lessBalance(x);
    }
    public void receiveMoney(int x)
    {
        wallet.addBalance(x);
    }
    public void withdrawMoney(Bank bank,int x)
    {
        saveMoney(bank.withdraw(x));
    }

    public int getWalletMoney()
    {
        return wallet.getBalance();
    }

    public String getName() {
        return name;
    }

    public void enoughMoney(int x) {
        if(wallet.getBalance() < x)
        {
            System.out.println("Not enough money!");
        }
    }
    public void checkMoney()
    {
        System.out.println(name + " has "+ getWalletMoney()+"€ on his Wallet!");
    }
}
