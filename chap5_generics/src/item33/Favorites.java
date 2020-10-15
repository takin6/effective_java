package item33;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Favorites {
    // Class is generic.
    // String.class is of type Class<String>, and Integer.class is of type Class<Integer>
    private Map<Class<?>, Object> favorites = new HashMap<>();

//    public <T> void putFavorite(Class<T> type, T instance) {
//        favorites.put(Objects.requireNonNull(type), instance);
//    }

    // Achieving runtime type safety with a dynamic cast
    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type) {
        // dynamically casts the object reference to the type represented by the Class object, using Class’s cast method.
        return type.cast(favorites.get(type));
    }

    public static void main(String[] args) {
        Favorites f = new Favorites();
        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorites.class);
        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);
        System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass.getName());
    }
}
