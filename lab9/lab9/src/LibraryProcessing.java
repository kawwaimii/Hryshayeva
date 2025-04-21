import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class LibraryProcessing {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("library.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList bookList = doc.getElementsByTagName("book");
            System.out.println("Список книг:");

            double totalPrice = 0;
            for (int i = 0; i < bookList.getLength(); i++) {
                Node bookNode = bookList.item(i);
                if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookElement = (Element) bookNode;
                    String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                    String author = bookElement.getElementsByTagName("author").item(0).getTextContent();
                    int year = Integer.parseInt(bookElement.getElementsByTagName("year").item(0).getTextContent());
                    String genre = bookElement.getElementsByTagName("genre").item(0).getTextContent();
                    double price = Double.parseDouble(bookElement.getElementsByTagName("price").item(0).getTextContent());

                    totalPrice += price;

                    System.out.printf("Название: %s, Автор: %s, Год: %d, Жанр: %s, Цена: %.2f%n", title, author, year, genre, price);
                }
            }

            // Средняя цена
            double averagePrice = totalPrice / bookList.getLength();
            System.out.printf("%nСредняя цена книг: %.2f%n", averagePrice);

            // Фильтрация книг по жанру
            String filterGenre = "Сказка"; // Заданный критерий
            System.out.printf("%nФильтрованные книги по жанру '%s':%n", filterGenre);
            for (int i = 0; i < bookList.getLength(); i++) {
                Node bookNode = bookList.item(i);
                if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookElement = (Element) bookNode;
                    String genre = bookElement.getElementsByTagName("genre").item(0).getTextContent();
                    if (genre.equals(filterGenre)) {
                        String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                        String author = bookElement.getElementsByTagName("author").item(0).getTextContent();
                        System.out.printf("Название: %s, Автор: %s%n", title, author);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
