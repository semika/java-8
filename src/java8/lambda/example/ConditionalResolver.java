package java8.lambda.example;

import java.util.function.Consumer;

public class ConditionalResolver<T> {

    private SimpleConsumer trueConsumer;
    private SimpleConsumer falseConsumer;
    private Boolean condition;

    public ConditionalResolver(Boolean condition) {
        this.condition = condition;
    }

    public static <T> ConditionalResolver of(Boolean condition) {
        return new ConditionalResolver(condition);
    }

    public ConditionalResolver<T> ifTrue(SimpleConsumer consumer) {
        this.trueConsumer = consumer;
        return this;
    }

    public ConditionalResolver<T> ifFalse(SimpleConsumer consumer) {
        this.falseConsumer = consumer;
        return this;
    }

    public void execute() {
        if (this.condition) {
            this.trueConsumer.apply();
        } else {
            this.falseConsumer.apply();
        }
    }
}
