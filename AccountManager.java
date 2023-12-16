public class AccountManager {
	public static void main(String[] args) {
		BankReader reader = new BankReader();
		BankAccount account = new BankAccount("³» °èÁÂ", 0);
		BankWriter writer = new BankWriter(account);
		AccountController controller = new AccountController(reader, writer, account);
		controller.processTransactions();
	}
}
