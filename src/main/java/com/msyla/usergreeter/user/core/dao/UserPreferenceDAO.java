package com.msyla.usergreeter.user.core.dao;

import com.msyla.usergreeter.user.core.entity.UserPreference;
import org.springframework.data.repository.CrudRepository;

public interface UserPreferenceDAO extends CrudRepository<UserPreference, Long>{
    
    public UserPreference findByFirstName(String firstName);
}
