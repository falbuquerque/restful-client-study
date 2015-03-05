package br.com.falbuquerque.restful.resource;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * A generic item in a resource.
 * 
 * @author Felipe Albuquerque
 */
public abstract class Item {

    private final String rel;
    private final Map<String, String> links;
    private Resource<? extends Item> resource;

    /**
     * Creates the item.
     * 
     * @param rel
     *            the URI referent to this item
     * @param links
     *            the links to which that this item can lead
     */
    public Item(final String rel, final Map<String, String> links) {
        this.rel = rel;
        this.links = links;
    }

    /**
     * Gets the URI referent to this item.
     * 
     * @return the URI referent to this item
     */
    public String getRel() {
        return rel;
    }

    /**
     * Gets the links to which that this item can lead.
     * 
     * @return the links to which that this item can lead
     */
    public Map<String, String> getLinks() {
        return links;
    }

    /**
     * Gets the resource that contains this item.
     * 
     * @return the resource that contains this item
     */
    public Resource<? extends Item> getResource() {
        return resource;
    }

    /**
     * Gets the URL to a link pointed by this resource.
     * 
     * @param linkKey
     *            the key of the link
     * @return the URL to the link with the given key or <code>null</code> if
     *         there is no link with the given key
     * @throws MalformedURLException
     *             when the URL formed by the link is invalid. In this case,
     *             mind checking:
     *             <ul>
     *             <li>if {@link Resource#getBaseUrl()} is a valid URL</li>
     *             <li>if {@link Item#getRel()} is a valid URI</li>
     *             <li>if the value to the link key in {@link Item#getLinks()}
     *             is a valid URI</li>
     *             </ul>
     */
    public URL getURL(final String linkKey) throws MalformedURLException {

        if ((resource != null) && (links != null) && links.containsKey(linkKey)) {
            return new URL(resource.getBaseUrl() + rel + links.get(linkKey));
        }

        return null;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Defines the resource that contains this item.
     * 
     * @param resource
     *            the resource that contains this item
     */
    void setResource(Resource<? extends Item> resource) {
        this.resource = resource;
    }
}
