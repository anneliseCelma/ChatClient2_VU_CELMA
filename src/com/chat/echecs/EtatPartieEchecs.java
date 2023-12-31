package com.chat.echecs;


import observer.Observable;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-10-01
 */
public class EtatPartieEchecs extends Observable{
    private char[][] etatEchiquier = new char[8][8];
    public EtatPartieEchecs() {
        //Les pions :
        for (int j=0;j<8;j++) {
            etatEchiquier[1][j] = 'p';
            etatEchiquier[6][j] = 'P';
        }
        //Cases vide :
        for (int j=0;j<8;j++)
          for (int i=2;i<6;i++) {
            etatEchiquier[i][j] = ' ';
        }

        //Tours :
        etatEchiquier[0][0] = 't';
        etatEchiquier[0][7] = 't';
        etatEchiquier[7][0] = 'T';
        etatEchiquier[7][7] = 'T';

        //Cavaliers :
        etatEchiquier[0][1] = 'c';
        etatEchiquier[0][6] = 'c';
        etatEchiquier[7][1] = 'C';
        etatEchiquier[7][6] = 'C';

        //Fous :
        etatEchiquier[0][2] = 'f';
        etatEchiquier[0][5] = 'f';
        etatEchiquier[7][2] = 'F';
        etatEchiquier[7][5] = 'F';

        //Dames :
        etatEchiquier[0][3] = 'd';
        etatEchiquier[7][3] = 'D';

        //Rois :
        etatEchiquier[0][4] = 'r';
        etatEchiquier[7][4] = 'R';
    }
    public boolean move(String deplacement) {
        boolean res = false;
        //à compléter
        
        System.out.println(deplacement);
        if(deplacement != null) {
        	int p1l, p1c, p2l, p2c;
            char temp, init, finale;
        	
        	p1c = ((int) (deplacement.charAt(0)-'a'));
        	p1l = 8-Character.getNumericValue(deplacement.charAt(1));
        	p2c = ((int) (deplacement.charAt(3)-'a'));
        	p2l = 8-Character.getNumericValue(deplacement.charAt(4));
        	
        	System.out.println("Position: " + p1l+" "+p1c+" "+p2l+" "+p2c);
        	
        	
        	if(etatEchiquier[p1l][p1c] == 'p' || etatEchiquier[p1l][p1c] == 'P') {
        		if(p2l == 0) {
        			etatEchiquier[p2l][p2c] = 'D';
                	etatEchiquier[p1l][p1c] = ' ';
        		} else if(p2l == 7) {
        			etatEchiquier[p2l][p2c] = 'd';
        			etatEchiquier[p1l][p1c] = ' ';
        		} else {
        			etatEchiquier[p2l][p2c] = etatEchiquier[p1l][p1c];
                	etatEchiquier[p1l][p1c] = ' ';
        		}
            	
        	} else {
        	etatEchiquier[p2l][p2c] = etatEchiquier[p1l][p1c];
        	etatEchiquier[p1l][p1c] = ' ';
        	}
        	
        	
        	res = true;
        	notifierObservateurs();
        	return res;
        }
        
        return res;
    }

    @Override
    public String toString() {
        String s = "";
        for (byte i=0;i<8;i++) {
            s+=(byte)(8-i)+" ";
            for (int j=0;j<8;j++)
                s+=((etatEchiquier[i][j]==' ')?".":etatEchiquier[i][j])+" ";
            s+="\n";
        }
        s+="  ";
        for (char j='a';j<='h';j++)
            s+=j+" ";
        return s;
    }

    public char[][] getEtatEchiquier() {
        return etatEchiquier;
    }

    public void setEtatEchiquier(char[][] etatEchiquier) {
        this.etatEchiquier = etatEchiquier;
    }
}
