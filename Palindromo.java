package palindromo;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author eri
 */
public class Palindromo extends JFrame implements ActionListener {
    
    private JTextField caja;
    private JTextField caja2;
    private JTextField caja3;
    private JTextField caja4;
    private JTextField caja5;
    
    private JButton verificar;
    
    private JLabel palabra;
    private JLabel palindro;
    private JLabel longitud;
    private JLabel reves;
    private JLabel moda;
    
    public Palindromo(){
        super();
        configurarVentana();
        crearComponentes();
        
    }
    
    public void configurarVentana(){
        this.setTitle("PALINDROMOS");
        this.setSize(300, 450);
        this.getContentPane().setBackground(Color.cyan);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(true); //Maximizar o minimizar
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
    public void crearComponentes(){
        palabra = new JLabel();
        palabra.setText("Palabra");
        palabra.setBounds(10, 40, 80, 30); //x,y,ancho,alto
        palabra.setForeground(Color.black);
        this.add(palabra);
        
        caja = new JTextField();
        caja.setBounds(100, 40, 160, 30);
        this.add(caja);
        
        verificar = new JButton();
        verificar.setText("VERIFICAR");
        verificar.setBounds(45, 90, 100, 30);
        verificar.setVisible(true);
        verificar.setForeground(Color.black);
        verificar.addActionListener(this);
        this.add(verificar);
        
        palindro = new JLabel();
        palindro.setText("Palindromo");
        palindro.setBounds(10, 200, 100, 30);
        palindro.setForeground(Color.black);
        palindro.setVisible(false);
        this.add(palindro);
        
        caja2 = new JTextField();
        caja2.setBounds(120, 200, 110, 30);
        caja2.setEditable(false);
        caja2.setVisible(false);
        this.add(caja2);
        
        longitud = new JLabel();
        longitud.setText("Longitud");
        longitud.setBounds(10, 240, 100, 30);
        longitud.setForeground(Color.black);
        longitud.setVisible(false);
        this.add(longitud);
        
        caja3 = new JTextField();
        caja3.setBounds(120, 240, 110, 30);
        caja3.setEditable(false);
        caja3.setVisible(false);
        this.add(caja3);
        
        reves = new JLabel();
        reves.setText("Inversa");
        reves.setBounds(10, 280, 100, 30);
        reves.setForeground(Color.black);
        reves.setVisible(false);
        this.add(reves);
        
        caja4 = new JTextField();
        caja4.setBounds(120, 280, 110, 30);
        caja4.setEditable(false);
        caja4.setVisible(false);
        this.add(caja4);
        
        moda = new JLabel();
        moda.setText("Letra moda");
        moda.setBounds(10, 320, 100, 30);
        moda.setForeground(Color.black);
        moda.setVisible(false);
        this.add(moda);
        
        caja5 = new JTextField();
        caja5.setBounds(120, 320, 110, 30);
        caja5.setEditable(false);
        caja5.setVisible(false);
        this.add(caja5);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        palindro.setVisible(true);
        caja2.setVisible(true);
        longitud.setVisible(true);
        caja3.setVisible(true);
        reves.setVisible(true);
        caja4.setVisible(true);
        moda.setVisible(true);
        caja5.setVisible(true);
        
        String pal = caja.getText();
        String palSinEspacios = "";
        int i = 0;
        while(i<pal.length()){ //Para quitar los espacios
            if(pal.charAt(i) != ' '){
                palSinEspacios+=pal.charAt(i);
            }
            i++;
        }
        
        StringBuilder builder = new StringBuilder(palSinEspacios);
        String palReves = builder.reverse().toString();
        
        //Verificar si es palindromo
        if(palSinEspacios.equals(palReves)){
            caja2.setText("Sí");
        }else{
            caja2.setText("No");
        }
            
        caja3.setText(palSinEspacios.length() + " letras"); //Longitud
        caja4.setText(palReves); //Inversa
        
        int contador = 0;
        int moda = 0;
        char letra;
        char letraModa = ' ';
        for(int j = 0; j<palSinEspacios.length(); j++){
            letra = palSinEspacios.charAt(j);
            for(int p = 0; p < palSinEspacios.length(); p++){
                if (letra == palSinEspacios.charAt(p)){
                    contador++;
                }
            }
            if(contador > moda){
                moda = contador;
                letraModa = letra;
            }
            contador = 0;
        }
        
        caja5.setText(letraModa + " aparece " + moda + " veces");
        
    }
    
    public static void main(String[] args) {
        Palindromo palindro = new Palindromo();
        palindro.setVisible(true);
    }
    
}
