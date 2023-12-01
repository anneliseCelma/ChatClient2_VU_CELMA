package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class PanneauChat extends JPanel {
    protected JTextArea zoneChat;
    protected JTextField champDeSaisie;

    public PanneauChat() {
        //à compléter.
    	
    	setLayout(new BorderLayout());
    	zoneChat= new JTextArea();
    	zoneChat.setEditable(false);
    	JScrollPane scrollPane = new JScrollPane(zoneChat);
    	champDeSaisie = new JTextField();
    	
    	add(scrollPane, BorderLayout.CENTER);
    	add(champDeSaisie, BorderLayout.SOUTH);
    }

    public void ajouter(String msg) {
        zoneChat.append("\n"+msg);
    }
    public void setEcouteur(ActionListener ecouteur) {
        //Enregistrer l'écouteur auprès du champ de saisie
    	champDeSaisie.addActionListener(ecouteur);
    }

    public void vider() {
        this.zoneChat.setText("");
    }
}