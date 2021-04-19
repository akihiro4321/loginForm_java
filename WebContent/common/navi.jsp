<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>


<!-- ナビゲーション -->
<nav class="navbar navbar-expand-lg navbar-light bg-light shadow fixed-top">
  <div class="container">

    <!-- ログインページへのリンクを入れています -->
    <a class="navbar-brand" href="login.jsp">SchooCampus</a>


      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="StudentServlet?list=true">学生の一覧</a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="LoginServlet">ログアウト</a>
          </li>
        </ul>
        <div class="navbar-text">
          ログインユーザ名：
        </div>
      </div>
  </div>
</nav>