package com.smartjob.platform.repository;
import java.util.List;
import com.smartjob.platform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
