package controleur;

import com.chat.client.ClientChat;
import com.chat.commun.net.Connexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurJeuEchecs implements ActionListener {

	private String posClic;
    private ClientChat clientChat;
    

    public EcouteurJeuEchecs(ClientChat clientChat) {
        this.clientChat = clientChat;
        this.posClic = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //à compléter
    	
    	String positionActuelle = e.getActionCommand();

        if (posClic == null) {
        	posClic = positionActuelle;
        } else {
            String deplacement = posClic + "-" + positionActuelle;
            clientChat.envoyer("MOVE " + deplacement.toLowerCase());
            
            posClic = null; // reset la positio initiale pour la prochaine
        }

    }
}