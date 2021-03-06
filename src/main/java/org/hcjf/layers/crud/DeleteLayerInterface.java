package org.hcjf.layers.crud;

import org.hcjf.layers.LayerInterface;
import org.hcjf.layers.query.Query;

import java.util.Collection;

/**
 * @author javaito
 */
public interface DeleteLayerInterface<O extends Object> extends LayerInterface {

    /**
     * This method return the resource class of the layer.
     * @return Resource class.
     */
    public Class<O> getResourceType();

    /**
     * This method implements the delete operation over the resource.
     * @param id Id of the instance that gonna be deleted.
     * @return Instance of the resource that was deleted.
     */
    public O delete(Object id);

    /**
     * This method implements the delete operation over a add of the instances.
     * This instances are selected using the query like a filter.
     * @param queryId Id of the query.
     * @return Return the instances deleted.
     */
    public Collection<O> delete(Query.QueryId queryId);

    /**
     * This method implements the delete operation over a add of the instances.
     * This instances are selected using the query like a filter.
     * @param query Query to select the instances to delete.
     * @return Return the instances deleted.
     */
    public Collection<O> delete(Query query);

}
