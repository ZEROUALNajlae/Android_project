
package com.example.myplannerify.database_classes ;


public class Menu {

	private static int id_menu;
	private String nom_menu;
	private String prix_menu;
	private String description_menu;
	private byte[] image_menu;
	private int id_organisateur;
	private String type;

	//Les colonnes de la table MENU
	private static final String TABLE_NAME = "MENU";
	private static final String COL_ID = "ID";
	private static final String COL_NOM = "NOM";
	private static final String COL_PRIX = "PRIX" ;
	private static final String COL_DESC = "DESCRIPTION";
	private static final String COL_IMG = "IMAGE";
	private static final String COL_ID_ORGANISATEUR = "ID_ORGANISATEUR";
	private static final String COL_TYPE = "TYPE";

	public  Menu(){
		id_menu++;
	}

	public Menu(String nom, String prix, String description, byte[] image, int id_organisateur , String type){
		id_menu++;
		this.nom_menu = nom;
		this.prix_menu = prix;
		this.description_menu = description;
		this.image_menu = image;
		this.id_organisateur = id_organisateur;
		this.type = type ;
	}

	public static int getId_menu() {
		return id_menu;
	}

	public String getNom_menu() {
		return nom_menu;
	}

	public String getPrix_menu() {
		return prix_menu;
	}

	public String getDescription_menu() {
		return description_menu;
	}

	public byte[] getImage_menu() {
		return image_menu;
	}

	public int getId_organisateur() {
		return id_organisateur;
	}

	public String getType() {
		return type;
	}

	public static void setId_menu(int id_menu) {
		Menu.id_menu = id_menu;
	}

	public void setNom_menu(String nom_menu) {
		this.nom_menu = nom_menu;
	}

	public void setPrix_menu(String prix_menu) {
		this.prix_menu = prix_menu;
	}

	public void setDescription_menu(String description_menu) {
		this.description_menu = description_menu;
	}

	public void setImage_menu(byte[] image_menu) {
		this.image_menu = image_menu;
	}

	public void setId_organisateur(int id_organisateur) {
		this.id_organisateur = id_organisateur;
	}

	public void setType(String type) {
		this.type = type;
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

	public static String getColPrix() {
		return COL_PRIX;
	}

	public static String getColDesc() {
		return COL_DESC;
	}

	public static String getColIdOrganisateur() {
		return COL_ID_ORGANISATEUR;
	}

	public static String getColImg() {
		return COL_IMG;
	}

	public static String getColType() {
		return COL_TYPE;
	}
}


