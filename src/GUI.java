import java.awt.*;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class GUI {
	private static final Color Color = null;
	private JPanel bottomPanel;
	private JLabel bottomLabel;
	private JTextField userMessageField;
	private JButton send;
	private JTextArea area;
	private Border textAreaBorder;

	
	Color ACCENT_COLOR = new Color(43,188,138);
	Font FONT = new Font("Iosevka Nerd Font", Font.PLAIN, 15);
	Color TEXT_COLOR = new Color(201,202,204);
	Color BACKGROUND_COLOR = new Color(29,31,33);

	//Method to reply
	private void replyWith(String recieve) 
	{
		area.append("Chatbot --> " + recieve + "\n");
	}
	
	//This method will find a singular keyword
	private boolean findKeyword(String goal, String message)
	{
		boolean found = false;
		goal=goal.toLowerCase();
		message = message.trim();
		String[] splitMessage = message.split(" ");
		for(int i= 0; i < splitMessage.length; i++)
		{
			if(splitMessage[i].equals(goal))
					{
						found = true;
					}
		}
		
		return found;
	}
	
	//This method will find an entire keyPhrase
	private boolean findKeyPhrase(String goal, String message)
	{
		boolean found = false;
		message = message.trim();
		goal = goal.toLowerCase();
		if(message.equals(goal));
		{
			found = true;
		}		
		return found;
	}
	
	public GUI()
	{
		JFrame frame = new JFrame("Chatbot");
		
		//This is the frame
		frame.setSize(500, 650);
		frame.setResizable(false);
		
		//Text Area
		area = new JTextArea();
		area.setLineWrap(true);
		area.setEditable(false);
		
		//Setting Color and Border of Text Area
		area.setBackground(BACKGROUND_COLOR);
		textAreaBorder = BorderFactory.createLineBorder(BACKGROUND_COLOR, 10);
		area.setBorder(textAreaBorder);
		
		//Font and Font Color
		area.setForeground(TEXT_COLOR);
		area.setFont(FONT);
		
		//Panel at Bottom
		bottomPanel = new JPanel();
		bottomLabel = new JLabel("Enter Message: ");
		bottomLabel.setForeground(ACCENT_COLOR);
		bottomPanel.setBackground(BACKGROUND_COLOR);
		
		//User Message Field
		userMessageField = new JTextField(20);
		userMessageField.setBackground(TEXT_COLOR);
		
		send = new JButton("Send");
		send.setBackground(BACKGROUND_COLOR);
		send.setForeground(ACCENT_COLOR);
		
		//SEND BUTTON ACTION LISTENER
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource() == send )
				{
					String message = userMessageField.getText();
					area.append("You --> " + message + "\n");
					message = message.toLowerCase();
					userMessageField.setText("");
					
					//This is where all responses are using reply with method
					//Pet Statements
					if(findKeyword("cat", message))
					{
						replyWith("What is your pet's name?");
					}
					else if(findKeyword("dog", message))
					{
						replyWith("What is your pet's name?");
					}

					//User loves them

					//Tell me a joke
					else if(findKeyPhrase("Tell me a joke", message))
					{
						replyWith("Q: Why couldn't the pony sing a lullaby?");
						replyWith("A: she was a little horse!");
					}
					
					else if(findKeyPhrase("How is your day?", message))
					{
						replyWith("Very good and yours?");
					}
					
					
				}
			}
		});
		
		
		//Add above to the Frame
		bottomPanel.add(bottomLabel);
		bottomPanel.add(userMessageField);
		bottomPanel.add(send);
		frame.getContentPane().add(BorderLayout.SOUTH, bottomPanel);
		frame.getContentPane().add(BorderLayout.CENTER, area);
		frame.setVisible(true);
	}
}
