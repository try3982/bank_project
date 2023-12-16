import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.List;

public class BankWriter {
	private BankAccount bank;
	private String last_transaction = "";

	public BankWriter(BankAccount account) {
		bank = account;
	}

	public void showTransaction(String message, int amount) {
		last_transaction = message + " " + unconvert(amount);
		JOptionPane.showMessageDialog(null, bank.account_name + ": " + last_transaction
				+ "\n거래 후  = $" + unconvert(bank.getBalance()));
	}

	public void showTransaction(String message) {
		last_transaction = message;
		JOptionPane.showMessageDialog(null, bank.account_name + ": " + last_transaction
				+ "\n거래 후  = $" + unconvert(bank.getBalance()));
	}

	public void showLoanTransaction(String message, int loanAmount, double loanInterest) {
		last_transaction = message + " $" + unconvert(loanAmount) + "\n대출이자 $" + unconvert((int) loanInterest)
				+ "\n대출 후 잔액= $" + unconvert(bank.getBalance());
		JOptionPane.showMessageDialog(null, bank.account_name + ": " + last_transaction);
	}


	private String unconvert(int i) {
		return new DecimalFormat("0.00").format(i / 100.0);
	}

	public void showBalance() {
		JOptionPane.showMessageDialog(null, "현재 잔액 = $" + unconvert(bank.getBalance()));
	}
}
