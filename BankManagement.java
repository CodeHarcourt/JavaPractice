import java.util.Scanner;

public class BankManagement {
    public static void main(String[] args){
        String accountNumber;
        String accountHolderName;
        double balance;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入账户号码:");
        accountNumber = sc.nextLine();
        System.out.print("请输入账户持有人姓名:");
        accountHolderName = sc.nextLine();
        System.out.print("请输入账户余额:");
        balance = sc.nextDouble();
        BankAccount ba = new BankAccount(accountNumber, accountHolderName, balance);
        System.out.print("请输入存款金额:");
        double deposit = sc.nextDouble();
        ba.deposit(deposit);
        System.out.print("请输入取款金额:");
        double withdraw = sc.nextDouble();
        ba.withdraw(withdraw);
        System.out.println("账户的余额为" + ba.balance);
    }
}
class BankAccount{
    String accountNumber;
    String accountHolderName;
    double balance;

    BankAccount(String accountNumber,String accountHolderName, double balance){
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
    void deposit(double amount){
        this.balance += amount;
    }
    void withdraw(double amount){
        try{
            if(this.balance < amount){
                throw new InsufficientBalanceException();
            }
            this.balance -= amount;
            System.out.println("取款成功");
        }catch(InsufficientBalanceException e){
            System.out.println("余额不足");
        }
    }
    double getBalance(){
        return this.balance;
    }
}
class InsufficientBalanceException extends RuntimeException{
    InsufficientBalanceException(){super();}
    InsufficientBalanceException(String message){super(message);}
}
