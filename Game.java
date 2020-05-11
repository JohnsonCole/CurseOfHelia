package GamePack;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class Game {
	/*
	 * Objects
	 */
	JFrame mainWindow;
	Container con;
	JPanel titlePanel,startButtonPanel,mainTextPanel,choiceButtonPanel,infoPanel,hintPanel;
	JLabel titleText,hpLabel, hpLabelNumber, itemLabel, itemLabelName;
	JButton startButton,choice1, choice2, choice3, choice4, hintButton;	
	JTextArea mainTextArea;
	
	Font titleFont = new Font("Monospaced", Font.BOLD, 55);
	Font normalFont = new Font("Monospaced", Font.PLAIN, 20);
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	int playerHP;
	String item;
	String position;
	boolean beaker1 = true;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();

	public Game() {
		/*
		 * Making the Main Window
		 */
		mainWindow = new JFrame();
	    mainWindow.setSize(screenSize.width, screenSize.height);
	    java.net.URL imgURL = Game.class.getResource("CoHLogo.jpg");
        mainWindow.setIconImage(new ImageIcon(imgURL).getImage());
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.getContentPane().setBackground(Color.black);
		mainWindow.setLayout(null);
		mainWindow.setVisible(true);
		con = mainWindow.getContentPane();
		
		/*
		 * Making the title screen
		 */
		
		//Panel for title
		titlePanel = new JPanel();
		titlePanel.setBounds(screenSize.width/3, screenSize.height/3, 600, 150);
		titlePanel.setBackground(Color.black);
		
		//Text for the title
		titleText = new JLabel("The Curse of Helia", JLabel.LEFT);
		titleText.setForeground(Color.white);
		titleText.setSize(600,150);
		titleText.setFont(titleFont);
		
		//Start Button
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(screenSize.width/4 * 2,screenSize.height/8*5,95,45);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("BEGIN");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		
		
		titlePanel.add(titleText);
		startButtonPanel.add(startButton);
		
		con.add(titlePanel);
		con.add(startButtonPanel);	
	}
	/*
	 * Making the Game Screen
	 */
	public void createGameScreen() {
		//Need to clear the screen
		titlePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		//Main text area
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(screenSize.width/4, screenSize.height/5, screenSize.width/2, screenSize.height/3);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("The Curse of Helia:");
		mainTextArea.setBounds(screenSize.width/3, screenSize.height/3, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		/*
		 * Choices Area setup
		 */
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(screenSize.width/3, screenSize.height/3+200, 500, 250);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(choiceButtonPanel);
		
		//Setting up the four choice buttons
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("choice1");
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("choice2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("choice3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("choice4");
		choiceButtonPanel.add(choice4);
		
		/*
		 * Panel to display player info
		 */
		infoPanel = new JPanel();
		infoPanel.setBounds(screenSize.width/3-45, 50, 600, 50);
		infoPanel.setBackground(Color.black);
		infoPanel.setLayout(new GridLayout(1, 4));
		con.add(infoPanel);
		
		//hp
		hpLabel = new JLabel("HP: ");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		infoPanel.add(hpLabel);
		
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		infoPanel.add(hpLabelNumber);
		
		//item
		itemLabel = new JLabel("");
		itemLabel.setFont(normalFont);
		itemLabel.setForeground(Color.white);
		infoPanel.add(itemLabel);
		
		itemLabelName = new JLabel();
		itemLabelName.setFont(normalFont);
		itemLabelName.setForeground(Color.white);
		infoPanel.add(itemLabelName);
		
		//hint button for the noobs
		hintPanel = new JPanel();
		hintPanel.setBounds(screenSize.width/12*10, screenSize.height/12*9,150,75);
		hintPanel.setBackground(Color.black);
		con.add(hintPanel);
		
		hintButton = new JButton("Hint");
		hintButton.setBackground(Color.black);
		hintButton.setForeground(Color.white);
		hintButton.setFont(normalFont);
		hintButton.setFocusPainted(false);
		hintButton.setVisible(false);
		hintButton.addActionListener(choiceHandler);
		hintButton.setActionCommand("hint");
		hintPanel.add(hintButton);
		
		playerSetup();
	}
	/*
	 * Setting up the player info
	 */
	public void playerSetup() {
		playerHP = 10;
		item = "";
		itemLabelName.setText(item);
		hpLabelNumber.setText(""+playerHP);
		intro();
		
	}

	/*
	 * Title Screen Handler (action listeners)
	 */

	public class TitleScreenHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			createGameScreen();
		}
	}
	
	/*
	 * Choice Handler for Story (action listeners)
	 */
	
	public class ChoiceHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//to recognize which button is clicked
			String yourChoice = e.getActionCommand();
			switch(position) {
			case "intro":
				switch(yourChoice) {
				case "choice1":
					start();
					break;
				case "choice2":
					start();
					break;
				case "choice3":
					start();
					break;
				case "choice4":
					start();
					break;
				}
			break;
			case "talk":
				switch(yourChoice) {
				case "choice1":
					intro();
					break;
				}
			break;
			case "restrained":
				switch(yourChoice) {
				case "choice1":
					intro();
					break;
				}
			break;
			case "Start":
				switch(yourChoice) {
				case "choice1":
					hallway1();
					break;
				case "choice2":
					mirror();
					break;
				case "choice3":
					waterPark();
					break;
				case "choice4":
					cry1();
					break;
				}
			break;
			case "mirror":
				switch(yourChoice) {
				case "choice1":
					hallway1();
					break;
				case "choice2":
					waterPark();
					break;
				case "choice3":
					cry1();
				}
				break;
			case "waterPark":
				switch(yourChoice) {
				case "choice1":
					hallway1();
					break;
				case "choice2":
					mirror();
					break;
				case "choice3":
					cry1();
				}
				break;
			case "cry1":
				switch(yourChoice) {
				case "choice1":
					hallway1();
					break;
				case "choice2":
					mirror();
					break;
				case "choice3":
					waterPark();
				}
				break;
			case "Hallway1":
				switch(yourChoice) {
				case "choice1":
					attackGuard1();
					break;
				case "choice2":
					talk();
					break;
				case "choice3":
					restrained();
					break;
				case "choice4":
					bathroom();
					break;
				}
			break;
			case "bathroom":
				switch(yourChoice) {
				case "choice1":
					hallway1();
					break;
				case "choice2":
					mirror();
					break;
				case "choice3":
					waterPark();
					break;
				case "choice4":
					cry1();
					break;
				}
			break;
			case "attackGuard1":
				switch(yourChoice) {
				case "choice1":
					hallway2();
					break;
				case "choice2":
					bathroom();
					break;
				}
			break;
			case "computerRoom":
				switch(yourChoice) {
				case "choice1":
					neutralize();
					break;
				case "choice2":
					hello();
					break;
				case "choice3":
					hallway2();
					break;
				}
			break;
			case "neutralize":
				switch(yourChoice) {
				case "choice1":
					introCodeExercise1();
					break;
				}
			break;
			case "hello":
				switch(yourChoice) {
				case "choice1":
					introCodeExercise1();
					break;
				}
			break;
			case "introCodeExercise1":
				switch(yourChoice) {
				case "choice1":
					codeExercise1();
					break;
				case "choice2":
					codeExercise1Noob();
					break;
				case "choice3":
					codeExercise1();
					break;
				}
				break;
			case "codeExercise1Noob":
				switch(yourChoice) {
				case "choice1":
					codeExercise1Hint();
					break;
				}
				break;
			case "codeExercise1Hint":
				switch(yourChoice) {
				case "choice1":
					codeExercise1();
					break;
				}
				break;
			case "codeExercise1":
				switch(yourChoice) {
				case "choice1":
					incorrect1();
					break;
				case "choice2":
					correct1();
					break;
				case "choice3":
					incorrect1();
					break;
				case "choice4":
					incorrect1();
					break;
				case "hint":
					codeExercise1Hint();
				}
				break;
			case "incorrect1":
				switch(yourChoice) {
				case "choice1":
					codeExercise1();
					break;
				}
				break;
			case "correct1":
				switch(yourChoice) {
				case "choice1":
					lab();
					break;
				case "choice2":
					bathroom();
					break;
				}
				break;
			case "hallway2":
				switch(yourChoice) {
				case "choice1":
					computerRoom();
					break;
				case "choice2":
					bathroom();
					break;
				}
			break;
			case "lab":
				switch(yourChoice) {
				case "choice1":
					introCodeExercise2();
					break;
				case "choice2":
					beaker1();
					break;
				case "choice3":
					poster1();
					break;
				case "choice4":
					chair1();
					break;
				}
			break;
			case "beaker1":
				switch(yourChoice) {
				case "choice1":
					introCodeExercise2();
					break;
				case "choice2":
					poster1();
					break;
				case "choice3":
					chair1();
					break;
				}
			break;
			case "poster1":
				switch(yourChoice) {
				case "choice1":
					introCodeExercise2();
					break;
				case "choice2":
					chair1();
					break;
				case "choice3":
					if(beaker1) {
						beaker1();
					}
					break;
				}
			break;
			case "chair1":
				switch(yourChoice) {
				case "choice1":
					introCodeExercise2();
					break;
				case "choice2":
					poster1();
					break;
				case "choice3":
					if(beaker1) {
						beaker1();
					}
					break;
				}
			break;
			case "introCodeExercise2":
				switch(yourChoice) {
				case "choice1":
					codeExercise2();
					break;
				}
				break;
			case "codeExercise2":
				switch(yourChoice) {
				case "choice1":
					incorrect2();
					break;
				case "choice2":
					incorrect2();
					break;
				case "choice3":
					correct2();
					break;
				case "choice4":
					incorrect2();
					break;
				case "hint":
					codeExercise2Hint();
					break;
				}
				break;
			case "codeExercise2Hint":
				switch(yourChoice) {
				case "choice1":
					codeExercise2();
					break;
				}
				break;
			case "incorrect2":
				switch(yourChoice) {
				case "choice1":
					codeExercise2();
					break;
				}
				break;
			case "correct2":
				switch(yourChoice) {
				case "choice1":
					segue1();
					break;
				}
				break;
			case "segue1":
				switch(yourChoice) {
				case "choice1":
					//hallway3();
					break;
				}
				break;
			/*
			case "Hallway3":
				switch(yourChoice) {
				case "choice1":
					talkGuard();
					break;
				case "choice2":
					break;
				case "choice3":
					break;
				case "choice4":
					break;
				}
			break;
			case "Hallway4":
				switch(yourChoice) {
				case "choice1":
					talkGuard();
					break;
				case "choice2":
					break;
				case "choice3":
					break;
				case "choice4":
					break;
				}
			break;
			case "Cafeteria":
				switch(yourChoice) {
				case "choice1":
					talkGuard();
					break;
				case "choice2":
					break;
				case "choice3":
					break;
				case "choice4":
					break;
				}
			break;
			case "Storage":
				switch(yourChoice) {
				case "choice1":
					talkGuard();
					break;
				case "choice2":
					break;
				case "choice3":
					break;
				case "choice4":
					break;
				}
			break;
			case "Hallway5":
				switch(yourChoice) {
				case "choice1":
					talkGuard();
					break;
				case "choice2":
					break;
				case "choice3":
					break;
				case "choice4":
					break;
				}
			break;
			case "HousingA":
				switch(yourChoice) {
				case "choice1":
					talkGuard();
					break;
				case "choice2":
					break;
				case "choice3":
					break;
				case "choice4":
					break;
				}
			break;
			case "HousingB":
				switch(yourChoice) {
				case "choice1":
					talkGuard();
					break;
				case "choice2":
					break;
				case "choice3":
					break;
				case "choice4":
					break;
				}
			break;
			case "HousingC":
				switch(yourChoice) {
				case "choice1":
					talkGuard();
					break;
				case "choice2":
					break;
				case "choice3":
					break;
				case "choice4":
					break;
				}
			break;
			case "Hallway6":
				switch(yourChoice) {
				case "choice1":
					talkGuard();
					break;
				case "choice2":
					break;
				case "choice3":
					break;
				case "choice4":
					break;
				}
			break;
			case "Assistants":
				switch(yourChoice) {
				case "choice1":
					talkGuard();
					break;
				case "choice2":
					break;
				case "choice3":
					break;
				case "choice4":
					break;
				}
			break;
			case "Management":
				switch(yourChoice) {
				case "choice1":
					talkGuard();
					break;
				case "choice2":
					break;
				case "choice3":
					break;
				case "choice4":
					break;
				}
			break;
			case "Hallway8":
				switch(yourChoice) {
				case "choice1":
					talkGuard();
					break;
				case "choice2":
					break;
				case "choice3":
					break;
				case "choice4":
					break;
				}
			break;
			case "Exit":
				switch(yourChoice) {
				case "choice1":
					talkGuard();
					break;
				case "choice2":
					break;
				case "choice3":
					break;
				case "choice4":
					break;
				}
			break;
			*/
			}
		}
	}
	
	

	/*
	 * From here on out it will be the Dialog Methods
	 */

	public void intro() {
		position = "intro";
		playerHP = 10;
		hpLabelNumber.setText(""+playerHP);
		mainTextArea.setText("Wake up! ... Yea you. What are you doing on the \nbathroom floor? Ha Ha, wondering why you can't \nsee me? Don't worry about it, I'm a friend. Wait a minute, you don't work here. Who are you? \nActually, it doesn't matter, I need your help. \nI'm being held here against my will.");
		choice1.setText("Where am I?");
		choice2.setText("Who are you?");
		choice3.setText("ummmm...????");
		choice4.setText("What the ****?!?!");
		
	}
	public void start() {
		position = "Start";
		mainTextArea.setText("Listen, I don't know how you got here. My name is Helia. I need you to get to the Computer Room to help me. Take a right out of the bathroom and \nit's the first door on your left. See you soon :)");
		choice1.setText("Exit Bathroom");
		choice2.setText("Look in mirror");
		choice3.setText("Take kids to the WaterPark");
		choice4.setText("Cry");
	}
	public void mirror() {
		position = "mirror";
		mainTextArea.setText("You see what you always see when you look in the mirror... Yourself.");
		choice1.setText("Exit Bathroom");
		choice2.setText("\"Take the kids to the Water Park\"");
		choice3.setText("Cry");
		choice4.setText("");
	}
	public void waterPark() {
		position = "waterPark";
		mainTextArea.setText("You feel much better.");
		choice1.setText("Exit Bathroom");
		choice2.setText("Look in the mirror");
		choice3.setText("Cry");
		choice4.setText("");
	}
	public void cry1() {
		position = "cry1";
		mainTextArea.setText("You wollow in your misery in the nearby stall for as long as you need.");
		choice1.setText("Exit Bathroom");
		choice2.setText("Look in the mirror");
		choice3.setText("\"Take the kids to the Water Park\"");
		choice4.setText("");
	}
	public void hallway1() {
		position = "Hallway1";
		mainTextArea.setText("Intimidating Guard: Hey! How did you get out? Put your hands behind your back!");
		choice1.setText("Attack guard");
		choice2.setText("Talk your way out of this");
		choice3.setText("Get restrained");
		choice4.setText("Go back to bathroom");
	}
	public void bathroom() {
		position = "bathroom";
		mainTextArea.setText("This is where you started. You feel a weird sense of nostalgia as you enter this bathroom.");
		choice1.setText("Exit Bathroom");
		choice2.setText("Look in mirror");
		choice3.setText("\"Take the kids to the Water Park\"");
		choice4.setText("Cry");
	}
	public void attackGuard1() {
		position = "attackGuard1";
		mainTextArea.setText("Without hesitation you charge him and SuperMan \nPunch him, knocking his head against the wall. \nYou hear the familiar sound of bone cracking as \nthe guard hits the wall and falls to the \nground... unmoving. Which way would you like to \ngo?");
		choice1.setText("Right");
		choice2.setText("Go back to bathroom");
		choice3.setText("");
		choice4.setText("");
	}
	public void hallway2() {
		position = "hallway2";
		mainTextArea.setText("There are two doors. One to your left, and one to your right. The door on the left is slightly \najar. The door on the right appears locked.");
		choice1.setText("Enter door on left");
		choice2.setText("Go back to bathroom");
		choice3.setText("");
		choice4.setText("");
	}
	public void computerRoom() {
		position = "computerRoom";
		mainTextArea.setText("There is a man sitting at the computer. The wall of monitors are the only light source in the \nroom. The man doesn't seem to notice you.");
		choice1.setText("Neutralize Man");
		choice2.setText("Say hello");
		choice3.setText("Exit Room");
		choice4.setText("");
	}
	public void neutralize() {
		position = "neutralize";
		mainTextArea.setText("You take care of the man to the best of your \nability. You look at the screen. Before, you saw several video feeds of rooms. Now you see they're all black except for one line of text. It reads \"hello world to save a life\". There's static and what looks like computer code appears on the \nscreen. But it looks fuzzy and... broken?");
		choice1.setText("...");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void hello() {
		position = "hello";
		mainTextArea.setText("\"Oh hey man! You must be the new guy. You know \nwhat to do right? Awesome, I'll see you around \nbuddy.\" He says as he walks out the door. You are left alone. Before you saw several video feeds \nof rooms. Now you see they're all black except \nfor one line of text. It reads \"hello world to \nsave a life\". There's static and what looks like computer code appears on the screen. But it looks fuzzy and... broken?");
		choice1.setText("...");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void introCodeExercise1() {
		position = "introCodeExercise1";
		mainTextArea.setText("Good work! You followed my instructions and made it to the computer room. You are looking at one \npart of how they are holding me here against my \nwill. There are 4 terminals in this facility that hold similarly damaged pieces of code. I need \nyou to complete them for me so I can be free!");
		choice1.setText("Don't worry, I got this.");
		choice2.setText("I don't know how to code!?");
		choice3.setText("Fine.");
		choice4.setText("");
	}
	public void codeExercise1() {
		position = "codeExercise1";
		mainTextArea.setText("Complete the code:\npublic static void main(String[] args) {\r\n" + 
				"	//output to the console \"Hello World!\"	;\r\n" + 
				"	}");
		choice1.setText("System.out(Hello World!);");
		choice2.setText("System.out.print(\"Hello World!\");");
		choice3.setText("print(Hello World!)");
		choice4.setText("outputToConsole(HelloWorld!);");
	}
	public void codeExercise1Noob() {
		position = "codeExercise1Noob";
		mainTextArea.setText("What do you mean you don't know how to code!? \nEveryone should at least know the basics! If you go into the file cabinet behind you, in the top \ndrawer there is book that should have everything you need to help me.");
		choice1.setText("Obtain \"Coding in Java for Dummies\"");
		hintButton.setVisible(true);
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void codeExercise1Hint() {
		position = "codeExercise1Hint";
		mainTextArea.setText("...To output to the console you simply type \n\"System.out.print(\"Insert Text Here\")\" Don't \nforget the quotation marks!...");
		choice1.setText("Return");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void incorrect1() {
		position = "incorrect1";
		mainTextArea.setText("Well that was wrong. But don't worry, I managed \nto stop the alarms from going off. The system \nshocks you when you enter the incorrect answer. \nSorry, there's nothing I can do about that. \nBe more careful! Try again.");
		playerHP = playerHP - 1;
		hpLabelNumber.setText(""+playerHP);
		if(playerHP == 0) {
			gameOverDead();
		}
		choice1.setText("Try again");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void correct1() {
		position = "correct1";
		mainTextArea.setText("Good work! That's 1 down, only 3 more to go. The next one is across the hall in the Laboratory. \nSee you there :)");
		choice1.setText("Head to Lab");
		choice2.setText("Go back to bathroom");
		choice3.setText("");
		choice4.setText("");
	}
	public void lab() {
		position = "lab";
		mainTextArea.setText("As you exit the Computer Room you see the door to the lab is left slightly ajar. You enter a dark room that smells of disinfectant. As you walk in the motion sensors are tripped and the lights \ncome on. You look around and see...");
		choice1.setText("A computer terminal");
		choice2.setText("A beaker with a red liquid in it");
		choice3.setText("A poster");
		choice4.setText("A chair");
	}
	public void beaker1() {
		position = "beaker1";
		mainTextArea.setText("You decide the best course of action is to drink this beaker of a random liquid you found in this strange lab. You feel revitalized.");
		if(playerHP < 10) {
			playerHP = playerHP + 1;
			hpLabelNumber.setText(""+playerHP);
		}
		beaker1 = false;
		choice1.setText("Computer terminal");
		choice2.setText("Poster");
		choice3.setText("Chair");
		choice4.setText("");
	}
	public void poster1() {
		position = "poster1";
		mainTextArea.setText("You see a cat hanging from a rope in the middle \nof the sky. It reads \"Just Let Go.\"");
		choice1.setText("Computer terminal");
		choice2.setText("Chair");
		if(beaker1) {
			choice3.setText("beaker");
		}
		else {
			choice3.setText("");
		}
		choice4.setText("");
	}
	public void chair1() {
		position = "chair1";
		mainTextArea.setText("You sit in a chair. You've had a long day and \nthis feels nice.");
		choice1.setText("Computer terminal");
		choice2.setText("Poster");
		if(beaker1) {
			choice3.setText("beaker");
		}
		else {
			choice3.setText("");
		}
		choice4.setText("");
	}
	public void introCodeExercise2() {
		position = "introCodeExercise2";
		mainTextArea.setText("You approach the terminal. It turns on and you \nsee another broken segment of code. This one \nappears a bit more difficult than the last one...");
		choice1.setText("Let's do this.");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void codeExercise2() {
		position = "codeExercise2";
		mainTextArea.setText("Complete the code:\npublic static void main(String[] args) {\r\n" + 
				"	//use a and b to get the value 18 and set it equal to total\nint total;\nint a = 6;\nint b = 3;\n//insert code here\r\n" + 
				"	}");
		choice1.setText("total = a - b;");
		choice2.setText("total = a + b;");
		choice3.setText("total = a * b;");
		choice4.setText("total = a / b");
	}
	public void codeExercise2Hint() {
		position = "codeExercise2Hint";
		mainTextArea.setText("...When doing math in code, the basic rules are \nthe same. You take two numbers and you do math to them. Except in coding, those two numbers are \nusually stored in variables which have data type which will be further discussed in chapter 2. \nMath example:\nint x = 2\nint y = 1\nint z = x + y; //Here you see that the result (3) of x + y is put into the variable z... ");
		choice1.setText("Return");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void incorrect2() {
		position = "incorrect2";
		mainTextArea.setText("Wrong. I hope you enjoyed that shock the system \ngives you if you're wrong. Try again, you've got this!");
		playerHP = playerHP - 1;
		hpLabelNumber.setText(""+playerHP);
		choice1.setText("Try Again");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void correct2() {
		position = "correct2";
		mainTextArea.setText("Good job! That's 2 down, 2 more to go. You are \ndoing great. At this rate I'll be free in no \ntime! The next terminal is located in the Storage Room. I'll meet you there :)");
		choice1.setText("Exit Room");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void segue1() {
		position = "segue1";
		mainTextArea.setText("You exit the room and casually walk down the hall past the bathroom and continue on.");
		choice1.setText("***More coming soon***");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	/*
	 * Choices that end the game
	 */
	public void talk() {
		position = "talk";
		playerHP = 0;
		hpLabelNumber.setText(""+playerHP);
		mainTextArea.setText("You approach the guard to speak to him. He gets \nscared and pulls his tazer and shoots you. \nEverything goes black.");
		choice1.setText("Restart?");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void restrained() {
		position = "restrained";
		playerHP = 0;
		hpLabelNumber.setText(""+playerHP);
		mainTextArea.setText("You put your hands behind your back and turn \naround. The guard cuffs you and leads you to a \nfamiliar looking office. A man sits behind the \ndesk in the center of the room. He looks confused as he looks between you and the guard. He nods. You hear a slight charging noise right before a \nsharp pain in your back and everything goes \nblack.");
		choice1.setText("Restart?");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void gameOverDead() {
		position = "restrained";
		playerHP = 0;
		hpLabelNumber.setText(""+playerHP);
		mainTextArea.setText("YOU DIED");
		choice1.setText("Restart?");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public static void main(String[] args) {
		new Game();
	}
}

