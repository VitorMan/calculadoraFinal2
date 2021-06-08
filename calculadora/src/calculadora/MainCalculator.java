package calculadora;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCalculator extends JFrame{
	/**
	 * versão 1.0 final
	 */
	private static final long serialVersionUID = 1L;
	
	public float resolution(String n1, String n2, String oper) {
		float esq = Float.parseFloat(n1);
		float dir = Float.parseFloat(n2);
		float resultado;
		switch(oper) {
			case "+":
				resultado = esq + dir;
				break;
			case"-":
				resultado = esq - dir;
				break;
			case "x":
				resultado = esq * dir;
				break;
			default:
				resultado = esq / dir;
				break;
		}
		return resultado;
	}
	public MainCalculator() {
		
		// <setando o JFrame>
		super.setSize(270,210);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setLayout(new FlowLayout(FlowLayout.CENTER));
		super.setLocationRelativeTo(null);
		//</setando o JFrame>
		 
		//<instanciando e adicionando componentes ao JFrame>
		Tela view = new Tela();
		Teclas show = new Teclas();
		//
		super.add(view);//tela onde aparecem os numeros digitados
		super.add(show);//teclas virtuais da interface do usuario
		//</adicionando componentes ao JFrame>
		
		//<adicionando listeners que usam as duas classes>
		for(int n=0;n<16;n++) {
			int N = n;
			//<listener das teclas virtuais>
			show.teclas[n].addMouseListener(new MouseAdapter(){
				@Override
				public void mousePressed(MouseEvent me) {
					
						if( N==7 || N==11 || N==14 || N==15){//filtrando teclas das operacoes
							if(view.txt[0].getText().isEmpty() == false) {
								view.txt[1].setText(show.teclas[N].getText());
							}else {
								me.consume();
							}
						}else if(N==3){//filtrando a tecla de backspace
							if(view.txt[2].getText().equals("") && view.txt[1].getText().equals("") && !view.txt[0].getText().equals("")) {
								view.txt[0].setText(view.txt[0].getText().substring(0, view.txt[0].getText().length()-1));
							}else if(!view.txt[2].getText().equals("")) {
								view.txt[2].setText(view.txt[2].getText().substring(0, view.txt[2].getText().length()-1));
							}else if(view.txt[2].getText().equals("")&&!view.txt[1].getText().equals("")) {
								view.txt[1].setText("");
							}
						}else if(N==13) {//filtrando a tecla de resolucao
							float res = resolution(view.txt[0].getText(), view.txt[2].getText(), view.txt[1].getText());
							if(res%2==0) {
								view.txt[2].setText(Float.toString((int)res));
							}else {
								view.txt[2].setText(Float.toString((int)res));
							}
							for(int n =0; n<2;n++) {
								view.txt[n].setText("");
							}
						}else if(view.txt[1].getText().equals("")){//listener das teclas numericas basicas
							view.txt[0].setText(view.txt[0].getText()+show.teclas[N].getText());
						}else {
							view.txt[2].setText(view.txt[2].getText()+show.teclas[N].getText());
						}
				}
			});
		}
		//</listener das teclas virtuais>
		view.setPreferredSize(new Dimension(280, show.teclas[0].getPreferredSize().height*2));//setando um tamanho para a vizualizacao dos numeros
		addKeyListener(new KeyAdapter() {

			//<configurando o teclado para apenas numeros e operacoes>
			public void keyTyped(KeyEvent ke) {
				String numeros = "1234567890";
				String Operandos = "x+-/";
				if(numeros.contains(ke.getKeyChar()+"")) {
					if(view.txt[1].getText().equals("")) {
						view.txt[0].setText(view.txt[0].getText()+ke.getKeyChar());
					}else {
						view.txt[2].setText(view.txt[2].getText()+ke.getKeyChar());
					}
				}
				if(Operandos.contains(ke.getKeyChar()+"")) {
					if("/".contains(ke.getKeyChar()+"")){
						view.txt[1].setText("÷");
					}else {
						view.txt[1].setText(ke.getKeyChar()+"");
					}
				}else {
					ke.consume();
				}
			}
		});
		//</configurando o teclado para apenas numeros e operacoes>
		
		super.setVisible(true);//tornando o Frame visivel
	}
	public static void main(String args[]) {
		new MainCalculator();//instanciando a classe MainCalculadora para inicia-la
	}
}
