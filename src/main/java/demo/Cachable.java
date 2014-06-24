package demo;

import java.io.Serializable;

public interface Cachable extends Serializable {

	public String getKey();

	public String getObjectKey();

}