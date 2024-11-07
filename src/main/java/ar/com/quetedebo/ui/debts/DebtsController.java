package ar.com.quetedebo.ui.debts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import ar.com.quetedebo.core.QueTeDebo;
import ar.com.quetedebo.core.Debt;

public class DebtsController {
	private QueTeDebo queTeDebo;
	private DebtsView debtsView;

	public DebtsController(QueTeDebo queTeDebo, DebtsView debtsView) {
		this.debtsView = debtsView;
		this.queTeDebo = queTeDebo;
		addActionButtonPay();
	}

	public void pay() {
		try {
			queTeDebo.payRequest("BBVA");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Debt> getDebts() {
		return queTeDebo.getDebts();
	}

	public void addActionButtonPay() {
		debtsView.getButtonPay().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pay();
			}
		});
	}
}
