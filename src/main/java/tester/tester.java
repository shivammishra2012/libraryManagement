package tester;

import Id.IdGenerator;
import authenticator.UserAuthenticator;
import book.BookCopy;
import book.BookDetails;
import library.Library;
import searcher.*;
import user.Member;

import java.util.Date;
import java.util.List;


public class tester {

    public List<BookCopy> SearchByBookName(String bookName)
    {
        if(bookName==null)
        {
            throw new IllegalArgumentException("book cannot be null");
        }
        BookSearcher bookSearcher=new NameBasedSeacher( bookName) ;
        return bookSearcher.search();

    }

    public List<BookCopy>SearchByAuthorName(String authorName)
    {
        if(authorName==null)
        {
            throw new IllegalArgumentException("authorName cannot be null");
        }
        BookSearcher bookSearcher=new authorBasedSearcher(authorName);
        return bookSearcher.search();
    }
    public List<Member>SearchMemberByMemberName(String memberName,String adminToken) throws IllegalAccessException {
        // authentication and authorisation
        if(!UserAuthenticator.isAdmin(adminToken))
        {
            throw new IllegalAccessException("operation forbidden");
        }
        MemberSearcher memberSearcher=new NameBasedMemberSearcher(memberName);
        return memberSearcher.search();

    }
    public void addBook(String bookName, Date PublicationDate, List<String> authors, String token) throws IllegalAccessException {
            if(!UserAuthenticator.isAdmin(token))
            {
                throw new IllegalAccessException("operation forbidden");
            }
            /** validation based seracher **/
         BookCopy bookCopy=  new BookCopy(new BookDetails(bookName,PublicationDate,authors), IdGenerator.getUniqueId());
         // new Library().addBookCopy(bookCopy);
    }
    public void deleteBook(int bookCopyId,String adminToken)
    {
        if(bookCopyId<=0 || adminToken==null|| adminToken.length()==0 )
        {
            throw new IllegalArgumentException("bookcopyid/admintoken cannot be null or empty");
        }
       BookSearcher bookSearcher= new IdBasedBookSearcher(bookCopyId);
        List<BookCopy> bookCopies=bookSearcher.search();
        if(bookCopies==null || bookCopies.size()==0)
        {
            throw new RuntimeException(" No book Copies is availabel");
        }
        new Library().deleteBookCopy(bookCopies.get(0));
    }

    public void blockMember(int memberId,String adminToken) throws IllegalAccessException {
        if(memberId<=0 || adminToken==null|| adminToken.length()==0 )
        {
            throw new IllegalAccessException("operation forbidden");
        }
        MemberSearcher memberSearcher=new IdBasedMemberSearcher(memberId);
        List<Member>members=memberSearcher.search();
        if(members==null || members.size()==0)
        {
            throw new RuntimeException(" No memebers  is available");

        }

        new Library().blockMember(members.get(0));

    }

    public void issueBook(int memberId,int bookId,String adminToken)
    {
        // params validation

        BookSearcher bookSearcher=new IdBasedBookSearcher(bookId);
        List<BookCopy> bookCopies=bookSearcher.search();
        if(bookCopies==null || bookCopies.size()==0)
        {
            throw new RuntimeException(" No book Copies is availabel");
        }
        MemberSearcher memberSearcher=new IdBasedMemberSearcher(memberId);
        List<Member> members=memberSearcher.search();
        if(members==null || members.size()==0)
        {
            throw new RuntimeException(" No member retrieved for given id");
        }
        new Library().issueBook(bookCopies.get(0),members.get(0));


    }

    public void submitBook(int memberId,int bookId,String adminToken)
    {

    }
    public Member getBorrowerOfBook(int bookCopyId,String adminToken)
    {

        return null;
    }
    public List<BookCopy> getBooksBorrowedByMember(int memberId,String adminToken)
    {

        return null;
    }
}