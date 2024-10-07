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
		queTeDebo.addObserver(this);
		debts = queTeDebo.getDebts(); //Repeticion?
	}

	public void pay() {
		try {
			queTeDebo.pay(debts);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Debt> getDebts() {
		return debts;
	}

	public void setDebts(List<Debt> debts) {
		this.debts = debts;
	}

	public void addActionButtonPay(JButton buttonPay) {
		debtsView.getButtonPay().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pay();
			}
		});
	}

	public void update(Observable o, Object arg) {
		debts = queTeDebo.getDebts();
	}

}
