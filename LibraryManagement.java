import java.util.Scanner;

import static java.lang.Thread.sleep;

public class LibraryManagement {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入图书馆当前情况:");
        System.out.print("\t共可收藏书籍数：");
        int BooksNum = sc.nextInt();
        System.out.print("\t现已收藏书籍数：");
        int nowBooksNum = sc.nextInt();
        Library lib = new Library(BooksNum, nowBooksNum);
        System.out.print("请输入所需操作类型\n\t(1)添加图书\n\t(2)删除图书\n\t(3)查询图书\n您所需执行操作为：");
        // 执行用户指定操作
        switch (sc.nextInt()) {
            case 1 -> {
                System.out.print("请输入图书标题：");
                sc.nextLine();
                String title = sc.nextLine();
                System.out.print("请输入图书作者：");
                String author = sc.nextLine();
                System.out.print("请输入图书ISBN码：");
                String ISBN0 = sc.nextLine();
                try {
                    lib.addBook(title, author, ISBN0);
                } catch (DuplicateISBNException e) {
                    System.out.println("图书的ISBN已存在");
                }
            }
            case 2 -> {
                System.out.print("请输入图书ISBN码：");
                sc.nextLine();
                String ISBN1 = sc.nextLine();
                try {
                    lib.removeBook(ISBN1);
                } catch (BookNotFoundException e) {
                    System.out.println("图书不存在");
                }
            }
            case 3 -> {
                System.out.print("请输入图书ISBN码：");
                sc.nextLine();
                String ISBN2 = sc.nextLine();
                Book book = lib.searchBook(ISBN2);
                if (book != null) {
                    System.out.println(book.toString());
                } else System.out.println("图书不存在！");
            }
        }
    }
}
class Book{
    String title;
    String author;
    String ISBN;
    Book(){}
    Book(String title, String author, String ISBN){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }
    public String toString(){
        return ("图书的标题为" + this.title + "图书的作者为" + this.author + "图书的ISBN识别码为" + this.ISBN);
    }
}
class Library {
    int BooksNum;
    int nowBooksNum;
    Book[] books;
    Library(){}
    Library(int BooksNum,int nowBooksNum) throws InterruptedException {
        this.BooksNum = BooksNum;
        this.nowBooksNum = nowBooksNum;
        Book[] books = new Book[BooksNum];
        Scanner sc = new Scanner(System.in);
        // 添加已有图书
        if(nowBooksNum != 0){
            for(int i = 0;i < nowBooksNum; i++){
                System.out.print("请输入图书标题：");
                books[i].title = sc.nextLine();
                System.out.print("请输入图书作者：");
                books[i].author = sc.nextLine();
                System.out.print("请输入图书ISBN：");
                books[i].ISBN = sc.nextLine();
            }
        }
    }

    void addBook(String title, String author, String ISBN) {
        // 添加图书
        for (int i = 0; i < nowBooksNum + 1; i++)
            // 图书已存在时抛出异常
            if (books[i].ISBN.equals(ISBN))
                throw new DuplicateISBNException();
        this.books[nowBooksNum].ISBN = ISBN;
        this.books[nowBooksNum].author = author;
        this.books[nowBooksNum].title = title;
        nowBooksNum += 1;
    }

    void removeBook(String ISBN) {
        // 删除图书
        boolean flag = false;
        int i;
        for (i = 0; i < nowBooksNum; i++)
            if (books[i].ISBN.equals(ISBN)) {
                flag = true;
                break;
            }
        if (!flag)
            throw new BookNotFoundException();
        for (int j = i; j < nowBooksNum; j++)
            this.books[j] = this.books[j + 1];
        nowBooksNum -= 1;
    }

    Book searchBook(String ISBN) {
        // 查询图书
        for (int i = 0; i < nowBooksNum; i++)
            if (books[i].ISBN.equals(ISBN)) {
                return this.books[i];
            }
        return null;
    }
}
class DuplicateISBNException extends RuntimeException{
    DuplicateISBNException(){super();}
    DuplicateISBNException(String message){super(message);}
}
class BookNotFoundException extends RuntimeException{
    BookNotFoundException(){super();}
    BookNotFoundException(String message){super(message);}
}
