package ar.com.quetedebo.ui;

import ar.com.quetedebo.core.QueTeDebo;
import ar.com.quetedebo.ui.admin.AdminUI;
import ar.com.quetedebo.ui.debts.DebtsView;

public class QueTeDeboApp {

	public static void main(String[] args) {
		if (args.length < 2) {
            throw new IllegalArgumentException("Both 'extensionsPath' and 'dataPath' are required. Please provide them as the first and second arguments.");
        }

        String extensionsPath = args[0];
        String dataPath = args[1];

		final QueTeDebo queTeDebo = new QueTeDebo(extensionsPath, dataPath);
		
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminUI(queTeDebo).setVisible(true);
                new DebtsView(queTeDebo).setVisible(true);
            }
        });
	}

}
