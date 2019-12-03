import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Ball extends JPanel{
        // Initialize ball position
        int x = 0;
        int y = 0;
        int xd = 1;
        int yd = 1;
        int width = 300, height = 400;

        private void moveBall(){
            x = x+xd;
            if(x>width-60){
            xd = -1;
            }
            else if(x<=0){
                xd = +1;
            }
            
            y = y+yd;
            if(y>height-60){
            yd = -1;
            }

            else if(y<=0){
                yd = +1;
            } 
        }
    @Override
    public void paint(Graphics g){
        // this clears the screen before reprinting circle at a new position 
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;

        //Antialiasing makes the figure smoother 
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        //Draws the circle at new position with the same diameter
        g2d.fillOval(x, y, 60,60);
    }

    public static void main(String[] args) throws InterruptedException{
        //Name of the window
        JFrame frame = new JFrame("Mini Tennis");
        Ball game = new Ball();
        frame.add(game);
        frame.setSize(game.width,game.height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while(true){
            game.moveBall();
            game.repaint();
            //tells the processor that the thread which is being 
            // run must sleep for 10 miliseconds . Bigger the number the slower
            // the game mov
            
            Thread.sleep(10);
        }
    }
}