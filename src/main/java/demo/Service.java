package demo;

public interface Service<V extends Cachable> {

	public void put(V obj);

	public V get(V key);

	public void delete(V key);

}
