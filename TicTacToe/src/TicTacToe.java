import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TicTacToe {

	private JFrame frame;
	private String m_previousMove = null;
	private JButton [][] m_allButtons = new JButton [3][3];
	private static String s_x = "X";
	private static String s_o = "O";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToe window = new TicTacToe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TicTacToe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 480, 329);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btn1 = new JButton("");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn1.setBounds(10, 28, 132, 64);
		frame.getContentPane().add(btn1);
		m_allButtons [0][0]=btn1;
		
		JButton btn2 = new JButton("");
		btn2.setBounds(163, 28, 132, 64);
		frame.getContentPane().add(btn2);
		m_allButtons [0][1]=btn2;
		
		JButton btn3 = new JButton("");
		btn3.setBounds(305, 28, 132, 64);
		frame.getContentPane().add(btn3);
		m_allButtons [0][2]=btn3;
		
		JButton btn4 = new JButton("");
		btn4.setBounds(10, 112, 132, 64);
		frame.getContentPane().add(btn4);
		m_allButtons [1][0]=btn4;
		
		JButton btn5 = new JButton("");
		btn5.setBounds(163, 112, 132, 64);
		frame.getContentPane().add(btn5);
		m_allButtons [1][1]=btn5;
		
		JButton btn6 = new JButton("");
		btn6.setBounds(305, 112, 132, 64);
		frame.getContentPane().add(btn6);
		m_allButtons [1][2]=btn6;
		
		JButton btn7 = new JButton("");
		btn7.setBounds(10, 197, 132, 64);
		frame.getContentPane().add(btn7);
		m_allButtons [2][0]=btn7;
		
		JButton btn8 = new JButton("");
		btn8.setBounds(163, 197, 132, 64);
		frame.getContentPane().add(btn8);
		m_allButtons [2][1]=btn8;
		
		JButton btn9 = new JButton("");
		btn9.setBounds(305, 197, 132, 64);
		frame.getContentPane().add(btn9);
		m_allButtons [2][2]=btn9;
		AddAllEventHandlers();
	}
	
	private void ChangeButtonText(JButton button)
	{
		if (m_previousMove != null)
		{
			if (m_previousMove.equals(s_o))
			{
				button.setText(s_x);
				button.setEnabled(false);
				m_previousMove = s_x;
			}
			else if (m_previousMove.equals(s_x))
			{
				button.setText(s_o);
				button.setEnabled(false);
			    m_previousMove = s_o;
		}
		}
	else
	{
		button.setText(s_x);
		m_previousMove = s_x;
			}
		}
	private void DisableAllButtons()
	{
		if (m_allButtons != null)
		{
			for (int i=0; i < 3; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					m_allButtons[i][j].setEnabled(false);
				}
			}
		}
	}
		
	private void AddAllEventHandlers()
	{
		if (m_allButtons != null)
		{
			for (int i=0; i < 3; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					JButton button = m_allButtons[i][j];
					button.addActionListener(new ActionListener()
					{
					public void actionPerformed(ActionEvent arg0)
					{
						ChangeButtonText(button);
						button.setEnabled(false);
						CheckGameWinner();
					}
					
					});
				}
			}
		}
	}
	
private void CheckGameWinner()
{
	if (m_allButtons !=null)
	{
		for (int i = 0; i < 3; i++)
		{
			String one = m_allButtons[i][0].getText();
			String two = m_allButtons[i][1].getText();
			String three = m_allButtons[i][2].getText();
			
			boolean empty = one.isEmpty() || two.isEmpty() || three.isEmpty();
			
			if (! empty)
			{
				boolean same = (one == two) && (two == three);
				
				if (same)
				{
					m_allButtons[i][0].setBackground(Color.WHITE);
					m_allButtons[i][1].setBackground(Color.WHITE);
					m_allButtons[i][2].setBackground(Color.WHITE);
					DisableAllButtons();
				}
			}
		}
				
				for (int i = 0; i < 3; i++)
				{
					String one = m_allButtons[0][i].getText();
					String two = m_allButtons[1][i].getText();
					String three = m_allButtons[2][i].getText();
					
					boolean empty = one.isEmpty() || two.isEmpty() || three.isEmpty();
					
					if (! empty)
					{
						boolean same = (one == two) && (two == three);
						
						if (same)
						{
							m_allButtons[0][i].setBackground(Color.WHITE);
							m_allButtons[1][i].setBackground(Color.WHITE);
							m_allButtons[2][i].setBackground(Color.WHITE);
							DisableAllButtons();
						}
				}
				}
					String one = m_allButtons[0][0].getText();
					String two = m_allButtons[1][1].getText();
					String three = m_allButtons[2][2].getText();
					
					boolean diagonalOneEmpty = one.isEmpty() || two.isEmpty() || three.isEmpty();
					
					if (! diagonalOneEmpty)
					{
						boolean diagonalOnesame = (one == two) && (two == three);
						
						if (diagonalOnesame)
						{
							m_allButtons[0][0].setBackground(Color.WHITE);
							m_allButtons[1][1].setBackground(Color.WHITE);
							m_allButtons[2][2].setBackground(Color.WHITE);
							DisableAllButtons();
						}
						String four = m_allButtons[0][2].getText();
						String five = m_allButtons[1][1].getText();
						String six = m_allButtons[2][0].getText();
						
						boolean diagonalTwoEmpty = four.isEmpty() || five.isEmpty() || six.isEmpty();
						
						if (! diagonalTwoEmpty)
						{
							boolean diagonalTwoSame = (four == five) && (five == six);
							
							if (diagonalTwoSame)
							{
								m_allButtons[0][2].setBackground(Color.WHITE);
								m_allButtons[1][1].setBackground(Color.WHITE);
								m_allButtons[2][0].setBackground(Color.WHITE);
								DisableAllButtons();
							}
			}
		}
	}
}}