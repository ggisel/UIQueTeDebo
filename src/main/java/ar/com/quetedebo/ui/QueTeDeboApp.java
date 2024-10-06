package ar.com.quetedebo.ui;

import ar.com.quetedebo.core.QueTeDebo;

public class QueTeDeboApp {

	public static void main(String[] args) {
		final QueTeDebo queTeDebo = new QueTeDebo();
		
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DebtsView(queTeDebo).setVisible(true);
            }
        });
	}

}
