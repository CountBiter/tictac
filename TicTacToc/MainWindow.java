import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainWindow extends JFrame implements ActionListener{

    private JLabel labelChoix;
    private final JButton btnWithFriend;
    private final JButton btnWithPc;
    private JRadioButton choixWithPc[] = new JRadioButton[3];
    private boolean showHidePcPlay = false;
    private final Font FontForLabel = new Font("Comic Sans MS", Font.PLAIN, 16);
    private static int i = 0;
    
    MainWindow() {
        
        btnWithFriend = new JButton("Играть с друзьями");
        btnWithFriend.setBounds(20, 100, 250, 50);
        btnWithFriend.setFont(FontForLabel);
        btnWithFriend.addActionListener(event -> {
            new PlayWindow(0);
            this.setVisible(false);
        });
        this.add(btnWithFriend);
        
        btnWithPc = new JButton("Играть с компьютером");
        btnWithPc.setBounds(20, 160, 250, 50);
        btnWithPc.setFont(FontForLabel);
        btnWithPc.addActionListener(event -> {
        	showHidePcPlay = (showHidePcPlay)? false : true;
        	for(i = 0; i < 3; i++)
        		choixWithPc[i].setVisible(showHidePcPlay);
        	
            this.setSize(310, (showHidePcPlay)?450:270);
        });
        this.add(btnWithPc);

        labelChoix = new JLabel(PlayWindow.setColor("Выбирите уровень сложности :", "green"));
        labelChoix.setBounds(30, 220, 250, 50);
        labelChoix.setVisible(false);
        this.add(labelChoix);
        
        choixWithPc[0] = new JRadioButton("Легко");
        choixWithPc[1] = new JRadioButton("Среднее");
        choixWithPc[2] = new JRadioButton("Сложно");
        
        for(int i = 0; i < 3; i++) {
        	choixWithPc[i].setBounds(40, 260 + 30 * i, 150, 30);
        	choixWithPc[i].setVisible(false);
        	choixWithPc[i].addActionListener(this);
	        this.add(choixWithPc[i]);
        }

        
        setTitle("Крестики нолики игра");
        setBounds(400, 170, 310, 270);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 3; i++)
			if(e.getSource() == choixWithPc[i]) {
                new PlayWindow(i+1);
                this.setVisible(false);
			}
	}
	
	public static void main(String[] args) {
        new MainWindow();
    }
}