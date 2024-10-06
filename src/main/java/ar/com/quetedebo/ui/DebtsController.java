package ar.com.quetedebo.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import ar.com.quetedebo.core.Debt;
import ar.com.quetedebo.core.QueTeDebo;

public class DebtsController implements Observer {
	private QueTeDebo queTeDebo;
	private DebtsView debtsView;
	private List<Debt> debts;

	public DebtsController(QueTeDebo queTeDebo, DebtsView debtsView) {
		this.debtsView = debtsView;
		this.queTeDebo = queTeDebo;
		this.queTeDebo.addObserver(this);
		debts = this.queTeDebo.getDebts();
	}

	public void pay() {
		this.queTeDebo.pay(debts);
	}

	public List<Debt> getDebts() {
		return debts;
	}

	public void setDebts(List<Debt> debts) {
		this.debts = debts;
	}

	public void addActionButtonPay(JButton buttonPay) {
		this.debtsView.getButtonPay().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pay();
			}
		});
	}

	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
	}

}
