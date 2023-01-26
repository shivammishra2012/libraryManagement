package searcher;

import book.BookCopy;
import dataaccessor.DBAccessor;
import dataaccessor.Results;
import dataaccessor.ResultsConverter;

import java.util.List;

public class NameBasedSeacher implements BookSearcher {

    private final DBAccessor dbAccessor;
    private final String bookName;

    public NameBasedSeacher( String bookName) {
        this.dbAccessor = new DBAccessor();
        this.bookName = bookName;
    }


    @Override
    public List<BookCopy> search() {
        //List<BookCopy> bookcopy=new ArrayList();


        Results results= dbAccessor.getBooksWithName(bookName);
        return ResultsConverter.convertToBookCopies(results);

        //return null;
    }
}
