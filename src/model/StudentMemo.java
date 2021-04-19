package model;

public class StudentMemo {
    private String studentNumber; // 学生番号
    private String studentName; // 学生名
    private String staffId; // スタッフID
    private String staffName; // スタッフ名
    private String memoId; // メモID
    private String memo; // メモ内容

    public StudentMemo(String studentNumber, String studentName, String staffId, String staffName, String memoId,
            String memo) {
        this.studentNumber = studentNumber;
        this.studentName = studentName;
        this.staffId = staffId;
        this.staffName = staffName;
        this.memoId = memoId;
        this.memo = memo;
    }

    public StudentMemo(String staffId, String staffName) {
        this.staffId = staffId;
        this.staffName = staffName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getMemoId() {
        return memoId;
    }

    public void setMemoId(String memoId) {
        this.memoId = memoId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }



}
