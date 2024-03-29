package org.openflow.util;

/**
 *
 * @author David Erickson (daviderickson@cs.stanford.edu)
 */
public interface Instantiable<E> {

    /**
     * Create a new instance of a given subclass.
     * @return the new instance.
     */
    public E instantiate();
}
