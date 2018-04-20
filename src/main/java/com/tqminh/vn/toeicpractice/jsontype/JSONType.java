package com.tqminh.vn.toeicpractice.jsontype;

import java.io.IOException;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.HibernateException;
import org.hibernate.boot.registry.classloading.internal.ClassLoaderServiceImpl;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.SerializationException;
import org.hibernate.usertype.DynamicParameterizedType;
import org.hibernate.usertype.UserType;
import org.postgresql.util.PGobject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import antlr.collections.List;

public class JSONType implements UserType, DynamicParameterizedType {

    static final class CollectionFactory {
        @SuppressWarnings("unchecked")
        static <E, T extends Collection<E>> T newInstance(
            final Class<T> collectionClass) {
            if (List.class.isAssignableFrom(collectionClass)) {
                return (T) new ArrayList<E>();
            }
            else if (Set.class.isAssignableFrom(collectionClass)) {
                return (T) new HashSet<E>();
            }
            else {
                throw new IllegalArgumentException(
                    "Unsupported collection type : " + collectionClass);
            }
        }
    }

    public static final String CLASS = "CLASS";

    private static final ClassLoaderService classLoaderService = new ClassLoaderServiceImpl();

    public static final String JSONB_TYPE = "jsonb";

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private Class<?> jsonClassType;

    @Override
    public Object assemble(final Serializable cached, final Object owner)
            throws HibernateException {
        return this.deepCopy(cached);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object deepCopy(final Object value) throws HibernateException {

        if (!(value instanceof Collection<?>)) {
            return value;
        }

        Collection<?> collection = (Collection<?>) value;
        Collection<Object> collectionClone = CollectionFactory
            .newInstance(collection.getClass());

        collectionClone.addAll(
            collection.stream().map(this::deepCopy)
                .collect(Collectors.toList()));

        return collectionClone;
    }

    @Override
    public Serializable disassemble(final Object value)
            throws HibernateException {
        Object deepCopy = this.deepCopy(value);

        if (!(deepCopy instanceof Serializable)) {
            throw new SerializationException(
                String.format("%s is not serializable class", value), null);
        }

        return (Serializable) deepCopy;
    }

    @Override
    public boolean equals(final Object x, final Object y)
            throws HibernateException {
        if (x == y) {
            return true;
        }

        if ((x == null) || (y == null)) {
            return false;
        }

        return x.equals(y);
    }

    @Override
    public int hashCode(final Object x) throws HibernateException {
        assert (x != null);
        return x.hashCode();
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Object nullSafeGet(
        final ResultSet resultSet,
        final String[] names,
        final SessionImplementor session,
        final Object owner) throws HibernateException, SQLException {
        try {
            final String json = resultSet.getString(names[0]);
            return json == null ? null
                    : objectMapper.readValue(json, this.jsonClassType);
        }
        catch (IOException e) {
            throw new HibernateException(e);
        }
    }

    @Override
    public void nullSafeSet(
        final PreparedStatement st,
        final Object value,
        final int index,
        final SessionImplementor session)
            throws HibernateException, SQLException {
        try {
            final String json = value == null ? null
                    : objectMapper.writeValueAsString(value);
            PGobject pgo = new PGobject();
            pgo.setType(JSONB_TYPE);
            pgo.setValue(json);
            st.setObject(index, pgo);
        }
        catch (JsonProcessingException e) {
            throw new HibernateException(e);
        }
    }

    @Override
    public Object replace(
        final Object original,
        final Object target,
        final Object owner) throws HibernateException {
        return this.deepCopy(original);
    }

    @Override
    public Class<Object> returnedClass() {
        return Object.class;
    }

    @Override
    public void setParameterValues(final Properties parameters) {
        final String clazz = (String) parameters.get(CLASS);
        this.jsonClassType = classLoaderService.classForName(clazz);
    }

    @Override
    public int[] sqlTypes() {
        return new int[] { Types.JAVA_OBJECT };
    }
}
