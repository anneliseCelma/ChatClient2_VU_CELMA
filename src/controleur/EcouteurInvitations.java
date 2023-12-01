package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;

import com.chat.client.ClientChat;
import vue.PanneauInvitations;
import java.util.List;


public class EcouteurInvitations implements ActionListener{
	
	 private ClientChat clientChat;
//	 private JFrame fenetre;
	 private PanneauInvitations panneauInvitations;
	

	 public EcouteurInvitations(ClientChat clientChat,PanneauInvitations panneauInvitations) {
	      this.clientChat = clientChat;
//	      this.fenetre = fenetre;
//	      this.panneauInvitations.setEcouteur(this);
	      this.panneauInvitations=panneauInvitations;
	 }

	 @Override
	    public void actionPerformed(ActionEvent e) {
	        List<String> invitationsSelectionnees = panneauInvitations.getElementsSelectionnes();

	        if (e.getActionCommand().equals("ACCEPTER")) {
	  
	            for (String invitation : invitationsSelectionnees) {
	                clientChat.envoyer("JOIN " + invitation);
	            }
	        } else if (e.getActionCommand().equals("REFUSER")) {
	            for (String invitation : invitationsSelectionnees) {
	                clientChat.envoyer("DECLINE " + invitation);
	            }
	        }

	        for (String invitation : invitationsSelectionnees) {
	            panneauInvitations.retirerInvitationRecue(invitation);
	        }
	    }
	
	    

	    public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
