package ar.com.quetedebo.ui;

import ar.com.quetedebo.core.QueTeDebo;
import ar.com.quetedebo.ui.admin.AdminUI;
import ar.com.quetedebo.ui.debts.DebtsView;

public class QueTeDeboApp {

	public static void main(String[] args) {
		final QueTeDebo queTeDebo = new QueTeDebo();
		
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminUI(queTeDebo).setVisible(true);
                new DebtsView(queTeDebo).setVisible(true);
            }
        });
	}

}
