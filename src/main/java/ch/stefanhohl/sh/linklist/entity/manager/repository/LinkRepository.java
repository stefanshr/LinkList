package ch.stefanhohl.sh.linklist.entity.manager.repository;


import ch.stefanhohl.sh.linklist.entity.Link;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Stefan Hohl
 * @version 05.11.2020
 */

@Repository
public interface LinkRepository extends CrudRepository<Link, Integer> {

}