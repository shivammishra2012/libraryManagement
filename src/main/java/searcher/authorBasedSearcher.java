package searcher;

import book.BookCopy;

import java.util.List;

public class authorBasedSearcher  implements BookSearcher{

    private final String  authorName;

    public authorBasedSearcher(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public List<BookCopy> search() {

        return null;
    }
}
