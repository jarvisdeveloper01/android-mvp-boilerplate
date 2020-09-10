package com.jainamj.myapplication.base.network;


import androidx.annotation.NonNull;

import com.google.gson.reflect.TypeToken;
import com.jainamj.myapplication.data.api.models.Response;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.annotation.Nullable;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class MyAppUnwrapperConverterFactory extends Converter.Factory {

    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {

        for (Annotation annotation : annotations) {
            if (annotation instanceof UseOriginalResponse) {
                return null;
            }
        }

        Type envelopedType = TypeToken.getParameterized(Response.class, type).getType();

        final Converter<ResponseBody, Response> delegate = retrofit.nextResponseBodyConverter(this, envelopedType, annotations);

        return new Converter<ResponseBody, Object>() {

            @Override
            public Object convert(@NonNull ResponseBody value) throws IOException {

                Response wrapper = delegate.convert(value);
                return wrapper.getData();

            }
        };

    }


}