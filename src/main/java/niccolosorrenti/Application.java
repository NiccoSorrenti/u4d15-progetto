package niccolosorrenti;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import niccolosorrenti.dao.CatalogoDAO;
import niccolosorrenti.dao.PrestitoDAO;
import niccolosorrenti.dao.UtenteDAO;
import niccolosorrenti.entities.*;

import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("catalogobibliograficopu");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CatalogoDAO catalogoDAO = new CatalogoDAO(entityManager);
        UtenteDAO utenteDAO = new UtenteDAO(entityManager);
        PrestitoDAO prestitoDAO = new PrestitoDAO(entityManager);

        Libro libro = new Libro(1234, "TitoloLibro", 2026, 100, "AutoreLibro", "Sportivo");
        Rivista rivista = new Rivista(1235, "TitoloRivista", 2026, 50, TipoRivista.MENISLE);
        Utente utente = new Utente("Niccolò", "Sorrenti", LocalDate.now(), 1);
        Prestito prestito = new Prestito(utente, libro, LocalDate.of(2026, 03, 01), LocalDate.of(2026, 03, 05), LocalDate.of(2026, 03, 20));

//        ------------------ SALVATAGGIO UTENTE ------------------
//        utenteDAO.salvaUtente(utente);

//        ------------------ SALVATAGGIO PRESTITO ------------------
//        prestitoDAO.salvaPrestito(prestito);

//        ------------------ AGGIUNTA ELEMENTI CATALOGO ------------------
//        catalogoDAO.aggiuntaElementoCatalogo(libro);
//        catalogoDAO.aggiuntaElementoCatalogo(rivista);

//        ------------------ RICERCA PER ISBN ------------------
//        catalogoDAO.ricercaPerISBN(12345);
//        catalogoDAO.ricercaPerISBN(1234);

//        ------------------ RIMOZIONE PER ISBN ------------------
//        catalogoDAO.rimozionePerISBN(12345);
//        catalogoDAO.rimozionePerISBN(1234);


//        ------------------ RICERCA PER ANNO ------------------
//        try {
//            List<Catalogo> lista = catalogoDAO.ricercaPerAnno(2026);
//            lista.forEach(System.out::println);
//
//        } catch (NotFoundYearException e) {
//            System.out.println(e.getMessage());
//        }

//        ------------------ RICERCA PER AUTORE ------------------
//        try {
//            List<Libro> lista = catalogoDAO.ricercaPerAutore("Autore2");
//            lista.forEach(System.out::println);
//        } catch (NotFoundAuthorExceptions e) {
//            System.out.println(e.getMessage());
//        }

//        RICERCA PER TITOLO
//        try {
//            List<Catalogo> lista = catalogoDAO.ricercaPerTitolo("ti");
//            lista.forEach(System.out::println);
//        } catch (NotFoundTitleException e) {
//            System.out.println(e.getMessage());
//        }


    }
}
