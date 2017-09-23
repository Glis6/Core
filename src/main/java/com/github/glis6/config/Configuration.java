package com.github.glis6.config;

/**
 * @author Glis
 */
public interface Configuration<T> {
    /**
     * @return The type of configuration we are loading.
     */
    T loadConfiguration() throws Exception;
}
