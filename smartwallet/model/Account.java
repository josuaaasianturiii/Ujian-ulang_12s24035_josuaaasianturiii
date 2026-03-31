package smartwallet.model;

/**
 * @author 12S24035 Josua Sianturi
 */
public class Account {
    private String owner;
    private String accountName;
    private String accountType;
    private double balance;

    public Account(String _owner, String _accountName){
        this.owner = _owner;
        this.accountName = _accountName;
        this.accountType = "";
        this.balance = 0.0;
    }

    public Account(String _owner, String _accountName, String _accountType){
        this.owner = _owner;
        this.accountName = _accountName;
        this.accountType = _accountType;
        this.balance = 0.0;
    }

    // Default
    public Account(){
        this.owner = "";
        this.accountName = "";
        this.accountType = "";
        this.balance = 0.0;
    }

    public String getOwner(){
        return owner;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void addTransaction(double _amount){
        this.balance += _amount;
    }
    
    @Override
    public String toString(){
        return accountName + "|" + owner + "|" + balance;
    }
}