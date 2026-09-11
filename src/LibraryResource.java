public class LibraryResource {
    private String id;
    private String title;
    private String isbn;
    private String author;
    private String publisher;
    private String publishedDate;
    private String genre;
    private int maxborrowDays;


    public LibraryResource(LibraryResourceBuilder builder) {
        this.id = builder.getId();
        this.title = builder.getTitle();
        this.isbn = builder.getIsbn();
        this.author = builder.getAuthor();
        this.publisher = builder.getPublisher();
        this.publishedDate = builder.getPublishedDate();
        this.genre = builder.getGenre();
        this.maxborrowDays = builder.getMaxborrowDays();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getGenre() {
        return genre;
    }

    public int getMaxborrowDays() {
        return maxborrowDays;
    }

    @Override
    public String toString() {
        return "LibraryResource{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", maxBorrowDays=" + maxborrowDays +
                '}';
    }
}
