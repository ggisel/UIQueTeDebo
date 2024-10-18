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

	public void pay(String paymentMethod) {
		// FIXME cambiar el nombre del metodo
		try {
			queTeDebo.payRequest(paymentMethod);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Debt> getDebts() {
		return queTeDebo.getDebts();
	}
	
	public String[] getPaymentsMethod() {
		String[] paymentMethodsSelector = queTeDebo.getPaymentsMethod().toArray(new String[0]);
		return paymentMethodsSelector;
	}

	public void addActionButtonPay() {
		debtsView.getButtonPay().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pay(debtsView.getPaymentMethodsSelector().getSelectedItem().toString());
			}
		});
	}
}
