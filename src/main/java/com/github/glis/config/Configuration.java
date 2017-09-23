package com.github.glis.config;

/**
 * @author Glis
 */
public interface Configuration<T> {
    /**
     * @return The type of configuration we are loading.
     */
    T loadConfiguration() throws Exception;
}
