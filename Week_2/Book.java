
enum BookMedium
{
    PhysicalBook, EBook, AudioBook;
}
enum BookGenre
{
    Fiction, NonFiction;
}
enum BookRating
{
    Rating1, Rating2, Rating3, Rating4, Rating5;
}

class Book
{
    private String title;
    private String author;
    private int publish_date;
    private int read_date;
    private BookMedium medium;
    private BookGenre genre;
    private BookRating rating;

    public Book(String title, String author, BookGenre genre)
    {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public Book(String title, String author, BookGenre genre, int published)
    {
        this.title = title;
        this.author = author;
        this.publish_date = published;
        this.genre = genre;
    }

    public Book(String title, String author, BookGenre genre, int published, int read, BookMedium medium, BookRating rating)
    {
        this.title = title;
        this.author = author;
        this.publish_date = published;
        this.read_date = read;
        this.medium = medium;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle()
    {
        return this.title;
    }
    public String getAuthor()
    {
        return this.author;
    }
    public int getPublishedDate()
    {
        return this.publish_date;
    }
    public int getReadDate()
    {
        return this.read_date;
    }
    public BookMedium getMedium()
    {
        return this.medium;
    }
    public BookGenre getGenre()
    {
        return this.genre;
    }
    public BookRating getRating()
    {
        return this.rating;
    }



    public void setTitle(String title)
    {
        this.title = title;
    }
    public void setAuthor(String author)
    {
        this.author = author;
    }
    public void setPublishedDate(int published)
    {
        this.publish_date = published;
    }
    public void setReadDate(int read)
    {
        this.read_date = read;
    }
    public void setMedium(BookMedium medium)
    {
        this.medium = medium;
    }
    public void setGenre(BookGenre genre)
    {
        this.genre = genre;
    }
    public void setRating(BookRating rating)
    {
        this.rating = rating;
    }

    public String toString()
    {
        if (this.rating != null)
        {
            String rating_string = this.rating.toString();
            char rate = rating_string.charAt(rating_string.length() - 1);
            return this.title + " by " + this.author + " (" + this.publish_date + ") - read in " + this.read_date + ", rated " + rate + "/5";
        } else if (this.publish_date != 0) {
            return this.title + " by " + this.author + " (" + this.publish_date + ")";
        } else {
            return this.title + " by " + this.author;
        }
    }

    public static void main(String[] args)
    {   //Instances of Book
        Book b1 = new Book("Children of Time", "Adrian Tchaikovsky", BookGenre.Fiction);
        System.out.println(b1);

        Book b2 = new Book("The Fifth Season", "N. K. Jemesin", BookGenre.Fiction, 2015);
        System.out.println(b2);
        
        Book b3 = new Book("Perdido Street Station", "China Mieville",
        BookGenre.Fiction, 2000, 2020, BookMedium.EBook, BookRating.Rating5);
        System.out.println(b3);      

        System.out.println(b1.getTitle());
        System.out.println(b1.getAuthor());
        System.out.println(b1.getGenre());
        System.out.println(b3.getRating());
        System.out.println(b2.getPublishedDate());
        System.out.println(b3.getReadDate());
        System.out.println(b3.getMedium());
        System.out.println(b3.getRating());
        b1.setReadDate(12);
        System.out.println(b1.getReadDate());
    }
}
