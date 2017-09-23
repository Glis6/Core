package com.github.glis.util;

import java.util.Collection;
import java.util.Optional;
import java.util.Random;

/**
 * @author Glis
 */
public interface RandomUtils {
    /**
     * @param collection The {@link Collection} to extract the element from.
     * @param <E>        The type of {@link Collection}.
     * @return A randomly selected element from the {@link Collection}.
     */
    <E> Optional<E> getRandomElement(Collection<E> collection);

    /**
     * @param array The array to extract the element from.
     * @param <E>   The type of array.
     * @return A randomly selected element from the array.
     */
    <E> Optional<E> getRandomElement(E[] array);

    /**
     * @return The {@link Random} used in the other functions.
     */
    Random getRandom();
}
