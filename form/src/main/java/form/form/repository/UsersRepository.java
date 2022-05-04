/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package form.form.repository;
import form.form.model.AddPostModel;
import form.form.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
/**
 *
 * @author HP
 */
public interface UsersRepository extends JpaRepository <UsersModel, Integer>{
    Optional<UsersModel> findByLoginAndPassword(String login, String password);
    
}
