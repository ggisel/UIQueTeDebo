package ar.com.quetedebo.ui.debts;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import ar.com.quetedebo.core.Debt;
import ar.com.quetedebo.core.QueTeDebo;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class DebtsView extends JFrame implements Observer {
	private static final long serialVersionUID = 1L;
	private javax.swing.JButton buttonPay;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelDebts;
    private javax.swing.JLabel labelNotDebts;
    private javax.swing.JMenu menuDebts;
    private javax.swing.JMenu menuPaymentsMethods;
    private javax.swing.JMenuBar menuQTD;
    private javax.swing.JPanel panelDebts;
    private javax.swing.JPanel panelNotDebts;
    private javax.swing.JTable tableDebts;
	
	private DebtsController debtsController;

	public DebtsView(QueTeDebo queTeDebo) {
		queTeDebo.addObserver(this);
		debtsController = new DebtsController(queTeDebo, this);
		
		initComponents();
		setDataComponents();
	}

	private void initComponents() {

        panelDebts = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDebts = new javax.swing.JTable();
        buttonPay = new javax.swing.JButton();
        labelDebts = new javax.swing.JLabel();
        panelNotDebts = new javax.swing.JPanel();
        labelNotDebts = new javax.swing.JLabel();
        menuQTD = new javax.swing.JMenuBar();
        menuDebts = new javax.swing.JMenu();
        menuPaymentsMethods = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QueTeDebo");
        setResizable(false);

        tableDebts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripci�n", "Pagar a", "Monto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableDebts);

        buttonPay.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonPay.setText("Pagar");

        labelDebts.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelDebts.setText("Vas a pagar las siguientes deudas");

        labelNotDebts.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelNotDebts.setText("No ten�s deudas para pagar");

        menuDebts.setText("Gastos");
        menuQTD.add(menuDebts);

        menuPaymentsMethods.setText("Met�dos de pago");
        menuQTD.add(menuPaymentsMethods);

        setJMenuBar(menuQTD);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(panelDebts);
        panelDebts.setLayout(new BorderLayout(0, 0));
        panelDebts.add(labelDebts, BorderLayout.NORTH);
        panelDebts.add(buttonPay, BorderLayout.SOUTH);
        panelDebts.add(jScrollPane2);
        getContentPane().add(panelNotDebts);
        panelNotDebts.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panelNotDebts.add(labelNotDebts);
        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        pack();
        setLocationRelativeTo(null);
    }
	
	private void setDataComponents() {

		boolean empty = debtsController.getDebts().size() == 0;
        panelDebts.setVisible(!empty);
		panelNotDebts.setVisible(empty);
		DefaultTableModel model = (DefaultTableModel) tableDebts.getModel();
		int lines = model.getRowCount();
		for (int i = 0; i < lines; i++) {
			model.removeRow(0);
		}
		for (Debt debt : debtsController.getDebts()) {
			System.out.println(debt);
			model.addRow(new Object[]{debt.getDescription(), debt.getMemberPayment(), debt.getAmount()});
        }
		debtsController.addActionButtonPay(buttonPay);
	}
	
	public JButton getButtonPay() {
		return buttonPay;
	}

	public void update(Observable o, Object paymentMethod) {
		if (paymentMethod instanceof String) {
            panelDebts.setVisible(false);
            labelNotDebts.setText("Pagaste tus deudas con " + paymentMethod);
            panelNotDebts.setVisible(true);
            setDataComponents();
		}
	}
}
