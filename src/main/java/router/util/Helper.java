package router.util;

// TODO: Auto-generated Javadoc
/**
 * This class isnt the most elegant, but there is no other way to cast String to primitive cells.
 *
 */
public class Helper {

    /**
     * Zero.
     *
     * @param <T> the generic type
     * @param clazz the clazz
     * @return the t
     */
    @SuppressWarnings("unchecked")
    public static <T> T zero(Class<T> clazz) {
        Object o = null;

        if (clazz.isPrimitive())
        {
            if (clazz == Boolean.TYPE)
            {
                o = Boolean.FALSE;
            }
            else if (clazz == Byte.TYPE)
            {
                o = Byte.valueOf((byte) 0);
            }
            else if (clazz == Character.TYPE)
            {
                o = new Character('\0');
            }
            else if (clazz == Double.TYPE)
            {
                o = new Double(0.0);
            }
            else if (clazz == Float.TYPE)
            {
                o = new Float(0.0f);
            }
            else if (clazz == Integer.TYPE)
            {
                o = Integer.valueOf(0);
            }
            else if (clazz == Long.TYPE)
            {
                o = Long.valueOf(0L);
            }
            else if (clazz == Short.TYPE)
            {
                o = Short.valueOf((short) 0);
            }
        }

        return (T) o;

    }

    /**
     * Parses the.
     *
     * @param <T> the generic type
     * @param value the value
     * @param clazz the clazz
     * @return the t
     */
    @SuppressWarnings("unchecked")
    public static <T> T parse(String value, Class<T> clazz) {

        Object o = null;

        if (value == null) {
            o = zero(clazz);
        } else
        if (clazz.isPrimitive()) {
            o = parsePrimitive(value, clazz);
        } else {
            o = parseSpecial(value, clazz);
        }

        // Unchecked cast
        return (T) o;
    }

    /**
     * Parses the primitive.
     *
     * @param value the value
     * @param clazz the clazz
     * @return the object
     * @throws IllegalArgumentException the illegal argument exception
     */
    private static Object parsePrimitive(String value, Class clazz) throws IllegalArgumentException {

        Object o = null;

        try {
            if (clazz == Boolean.TYPE)
            {
                o = Boolean.valueOf(value);
            }
            else if (clazz == Byte.TYPE)
            {
                o = Byte.valueOf(value);
            }
            else if (clazz == Character.TYPE)
            {
                o = value.charAt(0);
            }
            else if (clazz == Double.TYPE)
            {
                o = Double.valueOf(value);
            }
            else if (clazz == Float.TYPE)
            {
                o = Float.valueOf(value);
            }
            else if (clazz == Integer.TYPE)
            {
                o = Integer.valueOf(value);
            }
            else if (clazz == Long.TYPE)
            {
                o = Long.valueOf(value);
            }
            else if (clazz == Short.TYPE)
            {
                o = Short.valueOf(value);
            }
        }
        catch (Exception ex)
        {
            throw new IllegalArgumentException(ex);
        }

        return o;
    }

    /**
     * Parses the special.
     *
     * @param value the value
     * @param clazz the clazz
     * @return the object
     */
    private static Object parseSpecial(String value, Class clazz) {
        // TODO: Special type parsing
        return null;
    }

}
