package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StaffDao;
import exception.CampusException;
import model.Staff;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    //ログアウト機能
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();

        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
    }

    //ログイン機能
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("Post指令が来ました");
        int staffId = Integer.parseInt(request.getParameter("loginId"));
        String loginPassword = request.getParameter("loginPassword");
        String nextPage = null;
        //System.out.println("Postパラ受け取り");
        try {
            StaffDao staffDao = new StaffDao();
            Staff staff = staffDao.doLogin(staffId, loginPassword);
            //System.out.println("Login照合");

            //セッションスコープを取得
            HttpSession session = request.getSession();

            session.setAttribute("staff", staff);

            nextPage = "StudentServlet";
        }catch (CampusException e) {

            String message = e.getMessage();
            request.setAttribute("message", message);
            // ログイン画面へ遷移する準備
            nextPage = "login.jsp";
        }

        RequestDispatcher rd = request.getRequestDispatcher(nextPage);
        rd.forward(request, response);

    }

}
