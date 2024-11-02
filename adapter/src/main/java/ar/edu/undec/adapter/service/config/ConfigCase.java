package ar.edu.undec.adapter.service.config;

import curso.input.CreaterCurse;

import curso.output.SaveBD;
import curso.usecase.RegistrarCurso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigCase {
    @Bean
    public CreaterCurse createrCurse(SaveBD bd) {
        return new RegistrarCurso(bd);
    }
}
