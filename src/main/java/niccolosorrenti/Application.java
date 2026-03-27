package niccolosorrenti;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import niccolosorrenti.dao.CatalogoDAO;
import niccolosorrenti.entities.Libro;

public class Application {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("catalogobibliograficopu");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CatalogoDAO catalogoDAO = new CatalogoDAO(entityManager);

        Libro libro = new Libro(1234, "Titolo1", 2026, 100, "Autore1", "Sportivo");

//        catalogoDAO.aggiuntaElementoCatalogo(libro);
//        catalogoDAO.ricercaPerISBN(12345);
//        catalogoDAO.ricercaPerISBN(1234);
//        catalogoDAO.rimozionePerISBN(12345);
        catalogoDAO.rimozionePerISBN(1234);

    }
}
