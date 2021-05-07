package br.ce.desafio.core;

import org.junit.After;

import static br.ce.desafio.core.DriverFactory.KillDriver;

public class BaseSteps {

    @After
    public void fecharPagina() {
        KillDriver();
    }
}
