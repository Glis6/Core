package com.github.glis.util;

import lombok.Getter;

import java.util.Collection;
import java.util.Optional;
import java.util.Random;

/**
 * @author Glis
 */
public final class DefaultRandomUtils implements RandomUtils {
    /**
     * @see RandomUtils#getRandom()
     */
    @Getter
    private final Random random;

    /**
     * @param random The {@link Random} used in the other functions.
     */
    public DefaultRandomUtils(Random random) {
        this.random = random;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> Optional<E> getRandomElement(Collection<E> collection) {
        return collection.stream()
                .skip(random.nextInt(collection.size()))
                .findFirst();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> Optional<E> getRandomElement(E[] array) {
        if (array.length == 0)
            return Optional.empty();
        return Optional.ofNullable(array[random.nextInt(array.length - 1)]);
    }
}
