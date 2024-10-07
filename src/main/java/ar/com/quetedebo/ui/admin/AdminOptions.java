package ar.com.quetedebo.ui.admin;

import javax.swing.JPanel;

import ar.com.quetedebo.core.QueTeDebo;
import ar.com.quetedebo.core.model.Debt;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class AdminOptions extends JPanel {
	private JTextField tfMember;
	private JTextField tfAddress;
	private JTextField tfAmount;
	private JTextField tfDescription;
	
	public AdminOptions(final QueTeDebo queTeDebo) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblMember = new JLabel("Miembro");
		GridBagConstraints gbc_lblMember = new GridBagConstraints();
		gbc_lblMember.insets = new Insets(0, 0, 5, 5);
		gbc_lblMember.gridx = 0;
		gbc_lblMember.gridy = 0;
		add(lblMember, gbc_lblMember);
		
		JLabel lblAddress = new JLabel("Direccion");
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 1;
		gbc_lblAddress.gridy = 0;
		add(lblAddress, gbc_lblAddress);
		
		JLabel lblAmount = new JLabel("Monto");
		GridBagConstraints gbc_lblAmount = new GridBagConstraints();
		gbc_lblAmount.insets = new Insets(0, 0, 5, 5);
		gbc_lblAmount.anchor = GridBagConstraints.ABOVE_BASELINE;
		gbc_lblAmount.gridx = 2;
		gbc_lblAmount.gridy = 0;
		add(lblAmount, gbc_lblAmount);
		
		JLabel lblDescription = new JLabel("Descripcion");
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 3;
		gbc_lblDescription.gridy = 0;
		add(lblDescription, gbc_lblDescription);
		
		tfMember = new JTextField();
		GridBagConstraints gbc_tfMember = new GridBagConstraints();
		gbc_tfMember.insets = new Insets(0, 0, 0, 5);
		gbc_tfMember.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfMember.gridx = 0;
		gbc_tfMember.gridy = 1;
		add(tfMember, gbc_tfMember);
		tfMember.setColumns(10);
		
		tfAddress = new JTextField();
		GridBagConstraints gbc_tfAddress = new GridBagConstraints();
		gbc_tfAddress.insets = new Insets(0, 0, 0, 5);
		gbc_tfAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfAddress.gridx = 1;
		gbc_tfAddress.gridy = 1;
		add(tfAddress, gbc_tfAddress);
		tfAddress.setColumns(10);
		
		tfAmount = new JTextField();
		GridBagConstraints gbc_tfAmount = new GridBagConstraints();
		gbc_tfAmount.insets = new Insets(0, 0, 0, 5);
		gbc_tfAmount.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfAmount.gridx = 2;
		gbc_tfAmount.gridy = 1;
		add(tfAmount, gbc_tfAmount);
		tfAmount.setColumns(10);
		
		tfDescription = new JTextField();
		GridBagConstraints gbc_tfDescription = new GridBagConstraints();
		gbc_tfDescription.insets = new Insets(0, 0, 0, 5);
		gbc_tfDescription.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDescription.gridx = 3;
		gbc_tfDescription.gridy = 1;
		add(tfDescription, gbc_tfDescription);
		tfDescription.setColumns(10);
		
		JButton btnAddDebt = new JButton("Agregar Deuda");
		GridBagConstraints gbc_btnAddDebt = new GridBagConstraints();
		gbc_btnAddDebt.gridheight = 2;
		gbc_btnAddDebt.gridx = 4;
		gbc_btnAddDebt.gridy = 0;
		add(btnAddDebt, gbc_btnAddDebt);
		btnAddDebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queTeDebo.addDebt(new Debt(tfMember.getText(),tfAddress.getText(),Float.valueOf(tfAmount.getText()),tfDescription.getText()));
			}
		});
		
	}

}
