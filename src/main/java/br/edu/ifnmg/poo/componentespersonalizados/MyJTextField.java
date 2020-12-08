package br.edu.ifnmg.poo.componentespersonalizados;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 * Caixa de texto com mudança de cor de fundo diante de eventos de foco recebido
 * e foco perdido.
 *
 * @author Luis Guisso <luis dot guisso at ifnmg dot edu dot br>
 * @version 0.0.1, 07/12/2020
 */
public class MyJTextField extends JTextField {

    /**
     * Cor de fundo padrão.
     */
    private Color corPadrao;

    /**
     * Cor de fundo quando o componente ganha o foco.
     */
    private Color corFoco;

    //<editor-fold defaultstate="collapsed" desc="Construtores">
    public MyJTextField() {
        this(new Color(255, 255, 255), new Color(255, 255, 125));
    }

    public MyJTextField(Color corPadrao, Color corFoco) {
        this.corPadrao = corPadrao;
        this.setBackground(this.corPadrao);
        this.corFoco = corFoco;
        this.addFocusListener(new FocusHander());
    }

    //</editor-fold>
//    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Color getCorPadrao() {
        return corPadrao;
    }

    public void setCorPadrao(Color corPadrao) {
        this.corPadrao = corPadrao;
    }

    public Color getCorFoco() {
        return corFoco;
    }

    public void setCorFoco(Color corFoco) {
        this.corFoco = corFoco;
    }
    //</editor-fold>

    /**
     * Procedimento para alternância de cores de fundo.
     */
    private void alternarCor() {
        setBackground(
                getBackground().equals(corFoco)
                ? corPadrao
                : corFoco
        );
    }

    /**
     * Classe interna responsável pelo tratamento dos eventos de foco.
     */
    private class FocusHander implements FocusListener {

        /**
         * Ação para foco obtido.
         * 
         * @param e Evento de foco.
         */
        @Override
        public void focusGained(FocusEvent e) {
            alternarCor();
            MyJTextField.this.selectAll();
        }

        /**
         * Ação para foco perdido.
         * 
         * @param e Evento de foco.
         */
        @Override
        public void focusLost(FocusEvent e) {
            alternarCor();
        }

    }

}
