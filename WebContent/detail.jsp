<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <!-- 共通パーツ（ヘッダー）読み込み -->
  <jsp:include page="common/header.jsp"/>
  <body>
    <!-- 共通パーツ（ナビ）読み込み -->
    <jsp:include page="common/navi.jsp"/>
    <!-- 詳細部分 -->
    <section class="py-5">
      <div class="container">
        <h1 class="my-4">学生詳細</h1>
        <!-- DBを新規登録または更新した結果の表示処理 -->
        <!-- サーブレットでメッセージの設定処理を入れていない場合でも影響はありません -->
                  <div class="alert alert-success" role="alert">

            </div>

            <div class="alert alert-danger" role="alert">

            </div>


        <!-- 学生の詳細情報（新規登録の場合は空白を表示） -->

        <div class="row justify-content-center">
          <div class="media-container-column col-lg-8">
            <form action="StudentMemoServlet" method="post">
              <div class="row">
                <div class="col-md-12 form-group">
                  <label class="form-control-label">学生番号</label>
                  <input type="text"
                    name="student_number"
                    value=""
                    required="required"
                    class="form-control">
                </div>
                <div class="col-md-12 form-group">
                  <label class="form-control-label">学生名</label>
                  <input type="text"
                    name="student_name"
                    value=""
                    required="required"
                    class="form-control">
                </div>
                <div class="col-md-12 form-group">
                  <label class="form-control-label">メモ欄</label>
                  <textarea name="memo" class="form-control display-7"></textarea>
                </div>
                <div class="col-md-12 form-group">
                  <label class="form-control-label">更新者</label>
                  <p></p>
                </div>
                <div class="col-md-12 align-center">
                  <button type="submit" class="btn btn-primary btn-form display-4">登録</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>
    <!-- 共通パーツ（フッター）読み込み -->
    <jsp:include page="common/footer.jsp"/>
  </body>
</html>