package pl.pawelec97.pawApplication.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pawelec97.pawApplication.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
