package ar.com.quetedebo.ui;

import ar.com.quetedebo.core.QueTeDebo;
import ar.com.quetedebo.storage.PaymentHistory;
import ar.com.quetedebo.ui.admin.AdminUI;
import ar.com.quetedebo.ui.debts.DebtsView;

public class QueTeDeboApp {

	public static void main(String[] args) {
		if (args.length < 3) {
            throw new IllegalArgumentException("All three 'extensionsPath', 'dataPath', and 'storagePath' are required. Please provide them as the three arguments.");
        }

        String extensionsPath = args[0];
        String dataPath = args[1];
        String storagePath = args[2];

		final QueTeDebo queTeDebo = new QueTeDebo(extensionsPath, dataPath);

        queTeDebo.addObserver(new PaymentHistory(storagePath));

		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminUI(queTeDebo).setVisible(true);
                new DebtsView(queTeDebo).setVisible(true);
            }
        });
	}

}
