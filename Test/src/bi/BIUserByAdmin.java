package bi;
import java.util.Date;
import java.util.List;

public interface BIUserByAdmin {
	boolean addUser(User user);
	boolean updateUser(User user);
	boolean delUser(User user);

	boolean addBiAdmin(BiAdmin biAdmin);
	boolean updateBiAdmin(BiAdmin biAdmin);
	boolean delBiAdmin(BiAdmin biAdmin);

	boolean addBiAdminGroup(BiAdminGroup biAdminGroup);
	boolean updateBiAdminGroup(BiAdminGroup biAdminGroup);
	boolean delBiAdminGroup(BiAdminGroup biAdminGroup);

	boolean addBiAdminUser(BiAdminUser biAdminUser);
	boolean updateBiAdminUser(BiAdminUser biAdminUser);
	boolean delBiAdminUser(BiAdminUser biAdminUser);

	boolean addBiAdminUserList(List<BiAdminUser> biAdminUser);
	boolean checkIsAdmin(User user);
	boolean checkIsOnLine(User user);
	boolean check(BiAdminUser biAdminUser);
}

class User {
	int id;
	String name;
	String pwd;
	int userLevevlId;
	boolean isOnLine;
	Date lastOnLine;
}

class UserLevel{
	int id;
	String name;
	String info;
	boolean isAdmin;
}

class BiAdmin {
	int id;
	String name;
	String sql;
	String info;
	int groupId;
	int modelNum;
}

class BiAdminGroup {
	int id;
	String name;
	String info;
}

class BiAdminUser {
	int id;
	int uid;
	int biAdminId;
	boolean isRead;
}
