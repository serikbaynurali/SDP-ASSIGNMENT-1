public class Main {
    public static void main(String[] args) {

        LibraryResource customBook = new LibraryResourceBuilder("RES-001", "Clean Code", "Robert C. Martin")
                .setIsbn("978-0132350884")
                .setPublishedDate("2008-12-12")
                .setMaxborrowDays(21)
                .build();

        LibraryResourceDirector director = new LibraryResourceDirector();
        LibraryResourceBuilder builder = new LibraryResourceBuilder("RES-002", "Design Patterns", "Erich Gamma");

        LibraryResource book = director.constructBook(builder);

        System.out.println("Custom book max borrow days: " + customBook.getMaxborrowDays());
        System.out.println(customBook.getGenre());
        System.out.println(book);
    }
}
