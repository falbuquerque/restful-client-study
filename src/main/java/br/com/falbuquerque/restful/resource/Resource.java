package br.com.falbuquerque.restful.resource;

import java.util.Collection;
import java.util.Collections;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * A RESTful resource.
 * 
 * @param <T>
 *            the type of item the resource contains
 * 
 * @author Felipe Albuquerque
 */
public class Resource<T extends Item> {

    private final String baseUrl;
    private final String rel;
    private final Collection<T> items;
    private final T item;

    /**
     * Creates a resource.
     * 
     * @param baseUrl
     *            the base URL to access the resources
     * @param rel
     *            the URI referent to this resource
     * @param item
     *            the item contained in this resource
     */
    public Resource(final String baseUrl, final String rel, final T item) {
        this(baseUrl, rel, Collections.emptyList(), item);
    }

    /**
     * Creates a resource.
     * 
     * @param baseUrl
     *            the base URL to access the resources
     * @param rel
     *            the URI referent to this resource
     * @param items
     *            the items contained in this resource
     */
    public Resource(final String baseUrl, final String rel, final Collection<T> items) {
        this(baseUrl, rel, items, null);
    }

    /**
     * Creates a resource.
     * 
     * @param baseUrl
     *            the base URL to access the resources
     * @param rel
     *            the URI referent to this resource
     * @param items
     *            the items contained in this resource. Only one between item or
     *            items should be filled in the resource
     * @param item
     *            the item contained in this resource. Only one between item or
     *            items should be filled in the resource
     */
    private Resource(final String baseUrl, final String rel, final Collection<T> items, final T item) {

        if ((item != null) && ((items != null) && !items.isEmpty())) {
            throw new IllegalArgumentException("Only one between item or items should be filled in the resource");
        }

        this.baseUrl = baseUrl;
        this.rel = rel;
        this.items = items;
        this.item = item;
    }

    /**
     * Gets the base URL to access the resources.
     * 
     * @return the base URL to access the resources
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * Gets the URI referent to this resource.
     * 
     * @return the URI referent to this resource
     */
    public String getRel() {
        return rel;
    }

    /**
     * Gets the items contained in this resource.
     * 
     * @return the items contained in this resource
     */
    public Collection<T> getItems() {
        return Collections.unmodifiableCollection(items);
    }

    /**
     * Gets the item contained in this resource.
     * 
     * @return the item contained in this resource
     */
    public T getItem() {
        return item;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
