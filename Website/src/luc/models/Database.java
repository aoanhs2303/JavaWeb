package luc.models;

public class Database {
	public boolean checkUser(String user, String pass) {
		if(user.equals("Luc") && pass.equals("123")) {
			return true;
		} else {
			return false;
		}
	}
}
