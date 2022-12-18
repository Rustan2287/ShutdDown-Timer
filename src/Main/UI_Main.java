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
import javax.swing.JPanel;
import javax.swing.BoxLayout;

public class UI_Main {

	private JFrame frmTimer;
	private JTextField Hour_textField;
	private final Action action = new Stop();
	private final Action action_1 = new Start();
	private Runtime r = Runtime.getRuntime();
	private int Hour = 0;
	private int Minutes = 0;
	private int Seconds = 0;
	private JTextField Minutes_textField;
	private JTextField Seconds_textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UI_Main window = new UI_Main();
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
	public UI_Main() {
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

		JButton btnNewButton = new JButton("Start");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setAction(action_1);
		frmTimer.getContentPane().add(btnNewButton, BorderLayout.SOUTH);

		JButton btnNewButton_1 = new JButton("Stop");
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setAction(action);
		frmTimer.getContentPane().add(btnNewButton_1, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setForeground(new Color(255, 255, 255));
		frmTimer.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JLabel lblNewLabel = new JLabel("Hour");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);

		Hour_textField = new JTextField();
		Hour_textField.setText("0");
		panel.add(Hour_textField);
		Hour_textField.setBackground(Color.DARK_GRAY);
		Hour_textField.setForeground(Color.WHITE);
		Hour_textField.setHorizontalAlignment(SwingConstants.TRAILING);
		Hour_textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Minutes");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel_1);

		Minutes_textField = new JTextField();
		Minutes_textField.setText("0");
		Minutes_textField.setHorizontalAlignment(SwingConstants.TRAILING);
		Minutes_textField.setForeground(Color.WHITE);
		Minutes_textField.setBackground(Color.DARK_GRAY);
		panel.add(Minutes_textField);
		Minutes_textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Seconds");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel_2);

		Seconds_textField = new JTextField();
		Seconds_textField.setText("0");
		Seconds_textField.setHorizontalAlignment(SwingConstants.TRAILING);
		Seconds_textField.setForeground(Color.WHITE);
		Seconds_textField.setBackground(Color.DARK_GRAY);
		panel.add(Seconds_textField);
		Seconds_textField.setColumns(10);
	}

	private class Stop extends AbstractAction {

		public Stop() {
			putValue(NAME, "Stop");
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

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {

				Hour = Integer.parseInt(Hour_textField.getText());
				Minutes = Integer.parseInt(Minutes_textField.getText());
				Seconds = Integer.parseInt(Seconds_textField.getText());
				
				int sum = (Hour *3600) + (Minutes * 60) + Seconds;
				
				r.exec("shutdown -s -t " + sum);

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
