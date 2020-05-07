
package com.example.myplannerify.database_classes ;




public class Reservation {

	private static int id_reservation;
	private String date_reservation;
	private String date_evenement;
	private String date_rdv;
	private String detail_client;
	private String detail_organisateur;
	private int id_client;
	private int id_menu;
	/*private String date_msg;
	private String msg;
	private int id_client;
	private int id_organisateur;*/

	//les colonnes de la table RESERVATION
	private static final String TABLE_NAME = "RESERVATION";
	private static final String COL_ID = "ID";
	private static final String COL_DATE_RESERV = "DATE_RESERVATION";
	private static final String COL_DATE_EVENT = "DATE_EVENEMENT" ;
	private static final String COL_DATE_RDV = "DATE_RENDEZ_VOUS";
	private static final String COL_DETAIL_CLT = "DETAIL_CLIENT";
	private static final String COL_DETAIL_ORG = "DETAIL_ORGANISATEUR";
	private static final String COL_ID_CLT = "ID_CLIENT";
	private static final String COL_ID_MENU = "ID_MENU";
	// me
	/*private static final String COL_ID_CLT = "ID_CLIENT";
	private static final String COL_DATE_MSG = "DATE_ENVOIE_MSG";
	private static final String COL_DATE_EVENT = "DATE_EVENEMENT" ;
	private static final String COL_DATE_RDV = "DATE_RENDEZ_VOUS";
	private static final String COL_DETAIL_CLT = "DETAIL_CLIENT";*/


	public Reservation(){
		id_reservation++;
	}

	public Reservation(String date_reservation, String date_evenement, String date_rdv, String detail_client, String detail_organisateur, int id_client, int id_menu){
		id_reservation++;
		this.date_reservation = date_reservation;
		this.date_evenement = date_evenement;
		this.date_rdv = date_rdv;
		this.detail_client = detail_client;
		this.detail_organisateur = detail_organisateur;
		this.id_client = id_client;
		this.id_menu = id_menu;
	}

	public static int getId_reservation() {
		return id_reservation;
	}

	public String getDate_reservation() {
		return date_reservation;
	}

	public String getDate_evenement() {
		return date_evenement;
	}

	public String getDate_rdv() {
		return date_rdv;
	}

	public String getDetail_client() {
		return detail_client;
	}

	public String getDetail_organisateur() {
		return detail_organisateur;
	}

	public int getId_client() {
		return id_client;
	}

	public int getId_menu() {
		return id_menu;
	}

	public static void setId_reservation(int id_reservation) {
		Reservation.id_reservation = id_reservation;
	}

	public void setDate_reservation(String date_reservation) {
		this.date_reservation = date_reservation;
	}

	public void setDate_evenement(String date_evenement) {
		this.date_evenement = date_evenement;
	}

	public void setDate_rdv(String date_rdv) {
		this.date_rdv = date_rdv;
	}

	public void setDetail_client(String detail_client) {
		this.detail_client = detail_client;
	}

	public void setDetail_organisateur(String detail_organisateur) {
		this.detail_organisateur = detail_organisateur;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public void setId_menu(int id_menu) {
		this.id_menu = id_menu;
	}

	public static String getTableName() {
		return TABLE_NAME;
	}

	public static String getColId() {
		return COL_ID;
	}

	public static String getColDateReserv() {
		return COL_DATE_RESERV;
	}

	public static String getColDateEvent() {
		return COL_DATE_EVENT;
	}

	public static String getColDateRdv() {
		return COL_DATE_RDV;
	}

	public static String getColDetailClt() {
		return COL_DETAIL_CLT;
	}

	public static String getColDetailOrg() {
		return COL_DETAIL_ORG;
	}

	public static String getColIdClt() {
		return COL_ID_CLT;
	}

	public static String getColIdMenu() {
		return COL_ID_MENU;
	}
}
