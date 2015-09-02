package fr.demos.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class PartenaireCommercial {
	@Id
    private long idPartenaireCommercial;
    private String nom;
    private String adresse;
    private String email;
    private String mdp;
    private String telephone;
    private String telephoneFax;
    private String numeroSiret; 
    
	public long getIdPartenaireCommercial() {
		return idPartenaireCommercial;
	}
	public void setIdPartenaireCommercial(long idPartenaireCommercial) {
		this.idPartenaireCommercial = idPartenaireCommercial;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getTelephoneFax() {
		return telephoneFax;
	}
	public void setTelephoneFax(String telephoneFax) {
		this.telephoneFax = telephoneFax;
	}
	public String getNumeroSiret() {
		return numeroSiret;
	}
	public void setNumeroSiret(String numeroSiret) {
		this.numeroSiret = numeroSiret;
	}
	

    
    
}
