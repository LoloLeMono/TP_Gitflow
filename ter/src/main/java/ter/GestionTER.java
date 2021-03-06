package ter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

//import com.fasterxml.jackson.core.JsonGenerationException;
//import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GestionTER
{
	public ArrayList<Groupe> groupes;
	public ArrayList<Sujet> sujets;
	public HashMap<Groupe, Sujet> assos;
	
	public int nbVoeux;
	private boolean find;
	private int hDebut;
	
	public GestionTER()
	{
	  this.groupes = new ArrayList<Groupe>();
	  this.sujets = new ArrayList<Sujet>();
	  this.assos = new HashMap<Groupe, Sujet>();
	}
	
	public void addGroupe(String nom)
	{
	  this.groupes.add(new Groupe(nom));
	}
	
	public void addSujet(String titre)
	{
	  this.sujets.add(new Sujet(titre));
	}
	
	public ArrayList<Sujet> getSujets()
	{
	  return this.sujets;
	}
	
	public int getNbGroupe()
	{
	  return this.groupes.size();
	}
	
	public Groupe getGroupe(int id)
	{
	  if(id >= 0 && id < this.getNbGroupe())
	  {
	    return this.groupes.get(id);
	  }
	  return new Groupe("n'existe pas");
	}

	
	
	
	public Boolean addSujetGroupe(Groupe grp, HashMap<Integer, Sujet> voeux, int passe)
	{
		find = false;
		
		voeux.forEach((k,s) ->
		{
			if (!assos.containsValue(s) && !find)
			{
				assos.put(grp, s); //On rajoute le Groupe/Sujet au dico assos
				//sujets.remove(s);
				//groupes.remove(grp);
				find = true;
			}
		});
		
		if (sujets.size() == 0)
		{
			find = true;
		}
		
		if (passe == 2 && find == false)
		{
			assos.put(grp, sujets.get(1));
			//sujets.remove(sujets.get(1));
			//groupes.remove(grp);
			find = true;
		}
		
		return find;
	}
	
	
	
	public void rafraichirSujets()
	{
		ArrayList<Sujet> sujets2 = new ArrayList<Sujet>();
		
		for (int i=0; i<this.sujets.size(); i++)
		{
			
			if (!assos.containsValue(sujets.get(i)))
			{
				sujets2.add(sujets.get(i));
			}
		}
		
		if (sujets2.isEmpty())
		{
			System.out.println("Plus de sujets restant");
		}
		
		this.sujets = sujets2;
		
		
		/*
		this.sujets.forEach((s) ->
		{
			if (assos.containsValue(s))
			{
				this.sujets.remove(s);
			}
		});
		*/
	}
	
	public void rafraichirGroupe()
	{
		ArrayList<Groupe> groupes2 = new ArrayList<Groupe>();
		
		for (int i=0; i<this.groupes.size(); i++)
		{
			
			if (!assos.containsKey(groupes.get(i)))
			{
				groupes2.add(groupes.get(i));
			}
		}
		
		if (groupes2.isEmpty())
		{
			System.out.println("Plus de groupes restant");
		}
		
		this.groupes = groupes2;
	}

	public Sujet showSujet(Groupe grp)
	{
		return assos.get(grp);
	}
}
