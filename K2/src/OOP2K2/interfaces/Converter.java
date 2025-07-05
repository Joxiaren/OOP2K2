package OOP2K2.interfaces;

public interface Converter<T> {
    public T convert(Object[] data);
    public Object[] convert(T t);
}
