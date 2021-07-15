package ch.stefanhohl.sh.linklist.entity.manager.repository;


import ch.stefanhohl.sh.linklist.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Stefan Hohl
 * @version 05.11.2020
 */

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}