

package com.example.myplannerify.database_classes ;


public class Commentaire {

	private  int id_commentaire = 0;
	private String date_commentaire;
	private String txt_commentaire;
	private int id_organisateur;

	//les colonnes de la table COMMENTAIRE
	private static final String TABLE_NAME = "COMMENTAIRE";
	private static final String COL_ID = "ID";
	private static final String COL_DATE = "DATE" ;
	private static final String COL_TXT = "TEXTE";
	private static final String COL_ID_ORGANISATEUR = "ID_ORGANISATEUR";



	public Commentaire(String date, String txt, int id_organisateur){
		id_commentaire++;
		this.date_commentaire = date;
		this.txt_commentaire = txt;
		this.id_organisateur = id_organisateur;
	}

	public Commentaire(){

	}


	public  int getId_commentaire() {
		return id_commentaire;
	}

	public String getDate_commentaire() {
		return date_commentaire;
	}

	public String getTxt_commentaire() {
		return txt_commentaire;
	}

	public int getId_organisateur() {
		return id_organisateur;
	}

	public void setId_commentaire(int id_commentaire) {
		this.id_commentaire = id_commentaire;
	}

	public void setDate_commentaire(String date_commentaire) {
		this.date_commentaire = date_commentaire;
	}

	public void setTxt_commentaire(String txt_commentaire) {
		this.txt_commentaire = txt_commentaire;
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

	public static String getColTxt() {
		return COL_TXT;
	}

	public static String getColDate() {
		return COL_DATE;
	}

	public static String getColIdOrganisateur() {
		return COL_ID_ORGANISATEUR;
	}
}
