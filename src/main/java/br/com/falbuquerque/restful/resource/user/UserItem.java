package br.com.falbuquerque.restful.resource.user;

import java.util.Map;

import br.com.falbuquerque.restful.resource.Item;

/**
 * Item representing a simple user.
 * 
 * @author Felipe Albuquerque
 */
public class UserItem extends Item {

    /**
     * Links pointed by this type of item.
     * 
     * @author Felipe Albuquerque
     */
    public static enum Links {
        HISTORY("history"), PRODUCTS("products");

        private final String key;

        private Links(final String key) {
            this.key = key;
        }

        /**
         * Gets the key of the link.
         * 
         * @return the key of the link
         */
        public String key() {
            return key;
        }

    };

    private final Short id;
    private final String name;

    /**
     * Creates the item.
     * 
     * @param rel
     *            the URI referent to this item
     * @param links
     *            the links to which that this item can lead
     * @param id
     *            the user's ID
     * @param name
     *            the user's name
     */
    public UserItem(final String rel, final Map<String, String> links, final Short id, final String name) {
        super(rel, links);
        this.id = id;
        this.name = name;
    }

    /**
     * Gets the user's ID.
     * 
     * @return the user's ID
     */
    public Short getId() {
        return id;
    }

    /**
     * Gets the user's name.
     * 
     * @return the user's name
     */
    public String getName() {
        return name;
    }

}
