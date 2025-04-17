package per.llt.card.mapper;

import java.lang.reflect.Field;

public class GenericMapper {
    public static <S, T> T mapper(S source, Class<T> targetClass) {
        try {
            T target = targetClass.getDeclaredConstructor().newInstance();
            for (Field sourceField : source.getClass().getDeclaredFields()) {
                sourceField.setAccessible(true);
                try {
                    Field targetField = targetClass.getDeclaredField(sourceField.getName());
                    targetField.setAccessible(true);
                    targetField.set(target, sourceField.get(source));
                } catch (NoSuchFieldException e) {
                    System.out.println(e.getMessage());
                }
            }
            return target;
        } catch (Exception e) {
            throw new RuntimeException("Mapping failed", e);
        }

    }
}
