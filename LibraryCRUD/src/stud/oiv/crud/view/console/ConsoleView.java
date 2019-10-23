package stud.oiv.crud.view.console;

import stud.oiv.crud.beans.Book;
import stud.oiv.crud.beans.Librarian;
import stud.oiv.crud.beans.User;
import stud.oiv.crud.service.factory.ServiceFactory;

import java.util.Scanner;

public class ConsoleView {

    public void Show() {
        boolean exitFlag = false;
        Scanner scanner = new Scanner(System.in);

        while (!exitFlag) {
            System.out.println("What are you want to do?");
            System.out.println("1. See book list");
            System.out.println("2. See member list");
            System.out.println("3. See librarian list");
            System.out.println("4. Exit");

            String chosenNumber = scanner.nextLine();

            switch (chosenNumber) {
                case "1": {
                    ShowBooks();
                    break;
                }
                case "2": {
                    ShowMembers();
                    break;
                }
                case "3": {
                    ShowLibrarians();
                    break;
                }
                case "4": {
                    exitFlag = true;
                    break;
                }
                default: {
                    System.out.println("Incorrect value!");
                }
            }
        }

    }

    public void ShowBooks(){
        boolean endOfAction = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Book List");
        while (!endOfAction) {
            System.out.println("What are you want to do?");
            System.out.println("1. Edit book");
            System.out.println("2. Delete book");
            System.out.println("3. Create book");
            System.out.println("4. Sort by ascending");
            System.out.println("5. Sort by descending");
            System.out.println("6. Exit");


            String chosenNumber = scanner.nextLine();

            switch (chosenNumber) {
                case "1": {
                    System.out.println("Enter book type: ");
                    String bookType = scanner.nextLine();
                    System.out.println("Enter book id: ");
                    int bookId = scanner.nextInt();
                    BookView bookView = BookViewFactory.GetView(bookType);
                    if(bookView == null)
                    {
                        System.out.println("Incorrect book type");
                        continue;
                    }
                    Book book = bookView.ShowCreateWindow();
                    ServiceFactory.getInstance().getLibraryService().update(bookId,book);
                    break;
                }
                case "2": {
                    System.out.println("Enter book id: ");
                    int bookId = scanner.nextInt();
                    ServiceFactory.getInstance().getLibraryService().deleteBookById(bookId);
                    break;
                }
                case "3": {
                    System.out.println("Enter book type: ");
                    String bookType = scanner.nextLine();
                    BookView bookView = BookViewFactory.GetView(bookType);
                    if(bookView == null)
                    {
                        System.out.println("Incorrect book type");
                        continue;
                    }
                    Book book = bookView.ShowCreateWindow();
                    ServiceFactory.getInstance().getLibraryService().addBook(book);
                    break;
                }
                case "4": {
                    break;
                }
                case "5": {
                    break;
                }
                case "6":
                    {
                        endOfAction = true;
                        break;
                    }
                default: {
                    System.out.println("Incorrect value!");
                }
            }
        }
    }

    public void ShowMembers(){
        System.out.println("User List");
        boolean endOfAction = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("User List");
        while (!endOfAction) {
            System.out.println("What are you want to do?");
            System.out.println("1. Edit User");
            System.out.println("2. Delete User");
            System.out.println("3. Create User");
            System.out.println("4. Add book to user");
            System.out.println("5. Delete book from user");
            System.out.println("6. Exit");


            String chosenNumber = scanner.nextLine();

            switch (chosenNumber) {
                case "1": {
                    System.out.println("Enter user id: ");
                    int userId = scanner.nextInt();
                    User user = UserView.Show();
                    ServiceFactory.getInstance().getUserService().updateUser(userId,user);
                    break;
                }
                case "2": {
                    System.out.println("Enter user id: ");
                    int userId = scanner.nextInt();
                    ServiceFactory.getInstance().getUserService().deleteUserById(userId);
                    break;
                }
                case "3": {
                    User user = UserView.Show();
                    ServiceFactory.getInstance().getUserService().addUser(user);
                    break;
                }
                case "4": {
                    break;
                }
                case "5": {
                    break;
                }
                case "6":
                {
                    endOfAction = true;
                    break;
                }
                default: {
                    System.out.println("Incorrect value!");
                }
            }
        }
    }

    public void ShowLibrarians(){
        System.out.println("Librarian List");
        boolean endOfAction = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Librarian List");
        while (!endOfAction) {
            System.out.println("What are you want to do?");
            System.out.println("1. Edit Librarian");
            System.out.println("2. Delete Librarian");
            System.out.println("3. Create Librarian");
            System.out.println("4. Exit");

            String chosenNumber = scanner.nextLine();

            switch (chosenNumber) {
                case "1": {
                    System.out.println("Enter librarian  id: ");
                    int librarianId = scanner.nextInt();
                    Librarian librarian = LibrarianView.ShowCreateWindow();
                    ServiceFactory.getInstance().getLibrarianService().updateLibrarian (librarianId,librarian );
                    break;
                }
                case "2": {
                    System.out.println("Enter librarian  id: ");
                    int librarianId = scanner.nextInt();
                    ServiceFactory.getInstance().getLibrarianService().deleteLibrarianById(librarianId);
                    break;
                }
                case "3": {
                    Librarian librarian = LibrarianView.ShowCreateWindow();
                    ServiceFactory.getInstance().getLibrarianService().addLibrarian (librarian );
                    break;
                }
                case "4":
                {
                    endOfAction = true;
                    break;
                }
                default: {
                    System.out.println("Incorrect value!");
                }
            }
        }
    }



}