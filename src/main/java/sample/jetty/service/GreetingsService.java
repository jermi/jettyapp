package sample.jetty.service;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ValidateOnExecution;

/**
 * Created by kkoziel on 2014-11-24.
 */
public interface GreetingsService {
    String getHelloMessage();

    String greet(@NotEmpty @Length(min = 3)String name);
}
