package com.example.myplannerify.database_classes ;

public class Catalogue {

	private static int id_catalogue;
	private String nom_catalogue;
	private byte[] image_catalogue;
	private int id_organisateur;

	//Les colonnes e la table CATALOGUE
	private static final String TABLE_NAME = "CATALOGUE";
	private static final String COL_ID = "ID";
	private static final String COL_NOM = "NOM";
	private static final String COL_IMAGE = "IMAGE" ;
	private static final String COL_ID_ORG = "ID_ORGANISATEUR";

	public  Catalogue(){
		id_catalogue++;
	}

	public Catalogue(String nom, byte[] image, int id_organisateur){
		id_catalogue++;
		this.nom_catalogue = nom;
		this.image_catalogue = image;
		this.id_organisateur = id_organisateur;
	}

	public static int getId_catalogue() {
		return id_catalogue;
	}

	public String getNom_catalogue() {
		return nom_catalogue;
	}

	public byte[] getImage_catalogue() {
		return image_catalogue;
	}

	public int getId_organisateur() {
		return id_organisateur;
	}

	public static void setId_catalogue(int id_catalogue) {
		Catalogue.id_catalogue = id_catalogue;
	}

	public void setNom_catalogue(String nom_catalogue) {
		this.nom_catalogue = nom_catalogue;
	}

	public void setImage_catalogue(byte[] image_catalogue) {
		this.image_catalogue = image_catalogue;
	}

	public void setId_organisateur(int id_organisateur) {
		this.id_organisateur = id_organisateur;
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

	public static String getColImage() {
		return COL_IMAGE;
	}

	public static String getColIdOrg() {
		return COL_ID_ORG;
	}
}
