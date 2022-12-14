import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostManagerTest {

    PostManager createDefaultPostManager() {
        PostManager service = new PostManager();
        service.addNewFilmName("Бладшот");
        service.addNewFilmName("Вперёд");
        service.addNewFilmName("Отель \"Белград\"");
        service.addNewFilmName("Джентельмены");
        service.addNewFilmName("Человек-невидимка");
        service.addNewFilmName("Тролли. Мировой тур");
        service.addNewFilmName("Номер один");
        return service;
    }

    @Test
    void addNewFilmNameTest() {

        PostManager service = createDefaultPostManager();
        String expected = "Бабулех";
        service.addNewFilmName(expected);
        var result = service.findAllFilms();
        Assertions.assertEquals(expected, result[result.length - 1]);
    }

    @Test
    void findAllFilms() {
        PostManager service = createDefaultPostManager();
        String[] expected = {
                "Бладшот",
                "Вперёд",
                "Отель \"Белград\"",
                "Джентельмены",
                "Человек-невидимка",
                "Тролли. Мировой тур",
                "Номер один"};

        String[] actual = service.findAllFilms();
        assertArrayEquals(expected, actual);
    }

    @Test
    void findLastFilms() {
        PostManager service = new PostManager(3);
        service.addNewFilmName("Бладшот");
        service.addNewFilmName("Вперёд");
        service.addNewFilmName("Отель \"Белград\"");
        service.addNewFilmName("Джентельмены");

        String[] expected = {
                "Вперёд",
                "Отель \"Белград\"",
                "Джентельмены",
        };
        String[] actual = service.findLastFilms();
        assertArrayEquals(expected, actual);
    }
}