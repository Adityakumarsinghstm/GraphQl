package com.yt.graphql.helper;

public class ExceptionHelper {
    public static RuntimeException throwResourceNotFoundException()
    {
        return new RuntimeException("Resource Not Found !!");
    }
}
