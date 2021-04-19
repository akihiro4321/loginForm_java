package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StudentDao;
import model.Staff;

/**
 * Servlet implementation class StudentMemoServlet
 */
@WebServlet("/StudentMemoServlet")
public class StudentMemoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    //学生新規登録&メモ更新処理
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //セッションからstaff情報を取得
        HttpSession session = request.getSession();
        Staff staff = (Staff)session.getAttribute("staff");
        String staffId = staff.getStaffId();
        String staffName = staff.getStaffName();

        //Postされてきた記入項目の情報を取得
        String studentNumber = request.getParameter("student_number");
        String studentName = request.getParameter("student_name");
        String memo = request.getParameter("memo");

        String message = null; // 処理後に画面に表示するメッセージ

        //memoId有無で新規登録orメモ更新を切り分ける
        try {
            //memoIdを取得する処理
            StudentDao studentDao = new StudentDao();
            String memoId = studentDao.findMemoId(studentNumber);

            //新規登録orメモ更新の切り分け
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
