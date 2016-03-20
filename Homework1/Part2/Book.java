public class Book {
    //Some members here.
    String[] books = {"Java", "WebEngineering", "C"};
    boolean isBook (String course) {
        for (int i = 0; i < books.length; i++) {
            if (course.equals(books[i])){
                return true;
            }
        }
        return false;
    }
}