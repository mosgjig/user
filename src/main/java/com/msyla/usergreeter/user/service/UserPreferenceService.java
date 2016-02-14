/*
 * The MIT License
 *
 * Copyright 2016 Modest Syla.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.msyla.usergreeter.user.service;

import com.msyla.usergreeter.user.core.dao.UserPreferenceDAO;
import com.msyla.usergreeter.user.core.entity.UserPreference;
import com.msyla.usergreeter.user.dto.UserPreferenceDto;
import java.util.ArrayList;
import java.util.List;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPreferenceService {

    @Autowired
    private UserPreferenceDAO dao;

    @Autowired
    private Mapper mapper;

    public UserPreferenceDto create(UserPreferenceDto dto) {
        UserPreference up = mapper.map(dto, UserPreference.class);
        UserPreference savedUp = dao.save(up);
        return mapper.map(savedUp, UserPreferenceDto.class);
    }

    public UserPreferenceDto getById(Long id) {
        UserPreference up = dao.findOne(id);
        return mapper.map(up, UserPreferenceDto.class);
    }

    public UserPreferenceDto getByFirstName(String firstName) {
        UserPreference up = dao.findByFirstName(firstName);
        return mapper.map(up, UserPreferenceDto.class);
    }

    public List<UserPreferenceDto> getAll() {
        Iterable<UserPreference> ups = dao.findAll();
        List<UserPreferenceDto> dtos = new ArrayList<>();
        for (UserPreference up : ups) {
            dtos.add(mapper.map(up, UserPreferenceDto.class));
        }
        return dtos;
    }

    public UserPreferenceDto update(Long id, UserPreferenceDto dto) {
        if (!dto.getKey().equals(id)) {
            throw new IllegalArgumentException("id " + id + " doesn't match key " + dto.getKey());
        }
        UserPreference up = dao.findOne(id);
        if (up == null) {
            throw new IllegalArgumentException("can't find user preference with id " + id);
        }

        mapper.map(dto, up);
        UserPreference savedUp = dao.save(up);
        UserPreferenceDto savedDto = mapper.map(savedUp, UserPreferenceDto.class);
        return savedDto;
    }

    public void delete(Long id) {
        dao.delete(id);
    }
}
