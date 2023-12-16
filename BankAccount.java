import javax.swing.JOptionPane;
public class BankAccount {
	private static final int MIN_BALANCE_FOR_LOAN = 1000;
	public String account_name;
	private int balance;


	public BankAccount(String name, int initial_amount) {
		account_name = name;
		if (initial_amount >= 0)
			balance = initial_amount;
		else
			balance = 0;

	}

	public int getBalance() {
		return balance;
	}

	public boolean deposit(int amount) {
		boolean result = false;
		if (amount < 0)
			JOptionPane.showMessageDialog(null, "잘못된 입금액이라 무시합니다.");
		else {
			balance = balance + amount;
			result = true;
		}
		return result;
	}

	public boolean requestLoan(int amount, int term) {
		if (balance >= MIN_BALANCE_FOR_LOAN) {
			balance += amount;
			return true;
		} else {
			return false;
		}
	}

	public double calculateLoanInterest(int amount, int term) {
		double 기본이율 = 0.05;
		double 이자 = amount * 기본이율 * term;
		return 이자;
	}


	public boolean withdraw(int amount) {
		if (amount <= 0) {
			JOptionPane.showMessageDialog(null, "잘못된 출금액이라 무시합니다.");
			return false;
		}

		if (amount <= balance) {
			balance -= amount;
			JOptionPane.showMessageDialog(null, String.format("%.2f원 출금되었습니다.", amount / 100.0));
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "잔액이 부족합니다.");
			return false;
		}
	}
}
