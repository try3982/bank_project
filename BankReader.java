import javax.swing.*;

public class BankReader {
	private String input_line = "";

	public char readCommand(String message) {
		input_line = JOptionPane.showInputDialog(message).toUpperCase();
		return input_line.charAt(0);
	}

	public int readAmount() {
		int answer = 0;
		String s = input_line.substring(1, input_line.length());
		if (s.length() > 0) {
			double dollars_cents = new Double(s).doubleValue();
			answer = (int) (dollars_cents * 100);
		} else {
			JOptionPane.showMessageDialog(null, "금액을 입력하지 않아 0으로 처리합니다.");
		}
		return answer;
	}

	public int readLoanTerm() {
		int loanTerm = 0;
		boolean isValidInput = false;

		while (!isValidInput) {
			try {
				String input = JOptionPane.showInputDialog("대출 기간을 입력하세요:");
				loanTerm = Integer.parseInt(input);

				if (loanTerm > 0) {
					isValidInput = true;
				} else {
					JOptionPane.showMessageDialog(null, "올바른 대출 기간을 입력하세요 (양수만 가능).");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "숫자를 입력하세요.");
			}
		}

		return loanTerm;
	}
}
