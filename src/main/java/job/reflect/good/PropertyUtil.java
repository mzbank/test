package job.reflect.good;

import java.lang.reflect.Field;

public class PropertyUtil {

    public static void setProperty(Object object, String propertyName, Object value) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        Class<?> clazz = object.getClass();
        Field field = clazz.getDeclaredField(propertyName);
        field.setAccessible(true);
        field.set(object, value);
    }
}
