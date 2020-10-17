package com.example.geek.exception;

import lombok.NoArgsConstructor;

/**
 * @author caojianyi
 * @date 2018/9/25
 */
@NoArgsConstructor
public class JobExecuteFailedException extends RuntimeException {

    public JobExecuteFailedException(String message) {
        super(message);
    }

    public JobExecuteFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public JobExecuteFailedException(Throwable cause) {
        super(cause);
    }
}
