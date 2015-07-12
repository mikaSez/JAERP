package sample;

import java.util.function.Consumer;

/**
 * Created by MikaSez on 11/07/2015.
 */
public class FXUtil {
    public static <T> T build(T node, Consumer<T> initializer) {
        initializer.accept(node);
        return node;
    }
}