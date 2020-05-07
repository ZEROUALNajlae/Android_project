package com.example.myplannerify.database_classes ;

public class statut {

	private int id_client;
	private int id_organisateur;
	private boolean statut;

	private static   String TABLE_NAME = "STATUT";
	private static String COL_ID_CLIENT = "ID_CLIENT";
	private static String COL_ID_ORGANISATEUR = "ID_ORGANISATEUR";
	private static String COL_STATUT = "STATUT";

	public int getId_organisateur() {
		return id_organisateur;
	}

	public int getId_client() {
		return id_client;
	}

	public boolean isStatut() {
		return statut;
	}



	public void setId_organisateur(int id_organisateur) {
		this.id_organisateur = id_organisateur;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public static String getTableName() {
		return TABLE_NAME;
	}

	public static String getColIdOrganisateur() {
		return COL_ID_ORGANISATEUR;
	}

	public static String getColIdClient() {
		return COL_ID_CLIENT;
	}

	public static String getColStatut() {
		return COL_STATUT;
	}
}
