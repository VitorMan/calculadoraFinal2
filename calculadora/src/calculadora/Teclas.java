package calculadora;

import javax.swing.JPanel;

import java.awt.GridLayout;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Teclas extends JPanel{
	
	JButton[] teclas = new JButton[16];//criando array de botoes
	
	public Teclas() {
		setLayout(new GridLayout(4,4));// Setando o layout manager
		
		String Simbols[] = {"1","2","3","back","4","5","6","/","7","8","9","+","0","=","x","-"};//array de ID das teclas
		//<instanciando teclas virtuais>
		for(int i = 0;i<16;i++) {
			if(i==7) {
				teclas[i] = new JButton("÷");
			}else {
			teclas[i] = new JButton(Simbols[i]);
			}
			add(teclas[i]);
			teclas[i].setFocusable(false);
		}
		//</instanciando teclas virtuais>
	}
}