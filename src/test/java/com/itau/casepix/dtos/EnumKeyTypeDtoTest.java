package com.itau.casepix.dtos;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class EnumKeyTypeDtoTest {

    @Mock
    private EnumKeyTypeDto enumKeyTypeDto;

    @Test
    void test_validate_cpf_invalid(){
        assertFalse(enumKeyTypeDto.CPF.executeRule("11111111"));
    }

    @Test
    void test_validate_cpf_valid(){
        assertTrue(enumKeyTypeDto.CPF.executeRule("03138939503"));
    }

    @Test
    void test_validate_cnpj_invalid(){
        assertFalse(enumKeyTypeDto.CNPJ.executeRule("23093109220001"));
    }

    @Test
    void test_validate_cnpj_valid(){
        assertTrue(enumKeyTypeDto.CNPJ.executeRule("42591651000143"));
    }

    @Test
    void test_validate_email_invalid(){
        assertFalse(enumKeyTypeDto.EMAIL.executeRule("%teste@teste.com"));
    }

    @Test
    void test_validate_email_valid(){
        assertTrue(enumKeyTypeDto.EMAIL.executeRule("teste@teste.com"));
    }

    @Test
    void test_validate_celular_invalid(){
        assertFalse(enumKeyTypeDto.CELULAR.executeRule("5571999889999"));
    }

    @Test
    void test_validate_celular_valid(){
        assertTrue(enumKeyTypeDto.CELULAR.executeRule("+55071999430988"));
    }

    @Test
    void test_validate_aleatorio_invalid(){
        assertFalse(enumKeyTypeDto.ALEATORIO.executeRule("324n1j4j3k243kj21l4j32h4jh2312h4j32h6"));
    }

    @Test
    void test_validate_aleatorio_valid(){
        assertTrue(enumKeyTypeDto.ALEATORIO.executeRule("324n1j4j3k243kj21l4j32h4jh2312h4j32h"));
    }
}