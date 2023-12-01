package controleur;

import com.chat.client.ClientChat;
import com.chat.client.GestionnaireEvenementClient2;
import vue.PanneauChat;
import vue.PanneauChatPrive;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class EcouteurChatPrive extends EcouteurChatPublic {
    private String alias;
    private PanneauChatPrive panneauChatPrive; 
    public EcouteurChatPrive(String alias, ClientChat clientChat, PanneauChat panneauChat,PanneauChatPrive panneauChatPrive) {
        super(clientChat, panneauChat);
        this.alias = alias;
        this.panneauChatPrive = panneauChatPrive; 
    }
    //à compléter (redéfinir la méthode actionPerformed())
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() instanceof JTextField) {
            JTextField champDeSaisie = (JTextField) evt.getSource();
            String message = champDeSaisie.getText().trim();

           
                // Vérifier le texte saisi pour des commandes spécifiques
                if (message.equalsIgnoreCase("QUIT")) {
                    // Commande pour quitter le salon privé
                    clientChat.envoyer("QUIT " + alias);
                } else if (message.equalsIgnoreCase("ABANDON")) {
                    // Commande pour abandonner la partie d'échecs
                    clientChat.envoyer("ABANDON ");
                } else  {
                    // Tout autre texte est envoyé comme message privé
                    clientChat.envoyer(message);
                     panneauChat.ajouter("MOI>> " + message);
                }

                

              
                champDeSaisie.setText("");
            
        } else if (evt.getActionCommand().equals("INVITER_ECHEC")) {
      
        } else if (evt.getActionCommand().equals("ACCEPTER")) {
           
            panneauChatPrive.invitationEchecRecue();
            clientChat.envoyer("CHESS " + alias);
        } else if (evt.getActionCommand().equals("REFUSER")) {
           
        	panneauChatPrive.invitationEchecAnnulee();
            clientChat.envoyer("DECLINE " + alias);
        }
    }
    
    
    
}