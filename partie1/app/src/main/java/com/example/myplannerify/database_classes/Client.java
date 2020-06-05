package com.example.myplannerify.database_classes;

public class Client {

	private static int id_client = 0;
	private String nom_client;
	private String prenom_client;
	private String email_client;
	private String passwd_client;
	private String ville_client;


	//les colonnes de la table CLIENT

	private static final String TABLE_NAME = "CLIENT";
	private static final String COL_ID = "ID";
	private static final String COL_NOM = "NOM" ;
	private static final String COL_PRENOM = "PRENOM" ;
	private static final String COL_EMAIL = "EMAIL";
	private static final String COL_PASSWD = "PASSWD";
	private static final String COL_VILLE = "VILLE";

	public Client(){
		id_client++;
	}


	public Client(String nom, String prenom, String email, String passwd, String ville){
		id_client++;
		this.nom_client = nom;
		this.prenom_client = prenom;
		this.email_client = email;
		this.passwd_client = passwd;
		this.ville_client = ville;
	}

	public static int getId_client() {
		return id_client;
	}

	public String getNom_client() {
		return nom_client;
	}

	public String getPrenom_client() {
		return prenom_client;
	}

	public String getEmail_client() {
		return email_client;
	}

	public String getPasswd_client() {
		return passwd_client;
	}

	public String getVille_client() {
		return ville_client;
	}

	public static void setId_client(int id_client) {
		Client.id_client = id_client;
	}

	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}

	public void setPrenom_client(String prenom_client) {
		this.prenom_client = prenom_client;
	}

	public void setEmail_client(String email_client) {
		this.email_client = email_client;
	}

	public void setPasswd_client(String passwd_client) {
		this.passwd_client = passwd_client;
	}

	public void setVille_client(String ville_client) {
		this.ville_client = ville_client;
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

	public static String getColPrenom() {
		return COL_PRENOM;
	}

	public static String getColEmail() {
		return COL_EMAIL;
	}

	public static String getColPasswd() {
		return COL_PASSWD;
	}

	public static String getColVille() {
		return COL_VILLE;
	}
}
