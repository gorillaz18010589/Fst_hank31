package tw.brad.apps.brad31;

public class Member {
    private  String title;
    private  int icon; //頭象
    private boolean isVIP;//開關屬性
    //屬性封裝用建構式帶進來
    public  Member(String title , int icon){
        this.icon = icon;
        this.title = title;
        this.isVIP = (int)(Math.random()*2)==0;//亂數不是0就是1亂數取得有無匯元
    }
    //會員取得方法
    public  String getTitle(){return  title;} //取得title方法
    public  int getIcon(){return  icon;} //取得頭象方法
    public boolean isVIP(){return isVIP;} //取得vip方法
    public void setVIP(boolean isVIP){this.isVIP = isVIP;}//人家有調整可以改vip

}
