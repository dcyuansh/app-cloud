package com.core.model;

import com.core.utils.StringUtils;
import com.core.utils.converter.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author spring.yuan
 * @version 1.0
 */
public class DataModel implements Map<String, Object>, Serializable {

    private Map<String, Object> fieldMap;


    public DataModel() {
        fieldMap = new LinkedHashMap<>();
    }

    public DataModel(Map<String, Object> fieldMap) {
        this.fieldMap = new LinkedHashMap<>();
        if (fieldMap != null) {
            for (String key : fieldMap.keySet()) {
                this.put(key, fieldMap.get(key), true, false);
            }
        }
    }

    @Override
    public Object put(String key, Object value) {
        return put(key, value, true, true);
    }

    public Object put(Object key, Object value, boolean needTranslateValue, boolean needFormatFieldName) {
        String name = String.valueOf(key);
        if (needFormatFieldName) {
            name = StringUtils.formatFieldName(name);
        }
        Object resultObject = value;
        if (needTranslateValue) {
            resultObject = StringUtils.translateValue(value);
        }
        fieldMap.put(name, resultObject);
        return resultObject;
    }

    public void setFieldValue(String name, Object value) {
        put(name, value, false, false);
    }

    public Object getFieldValue(String name) {
        return fieldMap.get(name);
    }

    public String getStringValue(String name) {
        return (String) StringConverter.convert(getFieldValue(name));
    }

    public Integer getIntegerValue(String name) {
        return (Integer) IntegerConverter.convert(getFieldValue(name));
    }

    public Float getFloatValue(String name) {
        return (Float) FloatConverter.convert(getFieldValue(name));
    }

    public Long getLongValue(String name) {
        return (Long) LongConverter.convert(getFieldValue(name));
    }

    public Double getDoubleValue(String name) {
        return (Double) DoubleConverter.convert(getFieldValue(name));
    }

    public BigDecimal getBigDecimalValue(String name) {
        return (BigDecimal) BigDecimalConverter.convert(getFieldValue(name));
    }

    public Date getDateValue(String name) {
        return (Date) DateConverter.convert(getFieldValue(name));
    }

    public LocalDate getLocalDateValue(String name) {
        return (LocalDate) LocalDateConverter.convert(getFieldValue(name));
    }

    public LocalDateTime getLocalDateTimeValue(String name) {
        return (LocalDateTime) LocalDateTimeConverter.convert(getFieldValue(name));
    }

    public boolean hasField(String name) {
        return fieldMap.containsKey(name);
    }

    public boolean hasFieldValue(String name) {
        return hasField(name) && getFieldValue(name) != null;
    }

    public void removeField(String name) {
        fieldMap.remove(name);
    }

    @Override
    public int size() {
        return fieldMap.size();
    }

    @Override
    public boolean isEmpty() {
        return fieldMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return fieldMap.containsValue(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return fieldMap.containsValue(value);
    }

    @Override
    public Object get(Object key) {
        return fieldMap.get(key);
    }

    @Override
    public Object remove(Object key) {
        return fieldMap.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ?> m) {
        fieldMap.putAll(m);
    }

    @Override
    public void clear() {
        fieldMap.clear();
    }

    @Override
    public Set<String> keySet() {
        return fieldMap.keySet();
    }

    @Override
    public Collection<Object> values() {
        return fieldMap.values();
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
        return fieldMap.entrySet();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataModel dataModel = (DataModel) o;
        return Objects.equals(fieldMap, dataModel.fieldMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldMap);
    }
}
