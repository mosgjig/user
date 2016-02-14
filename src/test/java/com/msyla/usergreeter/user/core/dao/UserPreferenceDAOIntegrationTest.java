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
package com.msyla.usergreeter.user.core.dao;

import com.msyla.usergreeter.user.core.config.CoreConfig;
import com.msyla.usergreeter.user.core.entity.UserPreference;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CoreConfig.class, initializers = ConfigFileApplicationContextInitializer.class)
@Transactional
public class UserPreferenceDAOIntegrationTest {

    @Autowired
    private UserPreferenceDAO userPreferenceDAO;

    private static final String FIRST_NAME = RandomStringUtils.randomAlphabetic(45);
    private static final String LAST_NAME = RandomStringUtils.randomAlphabetic(45);
    private static final String SEASON = RandomStringUtils.randomAlphabetic(45);

    private UserPreference p;

    @Before
    public void onStartUp() {
        p = new UserPreference();
        p.setFirstName(FIRST_NAME);
        p.setLastName(LAST_NAME);
        p.setSeason(SEASON);
    }

    @Test
    public void testSave() {
        userPreferenceDAO.save(p);
        assertNotNull(p.getId());
    }

    @Test(expected = ConstraintViolationException.class)
    public void testSave_LongFirstName() {
        p.setFirstName(RandomStringUtils.randomAlphabetic(46));
        userPreferenceDAO.save(p);
    }

    @Test(expected = ConstraintViolationException.class)
    public void testSave_EmptyFirstName() {
        p.setFirstName("");
        userPreferenceDAO.save(p);
    }

    @Test(expected = ConstraintViolationException.class)
    public void testSave_LongLastName() {
        p.setLastName(RandomStringUtils.randomAlphabetic(46));
        userPreferenceDAO.save(p);
    }

    @Test(expected = ConstraintViolationException.class)
    public void testSave_EmptyLastName() {
        p.setLastName("");
        userPreferenceDAO.save(p);
    }

    @Test(expected = ConstraintViolationException.class)
    public void testSave_LongSeason() {
        p.setSeason(RandomStringUtils.randomAlphabetic(46));
        userPreferenceDAO.save(p);
    }

    @Test(expected = ConstraintViolationException.class)
    public void testSave_EmptySeason() {
        p.setSeason("");
        userPreferenceDAO.save(p);
    }

    @Test
    public void testFindOne() {
        userPreferenceDAO.save(p);
        assertNotNull(p.getId());

        UserPreference savedEntity = userPreferenceDAO.findOne(p.getId());

        assertNotNull(savedEntity);
        assertEquals(p, savedEntity);
    }

    @Test
    public void testFindByFirstName() {
        userPreferenceDAO.save(p);
        assertNotNull(p.getId());

        UserPreference savedEntity = userPreferenceDAO.findByFirstName(p.getFirstName());

        assertNotNull(savedEntity);
        assertEquals(p, savedEntity);
    }

    @Test
    public void testFindAll() {
        Iterable<UserPreference> entities = userPreferenceDAO.findAll();
        assertTrue(entities.iterator().hasNext());
    }

    @Test
    public void testUpdate() {
        userPreferenceDAO.save(p);
        assertNotNull(p.getId());
        UserPreference savedEntity = userPreferenceDAO.findOne(p.getId());
        assertEquals(p, savedEntity);

        savedEntity.setFirstName(RandomStringUtils.randomAlphabetic(20));
        savedEntity.setLastName(RandomStringUtils.randomAlphabetic(20));
        savedEntity.setSeason(RandomStringUtils.randomAlphabetic(20));

        UserPreference updatedEntity = userPreferenceDAO.save(savedEntity);
        assertNotNull(updatedEntity);
        assertEquals(savedEntity, updatedEntity);
    }

    @Test
    public void testDelete() {

        userPreferenceDAO.save(p);
        assertNotNull(p.getId());
        userPreferenceDAO.delete(p.getId());
        UserPreference entity = userPreferenceDAO.findOne(p.getId());
        assertNull(entity);
    }
}
