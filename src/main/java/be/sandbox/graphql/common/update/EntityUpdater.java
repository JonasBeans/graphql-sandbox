package be.sandbox.graphql.common.update;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class EntityUpdater {

    public static <INPUT, Entity, OUTPUT> OUTPUT update(
            INPUT input,
            Entity entity,
            BiFunction<INPUT, Entity, Entity> compare,
            UnaryOperator<Entity> save,
            Function<Entity, OUTPUT> map
    ) { return compare.andThen(save).andThen(map).apply(input, entity); }
}
