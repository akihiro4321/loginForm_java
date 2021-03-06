package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.CampusException;
import model.Student;

public class StudentDao extends BaseDao {

    public StudentDao() throws CampusException {
        super();
    }

    public List<Student> findAllStudent() throws CampusException{
        ArrayList<Student> studentList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM student";
            ps = con.prepareStatement(sql);
            //SQL操作
            rs = ps.executeQuery();

            while(rs.next()) {
                String studentNumber = rs.getString("student_number");
                String studentName = rs.getString("student_name");
                Student student = new Student(studentNumber, studentName);
                studentList.add(student);
            }
            close();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new CampusException("SQL実行中に例外が発生しました");
        }
        return studentList;
    }
    public String findMemoId(String studentNumber) throws CampusException{
        String memoId = null;
        try {
            String sql = "SELECT memo_id FROM memo WHERE student_number = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, studentNumber);
            //SQL操作
            rs = ps.executeQuery();

            while(rs.next()) {
                memoId = rs.getString("memo_id");
            }
            close();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new CampusException("メモIDの取得に失敗しました");
        }

        return memoId;
    }

}
