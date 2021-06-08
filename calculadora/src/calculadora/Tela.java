package calculadora;


import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Tela extends JPanel{
	//<instanciando onde os numeros devem aparecer>
	JLabel txt[] = new JLabel[3];
	//</instanciando onde os numeros devem aparecer>
	
	public Tela(){//construtor da Classe para visualizacao
		setLayout(new FlowLayout());
		//<instanciando componentes de view>
		for(int n=0;n<3;n++) {
			txt[n] = new JLabel("");
			add(txt[n]);
		}
		//</instanciando componentes de view>
	}
}
