package com.example.myplannerify;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.myplannerify.database_classes.*;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MySQLite extends SQLiteOpenHelper {

	public static final String DATABASE_NAME = "database.db";
	Iterator itr = new Iterator() {
		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public Object next() {
			return null;
		}
	};
	SQLiteDatabase dbw = this.getWritableDatabase();
	SQLiteDatabase dbr = this.getReadableDatabase();
	ContentValues contentValues = new ContentValues();

	public MySQLite(Context context) {

		super(context, DATABASE_NAME , null, 1);
	}



	//La table ORGANISATEUR



	final static String CREATE_TABLE_ORGANISATEUR = "CREATE TABLE "+Organisateur.getTableName()+"("+Organisateur.getColId()+" integer primary key autoincrement , "+Organisateur.getColNom()+" text ,"+Organisateur.getColEmail() +" text,"+Organisateur.getColPasswd()+" text ,"+ Organisateur.getColVille()+" text ,"+ Organisateur.getColAdresse()+" text ,"+ Organisateur.getColDesc()+" text ,"+Organisateur.getColImage()+" blob  ," +Organisateur.getColContact()+" text," +Organisateur.getColLikes() +" integer );";



	public long insertOrganisateur (Organisateur organisateur) {
		contentValues.put(Organisateur.getColNom(), organisateur.getNom_organisateur());
		contentValues.put(Organisateur.getColEmail(), organisateur.getEmail_organisateur());
		contentValues.put(Organisateur.getColPasswd(), organisateur.getPasswd_organisateur());
		contentValues.put(Organisateur.getColContact(), organisateur.getContact_organisateur());
		contentValues.put(Organisateur.getColVille(), organisateur.getVille_organisateur());
		contentValues.put(Organisateur.getColDesc(), organisateur.getDescription_organisateur());
		contentValues.put(Organisateur.getColAdresse(), organisateur.getAdresse_organisateur());
		contentValues.put(Organisateur.getColImage(), organisateur.getImage_organisateur());
		contentValues.put(Organisateur.getColLikes(), organisateur.getLikes());
		return dbw.insert(Organisateur.getTableName(), null, contentValues);
	}

	public int updateOrganisateur(Organisateur organisateur ,String nom,  String email , String password, String contact , String ville, String description, String adresse, byte[] image  ){
		organisateur.setNom_organisateur(nom);
		organisateur.setEmail_organisateur(email);
		organisateur.setPasswd_organisateur(password);
		organisateur.setContact_organisateur(contact);
		organisateur.setVille_organisateur(ville);
		organisateur.setDescription_organisateur(description);
		organisateur.setAdresse_organisateur(adresse);
		organisateur.setImage_organisateur(image);
		contentValues.put(Organisateur.getColNom(), organisateur.getNom_organisateur());
		contentValues.put(Organisateur.getColEmail(), organisateur.getEmail_organisateur());
		contentValues.put(Organisateur.getColPasswd(), organisateur.getPasswd_organisateur());
		contentValues.put(Organisateur.getColContact(), organisateur.getContact_organisateur());
		contentValues.put(Organisateur.getColVille(), organisateur.getVille_organisateur());
		contentValues.put(Organisateur.getColDesc(), organisateur.getDescription_organisateur());
		contentValues.put(Organisateur.getColAdresse(), organisateur.getAdresse_organisateur());
		contentValues.put(Organisateur.getColImage(),  organisateur.getImage_organisateur());
		String where = Organisateur.getColId() + " = ?";
		String[] whereArgs = {organisateur.getId_organisateur()+""};
		return dbw.update(Organisateur.getTableName(), contentValues, where, whereArgs);
	}


	public int deleteOrganisateur(Organisateur organisateur) {
		String where = Menu.getColId() + " = ?";
		String[] whereArgs = {organisateur.getId_organisateur() +""};

		return dbr.delete(Organisateur.getTableName(), where, whereArgs);
	}

	public Organisateur getOrganisateur(int id) {
		Organisateur organisateur = new Organisateur();
		Cursor c = dbr.rawQuery("SELECT * FROM "+Organisateur.getTableName()+" WHERE "+Organisateur.getColId()+ "=" +id, null);
		if (c.moveToFirst()) {
			organisateur.setId_organisateur(c.getInt(c.getColumnIndex(Organisateur.getColId())));
			organisateur.setNom_organisateur(c.getString(c.getColumnIndex(Organisateur.getColNom())));
			organisateur.setEmail_organisateur(c.getString(c.getColumnIndex(Organisateur.getColEmail())));
			organisateur.setPasswd_organisateur(c.getString(c.getColumnIndex(Organisateur.getColPasswd())));
			organisateur.setContact_organisateur(c.getString(c.getColumnIndex(Organisateur.getColContact())));
			organisateur.setVille_organisateur(c.getString(c.getColumnIndex(Organisateur.getColVille())));
			organisateur.setDescription_organisateur(c.getString(c.getColumnIndex(Organisateur.getColDesc())));
			organisateur.setAdresse_organisateur(c.getString(c.getColumnIndex(Organisateur.getColAdresse())));
			organisateur.setImage_organisateur(c.getBlob(c.getColumnIndex(Organisateur.getColImage())));
			organisateur.setLikes(c.getInt(c.getColumnIndex(Organisateur.getColLikes())));
			c.close();
		}

		return organisateur;
	}
	public List<Organisateur> getOrganisateurs() {
		List<Organisateur> data = new ArrayList<>();
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = dbr.rawQuery("select * from " + Organisateur.getTableName() + ";", null);
		while(c.moveToNext()) {
			Organisateur organisateur = new Organisateur("","","","0","","","",null, 0);
			organisateur.setId_organisateur(c.getInt(c.getColumnIndex(Organisateur.getColId())));
			organisateur.setNom_organisateur(c.getString(c.getColumnIndex(Organisateur.getColNom())));
			organisateur.setEmail_organisateur(c.getString(c.getColumnIndex(Organisateur.getColEmail())));
			organisateur.setPasswd_organisateur(c.getString(c.getColumnIndex(Organisateur.getColPasswd())));
			organisateur.setContact_organisateur(c.getString(c.getColumnIndex(Organisateur.getColContact())));
			organisateur.setVille_organisateur(c.getString(c.getColumnIndex(Organisateur.getColVille())));
			organisateur.setDescription_organisateur(c.getString(c.getColumnIndex(Organisateur.getColDesc())));
			organisateur.setAdresse_organisateur(c.getString(c.getColumnIndex(Organisateur.getColAdresse())));
			organisateur.setImage_organisateur(c.getBlob(c.getColumnIndex(Organisateur.getColImage())));
			data.add(organisateur);
		}
		c.close();
		return data;
	}

	/*public int getCommentaire_Organisateur(int id){
		SQLiteDatabase db = this.getReadableDatabase();
		int i = 0;
		Cursor c = dbr.rawQuery("select count(*) from " + Commentaire.getTableName() +" WHERE "+Commentaire.getColIdOrganisateur()+ "=" +id, null);
		if(null != c)
			if(c.getCount() > 0){
				c.moveToFirst();
				i = c.getInt(0);
			}
		c.close();

		return i ;
		}*/
	public int getLikes_Organisateur(int id) {
		SQLiteDatabase db = this.getReadableDatabase();
		int i = 0;
		Cursor c = dbr.rawQuery("select " + Organisateur.getColLikes() + " from " + Organisateur.getTableName() + " WHERE " + Organisateur.getColId() + "=" + id, null);
		if (null != c)
			if (c.getCount() > 0) {
				c.moveToFirst();
				i = c.getInt(0);
			}
		c.close();

		return i;

	}


	public void addLike(Organisateur organisateur){
		organisateur.setLikes(organisateur.getLikes() + 1);
		String where = Organisateur.getColId() + " = ?";
		String[] whereArgs = {organisateur.getId_organisateur()+""};
		contentValues.put(Organisateur.getColLikes(),  organisateur.getLikes());
		dbw.update(Organisateur.getTableName(), contentValues, where, whereArgs);

	}



	public void deleteLike(Organisateur organisateur){
		organisateur.setLikes(organisateur.getLikes() - 1);
		contentValues.put(Organisateur.getColLikes(),  organisateur.getLikes());
		String where = Organisateur.getColId() + " = ?";
		String[] whereArgs = {organisateur.getId_organisateur()+""};
		dbw.update(Organisateur.getTableName(), contentValues, where, whereArgs);

	}
	public boolean insertO( Organisateur organisateur ){

		contentValues.put(Organisateur.getColNom(), organisateur.getNom_organisateur());
		contentValues.put(Organisateur.getColEmail(), organisateur.getEmail_organisateur());
		contentValues.put(Organisateur.getColPasswd(), organisateur.getPasswd_organisateur());
		contentValues.put(Organisateur.getColContact(), organisateur.getContact_organisateur());
		contentValues.put(Organisateur.getColVille(), organisateur.getVille_organisateur());
		contentValues.put(Organisateur.getColDesc(), organisateur.getDescription_organisateur());
		contentValues.put(Organisateur.getColAdresse(), organisateur.getAdresse_organisateur());
		contentValues.put(Organisateur.getColImage(), organisateur.getImage_organisateur());
		long ins = dbw.insert(Organisateur.getTableName() , null , contentValues);
		if(ins==-1)return false;
		else return true;
	}

	public Boolean chkemailO(String Email_Organisateur){
		int i=0;
		//SQLiteDatabase db=  this.getReadableDatabase();
		Cursor cursorO = dbr.rawQuery("select * from "+Organisateur.getTableName()+" where "+Organisateur.getColEmail()+"=?", new String[]{Email_Organisateur});
		if(cursorO.getCount()>0)i=1;
		Cursor cursorC = dbr.rawQuery("select * from "+Client.getTableName()+" where "+Organisateur.getColEmail()+"=?", new String[]{Email_Organisateur});
		if(cursorC.getCount()>0)i=1;
		if(i==1) return true;
		else return false;
	}

	public Boolean empssO(String Email_Organisateur , String Password_Organisateur ) {
		//SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = dbr.rawQuery("select * from "+ Organisateur.getTableName()+" where "+Organisateur.getColEmail()+"=? and "+Organisateur.getColPasswd()+" = ?", new String[]{Email_Organisateur, Password_Organisateur});
		if (cursor.getCount() > 0) return true;
		else return false;
	}

	public void updatC(String Password_Client , String Email_Client) {
		contentValues.put(Client.getColPasswd() , Password_Client );

		String where = ""+Client.getColEmail()+"= ?";
		dbw.update(Client.getTableName(), contentValues, where ,new String[]{Email_Client});
		dbw.close();
	}
	public void  updatO(String userEmail,String password)
	{
		//  create object of ContentValues
		//ContentValues updatedValues = new ContentValues();
		// Assign values for each Column.
		//contentValues.put( Organisateur.getColEmail(), userEmail);
		contentValues.put(Organisateur.getColPasswd(), password);

		String where = ""+Organisateur.getColEmail()+"= ?";
		dbw.update(Organisateur.getTableName(),contentValues, where, new String[]{userEmail});

	}






	//La table CLIENT
	final static String CREATE_TABLE_CLIENT = "CREATE TABLE "+Client.getTableName()+"("+Client.getColId()+" integer primary key autoincrement , "+Client.getColNom()+" text,"+Client.getColPrenom()+" text,"+Client.getColEmail()+" text,"+Client.getColPasswd()+" text,"+Client.getColVille()+" text);";

	public long insertClient (Client client) {
		contentValues.put(Client.getColNom(), client.getNom_client());
		contentValues.put(Client.getColPrenom(), client.getPrenom_client());
		contentValues.put(Client.getColEmail(), client.getEmail_client());
		contentValues.put(Client.getColPasswd(), client.getPasswd_client());
		contentValues.put(Client.getColVille(), client.getVille_client());
		return dbw.insert(Client.getTableName(), null, contentValues);
	}

	public int updateClient(Client client, String nom, String prenom, String email, String password , String ville  ){
		client.setNom_client(nom);
		client.setPrenom_client(prenom);
		client.setEmail_client(email);
		client.setPasswd_client(password);
		client.setVille_client(ville);
		contentValues.put(Client.getColNom(), client.getNom_client());
		contentValues.put(Client.getColPrenom(), client.getPrenom_client());
		contentValues.put(Client.getColEmail(), client.getEmail_client());
		contentValues.put(Client.getColPasswd(), client.getPasswd_client());
		contentValues.put(Client.getColVille(), client.getVille_client());
		String where = Client.getColId() + " = ?";
		String[] whereArgs = {client.getId_client()+""};

		return dbw.update(Client.getTableName(), contentValues, where, whereArgs);
	}

	public int deleteClient(Client client) {
		String where = Client.getColId() + " = ?";
		String[] whereArgs = {client.getId_client()+""};

		return dbr.delete(Client.getTableName(), where, whereArgs);
	}

	public Client getClient(int id) {
		Client clt = new Client();
		Cursor c = dbr.rawQuery("SELECT * FROM "+Client.getTableName()+" WHERE "+Client.getColId()+"="+id, null);
		if (c.moveToFirst()) {
			clt.setId_client(c.getInt(c.getColumnIndex(Client.getColId())));
			clt.setNom_client(c.getString(c.getColumnIndex(Client.getColNom())));
			clt.setPrenom_client(c.getString(c.getColumnIndex(Client.getColPrenom())));
			clt.setEmail_client(c.getString(c.getColumnIndex(Client.getColEmail())));
			clt.setPasswd_client(c.getString(c.getColumnIndex(Client.getColPasswd())));
			clt.setVille_client(c.getString(c.getColumnIndex(Client.getColVille())));
			c.close();
		}

		return clt;
	}
	/*public ArrayList<Client> getClients() {
		ArrayList<Client> data = new ArrayList<>();
		return data = (ArrayList<Client>) dbr.rawQuery("select * from '" + Client.getTableName() + "'", null);
	}*/




	//La table Commentaire
	final static String CREATE_TABLE_COMMENTAIRE = "CREATE TABLE "+Commentaire.getTableName()+"("+Commentaire.getColId()+" integer primary key autoincrement , "+Commentaire.getColTxt()+" text,"+Commentaire.getColDate()+" text,"+Commentaire.getColIdOrganisateur()+" integer, CONSTRAINT Commentaire_Organisateur_FK FOREIGN KEY ("+Commentaire.getColIdOrganisateur()+") REFERENCES "+ Organisateur.getTableName()+ "("+Organisateur.getColId()+"));";

	public long insertCommentaire (Commentaire commentaire) {
		contentValues.put(Commentaire.getColTxt(), commentaire.getTxt_commentaire());
		contentValues.put(Commentaire.getColDate(), commentaire.getDate_commentaire());
		contentValues.put(Commentaire.getColIdOrganisateur(), commentaire.getId_organisateur());
		return dbw.insert(Commentaire.getTableName(), null, contentValues);
	}

	public int updateCommentaire(Commentaire commentaire, String date, String texte, int id  ){
		commentaire.setDate_commentaire(date);
		commentaire.setTxt_commentaire(texte);
		commentaire.setId_organisateur(id);
		contentValues.put(Commentaire.getColTxt(), commentaire.getTxt_commentaire());
		contentValues.put(Commentaire.getColDate(), commentaire.getDate_commentaire());
		contentValues.put(Commentaire.getColIdOrganisateur(), commentaire.getColIdOrganisateur());
		String where = Commentaire.getColId() + " = ?";
		String[] whereArgs = {commentaire.getId_commentaire()+""};
		return dbw.update(Commentaire.getTableName(), contentValues, where, whereArgs);
	}


	public int deleteCommentaire(Commentaire commentaire) {
		String where = Commentaire.getColId() + " = ?";
		String[] whereArgs = {commentaire.getId_commentaire() +""};

		return dbr.delete(Commentaire.getTableName(), where, whereArgs);
	}

	public Commentaire getCommentaire(int id) {
		Commentaire commentaire = new Commentaire();
		Cursor c = dbr.rawQuery("SELECT * FROM "+Commentaire.getTableName()+" WHERE "+Commentaire.getColId()+"="+id, null);
		if (c.moveToFirst()) {
			commentaire.setId_commentaire(c.getInt(c.getColumnIndex(Commentaire.getColId())));
			commentaire.setDate_commentaire(c.getString(c.getColumnIndex(Commentaire.getColDate())));
			commentaire.setTxt_commentaire(c.getString(c.getColumnIndex(Commentaire.getColTxt())));
			commentaire.setId_organisateur(c.getInt(c.getColumnIndex(Commentaire.getColIdOrganisateur())));
			c.close();
		}

		return commentaire;
	}



	//La table MENU
	final static String CREATE_TABLE_MENU = "CREATE TABLE "+Menu.getTableName()+"("+ Menu.getColId() +" integer primary key autoincrement, " +Menu.getColNom() +" text, " + Menu.getColPrix() +" integer, " + Menu.getColDesc() +" text, " + Menu.getColImg() +" blob, "+ Menu.getColType() +" text, " + Menu.getColIdOrganisateur() +" integer, CONSTRAINT Menu_Organisateur_FK FOREIGN KEY ("+Menu.getColIdOrganisateur()+") REFERENCES "+ Organisateur.getTableName()+ "("+Organisateur.getColId()+"));";


	public long insertMenu(Menu menu) {
		contentValues.put(Menu.getColNom(), menu.getNom_menu());
		contentValues.put(Menu.getColPrix(), menu.getPrix_menu());
		contentValues.put(Menu.getColDesc(), menu.getDescription_menu());
		contentValues.put(Menu.getColImg(), menu.getImage_menu());
		contentValues.put(Menu.getColIdOrganisateur(), menu.getId_organisateur());
		contentValues.put(Menu.getColType(), menu.getType());
		return dbw.insert(Menu.getTableName(), null, contentValues);
	}

	public int updateMenu(Menu menu,String nom, String prix,  String description , byte[] image, int id  ){
		menu.setNom_menu(nom);
		menu.setPrix_menu(prix);
		menu.setDescription_menu(description);
		menu.setImage_menu(image);
		menu.setId_organisateur(id);
		contentValues.put(Menu.getColNom(),menu.getNom_menu());
		contentValues.put(Menu.getColPrix(), menu.getPrix_menu());
		contentValues.put(Menu.getColDesc(), menu.getDescription_menu());
		contentValues.put(Menu.getColImg(), menu.getImage_menu());
		contentValues.put(Menu.getColIdOrganisateur(), menu.getId_organisateur());
		String where = Commentaire.getColId() + " = ?";
		String[] whereArgs = {menu.getId_menu()+""};
		return dbw.update(Commentaire.getTableName(), contentValues, where, whereArgs);
	}


	public int deleteMenu(Menu menu) {
		String where = Menu.getColId() + " = ?";
		String[] whereArgs = {menu.getId_menu() +""};

		return dbr.delete(Menu.getTableName(), where, whereArgs);
	}

	public Menu getMenu(int id) {
		Menu menu = new Menu();
		Cursor c = dbr.rawQuery("SELECT * FROM "+Menu.getTableName()+" WHERE "+Menu.getColId()+"="+id, null);
		if (c.moveToFirst()) {
			menu.setId_menu(c.getInt(c.getColumnIndex(Menu.getColId())));
			menu.setNom_menu(c.getString(c.getColumnIndex(Menu.getColNom())));
			menu.setPrix_menu(c.getString(c.getColumnIndex(Menu.getColPrix())));
			menu.setDescription_menu(c.getString(c.getColumnIndex(Menu.getColDesc())));
			menu.setImage_menu(c.getBlob(c.getColumnIndex(Menu.getColImg())));
			menu.setId_organisateur(c.getInt(c.getColumnIndex(Menu.getColIdOrganisateur())));
			c.close();
		}

		return menu;
	}
	public List<Menu> getMenus(String type) {
		ArrayList<Menu> data = new ArrayList<>();
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = dbr.rawQuery("SELECT * FROM "+Menu.getTableName()+" WHERE "+ Menu.getColType() +" =  " + type , null);
		while (c.moveToNext()) {
			Menu menu = new Menu("","","",null,0,"");
			menu.setId_menu(c.getInt(c.getColumnIndex(Menu.getColId())));
			menu.setNom_menu(c.getString(c.getColumnIndex(Menu.getColNom())));
			menu.setPrix_menu(c.getString(c.getColumnIndex(Menu.getColPrix())));
			menu.setDescription_menu(c.getString(c.getColumnIndex(Menu.getColDesc())));
			menu.setImage_menu(c.getBlob(c.getColumnIndex(Menu.getColImg())));
			menu.setId_organisateur(c.getInt(c.getColumnIndex(Menu.getColIdOrganisateur())));
			menu.setType(c.getString(c.getColumnIndex(Menu.getColType())));
			data.add(menu);

		}
		c.close();

		return data;
	}
	public boolean insertC(Client client){
		//SQLiteDatabase db = this.getWritableDatabase();
		contentValues.put(Client.getColNom(), client.getNom_client());
		contentValues.put(Client.getColPrenom(), client.getPrenom_client());
		contentValues.put(Client.getColEmail(), client.getEmail_client());
		contentValues.put(Client.getColPasswd(), client.getPasswd_client());
		contentValues.put(Client.getColVille(), client.getVille_client());
		long ins = dbw.insert(Client.getTableName() , null , contentValues);
		if(ins==-1)return false;
		else return true;
	}
	public Boolean empssC(String Email_Client , String Password_Client ) {
		//SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = dbr.rawQuery("select * from "+ Client.getTableName()+" where "+Client.getColEmail()+"=? and "+Client.getColPasswd()+" = ?", new String[]{Email_Client, Password_Client});
		if (cursor.getCount() > 0) return true;
		else return false;
	}







	//La table RESERVAION

	final static String CREATE_TABLE_RESERVATION = "CREATE TABLE "+Reservation.getTableName()+ "( "  + Reservation.getColId() +" integer primary key autoincrement, " +  Reservation.getColDateReserv() +" text, " + Reservation.getColDateEvent() +" text, " + Reservation.getColDateRdv() +" text, " + Reservation.getColDetailClt() +" text, " + Reservation.getColDetailOrg()
		+" text, " + Reservation.getColIdClt() +" integer, " + Reservation.getColIdMenu() +" integer );";

	public long insertReservation (Reservation reservation) {
		contentValues.put(Reservation.getColDateReserv(), reservation.getDate_reservation());
		contentValues.put(Reservation.getColDateEvent(), reservation.getDate_evenement());
		contentValues.put(Reservation.getColDateRdv(), reservation.getDate_rdv());
		contentValues.put(Reservation.getColDetailClt(), reservation.getDetail_client());
		contentValues.put(Reservation.getColDetailOrg(), reservation.getDetail_organisateur());
		contentValues.put(Reservation.getColIdClt(), reservation.getId_client());
		contentValues.put(Reservation.getColIdMenu(), reservation.getId_menu());
		return dbw.insert(Reservation.getTableName(), null, contentValues);
	}

	public int updateReservation(Reservation reservation, String datereservation, String dateevenement, String daterdv, String detailclient, String detailorganisateur, int idclient, int idmenu ){
		reservation.setDate_reservation(datereservation);
		reservation.setDate_evenement(dateevenement);
		reservation.setDate_rdv(daterdv);
		reservation.setDetail_client(detailclient);
		reservation.setDetail_organisateur(detailorganisateur);
		reservation.setId_client(idclient);
		reservation.setId_menu(idmenu);
		contentValues.put(Reservation.getColDateReserv(), reservation.getDate_reservation());
		contentValues.put(Reservation.getColDateEvent(), reservation.getDate_evenement());
		contentValues.put(Reservation.getColDateRdv(), reservation.getDate_rdv());
		contentValues.put(Reservation.getColDetailClt(), reservation.getDetail_client());
		contentValues.put(Reservation.getColDetailOrg(), reservation.getDetail_organisateur());
		contentValues.put(Reservation.getColIdClt(), reservation.getId_client());
		contentValues.put(Reservation.getColIdMenu(), reservation.getId_menu());
		String where = Reservation.getColId() + " = ?";
		String[] whereArgs = {reservation.getId_menu()+""};
		return dbw.update(Reservation.getTableName(), contentValues, where, whereArgs);
	}


	public int deleteReservation(Reservation reservation) {
		String where = Reservation.getColId() + " = ?";
		String[] whereArgs = {reservation.getId_menu() +""};

		return dbr.delete(Reservation.getTableName(), where, whereArgs);
	}

	public Reservation getReservation(int id) {
		Reservation reservation = new Reservation();
		Cursor c = dbr.rawQuery("SELECT * FROM "+Menu.getTableName()+" WHERE "+Commentaire.getColId()+"="+id, null);
		if (c.moveToFirst()) {
			reservation.setId_reservation(c.getInt(c.getColumnIndex(Reservation.getColId())));
			reservation.setDate_reservation(c.getString(c.getColumnIndex(Reservation.getColDateReserv())));
			reservation.setDate_evenement(c.getString(c.getColumnIndex(Reservation.getColDateEvent())));
			reservation.setDate_rdv(c.getString(c.getColumnIndex(Reservation.getColDateRdv())));
			reservation.setDetail_client(c.getString(c.getColumnIndex(Reservation.getColDetailClt())));
			reservation.setDetail_organisateur(c.getString(c.getColumnIndex(Reservation.getColDetailOrg())));
			reservation.setId_client(c.getInt(c.getColumnIndex(Reservation.getColIdClt())));
			reservation.setId_menu(c.getInt(c.getColumnIndex(Reservation.getColIdMenu())));
			c.close();
		}

		return reservation;
	}
	/*public ArrayList<Reservation> getReservations() {
		ArrayList<Reservation> data = new ArrayList<>();
		return data = (ArrayList<Reservation>) dbr.rawQuery("select * from '" + Menu.getTableName() + "'", null);
	}*/





	//La table CATALOGUE

	final static String CREATE_TABLE_CATALOGUE = "CREATE TABLE "+Catalogue.getTableName()+ "("+ Catalogue.getColId() +" integer primary key autoincrement, " + Catalogue.getColNom() +" text, " + Catalogue.getColImage() +" blob, " + Catalogue.getColIdOrg() +" integer );";

	public long insertCatalogue (Catalogue catalogue) {
		contentValues.put(Catalogue.getColNom(), catalogue.getNom_catalogue());
		contentValues.put(Catalogue.getColImage(), catalogue.getImage_catalogue());
		contentValues.put(Catalogue.getColIdOrg(), catalogue.getId_organisateur());
		return dbw.insert(Catalogue.getTableName(), null, contentValues);
	}

	public int updateCatalogue(Catalogue catalogue, String nom, byte[] image, int idorganisateur  ){
		catalogue.setNom_catalogue(nom);
		catalogue.setImage_catalogue(image);
		catalogue.setId_organisateur(idorganisateur);
		contentValues.put(Catalogue.getColNom(), catalogue.getNom_catalogue());
		contentValues.put(Catalogue.getColImage(), catalogue.getImage_catalogue());
		contentValues.put(Catalogue.getColIdOrg(), catalogue.getId_organisateur());
		String where = Catalogue.getColId() + " = ?";
		String[] whereArgs = {catalogue.getId_catalogue()+""};
		return dbw.update(Catalogue.getTableName(), contentValues, where, whereArgs);
	}


	public int deleteCatalogue(Catalogue catalogue) {
		String where = Catalogue.getColId() + " = ?";
		String[] whereArgs = {catalogue.getId_catalogue() +""};

		return dbr.delete(Catalogue.getTableName(), where, whereArgs);
	}

	public Catalogue getCatalogue(int id) {
		Catalogue catalogue = new Catalogue();
		Cursor c = dbr.rawQuery("SELECT * FROM "+Catalogue.getTableName()+" WHERE "+Catalogue.getColId()+"="+id, null);
		if (c.moveToFirst()) {
			catalogue.setId_catalogue(c.getInt(c.getColumnIndex(Catalogue.getColId())));
			catalogue.setNom_catalogue(c.getString(c.getColumnIndex(Catalogue.getColNom())));
			catalogue.setImage_catalogue(c.getBlob(c.getColumnIndex(Catalogue.getColImage())));
			catalogue.setId_organisateur(c.getInt(c.getColumnIndex(Catalogue.getColIdOrg())));

			c.close();
		}

		return catalogue;
	}
	/*public ArrayList<Catalogue> getCatalogues() {
		ArrayList<Catalogue> data = new ArrayList<>();
		SQLiteDatabase db = this.getReadableDatabase();
		return data = (ArrayList<Catalogue>) dbr.rawQuery("select * from '" + Catalogue.getTableName() + "'", null);
	}*/













	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_TABLE_CLIENT);
		db.execSQL(CREATE_TABLE_ORGANISATEUR);
		db.execSQL(CREATE_TABLE_COMMENTAIRE);
		db.execSQL(CREATE_TABLE_MENU);
		db.execSQL(CREATE_TABLE_RESERVATION);
		db.execSQL(CREATE_TABLE_CATALOGUE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS "+Client.getTableName()+" ;");
		db.execSQL("DROP TABLE IF EXISTS "+Commentaire.getTableName()+" ;");
		db.execSQL("DROP TABLE IF EXISTS "+Menu.getTableName()+"; ");
		db.execSQL("DROP TABLE IF EXISTS "+Organisateur.getTableName()+" ;");
		db.execSQL("DROP TABLE IF EXISTS "+Reservation.getTableName()+"; ");
		db.execSQL("DROP TABLE IF EXISTS "+Catalogue.getTableName()+"; ");
		onCreate(db);
	}
	public Organisateur getOrganisteur(String email) {
		Organisateur clt = new Organisateur();
		Cursor c = dbr.rawQuery("SELECT * FROM "+Organisateur.getTableName()+" WHERE "+Organisateur.getColEmail()+"="+ "'" + email + "'" , null);
		if (c.moveToFirst()) {
			clt.setId_organisateur(c.getInt(c.getColumnIndex(Organisateur.getColId())));
			clt.setNom_organisateur(c.getString(c.getColumnIndex(Organisateur.getColNom())));
			clt.setEmail_organisateur(c.getString(c.getColumnIndex(Organisateur.getColEmail())));
			clt.setDescription_organisateur(c.getString(c.getColumnIndex(Organisateur.getColDesc())));
			clt.setPasswd_organisateur(c.getString(c.getColumnIndex(Organisateur.getColPasswd())));
			clt.setVille_organisateur(c.getString(c.getColumnIndex(Organisateur.getColVille())));
			clt.setAdresse_organisateur(c.getString(c.getColumnIndex(Organisateur.getColAdresse())));
			clt.setContact_organisateur(c.getString(c.getColumnIndex(Organisateur.getColContact())));
			clt.setImage_organisateur(c.getBlob(c.getColumnIndex(Organisateur.getColImage())));
			c.close();
		}

		return clt;
	}


}

