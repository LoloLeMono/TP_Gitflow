package ter;

import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Groupe {
  public int id;
  public static int idPartage;
  public String nomRef;
  public HashMap<Integer, Sujet> voeux;
  
  public ArrayList<Integer> horaire;

  public Groupe() {}

  public Groupe(int id, int idPartage, String nom, HashMap<Integer, Sujet> voeux, boolean voeuFini)
  {
    this.id = id;
    Groupe.idPartage = idPartage;
    this.nomRef = nom;
    this.voeux = voeux;
  }

  public Groupe(String nom)
  {
    this.id = idPartage;
    idPartage ++;
    this.nomRef = nom;
    this.voeux = new HashMap<Integer, Sujet>();
  }
  
  public void setNom(String nom)
  {
    this.nomRef = nom;
  }
  
  public String getNom()
  {
    return this.nomRef;
  }
  
  public int getId() {
    return this.id;
  }

  
  public void setVoeux(HashMap<Integer, Sujet> hash)
  {
    this.voeux = hash;
  }

  public boolean isSujetInVoeu(Sujet suj)
  {
    boolean inIt = false;
    for(Integer key : this.voeux.keySet())
    {
      if(this.voeux.get(key) == suj)
      {
        inIt = true;
      }
    }
    return inIt;
  }
  
  
  public void addVoeu(int ordre, Sujet suj)
  {
    this.voeux.put(ordre, suj);
  }

  
  
  public void remplirVoeuxAleatoire(GestionTER ges)
  {  	
	int index;
	
	for (int pos=0; pos<ges.nbVoeux; pos++)
	{
		if(ges.sujets.size() == 0)
		{
			break;
		}
		
		do
		{
			index = (int)(Math.random() * ges.sujets.size()); //nb aleatoire de pour metre le sujet dans la liste de voeux

		} while (this.isSujetInVoeu(ges.getSujets().get(index)) && ges.sujets.size() != 0);
		
		  // Tant que c'est pas le mm et qu'il reste des sujets
		
		this.addVoeu(pos, ges.getSujets().get(index));
	}
	
	System.out.println(this);
  }
  

}
