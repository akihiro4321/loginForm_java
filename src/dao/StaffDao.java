package dao;

import java.sql.SQLException;

import exception.CampusException;
import model.Staff;

public class StaffDao extends BaseDao {

    public StaffDao() throws CampusException {
        super();
    }

    public Staff doLogin(int staffId, String loginPassword) throws CampusException{
        Staff loginUser = null;
        try {
            String sql = "SELECT * FROM staff WHERE staff_id = ? AND login_password = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, staffId);
            ps.setString(2, loginPassword);

            //SQL操作
            rs = ps.executeQuery();

            while(rs.next()) {
                String userId = rs.getString("staff_id");
                String userName = rs.getString("staff_name");
                String password = rs.getString("login_password");
                loginUser = new Staff(userId, userName, password);
            }
            close();
         // ログイン結果を確認
            if(loginUser == null) {
                throw new CampusException("ログインできませんでした");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CampusException("SQL実行中に例外が発生しました");
        }
    // スタッフ情報を返却
    return loginUser;
    }

}
