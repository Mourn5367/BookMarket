package kr.ac.kopo.su.bookmarket.repository;

import kr.ac.kopo.su.bookmarket.domain.Book;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;


// 이거 Book 생성자 자체에 이거 다 입력하도록 하면 굳이 setBook 안해도됨
@Repository
public class BookRepositoryImpl implements BookRepository
{
    public BookRepositoryImpl()
    {
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        listOfBooks.add(setBook(book1,"ISBN_0001","SpringBoot 완전정복",
                BigDecimal.valueOf(35000),"송미영","자바 스프링부트라면서 왜 옛날 자바 스프링 프레임워크의 용어를 쓰는지 나는 모르겠다. 책은 최근에 출판하였지만 사람은 최근에 나오지 않아서 그런가",
                "길벗캠퍼스","IT 교재",1000,"2024/12/31","신규도서","ISBN_0001.jpg"));
        listOfBooks.add(setBook(book2,"ISBN_0002","도둑맞은 집중력",
                BigDecimal.valueOf(13800),"요한하리","집중력의 위기가 곧 재앙인 이유와 집중력을 훔쳐 가는 도둑들에 관한 이야기를 거쳐 책은 우리의 집중력을 되찾기 위한 방법으로 향한다. 저자의 제안은 대담하게 사회 전체의 구조를 저격한다. \"주 4일제가 필요하다.\" 맥락 없이 들으면 의아한 해결책이지만 책을 집중력 있게 읽었다면 충분히 납득 가능하다. 이 놀라운 결론을 함께 주장하기 위해, 쇼츠와 톡과 타임라인에 중독된 모든 이들에게 이 책을 권한다.",
                "어크로스","사회 과학",444,"2023/04/28","중고도서","ISBN_0002.jpg"));
        listOfBooks.add(setBook(book3,"ISBN_0003","도둑맞은 손",
                BigDecimal.valueOf(18000),"장 피에르 보","프랑스에서 생명윤리법이 제정된 1994년 직전에, 생명윤리에 대한 논쟁을 촉발하려는 목적으로 출간된 책이다. 저자는 산업화와 생명공학의 폭발적 발전, 공공 보건 개념과 사회보장 제도의 도입, 몸을 대상화하는 대중문화와 자본주의의 강력한 작동하에 몸과 관련된 쟁점들이 점점 더 첨예해지고 있는 현대의 지형을 촘촘히 그려나가며 결국 생명의 현현(顯現)이자 주체인 ‘인간’이란 무엇인지, 인간을 이렇게 정의하고 해석하는 이 ‘사회’는 무엇인지를 묻고 있다.",
                "이음","교양 철학",777,"2019/09/06","신규도서","ISBN_0003.jpg"));
    }

    private List<Book> listOfBooks  = new ArrayList<Book>();
    @Override
    public List<Book> getAllBookList() {
        return listOfBooks;
    }

    @Override
    public Book getBookById(String bookId)
    {
        Book bookInfo = null;
        for (Book book : listOfBooks)
        {
            if (book != null && book.getBookId() != null && book.getBookId().equals(bookId))
            {
                bookInfo = book;
                break;
            }
        }

        if (bookInfo == null)
        {
            throw new IllegalArgumentException("도서 ID가 \""+bookId + "\" 인 도서는 없습니다.");
        }

        return bookInfo;
    }

    @Override
    public List<Book> getBookListByCategory(String category)
    {
        List<Book> booksByCategory = new ArrayList<>();
        for (Book book : listOfBooks)
        {
            if (book.getCategory() != null && book.getCategory().equals(category))
            {
                booksByCategory.add(book);
            }
        }
        return booksByCategory;
    }

    @Override
    public Set<Book> getBookListByFilter(Map<String, List<String>> filter)
    {
        Set<Book> booksByPublisher = new HashSet<>();
        Set<Book> booksByCategory = new HashSet<>();
        Set<String> booksByFilter = filter.keySet();

        if (booksByFilter.contains("publisher"))
        {
            for ( int i = 0; i < filter.get("publisher").size(); i++)
            {
                String publisherName = filter.get("publisher").get(i);
                for (Book book : listOfBooks)
                {
                    if(publisherName.equalsIgnoreCase(book.getPublisher()))
                    {
                        booksByPublisher.add(book);

                    }
                }
            }
        }

        if (booksByFilter.contains("category"))
        {
            for (int i = 0; i < filter.get("category").size(); i++) {
                String categoryName = filter.get("category").get(i);
                List<Book> list = getBookListByCategory(categoryName);
                booksByCategory.addAll(list);
            }
        }
        // 저장된 요소에서 같은 값만 남기고 나머지는 제거 retainAll
        booksByCategory.retainAll(booksByPublisher);

        return booksByCategory;
    }

    @Override
    public void setNewBook(Book book)
    {
        listOfBooks.add(book);
    }

    public Book setBook(Book newBook, String bookId, String name,
                        BigDecimal unitPrice, String author,
                        String description, String publisher,
                        String category, long unitsInStock,
                        String releaseDate, String condition,
                        String fileName)
    {
        newBook.setBookId(bookId);
        newBook.setName(name);
        newBook.setUnitPrice(unitPrice);
        newBook.setAuthor(author);
        newBook.setDescription(description);
        newBook.setPublisher(publisher);
        newBook.setCategory(category);
        newBook.setUnitsInStock(unitsInStock);
        newBook.setReleaseDate(releaseDate);
        newBook.setCondition(condition);
        newBook.setFileName(fileName);
        return newBook;
    }



}
