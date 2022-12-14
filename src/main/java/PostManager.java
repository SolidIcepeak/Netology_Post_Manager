import java.util.Arrays;

public class PostManager {
    private String[] filmNames = new String[0];
    private int lastFilmsCount;

    public PostManager() {

        lastFilmsCount = 10;
    }

    public PostManager(int lastFilmsCount) {
        this.lastFilmsCount = lastFilmsCount;
    }

    public void addNewFilmName(String newFilmName) {
        String[] tmp = new String[filmNames.length + 1];
        for (int i = 0; i < filmNames.length; i++) {
            tmp[i] = filmNames[i];
        }
        tmp[tmp.length - 1] = newFilmName;
        filmNames = tmp;

    }

    public String[] findAllFilms() {
        return filmNames;
    }

    public String[] findLastFilms() {
        if (filmNames.length < lastFilmsCount) {
            return filmNames;
        }
        return Arrays.copyOfRange(filmNames, filmNames.length - lastFilmsCount, filmNames.length);
    }
}

