

package com.example.myplannerify.database_classes ;




public class Organisateur {

	private int id_organisateur = 0;
	private String nom_organisateur;
	private String email_organisateur;
	private String passwd_organisateur;
	private int contact_organisateur;
	private String ville_organisateur;
	private String description_organisateur;
	private String adresse_organisateur;
	private int likes = 0;
	private byte[] image_organisateur;

	//Les colonnes de la table ORGANISATEUR
	private static final String TABLE_NAME = "ORGANISATEUR";
	private static final String COL_ID = "ID";
	private static final String COL_NOM = "NOM" ;
	private static final String COL_EMAIL = "EMAIL";
	private static final String COL_PASSWD = "PASSWD";
	private static final String COL_CONTACT = "CONTACT" ;
	private static final String COL_VILLE = "VILLE" ;
	private static final String COL_DESC = "DESCRIPTION" ;
	private static final String COL_ADRESSE = "ADRESSE" ;
	private static final String COL_IMAGE = "IMAGE" ;
	private static final String COL_LIKES =  "LIKES" ;

	public Organisateur(){  }

	public Organisateur(String nom, String email, String passwd, int contact, String ville, String description, String adresse, byte[] image , int likes) {
		this.nom_organisateur = nom;
		this.email_organisateur = email;
		this.passwd_organisateur = passwd;
		this.contact_organisateur = contact;
		this.ville_organisateur = ville;
		this.description_organisateur = description;
		this.adresse_organisateur = adresse;
		this.image_organisateur = image;
		this.likes = likes ;
	}

	public  int getId_organisateur() {
		return this.id_organisateur;
	}

	public String getNom_organisateur() {
		return nom_organisateur;
	}

	public String getEmail_organisateur() {
		return email_organisateur;
	}

	public String getPasswd_organisateur() {
		return passwd_organisateur;
	}

	public int getContact_organisateur() {
		return contact_organisateur;
	}

	public String getVille_organisateur() {
		return ville_organisateur;
	}

	public String getDescription_organisateur() {
		return description_organisateur;
	}

	public String getAdresse_organisateur() {
		return adresse_organisateur;
	}

	public byte[] getImage_organisateur() {
		return image_organisateur;
	}

	public int getLikes() {
		return likes;
	}

	public void setId_organisateur(int id_organisateur) {
		this.id_organisateur = id_organisateur;
	}

	public void setNom_organisateur(String nom_organisateur) {
		this.nom_organisateur = nom_organisateur;
	}

	public void setEmail_organisateur(String email_organisateur) {
		this.email_organisateur = email_organisateur;
	}

	public void setPasswd_organisateur(String passwd_organisateur) {
		this.passwd_organisateur = passwd_organisateur;
	}

	public void setContact_organisateur(int contact_organisateur) {
		this.contact_organisateur = contact_organisateur;
	}

	public void setVille_organisateur(String ville_organisateur) {
		this.ville_organisateur = ville_organisateur;
	}

	public void setDescription_organisateur(String description_organisateur) {
		this.description_organisateur = description_organisateur;
	}

	public void setAdresse_organisateur(String adresse_organisateur) {
		this.adresse_organisateur = adresse_organisateur;
	}

	public void setImage_organisateur(byte[] image_organisateur) {
		this.image_organisateur = image_organisateur;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public static String getTableName() {
		return TABLE_NAME;
	}

	public static String getColId() {
		return COL_ID;
	}

	public static String getColNom() {
		return COL_NOM;
	}

	public static String getColDesc() {
		return COL_DESC;
	}

	public static String getColEmail() {
		return COL_EMAIL;
	}

	public static String getColPasswd() {
		return COL_PASSWD;
	}

	public static String getColContact() {
		return COL_CONTACT;
	}

	public static String getColVille() {
		return COL_VILLE;
	}

	public static String getColAdresse() {
		return COL_ADRESSE;
	}

	public static String getColImage() {
		return COL_IMAGE;
	}

	public static String getColLikes(){
		return COL_LIKES;
	}
}
