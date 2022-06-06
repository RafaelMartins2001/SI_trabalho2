package isel.sisinf.grp05.model;

public interface DataMapper<T, Tid> {
    void create(T e);
    T read(Tid id);
    void update(T e);
    void delete(T e);
}
