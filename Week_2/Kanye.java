import java.util.Arrays;

enum Album{
    theCollegeDropout, LateRegristration, Graduation, Heartbreak, MBDTF, Yeezus, TLOP, Ye, JesusisKing, Donda; 
}
enum Genre{
    Rap, Experiemntal, Gospel;
}
enum Features{
    True, False;
}
enum Discog{
    one1, two2, the3, four4, five, six6, seven7, eight8, nine9, ten10;
}
class Kanye{
    String Title;
    int duration;
    Album album;
    Genre genre;
    Features features;

    public Kanye(String Title, int duration, Album album, Genre genre, Features features)
    {
        this.Title = Title;
        this.duration = duration;
        this.album = album;
        this.genre = genre;
        this.features = features;
    }
    public String GetDuration()
    {   
        String new_duration = this.duration + "";
        return ("It is " + new_duration + " seconds in length.");
    }
    public Album GetAlbum()
    {
        return this.album;
    }
    public Genre genre(){
        return this.genre;

    }
    public Features features(){
        return this.features;
    }    
    public String GetTitle()
    {
        return this.Title;
    }
    public String toString()
    {
        if(this.features != false)
        {
        return("The album" + this.Title + " by Kanye West is from " + this.album + ". It lasts " + this.duration + " and it");
        }
    
    }
}