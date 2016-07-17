package org.hcjf.layers.query;

/**
 * @author javaito
 * @mail javaito@gmail.com
 */
public class Distinct extends Evaluator {

    public Distinct(String fieldName, Object value) {
        super(fieldName, value);
    }

    @Override
    protected boolean evaluate(Object object) {
        return false;
    }

}