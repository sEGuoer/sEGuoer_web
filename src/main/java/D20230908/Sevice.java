package D20230908;

public interface Sevice {
    public default String userLogin(String email, String password){return "";}
    public default String userRegister(String email, String password, String account,  boolean IsVerifyCodeCorrect) {return "";}
    public default String mdFileToHtmlFile(String resource,String title ,String content){return "";}
}
