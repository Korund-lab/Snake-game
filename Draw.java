package gui;

import game.Snake;
import game.PickUp;

import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel
{   
    Point p;
    
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);
        
        //Draw Background
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0,0,Gui.width,Gui.height);
        
        //Draw Sanke Tails
        g.setColor(Color.GREEN);
        for(int i = 0; i< Snake.tails.size(); i++)
        {
            p = Snake.ptc(Snake.tails.get(i).getX(),Snake.tails.get(i).getY());
            g.fillRect(p.x,p.y, 32,32);
        }
        
        //Draw Sanke Head
        g.setColor(new Color(0,155,0));
        p = Snake.ptc(Snake.head.getX(),Snake.head.getY());
        g.fillRect(p.x,p.y, 32,32);
        
        //Draw PickUp
        g.setColor(Color.RED);
        p = Snake.ptc(Snake.pickup.getX(), Snake.pickup.getY());
        g.fillRect(p.x,p.y, 32,32);
        
        //Draw Grid
        g.setColor(Color.GRAY);     
        for(int i = 0; i<16; i++)
        {
            for(int j = 0; j<16; j++)
            {
                g.drawRect(i * 32 + Gui.xoff, j * 32 + Gui.yoff, 32,32);
            }
            
        }
        
        //Draw Border
        g.setColor(Color.BLACK);
        g.drawRect(Gui.xoff,Gui.yoff,512,512);
        
        //Draw Score
        g.setColor(Color.BLUE);
        g.setFont(new Font("Arial", Font.BOLD, 22));
        g.drawString("Score: " + Snake.score, 5, 25);
        g.drawString("Best: " + Snake.bestscore, 655, 25);
        
        repaint();
    }
}
