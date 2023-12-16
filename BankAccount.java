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
			JOptionPane.showMessageDialog(null, "�߸��� �Աݾ��̶� �����մϴ�.");
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
		double �⺻���� = 0.05;
		double ���� = amount * �⺻���� * term;
		return ����;
	}


	public boolean withdraw(int amount) {
		if (amount <= 0) {
			JOptionPane.showMessageDialog(null, "�߸��� ��ݾ��̶� �����մϴ�.");
			return false;
		}

		if (amount <= balance) {
			balance -= amount;
			JOptionPane.showMessageDialog(null, String.format("%.2f�� ��ݵǾ����ϴ�.", amount / 100.0));
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "�ܾ��� �����մϴ�.");
			return false;
		}
	}
}
