import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ModTicTacToe extends JFrame implements ActionListener{
    JLabel player_turn;
    JPanel j1,j2;
    int flag=0,num=1,pos,vpos,ch,cv,cd,test;
    JButton b[][] = new JButton[10][10];
    JLabel result;
    JButton reset;

    ModTicTacToe()
    {
        super("Tic-Tac-Toe");
        setSize(350,420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        j1 = new JPanel( new BorderLayout());
        player_turn = new JLabel("player 1");
        j1.add(player_turn,BorderLayout.SOUTH);
        
        j2 = new JPanel( new GridLayout(3,3,4,4));
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                b[i][j] = new JButton(num+"");
                b[i][j].setBackground(Color.WHITE);
                b[i][j].setPreferredSize(new Dimension(100,100));
                b[i][j].setFont(new Font("Aerial",Font.PLAIN,40));
                j2.add(b[i][j]);
                b[i][j].addActionListener(this);
                num++;

            }
        }
        reset = new JButton("RESET");
        result = new JLabel();
        j1.add(result);
        add(j1,BorderLayout.CENTER);
        add(j2);
        add(reset);
        reset.addActionListener(this);
        setVisible(true);
    }


public void actionPerformed(ActionEvent ae)
{
    String[] symbol = new String[1];
    if(flag%2==0)
    {  symbol[0] = "X";
        player_turn.setText("Turn: Player 2(O)");
    }
    else
    {   symbol[0] = "O";
        player_turn.setText("Turn: Player 1(X)");
    }

    if(ae.getActionCommand().equals("1"))
    {
        b[0][0].setText(symbol[0]);
        pos = 0; 
        vpos = 0;   
    }
    else if(ae.getActionCommand().equals("2"))
    {
        b[0][1].setText(symbol[0]);
        pos = 0;
        vpos = 1;      
    }
    else if(ae.getActionCommand().equals("3"))
    {
        b[0][2].setText(symbol[0]);
        pos = 0; 
        vpos = 2;      
    }
    else if(ae.getActionCommand().equals("4"))
    {
        b[1][0].setText(symbol[0]);  
        pos = 1; 
        vpos = 0;    
    }
    else if(ae.getActionCommand().equals("5"))
    {
        b[1][1].setText(symbol[0]);    
        pos = 1; 
        vpos = 1;   
    }
    else if(ae.getActionCommand().equals("6"))
    {
        b[1][2].setText(symbol[0]);  
        pos = 1; 
        vpos = 2;     
    }
    else if(ae.getActionCommand().equals("7"))
    {
        b[2][0].setText(symbol[0]);   
        pos = 2; 
        vpos = 0;
    }
    else if(ae.getActionCommand().equals("8"))
    {
        b[2][1].setText(symbol[0]);
        pos = 2;
        vpos = 1;
    }
    else if(ae.getActionCommand().equals("9"))
    {
        b[2][2].setText(symbol[0]);
        pos = 2;
        vpos = 2;
    }

    flag++;
    ch = check_horizontally(symbol[0],pos);
    cv = check_vertically(symbol[0], vpos);
    cd = check_diagonal(symbol[0]);
    test = ch+cv+cd;
    check_draw(test);

    if(ae.getActionCommand().equals("RESET"))
    {
        JOptionPane.showMessageDialog(ModTicTacToe.this, "reset");
        TTTreset();
    }
}

int check_horizontally(String ch, int position)
{
    int frequency = 0;
    for(int i=0;i<3;i++)
    {
        if(b[position][i].getActionCommand().equals(ch))
            frequency++;
    }

    if(frequency==3)
      {  Final_result();
        return 1;
      }
    else
        return 0;    //check_draw();
    
}
int check_diagonal(String ch)
{
    int frequency = 0;
    for(int i=0;i<3;i++)
    {
        if(b[i][i].getActionCommand().equals(ch))
            frequency++;
    }

    
    int freq = 0;
    for(int i=0;i<3;i++)
    {
        if(b[i][2-i].getActionCommand().equals(ch))
            freq++;
    }
    if(frequency==3 || freq==3)
    {  Final_result();
        return 1;
    }
    else
        return 0;
}

int check_vertically(String ch, int position)
{
    int frequency = 0;
    for(int i=0;i<3;i++)
    {
        if(b[i][position].getActionCommand().equals(ch))
            frequency++;
    }

    if(frequency==3)
    {   Final_result();
        return 1;
    }
    else
       return 0;

}

void check_draw(int test)
{
    if(flag==9)
    {
        if(test==0)
        {
            player_turn.setText(" ");
            result.setText("DRAW");
            JOptionPane.showMessageDialog(ModTicTacToe.this, "DRAW");
        }
    }
}

void Final_result()
{
    if(flag%2==0)
    {
        player_turn.setText(" ");
        //result.setText("PLAYER 2 WINS");
        JOptionPane.showMessageDialog(ModTicTacToe.this,"player 2 won");
    }
    else
    {
        player_turn.setText(" ");
        //result.setText("PLAYER 1 WINS");
        JOptionPane.showMessageDialog(ModTicTacToe.this, "Player 1 won");
    }
}

void TTTreset()
{
    flag=0;
    num=1;
    for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                b[i][j].setText(num+"");
                num++;

            }
        }

}

}

/*class ModTTTdemo{
    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable(){
            public void run()
            {
                new ModTicTacToe();
            }
        });
    }
}*/

class ModTTTdemo{
    public static void main(String args[]){
        /*ModTicTacToe ttt =*/ new ModTicTacToe();
    }
}