package com.itau.casepix.services;

import com.itau.casepix.dtos.KeyPixPostDto;
import com.itau.casepix.exceptions.DuplicateKeyPixException;

public interface KeyPixService {
    Object create(final KeyPixPostDto keyPixPostDto) throws DuplicateKeyPixException;
}
