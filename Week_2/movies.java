import java.util.Arrays;

enum Genres
{
    Crime, Fiction, Scifi, Horror, TrueStory, Gangster, Lonelilism, Sports;
}
enum Rating
{
 one1, two2, three3, four4, five5;
}

class Movies
{
    private String title;
    private String director;
    private int duration;
    private String mainactor;
    private Rating rating;
    private Genres genre;

    public Movies(String title, String director, int duration, String mainactor, Rating rating, Genres genre)
    {
        this.title = title;
        this.director = director;
        this.duration = duration;
        this.mainactor = mainactor;
        this.rating = rating;
        this.genre = genre;
    }

    public String GetTitle()
    {
        return this.title;
    }
    public String GetDirector()
    {
        return this.director;
    }
    public int duration()
    {
        return this.duration;
    }
    public String mainactor()
    {
        return this.mainactor;
    }
    public Rating rating()
    {
        return this.rating;
    }
    public String toString()
    {
     String rating = this.rating.toString();
     char rate = rating.charAt(rating.length() - 1);
     return ("The movie " + this.title + " is a movie based on " + this.genre + ". The main actor is " + this.mainactor +". It lasts "+ this.duration + " and has "+ rate+ " rating!!!");
    }

    public static void main(String[] args)
    {
        Movies RagingBull = new Movies("Raging Bull", "Martin Scorsese", 146, "Robert De Niro", Rating.four4, Genres.Sports);
        System.out.println(RagingBull);
        System.out.println(RagingBull.GetDirector());
    
    }


}
