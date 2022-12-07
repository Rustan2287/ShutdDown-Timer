package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.Window.Type;

public class UI_Fun {

	private JFrame frmTimer;
	private JTextField textField;
	private final Action action = new Stop();
	private final Action action_1 = new Start();
	private Runtime r = Runtime.getRuntime();
	private int Timer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UI_Fun window = new UI_Fun();
					window.frmTimer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI_Fun() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTimer = new JFrame();
		frmTimer.setForeground(new Color(0, 0, 0));
		frmTimer.setType(Type.UTILITY);
		frmTimer.setBackground(new Color(0, 0, 0));
		frmTimer.getContentPane().setForeground(new Color(0, 0, 0));
		frmTimer.getContentPane().setBackground(new Color(0, 0, 0));
		frmTimer.setAlwaysOnTop(true);
		frmTimer.setTitle("Timer");
		frmTimer.setBounds(100, 100, 450, 189);
		frmTimer.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("Timer");
		lblNewLabel.setForeground(new Color(255, 128, 0));
		frmTimer.getContentPane().add(lblNewLabel, BorderLayout.WEST);

		textField = new JTextField();
		textField.setBackground(new Color(51, 51, 51));
		textField.setForeground(new Color(255, 128, 0));
		textField.setHorizontalAlignment(SwingConstants.TRAILING);
		frmTimer.getContentPane().add(textField, BorderLayout.CENTER);
		textField.setColumns(10);


		JButton btnNewButton = new JButton("Start");
		btnNewButton.setForeground(new Color(255, 128, 0));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setAction(action_1);
		frmTimer.getContentPane().add(btnNewButton, BorderLayout.SOUTH);

		JButton btnNewButton_1 = new JButton("Stop");
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setForeground(new Color(255, 128, 0));
		btnNewButton_1.setAction(action);
		frmTimer.getContentPane().add(btnNewButton_1, BorderLayout.NORTH);
	}

	private class Stop extends AbstractAction {

		public Stop() {
			putValue(NAME, "Stop");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				r.exec("shutdown -a");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	private class Start extends AbstractAction {

		public Start() {
			putValue(NAME, "Start");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		@Override
		public void actionPerformed(ActionEvent e){

			try {
				Timer = Integer.parseInt(textField.getText());

				r.exec("shutdown -s -t " + Timer * 60);

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
