package comp3350.grocerystoreassistant.persistence;

public class ItemPersistenceException extends RuntimeException {
    public ItemPersistenceException(final Exception cause){
        super(cause);
    }
}
