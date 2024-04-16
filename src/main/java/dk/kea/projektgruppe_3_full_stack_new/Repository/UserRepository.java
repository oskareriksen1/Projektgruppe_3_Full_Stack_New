package dk.kea.projektgruppe_3_full_stack_new.Repository;

import dk.kea.projektgruppe_3_full_stack_new.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getAll() {
        String sql = "select * from ønskeliste.users";
        List<User> userListt = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return userListt;
    }
}
