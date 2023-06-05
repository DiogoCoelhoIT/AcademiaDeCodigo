package academiadecodigo;

public class Wallet {

    //jogador pede dinehri ao banco, o banco da dinheiro ao cliente e o cliente mete dinherio na carteira

    private int balance;
    private int limit;
    private Client client;
    public Wallet(Client client)
    {
        this.client = client;
         balance = 0;
         limit = 10000;
    }

    public int getBalance() {
        return balance;
    }

    public void addBalance(int money) {
      if(money != 0)
      {
          balance += money;
          if(!isFull())
          {
             System.out.println(client.getName() +" - Saved " + money + " € on his wallet");
          }

          else {

              System.out.println(client.getName()+" - Not enough space on wallet, saved " + (money-(balance - limit))+"€ on wallet and " + (balance - limit)+" € went to waste");
              balance = limit;
          }
      }
    }

    public void lessBalance(int money)
    {
      if(balance >= money) {
          balance -= money;
      }else{
          System.out.println(client.getName() + " - Not enough money");
      }
    }
    public boolean isFull()
    {
        if(balance >= limit)
        {
            return true;
        }
        return false;
    }


}
