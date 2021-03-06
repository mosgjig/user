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
import org.dozer.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.same;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

public class UserPreferenceServiceUnitTest {

    @InjectMocks
    private UserPreferenceService uut;

    @Mock
    private UserPreferenceDAO mockUserPreferenceDAO;

    @Mock
    private Mapper mockMapper;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreate() {
        when(mockMapper.map(eq(UserPreferenceDto.class), same(UserPreference.class))).thenReturn(new UserPreference());

        UserPreferenceDto dto = new UserPreferenceDto();
        uut.create(dto);

        verify(mockUserPreferenceDAO).save(any(UserPreference.class));
        verifyNoMoreInteractions(mockUserPreferenceDAO);

        verify(mockMapper).map(any(UserPreference.class), same(UserPreferenceDto.class));
        verify(mockMapper).map(any(UserPreferenceDto.class), same(UserPreference.class));
        verifyNoMoreInteractions(mockMapper);
    }
    
    //TODO: finish.

}
