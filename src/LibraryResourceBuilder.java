public class LibraryResourceBuilder {
    private String id;
    private String title;
    private String isbn;
    private String author;
    private String publisher;
    private String publishedDate;
    private String genre;
    private int maxborrowDays = 14;

    public LibraryResourceBuilder(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public LibraryResourceBuilder setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public LibraryResourceBuilder setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public LibraryResourceBuilder setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
        return this;
    }

    public LibraryResourceBuilder setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public LibraryResourceBuilder setMaxborrowDays(int maxborrowDays) {
        this.maxborrowDays = maxborrowDays;
        return this;
    }


    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getIsbn() { return isbn; }
    public String getAuthor() { return author; }
    public String getPublisher() { return publisher; }
    public String getPublishedDate() { return publishedDate; }
    public String getGenre() { return genre; }
    public int getMaxborrowDays() { return maxborrowDays; }

    public LibraryResource build() {
        if (id == null)
            throw new IllegalStateException("id can not be null");
        if (title == null || title.isBlank()) {
            throw new IllegalStateException("Resource Title cannot be null or empty.");
        }
        if (maxborrowDays < 0) {
            throw new IllegalArgumentException("Borrow days cannot be negative.");
        }

        return new LibraryResource(this);
    }
}