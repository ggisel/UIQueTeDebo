package ar.com.quetedebo.ui.debts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import ar.com.quetedebo.core.QueTeDebo;
import ar.com.quetedebo.core.model.Debt;

public class DebtsController {
	private QueTeDebo queTeDebo;
	private DebtsView debtsView;

	public DebtsController(QueTeDebo queTeDebo, DebtsView debtsView) {
		this.debtsView = debtsView;
		this.queTeDebo = queTeDebo;
	}

	public void pay() {
		try {
			queTeDebo.pay();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Debt> getDebts() {
		return queTeDebo.getDebts();
	}

	public void addActionButtonPay(JButton buttonPay) {
		debtsView.getButtonPay().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pay();
			}
		});
	}
}
