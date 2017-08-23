package com.khmersolution.moduler.repository;

import com.khmersolution.moduler.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by Vannaravuth Yo
 * Date : 8/23/2017, 10:15 AM
 * Email : ravuthz@gmail.com
 */

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByEmail(@Param("email") String email);
    User findByUsername(@Param("username") String username);

    @RestResource(path = "first-name", rel = "first-name")
    List<User> findAllByFirstName(@Param("text") String text, Pageable pageable);

    @RestResource(path = "last-name", rel = "last-name")
    List<User> findAllByLastName(@Param("text") String text, Pageable pageable);

    @RestResource(path = "name", rel = "name")
    List<User> findAllByFirstNameOrLastNameContainsIgnoreCase(@Param("text") String text, Pageable pageable);

    @RestResource(path = "email", rel = "email")
    List<User> findAllByEmailContainsIgnoreCase(@Param("text") String text, Pageable pageable);

    @RestResource(path = "username", rel = "username")
    List<User> findAllByUsernameContainsIgnoreCase(@Param("text") String text, Pageable pageable);

}