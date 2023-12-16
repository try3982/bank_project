public class AccountController  {
	private BankReader reader;
	private BankWriter writer;
	private BankAccount account;

	public AccountController(BankReader r, BankWriter w, BankAccount a) {
		reader = r;
		account = a;
		writer = w;
	}

	public void processTransactions() {
		char command = reader.readCommand("��� �Ա�(D)/���(W)/����(L) �ݾ��� �Է��ϼ���.�ܾ� ��ȸ(B)/����(Q)");
		switch (command) {
			case 'Q':
				return;
			case 'D': {
				int amount = reader.readAmount();
				if (account.deposit(amount))
					writer.showTransaction("�Ա� $", amount);
				else
					writer.showTransaction("�Ա� ���� ", amount);
				break;
			}
			case 'W': {
				int amount = reader.readAmount();
				if (account.withdraw(amount))
					writer.showTransaction("��� $", amount);
				else
					writer.showTransaction("��� ���� ", amount);
				break;
			}
			case 'L': {
				int loanAmount = reader.readAmount();
				int loanTerm = reader.readLoanTerm();

				if (account.requestLoan(loanAmount, loanTerm)) {
					writer.showLoanTransaction("���� ����", loanAmount, account.calculateLoanInterest(loanAmount, loanTerm));
				} else {
					writer.showTransaction("���� ��û ���� ", loanAmount);
				}
				break;
			}
			case'B': {
				writer.showBalance();
					break;
			}
			default:
				writer.showTransaction("�߸��� ��� " + command);
		}
		this.processTransactions();
	}
}
