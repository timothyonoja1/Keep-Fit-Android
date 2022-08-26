package com.kratos.keepfit.core;

/** Models a Result. */
public abstract class Result<T> {

    /** Constructs a new instance. */
    public Result() {}

    /** Represents success. */
    public static final class Success<T> extends Result<T> {
        public T data;

        /** Constructs a new instance. */
        public Success(T data) {
            this.data = data;
        }
    }

    /** Represents error. */
    public static final class Error<T> extends Result<T> {

        /** Represents error exception. */
        public Exception exception;

        /** Constructs a new instance. */
        public Error(Exception exception) {
            this.exception = exception;
        }
    }
}
