package actions;

public class LoginAction{
    //判断是否为合法用户
    public boolean isLogin(String username,String userpassword){
        if("z".equals(username)&&"1234".equals(userpassword)){
            System.out.print("access"+username+userpassword);
            return true;
        }else{
            System.out.print("denied:"+username+userpassword);
            return false;
        }
    }

}
