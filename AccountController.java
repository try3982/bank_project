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
		char command = reader.readCommand("명령 입금(D)/출금(W)/대출(L) 금액을 입력하세요.잔액 조회(B)/종료(Q)");
		switch (command) {
			case 'Q':
				return;
			case 'D': {
				int amount = reader.readAmount();
				if (account.deposit(amount))
					writer.showTransaction("입금 $", amount);
				else
					writer.showTransaction("입금 오류 ", amount);
				break;
			}
			case 'W': {
				int amount = reader.readAmount();
				if (account.withdraw(amount))
					writer.showTransaction("출금 $", amount);
				else
					writer.showTransaction("출금 오류 ", amount);
				break;
			}
			case 'L': {
				int loanAmount = reader.readAmount();
				int loanTerm = reader.readLoanTerm();

				if (account.requestLoan(loanAmount, loanTerm)) {
					writer.showLoanTransaction("대출 성공", loanAmount, account.calculateLoanInterest(loanAmount, loanTerm));
				} else {
					writer.showTransaction("대출 신청 오류 ", loanAmount);
				}
				break;
			}
			case'B': {
				writer.showBalance();
					break;
			}
			default:
				writer.showTransaction("잘못된 명령 " + command);
		}
		this.processTransactions();
	}
}
