package app.nveasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.nveasy.entity.UsersApp;

@Repository
public interface UserRepository extends JpaRepository<UsersApp, Long> {
	@Query("SELECT u FROM UsersApp u WHERE u.username = ?1 AND u.password = ?2")
    UsersApp findByUserNameAndPassword(String username, String password);
}
