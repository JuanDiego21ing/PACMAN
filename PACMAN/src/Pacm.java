import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class Pacm {

	private JFrame frame;
	public int pacx=220,pacy=190;
	public int speed=10;
	public element pacman = new element(pacx, pacy, 30, 30,Color.YELLOW);
	public element pared = new element(20, 20, 190, 10,Color.decode("#3339FF"));
	public element pared1 = new element(30, 20, 10, 400,Color.decode("#3339FF"));
	public element pared2 = new element(30, 400, 10, 400,Color.decode("#3339FF"));
	JPanel tablero = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pacm window = new Pacm();
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
	public Pacm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 612, 500);
		frame.setTitle("PAC-MAN");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getKeyCode());
				
				if(e.getKeyCode()==87) {
					pacman.y-=speed;
				}
				if(e.getKeyCode()==83) {
					pacman.y+=speed;
				}
				if(e.getKeyCode()==65) {
	               pacman.x-=speed;
				}
				if(e.getKeyCode()==68) {
					pacman.x+=speed;
				}
				 if(pacman.chocar(pared)) {
		            	System.out.println("hola");
		            	
		            		if(e.getKeyCode()==87) {
					pacman.y += speed;
				}
		            	
		            		
		            		if(e.getKeyCode()==65) {
					pacman.x += speed;
				}	
		            		
		            	
		            }
				
				
				tablero.repaint();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		frame.setFocusable(true);
		frame.requestFocus();
			
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Reiniciar");
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
		panel.add(btnNewButton);
		
		
		tablero.setBackground(new Color(0, 64, 128));
		tablero.setForeground(new Color(0, 0, 0));
		frame.getContentPane().add(tablero, BorderLayout.CENTER);
		tablero.add(new MyGraphics());
	}
	 public class MyGraphics extends JComponent {

	        private static final long serialVersionUID = 1L;

	        MyGraphics() {
	            setPreferredSize(new Dimension(480,420));
	        }

	        @Override
	        public void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.fillRect(0, 0, 480, 420);
	            
	            //PAC-MAN
	            g.setColor(pacman.c);
	            g.fillArc(pacman.x, pacman.y, pacman.w, pacman.h, 0, 360);
	            
	            //PAREDES
	            g.setColor(pared.c);
	            g.fillRect(pared.x, pared.y, pared.w, pared.h);
	            
	            //PARED1
	            g.setColor(pared1.c);
	            g.fillRect(pared1.x, pared1.y, pared1.w, pared1.h);
	            
	            //PARED2
	            g.setColor(pared2.c);
	            g.fillRect(pared2.x, pared2.y, pared2.w, pared2.h);
	            
	            if(pacman.chocar(pared)) {
	            	System.out.println("hola");
	            }
	        }
	    }
	 
	 		public class element{
	 			int x, y, h, w;
	 			Color c;
	 			
	 		element(int x,int y, int h, int w, Color c){
	 			
	 			this.x = x;
	 			this.y = y;
	 			this.h = h;
	 			this.w = w;
	 			this.c = c;
	 			
	 			
	 		}
	 		
	 		public boolean chocar(element e) {
	 			
	 			
	 			
	 			if(this.x < e.x + e.w &&
	 			   this.x + this.w > e.x &&
	 			   
	 			  this.y < e.y + e.h &&
	 			  this.y + this.h > + e.y) {
	 				return true;
	 			}else {
	 		
	 		return false;
	 			}
	 	}

	 }
}
