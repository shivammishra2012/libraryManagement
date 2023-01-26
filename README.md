# libraryManagement

Requirements
Books have the following information:

Unique id
Title
Author
Publication Date
There can be multiple copies of the same book (book items). Each book item has a unique barcode.

There can be 2 types of users:

Librarians - Can add and remove books, book items and users, search the catalog (by title, author or publication date). Can also checkout, renew and return books.
General members - can search the catalog (by title, author or publication date), as well as check-out, renew, and return a book.
Each user has a unique barcode and a name.

Also, we have the following limitations:

A member can checkout at most 3 books
A member can keep a book at most 20 days.
The system should be able to calculate the fine for the users who return the books after the expected deadline.
