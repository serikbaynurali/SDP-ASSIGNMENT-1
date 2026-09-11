public class LibraryResourceDirector {
    public LibraryResource constructRareArchivalBook(LibraryResourceBuilder builder){
        return builder.setMaxborrowDays(0)
                .build();}

    public LibraryResource constructBook(LibraryResourceBuilder builder){
        return builder.setMaxborrowDays(30)
                .build();

    }
}
