package com.itau.casepix.dtos;

import com.itau.casepix.rules.RulesKeyPix;
import com.itau.casepix.validations.DocumentValidator;

public enum EnumKeyTypeDto implements RulesKeyPix {
    CPF {
        @Override
        public boolean executeRule(String key) {
            return DocumentValidator.isCPF(key);
        }
    },
    CNPJ {
        @Override
        public boolean executeRule(String key) {
            return DocumentValidator.isCnpj(key);
        }
    },
    EMAIL {
        @Override
        public boolean executeRule(String key) {
            return key.length() < 77 && key.toLowerCase().matches("^([a-z\\d]*)@(.*)$");
        }
    },
    CELULAR {
        @Override
        public boolean executeRule(String key) {
            return key.matches("(.*[+])(\\d{1,2})?(\\d{1,3})?(\\d{4,5}\\d{4})");
        }
    },
    ALEATORIO {
        @Override
        public boolean executeRule(String key) {
            return key.matches("^[a-z\\d]{1,36}$");
        }
    }
}

