package org.cnu.realcoding.myfirstspringbootapp6.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ExistingDogException extends RuntimeException{
}
