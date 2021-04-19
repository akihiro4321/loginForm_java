package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StudentDao;
import exception.CampusException;
import model.Staff;
import model.Student;
import model.StudentMemo;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    //学生新規登録画面へ案内
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ログインしている職員の情報を取得
        // DBの登録（更新）処理の際に使用します
        HttpSession session = request.getSession();
        Staff staff = (Staff)session.getAttribute("staff");
        StudentMemo studentMemo = null;
        //詳細ボタンから遷移してきたときの処理


        //学生登録ボタンから遷移してきたときの処理
        try {
            String staffId = staff.getStaffId();
            String staffName = staff.getStaffName();
            studentMemo = new StudentMemo(staffId, staffName);
            request.setAttribute("studentMemo", studentMemo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 次の画面に遷移
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("detail.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nextPage = null;
        try {
            StudentDao studentDao = new StudentDao();
            List<Student> studentList = studentDao.findAllStudent();
            // 取得した学生一覧をリクエストスコープにセット
            request.setAttribute("studentList", studentList);

            nextPage = "list.jsp";

        } catch (CampusException e) {

            String message = e.getMessage();
            request.setAttribute("message", message);
            // ログイン画面へ遷移する準備
            nextPage = "login.jsp";
        }

        RequestDispatcher rd = request.getRequestDispatcher(nextPage);
        rd.forward(request, response);
    }

}
