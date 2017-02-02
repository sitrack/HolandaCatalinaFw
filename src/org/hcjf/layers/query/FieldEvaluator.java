package org.hcjf.layers.query;

import org.hcjf.utils.Strings;

/**
 * This abstract class define the structure of the evaluating. The evaluator
 * is the implementation of a method to decide if an object is part of the result
 * of the query or not is.
 * @author javaito
 * @mail javaito@gmail.com
 */
public abstract class FieldEvaluator implements Evaluator {

    private final Query.QueryField queryField;
    private final Object value;

    public FieldEvaluator(Query.QueryField queryField, Object value) {
        this.queryField = queryField;
        this.value = value;
    }

    /**
     * Two evaluators are equals when are instances of the same class,
     * his field names are equals and his values are equals
     * @param obj Object to compare.
     * @return True if the instance is equals than object parameter and
     * false in the other ways.
     */
    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        if(obj.getClass().equals(getClass())) {
            FieldEvaluator fieldEvaluator = (FieldEvaluator) obj;
            result = this.queryField.equals(fieldEvaluator.queryField) &&
                    this.value.equals(fieldEvaluator.value);
        }

        return result;
    }

    /**
     * Return the query field associated to the evaluator.
     * @return Query field.
     */
    public Query.QueryField getQueryField() {
        return queryField;
    }

    /**
     * Return the value to compare with the field's object of the data collection's
     * instance.
     * @return Object value.
     */
    public final Object getValue(Object... parameters) {
        Object result = value;
        if(result instanceof UnprocessedValue) {
            result = ((UnprocessedValue)value).process(parameters);
        }
        return result;
    }

    /**
     * Return the class of the original value.
     * @return Class of the original value.
     */
    public final Class getValueType() {
        return value.getClass();
    }

    /**
     * Return the string representation of the evaluator.
     * @return Format: ClassName[fieldName,value]
     */
    @Override
    public String toString() {
        return getClass() + "[" + queryField + "," + value + "]";
    }

    /**
     * This kind of values take the true value in the execution time of the query.
     */
    public interface UnprocessedValue {

        /**
         * Return the processed value.
         * @param parameters Evaluation parameters.
         * @return Processed value.
         */
        public Object process(Object... parameters);

    }

    /**
     * Return the object that is in the specific position into the parameters array.
     */
    public static class ReplaceableValue implements UnprocessedValue {

        private final Integer place;

        public ReplaceableValue(Integer place) {
            this.place = place;
        }

        /**
         * Return the processed value.
         * @param parameters Evaluation parameters.
         * @return Processed value.
         */
        @Override
        public Object process(Object... parameters) {
            if(parameters.length <= place) {
                throw new IllegalArgumentException("Non-specified replaceable value, index " + place);
            }

            return parameters[place];
        }
    }

}
