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
public class PanneauChatPrive extends PanneauChat {
    private JButton bAccepterOuInviter, bRefuser;
    private FenetreEchecs fenetreEchecs;
    public PanneauChatPrive() {
    	super();
        bAccepterOuInviter = new JButton("Inviter échec");
        bRefuser = new JButton("Refuser");

        bAccepterOuInviter.setActionCommand("ACCEPTER");
        bRefuser.setActionCommand("REFUSER");

        //à compléter
        
        JPanel pNord = new JPanel();
        pNord.add(bAccepterOuInviter);
        pNord.add(bRefuser);
        bRefuser.setVisible(false);
        
//        this.setLayout(new BorderLayout());
        this.add(pNord, BorderLayout.NORTH);
    }
    @Override
    public void setEcouteur(ActionListener ecouteur) {
        super.setEcouteur(ecouteur);
        bAccepterOuInviter.addActionListener(ecouteur);
        bRefuser.addActionListener(ecouteur);
    }
    public void invitationEchecRecue() {
        //à compléter
    	 bAccepterOuInviter.setText("ACCEPTER");
    	bRefuser.setVisible(true);
    }
    public void invitationEchecAnnulee() {
        //à compléter
    	bAccepterOuInviter.setText("Inviter échec");
    	bRefuser.setVisible(false);
//    	
    }

    public void setFenetreEchecs(FenetreEchecs fenetreEchecs) {
        if (this.fenetreEchecs!=null){
            this.fenetreEchecs.setVisible(false);
            this.fenetreEchecs.dispose();
        }
        this.fenetreEchecs = fenetreEchecs;
    }
    public FenetreEchecs getFenetreEchecs() {
        return this.fenetreEchecs;
    }
}