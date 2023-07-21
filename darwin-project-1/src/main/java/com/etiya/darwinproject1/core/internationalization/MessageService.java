package com.etiya.darwinproject1.core.internationalization;

public interface MessageService {

    String getMessage(String keyword);

    String getMessageWithParams(String keyword, Object ...params);
}
