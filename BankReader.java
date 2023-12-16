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
			JOptionPane.showMessageDialog(null, "�ݾ��� �Է����� �ʾ� 0���� ó���մϴ�.");
		}
		return answer;
	}

	public int readLoanTerm() {
		int loanTerm = 0;
		boolean isValidInput = false;

		while (!isValidInput) {
			try {
				String input = JOptionPane.showInputDialog("���� �Ⱓ�� �Է��ϼ���:");
				loanTerm = Integer.parseInt(input);

				if (loanTerm > 0) {
					isValidInput = true;
				} else {
					JOptionPane.showMessageDialog(null, "�ùٸ� ���� �Ⱓ�� �Է��ϼ��� (����� ����).");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "���ڸ� �Է��ϼ���.");
			}
		}

		return loanTerm;
	}
}
