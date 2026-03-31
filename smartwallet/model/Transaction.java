package smartwallet.model;

/**
 * @author 12S24035 Josua sianturi
 */
public class Transaction {
    private static int idCounter = 0;
    private int id;
    private Account account;
    private double amount;
    private String postedAt;
    private String note;

    public Transaction(Account _Account, double _amount, String _postedAt, String _note){
        this.id = ++idCounter;
        this.account = _Account;
        this.amount = _amount;
        this.postedAt = _postedAt;
        this.note = _note;
        account.addTransaction(amount);
    }

    public int getId(){
        return id;
    }

    public Account getAccount(){
        return account;
    }

    public double getAmount(){
        return amount;
    }

    public String getPostedAt(){
        return postedAt;
    }

    public String getNote(){
        return note;
    }

    @Override
    public String toString(){
        return id + "|" + account.getAccountName() + "|" + amount + "|" + postedAt + "|" + note;
    }
}