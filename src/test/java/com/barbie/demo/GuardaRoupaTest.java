package com.barbie.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuardaRoupaTest {
    private GuardaRoupa guardaRoupa;

    @BeforeEach
    void preparar() {
        guardaRoupa = new GuardaRoupa(500);
    }
    @Test
    @DisplayName("Desconto de 10% em 200 deve resultar em 180")
    void deveAplicarDesconto() {
        double resultado = guardaRoupa.precoComDesconto(200, 10);

        assertEquals(180.00, resultado, 0.01);
    }

    @Test
    @DisplayName("Desconto negativo deve lançar exceção")
    void deveRejeitarDescontoNegativo() {
        assertThrows(IllegalArgumentException.class,
                () -> guardaRoupa.precoComDesconto(200, -10));
    }

    @Test
    @DisplayName("Desconto acima de 100 deve lançar exceção")
    void deveRejeitarDescontoAcimaDe100() {
        assertThrows(IllegalArgumentException.class,
                () -> guardaRoupa.precoComDesconto(200, 110));
    }

    @Test
    @DisplayName("Preço abaixo do orçamento deve ser permitido")
    void deveCabernoOrcamento() {
        assertTrue(guardaRoupa.cabeNoOrcamento(300));
    }

    @Test
    @DisplayName("Preço igual ao orçamento deve ser permitido")
    void deveAceitarPrecoIgualAoOrcamento() {
        assertTrue(guardaRoupa.cabeNoOrcamento(500));
    }

    @Test
    @DisplayName("Preço abaixo de 200 não é de gala")
    void naoDeveSerDeGala() {
        assertFalse(guardaRoupa.ehDeGala(199));
    }

    @Test
    @DisplayName("Preço exatamente 200 não é de gala")
    void precoIgualA200NaoDeveSerDeGala() {
        assertFalse(guardaRoupa.ehDeGala(200));
    }

    @Test
    @DisplayName("Preço acima de 200 é de gala")
    void deveSerDeGala() {
        assertTrue(guardaRoupa.ehDeGala(250));
    }
}

