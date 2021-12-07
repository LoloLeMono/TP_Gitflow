package ter;

import java.io.IOException;
import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;
import java.util.HashMap;

public class App 
{
    public static void main( String[] args ) throws IOException, cantAddVoeu
    {
    	
    	GestionTER ges = new GestionTER();
    	Groupe grp = new Groupe();
        
        //ajouter groupes + sujets
    	ges.addGroupe("groupe 1");
    	ges.addGroupe("groupe 2");
    	ges.addGroupe("groupe 3");
    	ges.addGroupe("groupe 4");
    	ges.addGroupe("groupe 5");
    	/*
    	ges.addGroupe("groupe 6");
    	ges.addGroupe("groupe 7");
    	ges.addGroupe("groupe 8");
    	ges.addGroupe("groupe 9");
    	ges.addGroupe("groupe 10");
    	ges.addGroupe("groupe 11");
    	ges.addGroupe("groupe 12");
    	*/
    	

    	ges.addSujet("sujet A");
    	ges.addSujet("sujet B");
        ges.addSujet("sujet C");
        ges.addSujet("sujet D");
        ges.addSujet("sujet E");
        ges.addSujet("sujet F");
        /*
        ges.addSujet("sujet G");
        ges.addSujet("sujet H");
        ges.addSujet("sujet I");
        ges.addSujet("sujet J");
        ges.addSujet("sujet K");
        ges.addSujet("sujet L");
        ges.addSujet("sujet M");
        ges.addSujet("sujet N");
        ges.addSujet("sujet O");
        ges.addSujet("sujet P");
        */
        
        ges.nbVoeux = 2;
        
        int index;
        boolean boule;
        
        // remplir les liste de voeux de chaques groupes
        
        for (int i=1; i<ges.getNbGroupe()+1; i++)
        {
        	
        	grp = ges.getGroupe(i-1);
        	
        	grp.remplirVoeuxAleatoire(ges);
        	
        	
        	// Chaques groupe envoi sa liste pour la première fois
            
        	
        	ges.addSujetGroupe(grp, grp.voeux, 1);
        	
        	//System.out.println("Assos");
        	System.out.println("Sujet retenu : "+ges.showSujet(grp));
        	//System.out.println(app.assos);
        	System.out.println("====================");
        	
        }
        
        // Enlever les sujets et les groupes retenus        
        ges.rafraichirSujets();
        ges.rafraichirGroupe();
        
        System.out.println("====================");
        System.out.println("====================");
        System.out.println("DEUXIEME PASSE");
        System.out.println("====================");
        System.out.println("====================");
        // System.out.println(ges.sujets);
        
        
        
        // Deuxieme envoi pour les groupes n'ayant pas eu de sujet
        
        for (int i=1; i<ges.getNbGroupe()+1; i++)
        {
       
        	grp = ges.getGroupe(i-1);
        	grp.remplirVoeuxAleatoire(ges);
        	
        	// Chaques groupe envoi sa liste pour la première fois
            
        	boule = false;
        	
        	do
        	{
        		boule = ges.addSujetGroupe(grp, grp.voeux, 2);
        	} while (!boule);
        	
        	//System.out.println("Assos");
        	System.out.println("Sujet retenu : "+ges.showSujet(grp));
        	//System.out.println(app.assos);
        	System.out.println("====================");
        	
        }
        
        
    }
}
