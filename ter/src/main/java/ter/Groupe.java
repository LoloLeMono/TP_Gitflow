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
  
  
  
  
  /*
  public boolean addVoeu(int ordre, Sujet suj) throws cantAddVoeu
  {
    if(ordre > 0 && ordre < 6)
    {
      if(!this.isSujetInVoeu(suj))
      {
        if(!this.voeux.keySet().contains(ordre))
        {
          this.voeux.put(ordre, suj);
        } else {
        	throw new cantAddVoeu("L'ordre a déjà été rempli");
        }
      } else {
    	  throw new cantAddVoeu("Le sujet a déjà été choisi");
      }
    } else {
    	throw new cantAddVoeu("L'ordre du voeu doit être entre 1 et 5");
    }
    
    boolean complet = true;
    
    for(int i=1; i<6; i++)
    {
      if(this.voeux.get(i) == null)
      {
        complet = false;
      }
    }
    if(complet)
    {
      this.voeuFini = true;
    }
    return true;
  }
 */


  public String toString()
  {
    String str = this.nomRef + " (id:" + this.id + ")\n"; 
    for(Integer key : this.voeux.keySet()) {
      str += "--" + key + ": " + this.voeux.get(key).toString() + "\n";
    }
    return str;
  }

}

/*
 private HashMap<String, NoticeBiblio> catalogue;

  public Catalogue() {
    catalogue = new HashMap<String, NoticeBiblio>();**/
