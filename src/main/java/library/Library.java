package library;

import book.BookCopy;
import dataaccessor.DBAccessor;
import dataaccessor.Results;
import user.Member;

import java.util.List;

public class Library {

    private final DBAccessor dbAccessor;

    public Library() {
        this.dbAccessor = dbAccessor;
    }

    public void addBookCopy(BookCopy bookCopy)
    {
        if(bookCopy==null)
        {
            //
        }
        dbAccessor.insertBookCopy(bookCopy);


    }

    // use synchronized keyword to avoid context switch between two thread

    public synchronized void deleteBookCopy(BookCopy bookCopy)
    {

        // check if bookcopy availabe
        // deletion

        if(dbAccessor.isCopyAvailable(bookCopy))
        {
            dbAccessor.deleteBookCopy(bookCopy);
        }

    }

    public void blockMember(Member member)
    {

    }
    public void issueBook(BookCopy bookCopy,Member member )
    {

    }
    public void submitBook(BookCopy bookCopy,Member member)
    {

    }
    public Member getBorrower(BookCopy bookCopy)
    {
        Results results=dbAccessor.getBorrower(bookCopy);

        //return ResultsConverter.convertToMember(results);
        return null;
    }

    public List<BookCopy> getBorrowedBooks(Member member)
    {

        return null;
    }
}
