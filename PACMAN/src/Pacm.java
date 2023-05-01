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
	//PAREDES CONTORNO
	public element pacman = new element(pacx, pacy, 30, 30,Color.YELLOW);
	public element pared = new element(20, 20, 190, 10,Color.decode("#3339FF"));
	public element pared1 = new element(30, 20, 10, 430,Color.decode("#3339FF"));
	public element pared2 = new element(30, 400, 10, 430,Color.CYAN);
	public element pared3 = new element(30, 200, 10, 80,Color.decode("#3339FF"));
	public element pared4 = new element(30, 260, 10, 80,Color.decode("#3339FF"));
	public element pared5 = new element(20, 260, 150, 10,Color.decode("#3339FF"));
	public element pared6 = new element(450, 20, 190, 10,Color.decode("#3339FF"));
	public element pared7 = new element(380, 200, 10, 80,Color.decode("#3339FF"));
	public element pared8 = new element(450, 260, 140, 10,Color.decode("#3339FF"));
	public element pared9 = new element(380, 250, 10, 80,Color.decode("#3339FF"));
	
	//PAREDES DENTRO
	public element pared10 = new element(90, 330, 10, 300,Color.decode("#3339FF"));
	public element pared11 = new element(90, 130, 10, 120,Color.decode("#3339FF"));
	public element pared12 = new element(90, 80, 10, 120,Color.decode("#3339FF"));
	public element pared13 = new element(80, 80, 60, 10,Color.decode("#3339FF"));
	public element pared14 = new element(210, 80, 60, 10,Color.decode("#3339FF"));
	public element pared15 = new element(270, 130, 10, 120,Color.decode("#3339FF"));
	public element pared16 = new element(270, 80, 10, 120,Color.decode("#3339FF"));
	public element pared17 = new element(260, 80, 60, 10,Color.decode("#3339FF"));
	public element pared18 = new element(380, 80, 60, 10,Color.decode("#3339FF"));
	
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
				 
				 if(pacman.chocar(pared1)) {
		            	System.out.println("hola");
		            	
		            		if(e.getKeyCode()==87) {
					pacman.y += speed;
				}
		            	
		            		
		            		if(e.getKeyCode()==65) {
					pacman.x += speed;
				}	
		            		
		            	
		            }
				 
				 if(pacman.chocar(pared2)) {
		            	System.out.println("hola");
		            	
		            		if(e.getKeyCode()==83) {
					pacman.y -= speed;
				}
		            	
		            		
		            		if(e.getKeyCode()==68) {
					pacman.x -= speed;
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
	            
	            //PARED3
	            g.setColor(pared3.c);
	            g.fillRect(pared3.x, pared3.y, pared3.w, pared3.h);
	            
	            //PARED4
	            g.setColor(pared4.c);
	            g.fillRect(pared4.x, pared4.y, pared4.w, pared4.h);
	            
	            //PARED5
	            g.setColor(pared5.c);
	            g.fillRect(pared5.x, pared5.y, pared5.w, pared5.h);
	            
	            //PARED6
	            g.setColor(pared6.c);
	            g.fillRect(pared6.x, pared6.y, pared6.w, pared6.h);
	            
	            //PARED7
	            g.setColor(pared7.c);
	            g.fillRect(pared7.x, pared7.y, pared7.w, pared7.h);
	            
	            //PARED8
	            g.setColor(pared8.c);
	            g.fillRect(pared8.x, pared8.y, pared8.w, pared8.h);
	            
	            //PARED9
	            g.setColor(pared9.c);
	            g.fillRect(pared9.x, pared9.y, pared9.w, pared9.h);
	            
	            //PARED10
	            g.setColor(pared10.c);
	            g.fillRect(pared10.x, pared10.y, pared10.w, pared10.h);
	            
	            //PARED11
	            g.setColor(pared11.c);
	            g.fillRect(pared11.x, pared11.y, pared11.w, pared11.h);
	            
	            //PARED12
	            g.setColor(pared12.c);
	            g.fillRect(pared12.x, pared12.y, pared12.w, pared12.h);
	            
	            //PARED13
	            g.setColor(pared13.c);
	            g.fillRect(pared13.x, pared13.y, pared13.w, pared13.h);
	            
	            //PARED14
	            g.setColor(pared14.c);
	            g.fillRect(pared14.x, pared14.y, pared14.w, pared14.h);
	            
	            //PARED15
	            g.setColor(pared15.c);
	            g.fillRect(pared15.x, pared15.y, pared15.w, pared15.h);
	            
	            //PARED16
	            g.setColor(pared16.c);
	            g.fillRect(pared16.x, pared16.y, pared16.w, pared16.h);
	            
	            //PARED17
	            g.setColor(pared17.c);
	            g.fillRect(pared17.x, pared17.y, pared17.w, pared17.h);
	            
	            //PARED18
	            g.setColor(pared18.c);
	            g.fillRect(pared18.x, pared18.y, pared18.w, pared18.h);
	            
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
	public boolean chocar1(element e) {
	 			
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
