package academiadecodigo;

public class Bank {

    //deposito
    //levantamento

    private Client client;
    private int balance;
    private double commission;
    public Bank(Client client)
    {
          commission = 0.1;
          this.client = client;
          balance = 0;
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
